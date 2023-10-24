package com.example.task_service.controller;

import com.example.task_service.apiBodies.PrivateUserCategoryRequest;
import com.example.task_service.dto.PrivateUserCategoryDTO;
import com.example.task_service.service.PrivateUserCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/task/private_category")
public class PrivateUserCategoryController {

    private final PrivateUserCategoryService privateUserCategoryService;

    @GetMapping(value = "/privateUserCategoryList/{userId}")
    public List<PrivateUserCategoryDTO> getPrivateUserCategories(@PathVariable Long userId){
        return privateUserCategoryService.getPrivateUserCategoriesByUserId(userId);
    }

    @PostMapping(value = "/privateUserCategory")
    public PrivateUserCategoryDTO addPrivateUserCategory(@RequestBody PrivateUserCategoryRequest privateUserCategoryRequest){
        return privateUserCategoryService.addPrivateUserCategory(privateUserCategoryRequest);
    }


}
