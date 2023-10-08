package com.example.user_service.controller;


import com.example.user_service.dto.UserDTO;
import com.example.user_service.requestBodies.UserRequest;
import com.example.user_service.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PUBLIC)
@RequestMapping(value = "/api/user")
public class UserRestController {


    private final UserService userService;

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

}
