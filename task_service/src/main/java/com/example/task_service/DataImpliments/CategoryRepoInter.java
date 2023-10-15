package com.example.task_service.DataImpliments;

import com.example.task_service.model.Category;

public interface CategoryRepoInter {

    Category addCategory(Category category);

    Category changeCategory(Category category);
}
