package com.example.task_service.service;


import com.example.task_service.dto.PrivateUserCategoryDTO;
import com.example.task_service.dto.mapper.PrivateUserCategoryMapper;
import com.example.task_service.model.ModelImpliments.PrivateUserCategoryIMPL;
import com.example.task_service.model.PrivateUserCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrivateUserCategoryService {

    private final PrivateUserCategoryIMPL privateUserCategoryIMPL;

    private final PrivateUserCategoryMapper privateUserCategoryMapper;

    public List<PrivateUserCategoryDTO> getPrivateUserCategoriesByUserId(Long userId){
        return privateUserCategoryMapper.toDtoList(privateUserCategoryIMPL.getPrivateUserCategoriesByUserId(userId));
    }

}