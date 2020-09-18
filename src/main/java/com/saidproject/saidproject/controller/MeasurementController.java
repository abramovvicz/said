package com.saidproject.saidproject.controller;

import com.saidproject.saidproject.dao.Measurement;
import com.saidproject.saidproject.repo.measurement.MeasurementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {

    @Autowired
    private MeasurementRepo measurementRepo;


    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Measurement>> getAllMeasurements() {
        List<Measurement> all = measurementRepo.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Measurement> getMeasurement(@PathVariable("id") Integer id) {
        Measurement measurementByIdById = measurementRepo.findById(id);
        return new ResponseEntity<>(measurementByIdById, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(Measurement measurement) {
        measurementRepo.save(measurement);
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(Measurement measurement) {
        measurementRepo.update(measurement);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathParam("id") Integer ID) {
        measurementRepo.delete(ID);
    }

}
