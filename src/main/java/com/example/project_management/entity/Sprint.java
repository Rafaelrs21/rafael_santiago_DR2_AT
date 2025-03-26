package com.example.project_management.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Sprint {
    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Project project;
    private List<Task> tasks;

    private boolean markedForDelete = false;

    public Sprint(Long id, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.project = null;
        this.tasks = new ArrayList<>();
    }

    public Sprint(long id, LocalDate startDate, LocalDate endDate, List<Task> tasks) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.project = null;
        this.tasks = tasks;
    }

    public void setAsSaved(long id) {
        this.id = id;
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
        return project.getId();
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
        boolean found = false;

        for (Task task : tasks) {
            if (Objects.equals(task.getId(), id)) {
                task.markToDelete();
                found = true;
                break;
            }
        }
    }
}
