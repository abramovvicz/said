package com.saidproject.saidproject.repo.description;

import com.saidproject.saidproject.dao.Description;

import java.util.List;

public interface IDescriptionRepo {

    List<Description> findAllForMeasurement(Integer measurementId);
    Description findById (Integer descriptionId);
    void save (Description description);
    void saveAll (List<Description> descriptionList);
    void update (Description description);
    void delete (Integer descriptionId);
}
