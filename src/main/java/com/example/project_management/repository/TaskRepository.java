package com.example.project_management.repository;

import com.example.project_management.entity.Task;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class TaskRepository {
    private final List<Task> taskStore = new ArrayList<>();

    public List<Task> findAll() {
        return new ArrayList<>(taskStore);
    }

    public Optional<Task> findById(Long id) {
        return taskStore.stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    public Task save(Task task) {
        if (task.getId() == null) {
            task.setAsSaved((long) (taskStore.size() + 1));
        }
        taskStore.add(task);
        return task;
    }

    public void deleteById(Long id) {
        taskStore.removeIf(task -> task.getId().equals(id));
    }
}