package com.sogeti.us.controllers;

import com.sogeti.us.services.CreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreateController {

    private CreateService createService;

    @Autowired
    public CreateController(CreateService createService) {
        this.createService = createService;
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK)
    public void create(@RequestBody CreateRequest createRequest) {
        createService.createRecord(createRequest);
    }

}
