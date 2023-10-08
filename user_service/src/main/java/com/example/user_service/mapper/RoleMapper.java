package com.example.user_service.mapper;

import com.example.user_service.dto.RoleDTO;
import com.example.user_service.dto.UserDTO;
import com.example.user_service.model.Role;
import com.example.user_service.model.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    RoleDTO toDto(Role role);

    Role toModel(RoleDTO roleDTO);

    List<RoleDTO> toDtoList(List<Role> list);

    List<Role> toEventList(List<RoleDTO> list);
}
