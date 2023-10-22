package com.example.task_service.model.repository.repoIMPL;


import com.example.task_service.model.PrivateUserCategory;

public interface PrivateUserCategoryRepoInter {

    PrivateUserCategory addUserPrivateCategory(PrivateUserCategory privateUserCategory);

    PrivateUserCategory addPrivateUserCategoryByUserId(PrivateUserCategory privateUserCategory);
}
