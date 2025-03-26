package com.example.project_management.repository;

import com.example.project_management.entity.Sprint;
import com.example.project_management.entity.Task;
import com.example.project_management.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
class TaskRepository {
    private final Map<Long, Task> taskStore = new HashMap<>();

    public List<Task> findAll() {
        return new ArrayList<>(taskStore.values());
    }

    public Optional<Task> findById(Long id) {
        return Optional.ofNullable(taskStore.get(id));
    }

    public void save(Task task) {
        taskStore.put(task.getId(), task);
    }

    public void deleteById(Long id) {
        taskStore.remove(id);
    }
}
