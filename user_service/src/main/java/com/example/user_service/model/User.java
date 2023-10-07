package com.example.user_service.model;


import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long id;

    @Column(name = "email")
    String email;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "date_of_birth")
    String dateOdBirth;

}
