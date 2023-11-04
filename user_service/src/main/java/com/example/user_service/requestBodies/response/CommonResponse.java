package com.example.user_service.requestBodies.response;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class CommonResponse {
    private String message;
    private Object data;
    private HttpStatus status;
}
