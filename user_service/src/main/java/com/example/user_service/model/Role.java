package com.example.user_service.model;

import jakarta.persistence.*;
import lombok.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;

@Data
@Slf4j
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
@Builder
public class Role implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "name")
    String roleName;

    @Override
    public String getAuthority() {
        return this.roleName;
    }
}
