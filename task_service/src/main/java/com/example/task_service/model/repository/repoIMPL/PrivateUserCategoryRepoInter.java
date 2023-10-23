package com.example.task_service.model.repository.repoIMPL;


import com.example.task_service.model.PrivateUserCategory;

import java.util.List;

public interface PrivateUserCategoryRepoInter {

    PrivateUserCategory addPrivateUserCategoryByUserId(PrivateUserCategory privateUserCategory);

    List<PrivateUserCategory> getPrivateUserCategoriesByUserId(Long userId);
}
