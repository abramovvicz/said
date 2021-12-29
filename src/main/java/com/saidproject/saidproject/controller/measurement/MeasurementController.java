package com.saidproject.saidproject.controller.measurement;

import com.saidproject.saidproject.dao.measurement.Measurement;
import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.service.measurement.IMeasurementService;
import com.saidproject.saidproject.service.measurement.MeasurementService;
import com.saidproject.saidproject.utils.ResultMessage;
import com.saidproject.saidproject.utils.ResultStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/measurements")
@CrossOrigin("*")
public class MeasurementController implements IMeasurementController {

    static final Logger logger = LoggerFactory.getLogger(MeasurementController.class);

    @Autowired
    private MeasurementService measurementService;

    @Value("${exampleListValue}")
    private List<String> someValue;


    @Value("${spring.datasource.url}")
    private String urlJdbc;

    @Override
    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable("id") int id) throws NotFoundException {
        System.out.println("DEMO:" + someValue);
        System.out.println("DEMO first "  + someValue.get(0));
        System.out.println("DEMO second "  + someValue.get(1));
        System.out.println("DEMO third "  + someValue.get(2));
        System.out.println("DEMO2:" + urlJdbc);
        Map<String, Object> result = new HashMap<>();
        Measurement measurement = measurementService.findById(id);
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
        System.out.println("exampleListValue" + someValue);
        System.out.println("urlJDBC" + urlJdbc);
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
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Map<String, Object>> save(@RequestBody Measurement measurement) {
        logger.info("ataken na post");

        Map<String, Object> result = new HashMap<>();
        Measurement savedMeasurement = measurementService.saveDescription(measurement);
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
        Measurement measurementUpdated = measurementService.update(measurement);
        if (measurementUpdated != null) {
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
