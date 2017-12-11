package camt.cbsd.services;

import camt.cbsd.dao.UserDao;
import camt.cbsd.entity.Product;
import camt.cbsd.entity.User;
import org.apache.commons.io.FilenameUtils;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;



@Service
@ConfigurationProperties(prefix = "server")
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;


    String imageServerDir;

    public void setImageServerDir(String imageServerDir) {
        this.imageServerDir = imageServerDir;
    }

    @Transactional
    public List<User> getStudents() {
        List<User> users = userDao.getUsers();
        for (User user : users) {
            Hibernate.initialize(user.getKeepProduct());
        }
        return users;
    }

    @Override
    @Transactional
    public User findById(long id) {
        User user = userDao.findById(id);
        Hibernate.initialize(user.getKeepProduct());
        return user;
    }

    @Override
    public User addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User addUser(User user, String imageFileName, BufferedImage image) throws IOException {
        // save file to the server
        int newId = userDao.size() + 1;
        String newFilename = newId + "." + imageFileName;
        File targetFile = Files.createFile(Paths.get(imageServerDir + newFilename)).toFile();
        ImageIO.write(image, FilenameUtils.getExtension(imageFileName), targetFile);

        // user.setImage(newFilename);
        userDao.addUser(user);
        return user;
    }


}