package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

public interface UserDao {
    User add(User user);
    User findById(long id);
    User findByUsername(String username);
    void delete(long id);
    List<User> getAll();

   

}
