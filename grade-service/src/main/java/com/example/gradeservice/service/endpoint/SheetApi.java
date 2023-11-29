package com.example.gradeservice.service.endpoint;


import com.example.gradeservice.bodies.response.CommonResponse;
import com.example.gradeservice.service.services.AppendValues;
import com.example.gradeservice.service.services.inter.AppendValuesInter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SheetApi {

    private final AppendValuesInter appendValuesInter;

    public CommonResponse appendValuesToSheet(){
        return null;
    }
}
