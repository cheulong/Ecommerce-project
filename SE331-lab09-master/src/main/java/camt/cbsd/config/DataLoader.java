package camt.cbsd.config;

import camt.cbsd.dao.ProductDao;
import camt.cbsd.dao.UserDao;
import camt.cbsd.entity.Product;
import camt.cbsd.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@ConfigurationProperties(prefix="server")
@Component
public class DataLoader implements ApplicationRunner{
    UserDao userDao;
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    ProductDao productDao;
    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    String baseUrl;
    String imageUrl;
    String imageBaseUrl;
    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        imageBaseUrl = baseUrl + imageUrl;
        User user1 = User.builder().userId("1234").firstName("a").lastName("a").email("a@gmail.com").phoneNumber("0999999999")
                .password("abc").address("1234").build();
        User user2 =  User.builder().userId("1235").firstName("b").lastName("b").email("b@gmail.com").phoneNumber("0999999999")
                .password("abc").address("1235").build();
        User user3 =  User.builder().userId("1236").firstName("c").lastName("c").email("c@gmail.com").phoneNumber("0999999999")
                .password("abc").address("1236").build();

        Product product1 = Product.builder().productId("1").productName("mario1").productPrice(12.0).productQuantity(10)
                .image(imageBaseUrl+"a.jpg").description("good shirt").size("M").color("Red").build();
        Product product2 =  Product.builder().productId("2").productName("mario2").productPrice(12.0).productQuantity(10)
                .image(imageBaseUrl+"b.jpg").description("good shirt").size("M").color("Red").build();
        Product product3 =  Product.builder().productId("3").productName("mario3").productPrice(12.0).productQuantity(10)
                .image(imageBaseUrl+"c.jpg").description("good shirt").size("M").color("Red").build();
        Product product4 =  Product.builder().productId("4").productName("mario4").productPrice(12.0).productQuantity(10)
                .image(imageBaseUrl+"d.jpg").description("good shirt").size("M").color("Red").build();

        productDao.add(product1);
        productDao.add(product2);
        productDao.add(product3);
        productDao.add(product4);

        userDao.addUser(user1);
        userDao.addUser(user2);
        userDao.addUser(user3);




    }
}
