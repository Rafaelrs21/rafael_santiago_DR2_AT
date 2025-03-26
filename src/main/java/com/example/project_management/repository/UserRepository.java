package com.example.project_management.repository;

import com.example.project_management.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
class UserRepository {
    private final Map<Long, User> userStore = new HashMap<>();

    public List<User> findAll() {
        return new ArrayList<>(userStore.values());
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userStore.get(id));
    }

    public void save(User user) {
        userStore.put(user.getId(), user);
    }

    public void deleteById(Long id) {
        userStore.remove(id);
    }
}