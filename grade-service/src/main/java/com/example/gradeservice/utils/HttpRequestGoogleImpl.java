package com.example.gradeservice.utils;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import lombok.AllArgsConstructor;

import java.io.IOException;


public class HttpRequestGoogleImpl implements HttpRequestInitializer {

    private Object object;

    public HttpRequestGoogleImpl(Credential credential){

    }

    @Override
    public void initialize(HttpRequest request) throws IOException {
    }
}
