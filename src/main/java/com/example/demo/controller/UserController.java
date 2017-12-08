package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {
    UserService userService;

    @PostMapping("/user")
    public User addCustomer(@RequestBody User user) {
        return userService.addMember(user);
    }

    @PostMapping("/user/staff")
    public User addShopkeeper(@RequestBody User user) {
        return userService.addShopkeeper(user);
    }

    @GetMapping("/user")
    public List<User> getAll() {
        return userService.getAll();
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
        userService.deleteMember(id);
        return ResponseEntity.ok().build();
    }


}
