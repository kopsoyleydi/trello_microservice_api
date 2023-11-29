package com.example.gradeservice.service.services.inter;

import com.google.api.services.sheets.v4.model.AppendValuesResponse;

import java.io.IOException;
import java.util.List;

public interface AppendValuesInter {
    public AppendValuesResponse appendValues(String spreadsheetId,
                                                    String range,
                                                    String valueInputOption,
                                                    List<List<Object>> values) throws IOException;


}
