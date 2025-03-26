package com.example.project_management.controller;

import com.example.project_management.entity.Sprint;
import com.example.project_management.service.SprintService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Sprint> getSprintById(@PathVariable Long id) {
        return sprintService.getSprintById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping
    public ResponseEntity<String> createSprint(@RequestBody Sprint sprint) {
        sprintService.saveSprint(sprint);
        return ResponseEntity.status(HttpStatus.CREATED).body("Sprint created successfully");
    }

    @PutMapping("/{id}/project")
    public ResponseEntity<Sprint> assignProjectToSprint(@PathVariable Long id, @RequestParam Long projectId) {
        Sprint updatedSprint = sprintService.assignProjectToSprint(id, projectId);
        return ResponseEntity.ok(updatedSprint);
    }

    @PutMapping("/{id}/task")
    public ResponseEntity<Sprint> addTaskToSprint(@PathVariable Long id, @RequestParam Long taskId) {
        Sprint updatedSprint = sprintService.addTaskToSprint(id, taskId);
        return ResponseEntity.ok(updatedSprint);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSprint(@PathVariable Long id) {
        sprintService.deleteSprint(id);
        return ResponseEntity.ok("Sprint deleted successfully");
    }
}
