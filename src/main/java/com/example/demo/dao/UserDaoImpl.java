package com.example.demo.dao;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoImpl implements UserDao {
    @Autowired
    UserRepository userRepository;


    @Override
    public User add(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(long id) {

        return userRepository.findById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUserAuthUsername(username);
    }

    @Override
    public void delete(long id) {
        User user = userRepository.findOne(id);
        userRepository.delete(user);
    }

    @Override
    public List<User> getAll() {
        return Lists.newArrayList(userRepository.findAll());
    }


}
