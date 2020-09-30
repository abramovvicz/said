package com.saidproject.saidproject.controller.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.service.description.IDescriptionService;
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/descriptions")
public class DescriptionController implements IDescriptionController {

    @Autowired
    public IDescriptionService descriptionService;

    @Override
    @GetMapping(value = "for/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Description>> findAllByMeasurementId(@PathVariable("id") Integer measurementId) throws NotFoundException {
        List<Description> allByMeasurementId = descriptionService.findAllForMeasurement(measurementId);
        return allByMeasurementId.isEmpty() ? ResponseEntity.badRequest().body(Collections.emptyList()) : ResponseEntity.ok(allByMeasurementId);
    }

    @Override
    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Description> findById(@PathVariable Integer id) throws NotFoundException{
        Description description = descriptionService.findById(id);
        return Objects.isNull(description) ? ResponseEntity.badRequest().body(new Description()) : ResponseEntity.ok(description);
    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Description>> findAll() throws NotFoundException {
        List<Description> descriptions = descriptionService.findAll();
        return descriptions.isEmpty() ? ResponseEntity.badRequest().body(Collections.emptyList()) : ResponseEntity.ok(descriptions);
    }

    @Override
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Description> save(@RequestBody Description entity) {
        Description savedDescription = descriptionService.save(entity);
        return Objects.isNull(savedDescription) ? ResponseEntity.badRequest().body(new Description()) : ResponseEntity.ok(savedDescription);
    }

    @Override
    @PostMapping(value = "/addAll/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Description>> saveAll(@RequestBody List<Description> descriptions) throws NotFoundException{
        List<Description> savedDescriptions = descriptionService.saveAll(descriptions);
        return savedDescriptions.isEmpty() ? ResponseEntity.badRequest().body(new ArrayList<>()) : ResponseEntity.ok(savedDescriptions);
    }


    @Override
    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody Description entity) {
        boolean isSaved = descriptionService.update(entity);
        return new ResponseEntity(isSaved ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
    }

    @Override
    @DeleteMapping(value = "/{id}/")
    public ResponseEntity delete(@PathVariable("id") Integer id) {
        boolean isDeleted = descriptionService.delete(id);
        return new ResponseEntity(isDeleted ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}

