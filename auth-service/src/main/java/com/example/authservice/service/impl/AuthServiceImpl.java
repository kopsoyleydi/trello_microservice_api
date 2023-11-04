package com.example.authservice.service.impl;

import com.example.authservice.dto.UserAuthInfo;
import com.example.authservice.request.AuthRequest;
import com.example.authservice.request.RegisterRequest;
import com.example.authservice.response.CommonResponse;
import com.example.authservice.service.AuthService;
import com.example.authservice.service.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
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
                .uri("http://user-service/users/auth/register")
                .bodyValue(registerRequest)
                .retrieve()
                .bodyToMono(CommonResponse.class)
                .block();

        if (response == null) {
            return CommonResponse.builder()
                    .message("User creation failed")
                    .status(HttpStatus.MULTI_STATUS)
                    .build();
        }

        return response;
    }

    @Override
    public CommonResponse login(AuthRequest authRequest) {
        CommonResponse response = webClientBuilder.build()
                .get()
                .uri("http://user-service/users/auth/login/" + authRequest.getEmail())
                .retrieve()
                .bodyToMono(CommonResponse.class)
                .block();

        UserAuthInfo userAuthInfo = new ObjectMapper().convertValue(response.getData(), UserAuthInfo.class);

        if (userAuthInfo == null || !passwordEncoder.matches(authRequest.getPassword(), userAuthInfo.getPassword())) {
            response = CommonResponse.builder()
                    .status(HttpStatus.BAD_REQUEST)
                    .message("Invalid credentials")
                    .build();
            return response;
        }

        String token = jwtService.generateToken(userAuthInfo);


        return CommonResponse.builder()
                .status(HttpStatus.OK)
                .message("Login success")
                .data(token)
                .build();
    }
}
