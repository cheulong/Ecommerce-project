package com.example.demo.dao;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import org.assertj.core.util.Lists;

import java.util.List;

public class ProductDaoImpl implements ProductDao {

    ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return Lists.newArrayList(productRepository.findAll());
    }

    @Override
    public Product findById(long id) {
        return productRepository.findOne(id);
    }

    @Override
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findOne(id);
        productRepository.delete(product);
    }
}
