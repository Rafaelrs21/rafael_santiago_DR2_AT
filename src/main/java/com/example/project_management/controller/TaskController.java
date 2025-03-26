package com.example.project_management.controller;

import com.example.project_management.entity.Task;
import com.example.project_management.enums.TaskStatus;
import com.example.project_management.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.saveTask(task);
    }

    @PutMapping("/{id}/status")
    public Task updateTaskStatus(@PathVariable Long id, @RequestParam TaskStatus status) {
        return taskService.updateTaskStatus(id, status);
    }

    @PutMapping("/{id}/owner")
    public Task updateTaskOwner(@PathVariable Long id, @RequestParam Long ownerId) {
        return taskService.updateTaskOwner(id, ownerId);
    }

    @PutMapping("/{id}/sprint")
    public Task assignTaskToSprint(@PathVariable Long id, @RequestParam Long sprintId) {
        return taskService.assignTaskToSprint(id, sprintId);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
