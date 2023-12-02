package com.example.taskservice.controller;

import com.example.taskservice.bodies.AddBoard;
import com.example.taskservice.bodies.ChangeBoard;
import com.example.taskservice.dto.BoardDto;
import com.example.taskservice.dto.response.CommonResponse;
import com.example.taskservice.service.second.boardservice.BoardServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/api/tasks/board")
public class BoardController {

    private final BoardServiceInter boardServiceInter;

    @PostMapping(value = "/addBoard")
    public CommonResponse addBoardService(@RequestBody AddBoard addBoard){
        return CommonResponse.builder()
                .message("New Board added success")
                .data(boardServiceInter.addBoard(addBoard))
                .status(HttpStatus.CREATED)
                .build();
    }

    @PutMapping(value = "/changeBoard")
    public CommonResponse changeBoardEndPoint(@RequestBody ChangeBoard changeBoard){
        return CommonResponse.builder()
                .message("Board change success")
                .data(boardServiceInter.changeBoard(changeBoard))
                .status(HttpStatus.OK)
                .build();
    }

}
