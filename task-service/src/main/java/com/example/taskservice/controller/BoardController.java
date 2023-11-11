package com.example.taskservice.controller;

import com.example.taskservice.dto.BoardDto;
import com.example.taskservice.dto.response.CommonResponse;
import com.example.taskservice.service.boardservice.BoardServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/tasks/board")
public class BoardController {

    private final BoardServiceInter boardServiceInter;

    @PostMapping(value = "/addBoard")
    public CommonResponse addBoardService(@RequestBody BoardDto boardDto){
        return CommonResponse.builder()
                .message("Board added success")
                .data(boardServiceInter.addBoard(boardDto))
                .build();
    }
}
