package com.example.user_service.dto.mapper;

import com.example.user_service.dto.UserDTO;
import com.example.user_service.model.User;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;


@Mapper(componentModel = "spring")
public interface UserPaginationMapper {
    Page<UserDTO> toPageList(Page<User> list);
}
