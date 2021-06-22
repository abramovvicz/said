package com.saidproject.saidproject.controller.description;

import com.saidproject.saidproject.controller.IController;
import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.exceptions.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Map;

public interface IDescriptionController extends IController<Map<String, Object>, Description> {

    ResponseEntity<Map<String, Object>> findAllByMeasurementId(@PathVariable("id") Iterable id) throws NotFoundException;

    ResponseEntity<Map<String, Object>> saveAll(List<Description> descriptions) throws NotFoundException;
}
