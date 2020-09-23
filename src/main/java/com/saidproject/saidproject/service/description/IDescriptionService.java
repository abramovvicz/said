package com.saidproject.saidproject.service.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.service.IService;

import java.util.List;

public interface IDescriptionService extends IService<Description> {

    List<Description> findAllForMeasurement(int id);
}
