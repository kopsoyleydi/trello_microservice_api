package com.example.gradeservice.service.services.inter;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface GetSheetServiceInter {

    List<Object> getSheetFromGoogle() throws GeneralSecurityException, IOException;
}
