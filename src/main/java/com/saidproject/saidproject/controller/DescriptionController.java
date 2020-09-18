package com.saidproject.saidproject.controller;

import com.saidproject.saidproject.dao.Description;
import com.saidproject.saidproject.repo.description.DescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DescriptionController {

    @Autowired
    public DescriptionRepo descriptionRepo;


    @GetMapping(value = "/descriptions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Description>> getAllDescriptionByMeasurementId(@PathVariable("id") Integer id) {
        List<Description> allByMeasurementId = descriptionRepo.findAllForMeasurement(id);
        return new ResponseEntity<>(allByMeasurementId, HttpStatus.OK);
    }
}

