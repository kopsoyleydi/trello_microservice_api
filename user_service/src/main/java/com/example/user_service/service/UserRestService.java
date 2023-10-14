package com.example.user_service.service;



import com.example.user_service.model.ModelImpliments.RoleIMPL;
import com.example.user_service.model.ModelImpliments.UserIMPL;
import com.example.user_service.config.bucket.S3Service;
import com.example.user_service.dto.UserDTO;
import com.example.user_service.dto.mapper.UserMapper;
import com.example.user_service.model.Role;
import com.example.user_service.model.User;
import com.example.user_service.requestBodies.UserRequest;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
@Slf4j
@RequiredArgsConstructor
@Builder
public class UserRestService {

    private final UserIMPL userIMPL;

    private final RoleIMPL roleIMPL;

    private final UserMapper userMapper;

    private final S3Service s3Service;


    private static final Logger logger = Logger.getLogger(String.valueOf(UserRestService.class));

    public List<UserDTO> getAllUsers(){
        return userMapper.toDtoList(userIMPL.getAllUsers());
    }

    public UserDTO getUserById(Long id){
        return userMapper.toDto(userIMPL.getUserById(id));
    }

    public void changeUser(UserDTO userDTO){
        userMapper.toDto(userIMPL.changeUserById(userMapper.toModel(userDTO)));
    }

    public UserDTO addNewUser(UserRequest userRequest){
        Role role = roleIMPL.getRoleById(1L);
        List<Role> roles = new ArrayList<>();
        roles.add(role);
        User user = User.builder()
                .name(userRequest.getName())
                .password(userRequest.getPassword())
                .dateOdBirth(userRequest.getDateOfBirth())
                .surname(userRequest.getSurname())
                .email(userRequest.getEmail())
                .roles(roles).
                build();
        logger.info("success");
        return userMapper.toDto(userIMPL.addNewUser(user));
    }

    public UserDTO putProfileImage(MultipartFile multipartFile, Long userId) throws IOException {
        String profileImageId = UUID.randomUUID().toString();
        UserDTO user = getUserById(userId);
        s3Service.putObject(
                "bekscloud",
                "trello_service/user_avatars/%s/%s".formatted(userId,profileImageId),
                multipartFile.getBytes()
        );
        user.setProfileUrl(profileImageId);
        changeUser(user);
        logger.info("success");
        return user;
    }
}
