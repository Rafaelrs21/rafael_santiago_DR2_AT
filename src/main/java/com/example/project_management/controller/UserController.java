package com.example.project_management.controller;

import com.example.project_management.entity.User;
import com.example.project_management.enums.UserPosition;
import com.example.project_management.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PutMapping("/{id}/email")
    public User updateUserEmail(@PathVariable Long id, @RequestParam String email) {
        return userService.updateUserEmail(id, email);
    }

    @PutMapping("/{id}/position")
    public User updateUserPosition(@PathVariable Long id, @RequestParam UserPosition position) {
        return userService.updateUserPosition(id, position);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

