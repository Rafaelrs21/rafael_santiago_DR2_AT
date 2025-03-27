package com.example.project_management.service;

import com.example.project_management.entity.Project;
import com.example.project_management.entity.Sprint;
import com.example.project_management.entity.Task;
import com.example.project_management.repository.ProjectRepository;
import com.example.project_management.repository.SprintRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SprintService {
    private final SprintRepository sprintRepository;
    private final ProjectRepository projectRepository;

    public SprintService(SprintRepository sprintRepository, ProjectRepository projectRepository) {
        this.sprintRepository = sprintRepository;
        this.projectRepository = projectRepository;
    }

    public List<Sprint> getAllSprints() {
        return sprintRepository.findAll();
    }

    public Optional<Sprint> getSprintById(Long id) {
        return sprintRepository.findById(id);
    }

    public Sprint createSprint() {
        Sprint sprint = new Sprint();
        sprintRepository.save(sprint);
        return sprint;
    }

    public void deleteSprint(Long id) {
        sprintRepository.deleteById(id);
    }

    public Sprint assignProjectToSprint(Long sprintId, Long projectId) {
        Sprint sprint = sprintRepository.findById(sprintId)
                .orElseThrow(() -> new RuntimeException("Sprint not found"));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        sprint.setProject(project);
        sprintRepository.save(sprint);
        return sprint;
    }

    public Sprint addTaskToSprint(Long sprintId, Long taskId) {
        Sprint sprint = sprintRepository.findById(sprintId)
                .orElseThrow(() -> new RuntimeException("Sprint not found"));

        Task task = new Task(taskId, "Task " + taskId);
        sprint.addTask(task);
        sprintRepository.save(sprint);
        return sprint;
    }
}