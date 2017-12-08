package camt.cbsd.services;

import camt.cbsd.entity.User;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;


public interface UserService {
    List<User> getStudents();
    User findById(long id);
    User addUser(User user);
    User addUser(User user, String imageFileName, BufferedImage image) throws IOException;
}
