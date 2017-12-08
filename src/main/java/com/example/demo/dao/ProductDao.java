package com.example.demo.dao;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts();
    Product findById(long id);
    Product addProduct(Product product);
    void deleteProduct(Long id);
}
