package com.example.project_management.entity;

import com.example.project_management.enums.TaskStatus;

public class Task {
    private Long id;
    private String title;
    private String description;
    private TaskStatus status;
    private User owner;
    private Sprint sprint;

    public Task() {}

    public Task(Long id, String title, String description, TaskStatus status, User owner) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.owner = null;
        this.sprint = null;
    }

    public Task(Long id, String title) {
        this.id = id;
        this.title = title;
        this.description = "";
        this.status = TaskStatus.TODO;
        this.owner = null;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public void setAsSaved(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public User getOwner() {
        return owner;
    }

    public Sprint getSprint() {
        return sprint;
    }
}