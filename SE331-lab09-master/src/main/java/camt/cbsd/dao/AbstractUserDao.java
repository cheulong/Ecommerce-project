package camt.cbsd.dao;

import camt.cbsd.entity.User;

import java.util.List;


public abstract class AbstractUserDao implements UserDao {
    List<User> users;
    String baseUrl;
    String imageUrl;

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    String imageBaseUrl;

    @Override
    public List<User> getUsers() {
        return users;
    }

    @Override
    public User findById(long id) {

        return users.stream().filter(s -> s.getId() == id).findFirst().orElse(null);
    }

    @Override
    public Integer size() {
        return users.size();
    }

    @Override
    public User addUser(User user){
        //update id
        int newId = this.size()+1;
        user.setId(newId);
        users.add(user);
        return user;
    }
}
