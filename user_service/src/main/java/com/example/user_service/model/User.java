package com.example.user_service.model;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "email", unique = true)
    public String email;

    @Column(name = "password")
    public String password;

    @Column(name = "name")
    public String name;

    @Column(name = "profile_url")
    public String profileUrl;

    @Column(name = "surname")
    public String surname;

    @Column(name = "date_of_birth")
    public String dateOfBirth;

    @ManyToOne
    public Role role;

}
