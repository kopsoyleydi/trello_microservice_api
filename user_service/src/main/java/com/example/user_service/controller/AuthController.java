package com.example.user_service.controller;


import com.example.user_service.dto.UserDTO;
import com.example.user_service.requestBodies.UserRequest;
import com.example.user_service.requestBodies.response.CommonResponse;
import com.example.user_service.service.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.logging.Logger;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/users/auth")
public class AuthController {
    private final UserService userRestService;

    private static final Logger logger = Logger.getLogger(String.valueOf(AuthController.class));


    @PostMapping(value = "/register")
    CommonResponse addUser(@RequestBody UserRequest userRequest){
        try {
            logger.info("User successfully added");
            userRestService.addNewUser(userRequest);
            return CommonResponse.builder().data(new Date().getTime()).message("Register success")
                    .status(HttpStatus.OK).build();
        }
        catch (Exception e){
            logger.warning("Something went woring");
            return CommonResponse.builder()
                    .message("Something went wrong")
                    .data(new Date().getTime())
                    .status(HttpStatus.MULTI_STATUS)
                    .build();
        }
    }

    @GetMapping("login/{email}")
    public CommonResponse getUserByEmail(@PathVariable String email) {
        UserDTO userDTO = userRestService.getUserByEmail(email);
        return CommonResponse.builder()
                .status(HttpStatus.OK)
                .data(userDTO)
                .message("Success")
                .build();
    }
}
