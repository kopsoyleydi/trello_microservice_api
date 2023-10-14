package com.example.user_service.requestBodies;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProfileBody {

    Long id;

    String email;

    String pictureLink;
}
