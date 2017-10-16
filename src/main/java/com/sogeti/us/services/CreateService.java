package com.sogeti.us.services;

import com.sogeti.us.controllers.CreateRequest;
import com.sogeti.us.model.ApiRecord;
import com.sogeti.us.repositories.ApiRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateService {

    private ApiRecordRepository repository;

    @Autowired
    public CreateService(ApiRecordRepository repository) {
        this.repository = repository;
    }

    public void createRecord(CreateRequest createRequest) {
        ApiRecord apiRecord = new ApiRecord(
                createRequest.getRecordedTimestamp(),
                createRequest.getLatitude(),
                createRequest.getLongitude(),
                createRequest.getObd2Data(),
                createRequest.getImageLocation());
        repository.save(apiRecord);
    }
}
