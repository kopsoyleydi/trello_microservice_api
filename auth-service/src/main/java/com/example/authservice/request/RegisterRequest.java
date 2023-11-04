package com.example.authservice.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    String name;
    String surname;
    String email;
    String password;
    String dateOfBirth;
}
