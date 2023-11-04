package com.example.authservice.controller;

import com.example.authservice.request.AuthRequest;
import com.example.authservice.request.RegisterRequest;
import com.example.authservice.response.CommonResponse;
import com.example.authservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public CommonResponse register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @PostMapping("/login")
    public CommonResponse login(@RequestBody AuthRequest loginRequest) {
        return authService.login(loginRequest);
    }
}
