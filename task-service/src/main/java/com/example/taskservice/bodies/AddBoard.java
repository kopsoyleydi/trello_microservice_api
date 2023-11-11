package com.example.taskservice.bodies;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddBoard {
    String name;
}
