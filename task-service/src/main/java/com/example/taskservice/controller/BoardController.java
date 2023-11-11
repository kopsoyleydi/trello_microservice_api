package com.example.taskservice.controller;

import com.example.taskservice.bodies.AddBoard;
import com.example.taskservice.dto.BoardDto;
import com.example.taskservice.dto.response.CommonResponse;
import com.example.taskservice.service.boardservice.BoardServiceInter;
import com.example.taskservice.service.boardservice.impl.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/tasks/board")
public class BoardController {

    private final BoardServiceInter boardServiceInter;


    @PostMapping(value = "/addBoard")
    public CommonResponse addBoardService(@RequestBody AddBoard addBoard){
        return CommonResponse.builder()
                .message("Board added success")
                .data(boardServiceInter.addBoard(addBoard))
                .status(HttpStatus.CREATED)
                .build();
    }
}
