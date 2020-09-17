package com.saidproject.saidproject.repo.description;

import com.saidproject.saidproject.dao.Description;

import java.util.List;

public interface IDescription {

    List<Description> findAllByMeasurementId(Integer id);
}
