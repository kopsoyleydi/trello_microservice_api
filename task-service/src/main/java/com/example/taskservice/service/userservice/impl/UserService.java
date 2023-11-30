package com.example.taskservice.service.userservice.impl;

import com.example.taskservice.dto.UserDto;
import com.example.taskservice.localConnect.requestLocal.UserAuthInfo;
import com.example.taskservice.localConnect.service.UserConnect;
import com.example.taskservice.service.userservice.UserServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserServiceInter {

    private final UserConnect userConnect;

    public UserDto getUserInfoById(Long id){
        UserDto userDto = new UserDto();
        UserAuthInfo userAuthInfo = userConnect.getUserInfo(id);
        userDto.setId(userAuthInfo.getId());
        userDto.setEmail(userAuthInfo.getEmail());
        userDto.setUsername(userAuthInfo.name + userAuthInfo.surname);
        return userDto;
    }
}
