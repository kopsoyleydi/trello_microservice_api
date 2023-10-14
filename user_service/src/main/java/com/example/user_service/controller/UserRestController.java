package com.example.user_service.controller;



import com.example.user_service.dto.UserDTO;
import com.example.user_service.requestBodies.ProfileBody;
import com.example.user_service.requestBodies.UserRequest;
import com.example.user_service.service.UserRestService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@RequestMapping(value = "/api/user")
public class UserRestController {

    private final UserRestService userRestService;



    private static final Logger logger = Logger.getLogger(String.valueOf(UserRestController.class));

    @GetMapping(value = "/getAllUsers")
    Page<UserDTO> getAllUsers(@RequestBody Pageable pageable){
        logger.info("The user list worked");
        return userRestService.getAllUsers(pageable);
    }

    @PostMapping(value = "/addUser")
    ResponseEntity<?> addUser(@RequestBody UserRequest userRequest){
        try {
            logger.info("User successfully added");
            return ResponseEntity.ok(userRestService.addNewUser(userRequest));
        }
        catch (Exception e){
            logger.warning("Something went woring");
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

}
