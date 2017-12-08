package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findByName(String name);

    List<Product> findByNameIgnoreCaseContainingOrderByName(String name);

    List<Product> findByDescriptionIgnoreCaseContaining(String description);

    List<Product> findByIntervalPrice(String min, String max);
}
