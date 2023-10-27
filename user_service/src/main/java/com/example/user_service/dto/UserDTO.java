package com.example.user_service.dto;


import com.example.user_service.model.Role;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    public Long id;

    public String email;

    public String password;

    public String name;

    public String profileUrl;

    public String surname;

    public String dateOfBirth;

    @ManyToMany
    public List<Role> roles;

}
