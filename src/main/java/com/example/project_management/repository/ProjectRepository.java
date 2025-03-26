package com.example.project_management.repository;

import com.example.project_management.entity.Project;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepository {
    private final List<Project> projects = new ArrayList<>();

    public List<Project> findAll() {
        return new ArrayList<>(projects);
    }

    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    public void save(Project project) {
        projects.removeIf(p -> p.getId().equals(project.getId())); // Remove se já existir
        projects.add(project);
    }

    public void deleteById(Long id) {
        projects.removeIf(p -> p.getId().equals(id));
    }
}