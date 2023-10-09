package com.example.user_service.repoIMPL;

import com.example.user_service.model.User;




import java.util.List;

public interface UserRepoInter {
    List<User> getAllUsers();

    User getUserById(Long id);

    User addNewUser(User user);

    User changeUserById(User user);

    void deleteUserById(Long id);
}
