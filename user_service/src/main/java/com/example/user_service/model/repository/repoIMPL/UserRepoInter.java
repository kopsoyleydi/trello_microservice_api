package com.example.user_service.model.repository.repoIMPL;

import com.example.user_service.model.User;

import java.util.List;

public interface UserRepoInter {
    List<User> getAllUsers();

    User getUserById(Long id);

    User addNewUser(User user);

    User changeUserInformation(User user);

    User getUserByEmail(String email);

    void deleteUserById(Long id);
}
