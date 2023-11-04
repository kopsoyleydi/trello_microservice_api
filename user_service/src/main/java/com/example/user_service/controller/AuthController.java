package com.example.user_service.controller;


import com.example.user_service.requestBodies.UserRequest;
import com.example.user_service.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users/auth")
public class AuthController {

    private final UserService userRestService;

    private static final Logger logger = Logger.getLogger(String.valueOf(AuthController.class));


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

}
