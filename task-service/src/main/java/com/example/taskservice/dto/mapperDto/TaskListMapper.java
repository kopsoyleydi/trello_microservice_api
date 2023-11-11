package com.example.taskservice.dto.mapperDto;


import com.example.taskservice.dto.TaskListDto;
import com.example.taskservice.model.TaskList;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskListMapper {
    TaskListDto toDto(TaskList taskList);

    TaskList toModel(TaskListDto taskListDto);

    List<TaskListDto> toDtoList(List<TaskList> list);

    List<TaskList> toModelList(List<TaskListDto> list);
}
