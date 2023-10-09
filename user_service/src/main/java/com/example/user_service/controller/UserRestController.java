package com.example.user_service.controller;


import com.example.user_service.bucket.S3Service;
import com.example.user_service.dto.UserDTO;

import com.example.user_service.requestBodies.UserRequest;
import com.example.user_service.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@RequestMapping(value = "/api/user")
public class UserRestController {


    private final UserService userService;

    private final S3Service s3Service;

    private static final Logger logger = Logger.getLogger(String.valueOf(UserRestController.class));

    @GetMapping(value = "/getAllUsers")
    List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value = "/addUser")
    ResponseEntity<?> addUser(@RequestBody UserRequest userRequest){
        try {
            return ResponseEntity.ok(userService.addNewUser(userRequest));
        }
        catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.valueOf("Something went wrong")
            );

        }
    }

    @PostMapping(value = "/put_profile_image")
    ResponseEntity<?> putProfileImage(@RequestBody MultipartFile multipartFile, Long userId){
        String profileImageId = UUID.randomUUID().toString();
        UserDTO user = new UserDTO();
        try {
            s3Service.putObject(
                    "bekscloud",
                    "trello_service/user_avatars/%s/%s".formatted(userId,profileImageId),
                    multipartFile.getBytes()
            );
            user.setProfileUrl(profileImageId);
            userService.changeUser(user);
            logger.info("success");
            return ResponseEntity.ok().body("Success");
        } catch (IOException exception) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
