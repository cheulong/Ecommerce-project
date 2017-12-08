package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User addMember(User user);
    void deleteMember(long id);
    User addShopkeeper(User user);
}
