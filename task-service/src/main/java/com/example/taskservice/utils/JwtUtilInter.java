package com.example.taskservice.utils;

public interface JwtUtilInter {

    String extractRole(String jwt);

    String extractEmail(String jwt);
}
