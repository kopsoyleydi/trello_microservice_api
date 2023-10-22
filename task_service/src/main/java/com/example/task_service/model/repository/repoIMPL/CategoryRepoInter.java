package com.example.task_service.model.repository.repoIMPL;

import com.example.task_service.model.Category;

public interface CategoryRepoInter {

    Category addCategory(Category category);

    Category changeCategory(Category category);
}
