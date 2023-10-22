package com.example.user_service.model.repository.repoIMPL;

import com.example.user_service.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserPaginationInter {

    Page<User> getPageWithAllUsers(Pageable pageable);
}
