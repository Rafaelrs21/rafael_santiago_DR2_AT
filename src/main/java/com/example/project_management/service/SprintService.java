package com.example.project_management.service;

import com.example.project_management.entity.Project;
import com.example.project_management.entity.Sprint;
import com.example.project_management.entity.Task;
import com.example.project_management.repository.ProjectRepository;
import com.example.project_management.repository.SprintRepository;
import com.example.project_management.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SprintService {
    private final SprintRepository sprintRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;

    public SprintService(SprintRepository sprintRepository, ProjectRepository projectRepository, TaskRepository taskRepository) {
        this.sprintRepository = sprintRepository;
        this.projectRepository = projectRepository;
        this.taskRepository = taskRepository;
    }

    public List<Sprint> getAllSprints() {
        return sprintRepository.findAll();
    }

    public Optional<Sprint> getSprintById(Long id) {
        return sprintRepository.findById(id);
    }

    public Sprint saveSprint(Sprint sprint) {
        sprint.setAsSaved(sprint.getId());
        return sprintRepository.save(sprint);
    }

    public Sprint assignProjectToSprint(Long sprintId, Long projectId) {
        return sprintRepository.findById(sprintId)
                .map(sprint -> {
                    Project project = projectRepository.findById(projectId).orElseThrow(() -> new RuntimeException("Project not found"));
                    sprint.setProject(project);
                    return sprintRepository.save(sprint);
                })
                .orElseThrow(() -> new RuntimeException("Sprint not found"));
    }

    public Sprint addTaskToSprint(Long sprintId, Long taskId) {
        return sprintRepository.findById(sprintId)
                .map(sprint -> {
                    Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
                    sprint.addTask(task);
                    return sprintRepository.save(sprint);
                })
                .orElseThrow(() -> new RuntimeException("Sprint not found"));
    }

    public void deleteSprint(Long id) {
        sprintRepository.deleteById(id);
    }
}
