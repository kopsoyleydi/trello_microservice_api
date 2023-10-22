package com.example.task_service.dto.mapper;


import com.example.task_service.dto.PrivateUserCategoryDTO;
import com.example.task_service.model.PrivateUserCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrivateUserCategoryMapper {

    PrivateUserCategoryDTO toDto(PrivateUserCategory privateUserCategory);

    PrivateUserCategory toModel(PrivateUserCategoryDTO categoryDTO);

    List<PrivateUserCategoryDTO> toDtoList(List<PrivateUserCategory> list);

    List<PrivateUserCategory> toModelList(List<PrivateUserCategoryDTO> list);
}
