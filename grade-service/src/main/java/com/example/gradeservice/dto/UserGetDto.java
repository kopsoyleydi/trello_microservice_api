package com.example.gradeservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserGetDto {
    public Long id;

    public String email;

    public String password;

    public String name;

    public String profileUrl;

    public String surname;

    public String dateOfBirth;

    public RoleDto role;
}
