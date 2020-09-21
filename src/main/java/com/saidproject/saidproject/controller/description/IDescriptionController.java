package com.saidproject.saidproject.controller.description;

import com.saidproject.saidproject.controller.IController;
import com.saidproject.saidproject.dao.description.Description;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IDescriptionController extends IController<Description> {

    @GetMapping(value = "/descriptions", produces = MediaType.APPLICATION_JSON_VALUE)
     ResponseEntity<List<Description>> findAllByMeasurementId(@PathVariable("id") Integer id);
}
