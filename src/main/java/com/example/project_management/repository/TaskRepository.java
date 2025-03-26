package com.example.project_management.repository;

import com.example.project_management.entity.Sprint;
import com.example.project_management.entity.Task;
import com.example.project_management.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByOwner(User owner);
    List<Task> findBySprint(Sprint sprint);
}
