package com.saidproject.saidproject.controller.measurement;

import com.saidproject.saidproject.dao.measurement.Measurement;
import com.saidproject.saidproject.service.measurement.IMeasurementService;
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
public class MeasurementController implements IMeasurementController {

    @Autowired
    private IMeasurementService measurementService;

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Measurement> findById(@PathVariable("id") int id) {
        Measurement measurementByIdById = measurementService.findById(id);
        return new ResponseEntity<>(measurementByIdById, HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Measurement>> findAll() {
        List<Measurement> all = measurementService.findAll();
        return new ResponseEntity<>(all, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void save(Measurement measurement) {
        measurementService.save(measurement);
    }

    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(Measurement measurement) {
        measurementService.update(measurement);
    }

    @Override
    public void delete(int id) {

    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathParam("id") Integer ID) {
        measurementService.delete(ID);
    }

}
