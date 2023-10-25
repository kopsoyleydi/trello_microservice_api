package com.example.user_service.model.ModelImpliments;

import com.example.user_service.model.User;
import com.example.user_service.model.repository.UserPaginationRepository;
import com.example.user_service.model.repository.repoIMPL.UserPaginationInter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserPaginationIMPL implements UserPaginationInter {

    private final UserPaginationRepository userPaginationRepository;
    @Override
    public Page<User> getPageWithAllUsers(Pageable pageable) {
        return userPaginationRepository
                .findAll(pageable);
    }
}
