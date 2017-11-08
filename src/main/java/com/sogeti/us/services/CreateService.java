package com.sogeti.us.services;

import com.google.gson.Gson;
import com.microsoft.azure.storage.CloudStorageAccount;
import com.microsoft.azure.storage.blob.CloudBlobClient;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.file.CloudFileClient;
import com.microsoft.azure.storage.file.CloudFileDirectory;
import com.microsoft.azure.storage.file.CloudFileShare;
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

    private static final String storageConnectionString = "DefaultEndpointsProtocol=https;AccountName=appdiag266;AccountKey=nGvA8hUJAywIMhGtEoPG6UJqfifF1+tOyVtwcWEv4/jQ8EMmD5wqHuRXrVaWNZg0OX31nqtWT6B+hQ0VCECK7A==;EndpointSuffix=core.windows.net";

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

        CloudStorageAccount account = null;
        try {
            account = CloudStorageAccount.parse(storageConnectionString);

            CloudFileClient fileClient = account.createCloudFileClient();
            CloudFileShare shareReference = fileClient.getShareReference("iot-image-share");
            CloudFileDirectory hackathon = shareReference.getRootDirectoryReference().getDirectoryReference("hackathon");

            FileOutputStream outStream = new FileOutputStream(new File("/home/azure/images/" + apiRecord.getImageLocation()));
            hackathon.getFileReference(apiRecord.getImageLocation()).download(outStream);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
