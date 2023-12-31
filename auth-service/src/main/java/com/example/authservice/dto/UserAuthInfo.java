package com.example.authservice.dto;

import lombok.*;


import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserAuthInfo {
    public Long id;

    public String email;

    public String password;

    public String name;

    public String profileUrl;

    public String surname;

    public String dateOfBirth;

    public RoleDto role;
}
