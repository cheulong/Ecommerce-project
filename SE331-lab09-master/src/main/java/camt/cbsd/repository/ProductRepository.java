package camt.cbsd.repository;

import camt.cbsd.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProductRepository extends CrudRepository<Product,Long> {


}