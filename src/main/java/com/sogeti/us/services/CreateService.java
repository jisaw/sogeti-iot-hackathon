package com.sogeti.us.services;

import com.google.gson.Gson;
import com.sogeti.us.controllers.CreateRequest;
import com.sogeti.us.model.ApiRecord;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
public class CreateService {


    public void createRecord(CreateRequest createRequest) {
        ApiRecord apiRecord = new ApiRecord(
                createRequest.getRecordedTimestamp(),
                createRequest.getLatitude(),
                createRequest.getLongitude(),
                createRequest.getObd2Data(),
                createRequest.getImageLocation());
        Gson gson  = new Gson();
        String json = gson.toJson(apiRecord);
        File file = new File(createRequest.getRecordedTimestamp().toString() + ".record");
        try (FileOutputStream output = new FileOutputStream(file)) {
            org.apache.commons.io.IOUtils.write(json, output, StandardCharsets.UTF_8);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
