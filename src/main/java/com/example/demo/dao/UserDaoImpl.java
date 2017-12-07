package com.example.demo.dao;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;


    @Override
    public User add(User user) {
        return null;
    }

    @Override
    public User findById(long id) {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public List<User> searchUser(String text) {
        return null;
    }
}
