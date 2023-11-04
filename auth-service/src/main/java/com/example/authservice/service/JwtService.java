package com.example.authservice.service;

import com.example.authservice.dto.UserAuthInfo;

public interface JwtService {
    String generateToken(UserAuthInfo userAuthInfo);
}
