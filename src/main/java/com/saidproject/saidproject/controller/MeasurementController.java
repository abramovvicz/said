package com.saidproject.saidproject.controller;

import com.saidproject.saidproject.repo.MeasurementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MeasurementController {

    @Autowired
    private MeasurementRepo measurementRepo;


    @GetMapping("/measurements")
    public void getAllMeasurements() {
        measurementRepo.findAll();
    }


}
