package com.example.taskservice.dto.mapper;


import com.example.taskservice.dto.UserDto;
import com.example.taskservice.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto(User user);

    User toModel(UserDto userDto);

    List<UserDto> toDtoList(List<User> list);

    List<User> toModelList(List<UserDto> list);
}
