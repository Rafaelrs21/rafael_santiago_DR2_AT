package com.example.project_management.service;

import com.example.project_management.entity.Sprint;
import com.example.project_management.entity.Task;
import com.example.project_management.entity.User;
import com.example.project_management.enums.TaskStatus;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {
    private final Map<Long, Task> taskStore = new HashMap<>();
    private final Map<Long, User> userStore = new HashMap<>();
    private final Map<Long, Sprint> sprintStore = new HashMap<>();

    public List<Task> getAllTasks() {
        return new ArrayList<>(taskStore.values());
    }

    public Optional<Task> getTaskById(Long id) {
        return Optional.ofNullable(taskStore.get(id));
    }

    public Task saveTask(Task task) {
        if (task.getId() == null) {
            throw new RuntimeException("Task ID cannot be null");
        }
        taskStore.put(task.getId(), task);
        return task;
    }

    public Task updateTaskStatus(Long id, TaskStatus status) {
        Task task = taskStore.get(id);
        if (task != null) {
            task.setStatus(status);
        }
        return task;
    }

    public Task updateTaskOwner(Long taskId, Long ownerId) {
        Task task = taskStore.get(taskId);
        User owner = userStore.get(ownerId);
        if (task != null && owner != null) {
            task.setOwner(owner);
        }
        return task;
    }

    public Task assignTaskToSprint(Long taskId, Long sprintId) {
        Task task = taskStore.get(taskId);
        Sprint sprint = sprintStore.get(sprintId);
        if (task != null && sprint != null) {
            task.setSprint(sprint);
        }
        return task;
    }

    public void deleteTask(Long id) {
        taskStore.remove(id);
    }
}

