package com.example.project_management.service;

import com.example.project_management.entity.Sprint;
import com.example.project_management.entity.Task;
import com.example.project_management.entity.User;
import com.example.project_management.enums.TaskStatus;
import com.example.project_management.repository.SprintRepository;
import com.example.project_management.repository.TaskRepository;
import com.example.project_management.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;
    private final SprintRepository sprintRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository, SprintRepository sprintRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
        this.sprintRepository = sprintRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task saveTask(Task task) {
        task.setAsSaved(task.getId());
        return taskRepository.save(task);
    }

    public Task updateTaskStatus(Long id, TaskStatus status) {
        return taskRepository.findById(id)
                .map(task -> {
                    task.setStatus(status);
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task updateTaskOwner(Long taskId, Long ownerId) {
        return taskRepository.findById(taskId)
                .map(task -> {
                    User owner = userRepository.findById(ownerId).orElseThrow(() -> new RuntimeException("User not found"));
                    task.setOwner(owner);
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public Task assignTaskToSprint(Long taskId, Long sprintId) {
        return taskRepository.findById(taskId)
                .map(task -> {
                    Sprint sprint = sprintRepository.findById(sprintId).orElseThrow(() -> new RuntimeException("Sprint not found"));
                    task.setSprint(sprint);
                    return taskRepository.save(task);
                })
                .orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}

