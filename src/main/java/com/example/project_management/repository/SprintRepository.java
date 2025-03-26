package com.example.project_management.repository;

import com.example.project_management.entity.Project;
import com.example.project_management.entity.Sprint;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class SprintRepository {
    private final List<Sprint> sprints = new ArrayList<>();

    public List<Sprint> findAll() {
        return new ArrayList<>(sprints);
    }

    public Optional<Sprint> findById(Long id) {
        return sprints.stream().filter(s -> s.getId().equals(id)).findFirst();
    }

    public void save(Sprint sprint) {
        sprints.removeIf(s -> s.getId().equals(sprint.getId()));
        sprints.add(sprint);
    }

    public void deleteById(Long id) {
        sprints.removeIf(s -> s.getId().equals(id));
    }

    public List<Sprint> findByProject(Project project) {
        return sprints.stream()
                .filter(s -> s.getProjectId() != 0 && s.getProjectId() == project.getId())
                .collect(Collectors.toList());
    }
}
