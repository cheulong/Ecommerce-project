package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public User addCustomer(@RequestBody User user) {
        return userService.addCustomer(user);
    }

    @PostMapping("/user/staff")
    public User addStaff(@RequestBody User user) {
        return userService.addStaff(user);
    }

    @GetMapping("/user")
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/user/search/{text}")
    public List<User> searchUser(@PathVariable("text") String text) {
        return userService.searchUser(text);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }


}
