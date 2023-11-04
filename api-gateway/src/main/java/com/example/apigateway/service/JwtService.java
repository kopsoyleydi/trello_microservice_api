package com.example.apigateway.service;

public interface JwtService {

    String extractEmail(String jwt);

    boolean validateToken(String jwt, String comparedJwtInRedis);

    String extractRole(String jwt);
}
