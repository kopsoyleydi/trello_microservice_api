package com.example.gradeservice.controller;


import com.example.gradeservice.bodies.response.CommonResponse;
import com.example.gradeservice.dto.GoogleSheetsDTO;
import com.example.gradeservice.service.services.CreateSheetService;
import com.example.gradeservice.service.services.inter.GetSheetServiceInter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/grade")
@RequiredArgsConstructor
public class FormulaController {

    private final GetSheetServiceInter getSheetServiceInter;

    private final CreateSheetService createSheetService;


    @GetMapping("/getSheetsInfo")
    private List<Object> getInfoFromSheet() throws GeneralSecurityException, IOException {
        return getSheetServiceInter.getSheetFromGoogle();
    }

    @PostMapping(value = "/addSheet")
    private CommonResponse addSheets(@RequestBody GoogleSheetsDTO googleSheetsDTO) throws GeneralSecurityException, IOException{
        try {
            return CommonResponse.builder()
                    .data(createSheetService.createGoogleSheet(googleSheetsDTO))
                    .message("Add Service")
                    .status(HttpStatus.CREATED).build();
        }
        catch (Exception e){
            return CommonResponse.builder().message("Failed").status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
