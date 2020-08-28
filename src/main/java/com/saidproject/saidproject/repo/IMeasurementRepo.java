package com.saidproject.saidproject.repo;

import com.saidproject.saidproject.dao.Measurement;

import java.util.List;

public interface IMeasurementRepo {

    Measurement findById(long ID);

    List<Measurement> findAll();

    void save();

}
