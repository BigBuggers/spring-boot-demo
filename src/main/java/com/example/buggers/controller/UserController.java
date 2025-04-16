package com.example.buggers.controller;

import com.example.buggers.dto.User;
import com.example.buggers.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/{userId}")
    public boolean updateUser(@PathVariable("userId") String userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public boolean deleteUser(@PathVariable("userId") String userId) {
        return userService.deleteUser(userId);
    }

}
