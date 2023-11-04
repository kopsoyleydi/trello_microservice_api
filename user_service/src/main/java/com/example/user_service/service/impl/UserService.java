package com.example.user_service.service.impl;



import com.example.user_service.model.ModelImpliments.RoleIMPL;
import com.example.user_service.model.ModelImpliments.UserIMPL;
import com.example.user_service.config.bucket.S3Service;
import com.example.user_service.dto.UserDTO;
import com.example.user_service.dto.mapper.UserMapper;
import com.example.user_service.model.Role;
import com.example.user_service.model.User;
import com.example.user_service.requestBodies.UserRequest;
import com.example.user_service.service.UserServiceInter;
import lombok.extern.slf4j.Slf4j;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@Service
@Slf4j
public class UserService implements UserServiceInter {

    @Autowired
    private UserIMPL userIMPL;

    @Autowired
    private RoleIMPL roleIMPL;

    @Autowired
    private UserMapper userMapper;


    @Autowired
    private S3Service s3Service;

    @Autowired
    private PasswordEncoder passwordEncoder;



    private static final Logger logger = Logger.getLogger(String.valueOf(UserService.class));


    public UserDTO getUserById(Long id){
        return userMapper.toDto(userIMPL.getUserById(id));
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        return userMapper.toDto(userIMPL.getUserByEmail(email));
    }

    public void changeUser(UserDTO userDTO){
        userMapper.toDto(userIMPL.changeUserInformation(userMapper.toModel(userDTO)));
    }

    public UserDTO addNewUser(UserRequest userRequest){
        Role role = roleIMPL.getRoleById(1L);
        User user = User.builder()
                .name(userRequest.getName())
                .password(passwordEncoder.encode(userRequest.getPassword()))
                .dateOfBirth(userRequest.getDateOfBirth())
                .surname(userRequest.getSurname())
                .email(userRequest.getEmail())
                .role(role).
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

    public byte[] getFileFromAws(Long userId) throws IOException{
        try {
            User user = userIMPL.getUserById(userId);
            logger.info("Success");
            byte[] ImageBytes =
                    s3Service.getObject(
                            "bekscloud", "trello_service/user_avatars/%s/%s"
                                    .formatted(user.getId(),
                                            user.getProfileUrl()));
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(ImageBytes).getBody();
        }
        catch (Exception e){
            e.getStackTrace();
        }
        return null;
    }

    public UserDTO changeUserInformation(UserRequest userRequest){
        User user = User.builder()
                        .id(userRequest.getId())
                                .surname(userRequest.getSurname())
                                        .name(userRequest.getName())
                                                .dateOfBirth(userRequest.getDateOfBirth()).build();
        return userMapper.toDto(userIMPL.changeUserInformation(user));
    }

}
