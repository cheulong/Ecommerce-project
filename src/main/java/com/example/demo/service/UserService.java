package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    List<User> searchUser(String text);
    User addCustomer(User user);
    User addStaff(User user);
    void deleteUser(long id);
}
