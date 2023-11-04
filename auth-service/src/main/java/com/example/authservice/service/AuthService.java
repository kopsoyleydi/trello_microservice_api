package com.example.authservice.service;

import com.example.authservice.request.AuthRequest;
import com.example.authservice.request.RegisterRequest;
import com.example.authservice.response.CommonResponse;

public interface AuthService {

    CommonResponse register(RegisterRequest registerRequest);

    CommonResponse login(AuthRequest authRequest);
}
