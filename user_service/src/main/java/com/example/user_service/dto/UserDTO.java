package com.example.user_service.dto;


import com.example.user_service.model.Role;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @ManyToOne
    public Role role;

}
