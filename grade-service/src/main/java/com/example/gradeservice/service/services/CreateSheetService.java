package com.example.gradeservice.service.services;

import com.example.gradeservice.dto.GoogleSheetResponseDTO;
import com.example.gradeservice.dto.GoogleSheetsDTO;
import com.example.gradeservice.utils.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.Permission;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CreateSheetService {

    private final GoogleCredential googleCredential;

    private static final String APPLICATION_NAME = "Google Sheets API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    private static final List<String> SCOPES =
            Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);

    private static final String CREDENTIALS_FILE_PATH = "/credentials/credentials.json";

    private Sheets getSheetService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new Sheets.Builder(httpTransport, JSON_FACTORY, googleCredential.getToServicesMethod(httpTransport))
                .setApplicationName(APPLICATION_NAME).build();
    }

    private Drive getDriveService() throws GeneralSecurityException, IOException {
        final NetHttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
        return new Drive.Builder(httpTransport, JSON_FACTORY, googleCredential.getToServicesMethod(httpTransport))
                .setApplicationName(APPLICATION_NAME).build();
    }

    public GoogleSheetResponseDTO createGoogleSheet(GoogleSheetsDTO request)
            throws GeneralSecurityException, IOException {
        Sheets service = getSheetService();
        SpreadsheetProperties spreadsheetProperties = new SpreadsheetProperties();
        spreadsheetProperties.setTitle(request.getSheetName());
        SheetProperties sheetProperties = new SheetProperties();
        sheetProperties.setTitle(request.getSheetName());
        Sheet sheet = new Sheet().setProperties(sheetProperties);
        Spreadsheet spreadsheet = new Spreadsheet().setProperties(spreadsheetProperties)
                .setSheets(Collections.singletonList(sheet));
        Spreadsheet createdResponse = service.spreadsheets().create(spreadsheet).execute();
        final GoogleSheetResponseDTO googleSheetResponseDTO = new GoogleSheetResponseDTO();
        ValueRange valueRange = new ValueRange().setValues(request.getDataToBeUpdated());
        service.spreadsheets().values().update(createdResponse.getSpreadsheetId(), "A1", valueRange)
                .setValueInputOption("RAW").execute();
        googleSheetResponseDTO.setSpreadSheetId(createdResponse.getSpreadsheetId());
        googleSheetResponseDTO.setSpeadSheetUrl(createdResponse.getSpreadsheetUrl());


        Drive driveService = getDriveService();
        request.getEmails().forEach(emailAddress -> {
            Permission permission = new Permission().setType("user").setRole("writer").setEmailAddress(emailAddress);
            try {
                driveService.permissions().create(createdResponse.getSpreadsheetId(), permission)
                        .setSendNotificationEmail(true).setEmailMessage("Google Sheet Permission testing");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return googleSheetResponseDTO;
    }
}
