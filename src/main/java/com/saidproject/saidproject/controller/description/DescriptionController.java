package com.saidproject.saidproject.controller.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.service.description.IDescriptionService;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/descriptions")
public class DescriptionController implements IDescriptionController {

    @Autowired
    public IDescriptionService descriptionService;

    @Override
    @GetMapping(value = "for/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findAllByMeasurementId(@PathVariable("id") Integer measurementId) throws NotFoundException {
        Map<String, Object> result = new HashMap<>();
        List<Description> allByMeasurementId = descriptionService.findAllForMeasurement(measurementId);
        if (allByMeasurementId != null && !allByMeasurementId.isEmpty()) {
            result.put(ResultMessage.RESULT_KEY, allByMeasurementId);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Measurements with id: " + measurementId + " not found");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Integer id) throws NotFoundException {
        Map<String, Object> result = new HashMap<>();
        Description description = descriptionService.findById(id);
        if (description != null) {
            result.put(ResultMessage.RESULT_KEY, description);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Description with id: " + id + " not found");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> findAll() throws NotFoundException {
        List<Description> descriptions = descriptionService.findAll();
        Map<String, Object> result = new HashMap<>();
        if (descriptions != null && !descriptions.isEmpty()) {
            result.put(ResultMessage.RESULT_KEY, descriptions);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Descriptions not found");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> save(@RequestBody Description entity) {
        Description savedDescription = descriptionService.save(entity);
        Map<String, Object> result = new HashMap<>();
        if (savedDescription != null) {
            result.put(ResultMessage.RESULT_KEY, savedDescription);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Something gone wrong, please try again or later.");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @PostMapping(value = "/addAll/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> saveAll(@RequestBody List<Description> descriptions) throws NotFoundException {
        List<Description> savedDescriptions = descriptionService.saveAll(descriptions);
        Map<String, Object> result = new HashMap<>();
        if (savedDescriptions != null && !savedDescriptions.isEmpty()) {
            result.put(ResultMessage.RESULT_KEY, savedDescriptions);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Something gone wrong, please try again or later.");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }


    @Override
    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> update(@RequestBody Description entity) {
        boolean isSaved = descriptionService.update(entity);
        Map<String, Object> result = new HashMap<>();
        if (isSaved) {
            result.put(ResultMessage.RESULT_KEY, entity);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Something gone wrong, please try again or later.");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @Override
    @DeleteMapping(value = "/{id}/")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Integer id) {
        boolean isDeleted = descriptionService.delete(id);
        Map<String, Object> result = new HashMap<>();
        if (isDeleted) {
            result.put(ResultMessage.RESULT_KEY, id);
            result.put(ResultMessage.STATUS_KEY, ResultStatus.OK);
            return ResponseEntity.ok(result);
        } else {
            result.put(ResultMessage.MESSAGE_KEY, "Something gone wrong, please try again or later.");
            result.put(ResultMessage.STATUS_KEY, ResultStatus.ERROR);
            return ResponseEntity.badRequest().body(result);
        }
    }
}

