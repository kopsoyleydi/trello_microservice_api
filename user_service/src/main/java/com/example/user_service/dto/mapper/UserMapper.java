package com.example.user_service.dto.mapper;


import com.example.user_service.dto.UserDTO;
import com.example.user_service.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDto(User user);

    User toModel(UserDTO userDTO);

    List<UserDTO> toDtoList(List<User> list);

    List<User> toEventList(List<UserDTO> list);
}
