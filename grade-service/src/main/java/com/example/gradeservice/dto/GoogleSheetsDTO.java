package com.example.gradeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoogleSheetsDTO {

    private String sheetName;

    private List<List<Object>> dataToBeUpdated;

    private List<String> emails;
}
