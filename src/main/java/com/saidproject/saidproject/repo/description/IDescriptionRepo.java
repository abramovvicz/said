package com.saidproject.saidproject.repo.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.repo.IRepo;

import java.util.List;

public interface IDescriptionRepo extends IRepo<Description> {
    List<Description> findAllForMeasurement(Integer measurementId);
    List<Description> saveAll (List<Description> descriptionList, Integer measurementId);
}
