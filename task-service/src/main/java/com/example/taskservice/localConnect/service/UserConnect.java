package com.example.taskservice.localConnect.service;


import com.example.taskservice.dto.response.CommonResponse;
import com.example.taskservice.localConnect.requestLocal.UserAuthInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class UserConnect {

    private final WebClient.Builder webClientBuilder;

    public UserAuthInfo getUserInfo(Long id){

        UserAuthInfo userAuthInfo = new UserAuthInfo();
        CommonResponse response = webClientBuilder.build().post()
                .uri("http://user-service/users/api/getUserById/id")
                .bodyValue(userAuthInfo)
                .retrieve()
                .bodyToMono(CommonResponse.class)
                .block();

        return userAuthInfo;

    }
}
