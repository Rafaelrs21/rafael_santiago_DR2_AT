package com.example.project_management.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sprint {
    private static long sprintCounter = 1;

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Project project;
    private List<Task> tasks;
    private boolean markedForDelete = false;

    public Sprint() {
        this.id = sprintCounter++;
        this.startDate = LocalDate.now();
        this.endDate = startDate.plusWeeks(2);
        this.tasks = new ArrayList<>();
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public void addTask(Task task) {
        task.setSprint(this);
        tasks.add(task);
    }

    public Long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public long getProjectId() {
        return project != null ? project.getId() : 0;
    }

    public boolean hasProject() {
        return project != null;
    }

    public List<Task> listTasks() {
        return tasks;
    }

    public void markToDelete() {
        markedForDelete = true;
    }

    public boolean isMarkedForDelete() {
        return markedForDelete;
    }

    public void removeTaskById(Long id) {
        tasks.removeIf(task -> Objects.equals(task.getId(), id));
    }
}
