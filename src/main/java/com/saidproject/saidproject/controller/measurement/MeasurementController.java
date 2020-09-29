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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/measurements")
public class MeasurementController implements IMeasurementController {

    @Autowired
    private IMeasurementService measurementService;

    @Override
    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Measurement> findById(@PathVariable("id") Integer id) {
        Measurement measurement = measurementService.findById(id);
        return Objects.isNull(measurement) ? ResponseEntity.badRequest().body(new Measurement()) : ResponseEntity.ok(measurement);

    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Measurement>> findAll() {
        List<Measurement> allMeasurements = measurementService.findAll();
        return allMeasurements.isEmpty() ? ResponseEntity.badRequest().body(Collections.emptyList()) : ResponseEntity.ok(allMeasurements);
    }

    @Override
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Measurement> save(@RequestBody Measurement measurement) {
        Measurement savedMeasurement = measurementService.save(measurement);
        return Objects.isNull(savedMeasurement) ? ResponseEntity.badRequest().body(new Measurement()) : ResponseEntity.ok(savedMeasurement);
    }

    @Override
    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Measurement measurement) {
        boolean isSaved = measurementService.update(measurement);
        return new ResponseEntity(isSaved ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
    }

    @Override
    @DeleteMapping(value = "/{id}/")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        boolean isDeleted = measurementService.delete(id);
        return new ResponseEntity(isDeleted ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
    }
}
