package com.example.user_service.model;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "email")
    public String email;

    @Column(name = "name")
    public String name;

    @Column(name = "profile_url")
    public String profileUrl;

    @Column(name = "surname")
    public String surname;

    @Column(name = "date_of_birth")
    public String dateOdBirth;

    @Column(name = "user_roles")
    @ManyToMany
    public List<Role> roles;

}
