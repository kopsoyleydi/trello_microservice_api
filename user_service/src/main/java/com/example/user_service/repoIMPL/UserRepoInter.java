package com.example.user_service.repoIMPL;

import com.example.user_service.model.User;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Optional;

@FieldDefaults(level = AccessLevel.PUBLIC)
public interface UserRepoInter {
    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User addNewUser(User user);

    User changeUserById(User user);

    void deleteUserById(Long id);
}
