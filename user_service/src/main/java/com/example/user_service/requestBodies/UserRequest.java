package com.example.user_service.requestBodies;

import com.example.user_service.dto.RoleDTO;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    Long id;

    String email;

    String password;

    String name;

    String surname;

    String dateOdBirth;

}
