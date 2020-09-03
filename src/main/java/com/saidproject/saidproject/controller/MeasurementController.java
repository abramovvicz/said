package com.saidproject.saidproject.controller;

import com.saidproject.saidproject.dao.Measurement;
import com.saidproject.saidproject.repo.MeasurementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MeasurementController {

    @Autowired
    private MeasurementRepo measurementRepo;


    @GetMapping(value = "/measurements", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Measurement>> getAllMeasurements() {
        List<Measurement> all = measurementRepo.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }


}
