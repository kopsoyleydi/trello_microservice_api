package com.example.user_service.service;


import com.example.user_service.DataImpliments.RoleIMPL;
import com.example.user_service.DataImpliments.UserIMPL;
import com.example.user_service.dto.RoleDTO;
import com.example.user_service.dto.UserDTO;
import com.example.user_service.mapper.UserMapper;
import com.example.user_service.model.Role;
import com.example.user_service.model.User;
import com.example.user_service.requestBodies.UserRequest;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PUBLIC)
public class UserService {

    private final UserIMPL userIMPL;

    private final RoleIMPL roleIMPL;

    private final UserMapper userMapper;

    public List<UserDTO> getAllUsers(){
        return userMapper.toDtoList(userIMPL.getAllUsers());
    }

    public UserDTO getUserById(Long id){
        return userMapper.toDto(userIMPL.getUserById(id).get());
    }

    public UserDTO changeUser(UserDTO userDTO){
        return userMapper.toDto(userIMPL.changeUserById(userMapper.toModel(userDTO)));
    }

    public UserDTO addNewUser(UserRequest userRequest){
        Role role = roleIMPL.getRoleById(userRequest.getRoleID());
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        return userMapper.toDto(userIMPL.addNewUser(User.builder()
                .name(userRequest.getName())
                .surname(userRequest.getSurname())
                .email(userRequest.getEmail())
                .dateOdBirth(userRequest.getDateOdBirth())
                .roles(roles).build()));
    }

}
