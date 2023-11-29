package com.example.taskservice.service.getInformationFromOtherService.user;


import com.example.taskservice.dto.UserDto;
import com.example.taskservice.dto.response.CommonResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class GetUser {

    private final WebClient.Builder webClient;

    public CommonResponse getUserFromUserService(String email){
        UserDto userDto = new UserDto();
        CommonResponse response = webClient.build()
                .post()
                .uri("http://user-service/users/api/getUserByEmail/{"+email+"}")
                .bodyValue(userDto)
                .retrieve()
                .bodyToMono(CommonResponse.class)
                .block();

        if (response == null) {
            return CommonResponse.builder()
                    .message("User creation failed")
                    .status(HttpStatus.MULTI_STATUS)
                    .data(userDto)
                    .build();
        }
        return response;
    }

}
