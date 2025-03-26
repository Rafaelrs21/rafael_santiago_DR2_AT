package com.example.project_management.service;

import com.example.project_management.entity.User;
import com.example.project_management.enums.UserPosition;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final Map<Long, User> userStore = new HashMap<>();

    public List<User> getAllUsers() {
        return new ArrayList<>(userStore.values());
    }

    public Optional<User> getUserById(Long id) {
        return Optional.ofNullable(userStore.get(id));
    }

    public User saveUser(User user) {
        userStore.put(user.getId(), user);
        return user;
    }

    public User updateUserEmail(Long id, String email) {
        User user = userStore.get(id);
        if (user != null) {
            User updatedUser = user.updateEmail(email);
            userStore.put(id, updatedUser);
            return updatedUser;
        }
        throw new RuntimeException("User not found");
    }

    public User updateUserPosition(Long id, UserPosition position) {
        User user = userStore.get(id);
        if (user != null) {
            User updatedUser = user.setPosition(position);
            userStore.put(id, updatedUser);
            return updatedUser;
        }
        throw new RuntimeException("User not found");
    }

    public void deleteUser(Long id) {
        userStore.remove(id);
    }
}