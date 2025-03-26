package com.example.project_management.controller;

import com.example.project_management.entity.Sprint;
import com.example.project_management.service.SprintService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprints")
public class SprintController {
    private final SprintService sprintService;

    public SprintController(SprintService sprintService) {
        this.sprintService = sprintService;
    }

    @GetMapping
    public List<Sprint> getAllSprints() {
        return sprintService.getAllSprints();
    }

    @GetMapping("/{id}")
    public Sprint getSprintById(@PathVariable Long id) {
        return sprintService.getSprintById(id).orElseThrow(() -> new RuntimeException("Sprint not found"));
    }

    @PostMapping
    public Sprint createSprint(@RequestBody Sprint sprint) {
        return sprintService.saveSprint(sprint);
    }

    @PutMapping("/{id}/project")
    public Sprint assignProjectToSprint(@PathVariable Long id, @RequestParam Long projectId) {
        return sprintService.assignProjectToSprint(id, projectId);
    }

    @PutMapping("/{id}/task")
    public Sprint addTaskToSprint(@PathVariable Long id, @RequestParam Long taskId) {
        return sprintService.addTaskToSprint(id, taskId);
    }

    @DeleteMapping("/{id}")
    public void deleteSprint(@PathVariable Long id) {
        sprintService.deleteSprint(id);
    }
}
