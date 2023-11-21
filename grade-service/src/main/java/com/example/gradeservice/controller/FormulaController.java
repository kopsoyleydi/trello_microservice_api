package com.example.gradeservice.controller;


import com.example.gradeservice.config.GoogleSheetsConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/grade")
@RequiredArgsConstructor
public class FormulaController {

    private final GoogleSheetsConfig googleSheetsConfig;


    @GetMapping("/getSheetsInfo")
    private List<Object> getInfoFromSheet() throws GeneralSecurityException, IOException {
        return googleSheetsConfig.getInfoFromSheet();
    }
}
