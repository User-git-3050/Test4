package com.spring.project3.Controller;


import com.spring.project3.Entity.Task;
import com.spring.project3.Entity.User;
import com.spring.project3.Service.UserService;
import com.spring.project3.dao.LoginRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @PostMapping("/")
    public void addUser(@RequestBody LoginRequest loginRequest) {
        userService.createUser(loginRequest);
    }

    @GetMapping("tasks/{id}")
    public ResponseEntity<List<Task>> getTasks(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getTasks(id));
    }


}
