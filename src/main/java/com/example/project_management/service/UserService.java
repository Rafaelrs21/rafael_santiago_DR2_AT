package com.example.project_management.service;

import com.example.project_management.entity.User;
import com.example.project_management.enums.UserPosition;
import com.example.project_management.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        if (user.getId() == null) {
            throw new IllegalArgumentException("User ID must be provided.");
        }
        return userRepository.save(user);
    }

    public User updateUserEmail(Long id, String email) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.updateEmail(email);
        return userRepository.save(user);
    }

    public User updateUserPosition(Long id, UserPosition position) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPosition(position);
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}