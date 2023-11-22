package com.example.gradeservice.service;

import com.google.api.client.json.JsonFactory;
import netscape.javascript.JSObject;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public interface GetSheetServiceInter {

    List<Object> getSheetFromGoogle() throws GeneralSecurityException, IOException;
}
