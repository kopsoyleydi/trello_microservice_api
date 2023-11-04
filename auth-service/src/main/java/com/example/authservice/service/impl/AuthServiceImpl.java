package com.example.authservice.service.impl;

import com.example.authservice.request.AuthRequest;
import com.example.authservice.request.RegisterRequest;
import com.example.authservice.response.CommonResponse;
import com.example.authservice.service.AuthService;
import com.example.authservice.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final WebClient.Builder webClientBuilder;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    @Override
    public CommonResponse register(RegisterRequest registerRequest) {
         CommonResponse response = webClientBuilder.build()
                .post()
                .uri("http://user-service/api/users")
                .bodyValue(registerRequest)
                .retrieve()
                .bodyToMono(CommonResponse.class)
                .block();

        if (response == null) {
            return CommonResponse.builder()
                    .message("User creation failed")
                    .status(500)
                    .build();
        }

        return response;
    }

    @Override
    public CommonResponse login(AuthRequest authRequest) {
        return null;
    }
}
