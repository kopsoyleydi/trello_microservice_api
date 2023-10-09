package com.example.user_service.dto;


import com.example.user_service.model.Role;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    Long id;

    String email;

    String name;

    String profileUrl;

    String surname;

    String dateOdBirth;

    @ManyToMany
    List<RoleDTO> roles;
}
