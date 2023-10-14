package com.example.user_service.requestBodies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    Long id;

    String email;

    String password;

    String name;

    String surname;

    String dateOfBirth;

}
