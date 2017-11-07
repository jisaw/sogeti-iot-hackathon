package com.sogeti.us.controllers;

import com.sogeti.us.model.ScoredResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAllController {

    private GetAllService service;

    @Autowired
    public GetAllController(GetAllService service) {
        this.service = service;
    }

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<ScoredResult> getAll() {
        return service.getResults();
    }
}
