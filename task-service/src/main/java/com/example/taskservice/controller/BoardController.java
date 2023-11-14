package com.example.taskservice.controller;

import com.example.taskservice.bodies.AddBoard;
import com.example.taskservice.dto.BoardDto;
import com.example.taskservice.dto.response.CommonResponse;
import com.example.taskservice.service.boardservice.BoardServiceInter;
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
        CommonResponse response = new CommonResponse();
        BoardDto boardDto = boardServiceInter.addBoard(addBoard);
        response.setMessage("Board added success");
        response.setData(boardDto);
        response.setStatus(HttpStatus.CREATED);
        return response;
    }

}
