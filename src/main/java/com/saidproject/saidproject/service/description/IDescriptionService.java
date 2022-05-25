package com.saidproject.saidproject.service.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.service.IService;

import java.util.List;

public interface IDescriptionService extends IService<Description> {

    List<Description> findAllForMeasurement(Iterable<Integer> id) throws NotFoundException;

    List<Description> saveAll(List<Description> descriptions) throws NotFoundException;
}
