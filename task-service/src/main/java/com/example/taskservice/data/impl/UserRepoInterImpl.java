package com.example.taskservice.data.impl;

import com.example.taskservice.data.repo.UserRepository;
import com.example.taskservice.data.repoInter.UserRepoInter;
import com.example.taskservice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserRepoInterImpl implements UserRepoInter {

    private final UserRepository userRepository;
    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public User changeUser(User user) {
        return userRepository.save(user);
    }
}
