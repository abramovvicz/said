package com.saidproject.saidproject.controller.measurement;

import com.saidproject.saidproject.dao.measurement.Measurement;
import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.service.measurement.IMeasurementService;
import com.saidproject.saidproject.utils.CreateExcelFile;
import com.saidproject.saidproject.utils.ResultMessage;
import com.saidproject.saidproject.utils.ResultStatus;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/measurements")
public class MeasurementController implements IMeasurementController {

    @Autowired
    private IMeasurementService measurementService;

    @Override
    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") Integer id) throws NotFoundException {
        Map<String, Object> result = new HashMap<>();
        Measurement measurement = measurementService.findById(id);
        try {
            CreateExcelFile.writeFile(measurement, "measurement.xlsx");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (measurement != null) {
            result.put(ResultMessage.RESULT_KEY, measurement);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Measurement with id: " + id + " not found");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findAll() throws NotFoundException {
        Map<String, Object> result = new HashMap<>();
        List<Measurement> allMeasurements = measurementService.findAll();
        if (allMeasurements != null && !allMeasurements.isEmpty()) {
            result.put(ResultMessage.RESULT_KEY, allMeasurements);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Measurements not found");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody Measurement measurement) {
        Map<String, Object> result = new HashMap<>();
        Measurement savedMeasurement = measurementService.save(measurement);
        if (savedMeasurement != null) {
            result.put(ResultMessage.RESULT_KEY, savedMeasurement);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Something went wrong, please try again");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> update(@RequestBody Measurement measurement) {
        Map<String, Object> result = new HashMap<>();
        boolean isSaved = measurementService.update(measurement);
        if (isSaved) {
            result.put(ResultMessage.RESULT_KEY, measurement);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Something went wrong, please try again");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @DeleteMapping(value = "/{id}/")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Integer id) {
        boolean isDeleted = measurementService.delete(id);
        Map<String, Object> result = new HashMap<>();
        if (isDeleted) {
            result.put(ResultMessage.RESULT_KEY, id);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Something went wrong, please try again");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }
}
