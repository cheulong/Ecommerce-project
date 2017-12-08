package com.example.demo.service;

import com.example.demo.dao.ProductDao;
import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductDao productDao;

    String urlPath;

    public void setUrlPath(String urlPath) {
        this.urlPath = urlPath;
    }

    public List<Product> addUrlPicture(List<Product> products) {
        for (Product product : products) {
            product.setImage(urlPath + "product/image/" + product.getImage());
        }
        return products;
    }

    public List<Product> getProducts() {
        return addUrlPicture(productDao.getProducts());
    }

    public Product findById(long id) {
        Product product = productDao.findById(id);
        if(product != null) {
            product.setImage(urlPath + "product/image/" + product.getImage());
        }
        return product;
    }

    public Product addProduct(Product product) {
        Product returnProduct = productDao.addProduct(product);
        returnProduct.setImage(urlPath + product.getImage());
        return returnProduct;
    }

    @Override
    public void deleteProduct(Long id) {
        productDao.deleteProduct(id);
    }


}


