package com.example.project_management.service;

import com.example.project_management.entity.User;
import com.example.project_management.enums.UserPosition;
import com.example.project_management.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        User savedUser = user.setAsSaved(user.getId());
        return userRepository.save(savedUser);
    }

    public User updateUserEmail(Long id, String email) {
        return userRepository.findById(id)
                .map(user -> {
                    User updatedUser = user.updateEmail(email);
                    return userRepository.save(updatedUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User updateUserPosition(Long id, UserPosition position) {
        return userRepository.findById(id)
                .map(user -> {
                    User updatedUser = user.setPosition(position);
                    return userRepository.save(updatedUser);
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}

