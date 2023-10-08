package com.example.user_service.repoIMPL;

import com.example.user_service.model.User;




import java.util.List;
import java.util.Optional;

public interface UserRepoInter {
    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    User addNewUser(User user);

    User changeUserById(User user);

    void deleteUserById(Long id);
}
