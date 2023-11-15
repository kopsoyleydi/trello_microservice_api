package com.example.taskservice.bodies;


import com.example.taskservice.model.TaskList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChangeBoard {
    private Long userId;

    private String name;

    private List<TaskList> lists;

}
