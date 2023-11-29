package com.example.gradeservice.bodies.response;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {
    private String message;
    private Object data;
    private HttpStatus status;
}
