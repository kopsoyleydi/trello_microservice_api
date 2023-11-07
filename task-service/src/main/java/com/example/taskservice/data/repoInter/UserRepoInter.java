package com.example.taskservice.data.repoInter;

import com.example.taskservice.model.User;

public interface UserRepoInter {

    User addUser(User user);

    void deleteUser(User user);

    User changeUser(User user);
}
