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
import java.util.Objects;

@RestController
@RequestMapping("/descriptions")
public class DescriptionController implements IDescriptionController {

    @Autowired
    public IDescriptionService descriptionService;

    @Override
    @GetMapping(value = "for/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Description>> findAllByMeasurementId(@PathVariable("id") Integer measurementId) {
        List<Description> allByMeasurementId = descriptionService.findAllForMeasurement(measurementId);
        return new ResponseEntity<>(allByMeasurementId, HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/{id}/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Description> findById(@PathVariable Integer id) {
        Description description = descriptionService.findById(id);
        return Objects.isNull(description) ? ResponseEntity.badRequest().body(new Description()) : ResponseEntity.ok(description);
    }

    @Override
    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Description>> findAll() {
        List<Description> descriptions = descriptionService.findAll();
        return new ResponseEntity<>(descriptions, HttpStatus.OK);
    }

    @Override
    @PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    public ResponseEntity<Description> save(@RequestBody Description entity) {
        Description savedUser = descriptionService.save(entity);
        return new ResponseEntity(savedUser,  HttpStatus.CREATED);
    }

//    @Override
//    @PostMapping(value = "/addAll/" , consumes = MediaType.APPLICATION_JSON_VALUE )
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    public ResponseEntity saveAll(@RequestBody List<Description> descriptions) {
//        boolean isSaved = descriptionService.saveAll(descriptions);
//        return new ResponseEntity(isSaved ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
//    }


    @Override
    @PutMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
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

