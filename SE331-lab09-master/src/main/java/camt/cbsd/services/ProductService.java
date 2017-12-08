package camt.cbsd.services;

import camt.cbsd.entity.Product;

import java.util.List;


public interface ProductService {
    List<Product> list();
    Product add(Product course);
    Product findById(long id);

}
