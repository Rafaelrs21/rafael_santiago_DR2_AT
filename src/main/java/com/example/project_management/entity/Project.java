package com.example.project_management.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Project {
    private Long id;
    private String name;
    private String description;
    private List<Sprint> sprints;

    public Project(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
        sprints = new ArrayList<>();
    }

    public void setAsSaved(long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Sprint> listSprints() {
        return sprints;
    }

    public void addSprint(Sprint sprint) {
        sprint.setProject(this);
        sprints.add(sprint);
    }

    public void removeSprintById(Long sprintId){
        boolean found = false;

        for (Sprint sprint : sprints) {
            if (Objects.equals(sprint.getId(), sprintId)) {
                sprint.markToDelete();
                found = true;
                break;
            }
        }
    }
}