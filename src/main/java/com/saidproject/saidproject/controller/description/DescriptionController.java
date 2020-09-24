package com.saidproject.saidproject.controller.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.service.description.IDescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/descriptions")
public class DescriptionController implements IDescriptionController {

    @Autowired
    public IDescriptionService descriptionService;

    @Override
    @GetMapping(value = "/descriptions/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Description>> findAllByMeasurementId(@PathVariable("id") Integer id) {
        List<Description> allByMeasurementId = descriptionService.findAllForMeasurement(id);
        return new ResponseEntity<>(allByMeasurementId, HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Description> findById(@PathVariable int id) {
        Description descriptionById = descriptionService.findById(id);
        return new ResponseEntity<>(descriptionById, HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Description>> findAll() {
        List<Description> descriptions = descriptionService.findAll();
        return new ResponseEntity<>(descriptions, HttpStatus.OK);
    }

    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void save(@RequestBody Description entity) {
        descriptionService.save(entity);
    }

    @PostMapping(value = "/all" , consumes = MediaType.APPLICATION_JSON_VALUE )
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void saveAll(@RequestBody List<Description> descriptions){
        descriptionService.saveAll(descriptions);
    }



    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public void update(@RequestBody Description entity) {
        descriptionService.update(entity);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathParam("id") Integer id) {
        descriptionService.delete(id);
    }
}

