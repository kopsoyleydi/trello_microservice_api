package com.example.user_service.service;

import com.example.user_service.dto.UserDTO;
import com.example.user_service.requestBodies.UserRequest;

public interface UserServiceInter {

    public UserDTO addNewUser(UserRequest userRequest);

    public UserDTO getUserById(Long id);

    public UserDTO getUserByEmail(String email);
}
