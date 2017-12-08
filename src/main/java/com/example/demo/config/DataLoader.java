package com.example.demo.config;

import com.example.demo.dao.ProductDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Product;
import com.example.demo.entity.User;
import com.example.demo.repository.AuthorityRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

public class DataLoader implements ApplicationRunner {
    UserDao userDao;
    ProductDao productDao;

    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthorityRepository authorityRepository;
    @Autowired
    UserService userService;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        productDao.addProduct(Product.builder().name("Mario T shirt").price(1200).quantity(20).description("Cool Mario t-shirt").image("5x.jpg").build());
        productDao.addProduct(Product.builder().name("Nintendo DS").price(3500).quantity(25).description("Nintendo DS").image("5x.jpg").build());
        productDao.addProduct(Product.builder().name("Nintendo 3DS").price(3500).quantity(25).description("Nintendo 3DS").image("5x.jpg").build());
        productDao.addProduct(Product.builder().name("Nintendo 3DS Max").price(3500).quantity(25).description("Nintendo DS Max").image("5x.jpg").build());
        productDao.addProduct(Product.builder().name("Nintendo Switch").price(3500).quantity(25).description("Nintendo Switch").image("5x.jpg").build());
        productDao.addProduct(Product.builder().name("Nintendo DS").price(3500).quantity(25).description("Nintendo DS").image("5x.jpg").build());

        User user1 = User.builder().firstName("Kitsada").lastName("Tangpoolponsavatdi").emailAddress("alienware16x@gmail.com").password("lionking2001").address("137 Moo.12 Kanthalaluk Sisaket 33110").build();
        User user2 = User.builder().firstName("Cheulong").lastName("Sear").emailAddress("sear_cheulong@cmu.ac.th").password("test123").address("137 Moo.15 Suthep Chiangmai 33000").build();

    }


}
