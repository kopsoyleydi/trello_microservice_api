package com.example.gradeservice.service.services;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.googleapis.testing.auth.oauth2.MockGoogleCredential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.BatchGetValuesResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class BatchGetValues {

    /**
     * Returns one or more ranges of values from a spreadsheet.
     *
     * @param spreadsheetId - Id of the spreadsheet.
     * @param ranges        - Range of cells of the spreadsheet.
     * @return Values in the range
     * @throws IOException - if credentials file not found.
     */
    public static BatchGetValuesResponse batchGetValues(String spreadsheetId,
                                                        List<String> ranges)
            throws IOException {
        /* Load pre-authorized user credentials from the environment.
           TODO(developer) - See https://developers.google.com/identity for
            guides on implementing OAuth2 for your application. */
        MockGoogleCredential credentials = (MockGoogleCredential) MockGoogleCredential.getApplicationDefault()
                .createScoped(Collections.singleton(SheetsScopes.SPREADSHEETS));


        // Create the sheets API client
        Sheets service = new Sheets.Builder(new NetHttpTransport(),
                GsonFactory.getDefaultInstance(),
                credentials)
                .setApplicationName("Sheets samples")
                .build();

        BatchGetValuesResponse result = null;
        try {
            // Gets the values of the cells in the specified range.
            result = service.spreadsheets().values().batchGet(spreadsheetId)
                    .setRanges(ranges).execute();
            System.out.printf("%d ranges retrieved.", result.getValueRanges().size());
        } catch (GoogleJsonResponseException e) {
            // TODO(developer) - handle error appropriately
            GoogleJsonError error = e.getDetails();
            if (error.getCode() == 404) {
                System.out.printf("Spreadsheet not found with id '%s'.\n", spreadsheetId);
            } else {
                throw e;
            }
        }
        return result;
    }
}
