package camt.cbsd.dao;

import camt.cbsd.entity.User;
import camt.cbsd.repository.UserRepository;
import jersey.repackaged.com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Profile("DBDataSource")
public class UserDaoDBImpl implements UserDao {
   @Autowired
    UserRepository userRepository;


    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return Lists.newArrayList(userRepository.findAll());

    }

    @Override
    public User findById(long id) {
      //  return userRepository.findById(id);
        return null;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Integer size() {
        return (int) userRepository.count();
    }
}
