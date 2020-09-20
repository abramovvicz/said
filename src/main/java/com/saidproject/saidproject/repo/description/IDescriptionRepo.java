package com.saidproject.saidproject.repo.description;

import com.saidproject.saidproject.dao.Description;
import com.saidproject.saidproject.repo.IRepo;

import java.util.List;

public interface IDescriptionRepo extends IRepo<Description> {
    List<Description> findAllForMeasurement(Integer measurementId);
    void saveAll (List<Description> descriptionList);
}
