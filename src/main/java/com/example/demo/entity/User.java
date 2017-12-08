package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Data
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = "true")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @NonNull
    String firstName;

    @NonNull
    String lastName;

    @NonNull
    String emailAddress;

    @NonNull
    String password;

    @NonNull
    String address;


}
