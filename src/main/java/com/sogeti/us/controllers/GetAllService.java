package com.sogeti.us.controllers;

import com.google.gson.Gson;
import com.sogeti.us.model.ApiRecord;
import com.sogeti.us.model.ScoredResult;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class GetAllService {

    private String dataPath;
    private Gson gson;

    @Autowired
    public GetAllService(@Value("${data.path:/home/azure/data/}") String dataPath, Gson gson) {
        this.dataPath = dataPath;
        this.gson = gson;
    }


    public List<ScoredResult> getResults() {
        File dir = new File(dataPath);
        File[] fileArr = dir.listFiles(new RecordFilter(".record.json"));
        if (fileArr == null) {
            return new ArrayList<ScoredResult>();
        }
        List<File> files = Arrays.asList(fileArr);
        return files.stream()
                .map(file -> {
                    try (FileInputStream fis = new FileInputStream(file)) {
                        return IOUtils.toString(fis, StandardCharsets.UTF_8);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return "";
                })
                .filter(s -> !s.isEmpty())
                .map(json -> gson.fromJson(json, ApiRecord.class))
                .map(apiRecord -> new ScoredResult(apiRecord, ThreadLocalRandom.current().nextInt(1, 3 + 1)))
                .collect(Collectors.toList());
    }

    class RecordFilter implements FilenameFilter {

        private String extension;

        RecordFilter(String extension) {
            this.extension = extension;
        }

        @Override
        public boolean accept(File file, String s) {
            return s.toLowerCase().endsWith(extension);
        }
    }
}
