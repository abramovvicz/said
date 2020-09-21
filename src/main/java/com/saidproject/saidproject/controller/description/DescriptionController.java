package com.saidproject.saidproject.controller.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.repo.description.IDescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DescriptionController implements IDescriptionController{

    @Autowired
    public IDescriptionRepo descriptionRepo;


    @GetMapping(value = "/descriptions", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Description>> findAllByMeasurementId(@PathVariable("id") Integer id) {
        List<Description> allByMeasurementId = descriptionRepo.findAllForMeasurement(id);
        return new ResponseEntity<>(allByMeasurementId, HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Description> findById(int id) {
        return null;
    }

    @Override
    public ResponseEntity<List<Description>> findAll() {
        return null;
    }

    @Override
    public void save(Description entity) {
        //TODO
    }

    @Override
    public void update(Description entity) {
        //TODO
    }

    @Override
    public void delete(int id) {
        //TODO
    }
}

