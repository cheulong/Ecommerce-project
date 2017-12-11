package camt.cbsd.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import javax.persistence.Entity;
import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //comment id as a String to use mongoDB
    Long id;
    String userId;
    String firstName;
   String lastName;
   String email;
   String password;
   String address;
   String phoneNumber;



    @ManyToMany
    List<Product> keepProduct = new ArrayList<>();

    public List<Product> addProduct(Product product) {
        keepProduct = Optional.ofNullable(keepProduct).orElse(new ArrayList<>());
        keepProduct.add(product);
        return keepProduct;

    }

}
