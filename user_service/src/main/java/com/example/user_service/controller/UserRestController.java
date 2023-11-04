package com.example.user_service.controller;



import com.example.user_service.requestBodies.ProfileBody;
import com.example.user_service.requestBodies.UserRequest;
import com.example.user_service.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users/api")
public class UserRestController {

    private final UserService userRestService;

    private static final Logger logger = Logger.getLogger(String.valueOf(UserRestController.class));

    @PostMapping(value = "/put_profile_image")
    ResponseEntity<?> putProfileImage(@RequestBody MultipartFile multipartFile, Long userId){
        try {
            return ResponseEntity.ok().body(userRestService.putProfileImage(multipartFile, userId));
        } catch (IOException exception) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping (value = "/getCurrentUser")
    ResponseEntity<?> getCurrentUser(@RequestBody ProfileBody profileBody){
        try {
            return ResponseEntity
                    .ok()
                    .body(userRestService.getUserById(profileBody.getId()));
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().body("Something went wrong");
        }
    }

    @GetMapping(value = "/getProfilePicture")
    ResponseEntity<?> getProfilePicture(@RequestBody ProfileBody profileBody){
        try {
            return ResponseEntity.ok().body(userRestService.getFileFromAws(profileBody.getId()));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Picture not found or picture not added");
        }
    }

    @PostMapping(value = "/changeUserInformation")
    ResponseEntity<?> changeUserInformation(@RequestBody UserRequest userRequest){
        try {
            logger.info("User information was changes");
            return ResponseEntity
                    .ok()
                    .body(userRestService.changeUserInformation(userRequest));
        }
        catch (Exception e){
            logger.warning("Something went wrong in change user information endpoint");
            return ResponseEntity.internalServerError().body("Something went wrong");
        }
    }

    @GetMapping(value = "/getUserByEmail")
    ResponseEntity<?> getUserByEmail(@RequestParam String email){
        try {
            logger.info("Get Email");
            return ResponseEntity
                    .ok()
                    .body(userRestService.getUserByEmail(email));
        }
        catch (Exception e){
            logger.warning("Something went wrong in change user information endpoint");
            return ResponseEntity.internalServerError().body("Something went wrong");
        }
    }

}
