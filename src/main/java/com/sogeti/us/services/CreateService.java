package com.sogeti.us.services;

import com.google.gson.Gson;
import com.sogeti.us.model.ApiRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

@Component
public class CreateService {

    private final String dataPath;

    private final Gson gson;

    @Autowired
    public CreateService(@Value("${data.path:/home/azure/data/}") String dataPath, Gson gson) {
        this.dataPath = dataPath;
        this.gson = gson;
    }

    public void createRecord(ApiRecord apiRecord) {
        String json = gson.toJson(apiRecord);
        File file = new File(dataPath + UUID.randomUUID().toString() + ".record.json");
        try (FileOutputStream output = new FileOutputStream(file)) {
            org.apache.commons.io.IOUtils.write(json, output, StandardCharsets.UTF_8);
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        }
    }
}
