package com.saidproject.saidproject.controller.description;

import com.saidproject.saidproject.controller.IController;
import com.saidproject.saidproject.dao.description.Description;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface IDescriptionController extends IController<Description> {

    ResponseEntity<List<Description>> findAllByMeasurementId(@PathVariable("id") Integer id);
//    ResponseEntity saveAll(List<Description> descriptions);
}
