package com.example.project_management.repository;

import com.example.project_management.entity.User;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository {
    private final Map<Long, User> userStore = new HashMap<>();

    public List<User> findAll() {
        return new ArrayList<>(userStore.values());
    }

    public Optional<User> findById(Long id) {
        return Optional.ofNullable(userStore.get(id));
    }

    public User save(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("User ID must be provided.");
        }
        userStore.put(user.getId(), user);
        return user;
    }

    public void deleteById(Long id) {
        userStore.remove(id);
    }
}
