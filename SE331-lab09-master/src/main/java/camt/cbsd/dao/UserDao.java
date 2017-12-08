package camt.cbsd.dao;

import camt.cbsd.entity.User;

import java.util.List;


public interface UserDao {
    List<User> getUsers();
    User findById(long id);
    User addUser(User user);
    Integer size();
}
