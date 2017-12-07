package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository <User,Long>{
    User findById(Long id);
    User findByUserUsername(String username);
    List<User> findByName(String name);
    List<User> findByNameIgnoreCase(String name);
    List<User> findByNameIgnoreCaseContaining(String name);
    List<User> findByNameIgnoreCaseContainingOrderByName(String name);
    List<User> findBySurnameIgnoreCaseContaining(String surname);
    List<User> findByNameIgnoreCaseContainingOrSurnameIgnoreCaseContaining(String name,String surname);
}
