package com.example.auth_service.responces;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthRequest {
    String email;

    String password;

    String name;

    String surname;

    String dateOfBirth;
}