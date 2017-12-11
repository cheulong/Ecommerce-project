package camt.cbsd.config;

import camt.cbsd.dao.ProductDao;
import camt.cbsd.entity.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@ConfigurationProperties(prefix="server")
@Component
public class DataLoader implements ApplicationRunner{



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





    }
}
