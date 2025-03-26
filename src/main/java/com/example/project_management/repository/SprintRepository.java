package com.example.project_management.repository;

import com.example.project_management.entity.Project;
import com.example.project_management.entity.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintRepository extends JpaRepository<Sprint, Long> {
    List<Sprint> findByProject(Project project);
}
