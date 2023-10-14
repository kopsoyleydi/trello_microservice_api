package com.example.user_service.controller;


import com.example.user_service.bucket.S3Service;
import com.example.user_service.dto.UserDTO;

import com.example.user_service.requestBodies.UserRequest;
import com.example.user_service.service.UserRestService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@RequestMapping(value = "/api/user")
public class UserRestController {


    private final UserRestService userRestService;

    private final S3Service s3Service;

    private static final Logger logger = Logger.getLogger(String.valueOf(UserRestController.class));

    @GetMapping(value = "/getAllUsers")
    List<UserDTO> getAllUsers(){
        return userRestService.getAllUsers();
    }

    @PostMapping(value = "/addUser")
    ResponseEntity<?> addUser(@RequestBody UserRequest userRequest){
        try {
            return ResponseEntity.ok(userRestService.addNewUser(userRequest));
        }
        catch (Exception e){
            return new ResponseEntity<>(
                    HttpStatus.valueOf("Something went wrong")
            );

        }
    }

    @PostMapping(value = "/put_profile_image")
    ResponseEntity<?> putProfileImage(@RequestBody MultipartFile multipartFile, Long userId){
        try {
            return ResponseEntity.ok().body(userRestService.putProfileImage(multipartFile, userId));
        } catch (IOException exception) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
