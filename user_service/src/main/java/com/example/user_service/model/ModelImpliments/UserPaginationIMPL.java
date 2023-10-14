package com.example.user_service.model.ModelImpliments;

import com.example.user_service.model.User;
import com.example.user_service.repository.UserPaginationRepository;
import com.example.user_service.repository.repoIMPL.UserPaginationInter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
