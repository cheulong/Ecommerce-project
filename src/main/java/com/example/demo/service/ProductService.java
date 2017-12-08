package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();
    Product findById(long id);
    Product addProduct(Product product);
    void deleteProduct(Long id);

}
