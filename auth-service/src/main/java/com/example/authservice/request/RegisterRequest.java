package com.example.authservice.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterRequest {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private String dateOfBirth;
}
