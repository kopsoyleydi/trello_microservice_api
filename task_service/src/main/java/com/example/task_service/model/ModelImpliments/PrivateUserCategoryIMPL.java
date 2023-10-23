package com.example.task_service.model.ModelImpliments;

import com.example.task_service.model.PrivateUserCategory;
import com.example.task_service.model.repository.PrivateUserCategoryRepository;
import com.example.task_service.model.repository.repoIMPL.PrivateUserCategoryRepoInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrivateUserCategoryIMPL implements PrivateUserCategoryRepoInter {

    private final PrivateUserCategoryRepository privateUserCategoryRepository;

    @Override
    public PrivateUserCategory addPrivateUserCategoryByUserId(PrivateUserCategory privateUserCategory) {
        return privateUserCategoryRepository.save(privateUserCategory);
    }

    @Override
    public List<PrivateUserCategory> getPrivateUserCategoriesByUserId(Long userId) {
        return privateUserCategoryRepository.findAllByUserId(userId);
    }
}
