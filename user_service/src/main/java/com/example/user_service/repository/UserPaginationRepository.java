package com.example.user_service.repository;

import com.example.user_service.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserPaginationRepository extends PagingAndSortingRepository<User, Long> {
}
