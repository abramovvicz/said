package com.saidproject.saidproject.repo.measurement;

import com.saidproject.saidproject.dao.Measurement;

import java.util.List;

public interface IMeasurementRepo {

    Measurement findById(int ID);

    List<Measurement> findAll();

    void save(Measurement measurement);

    void update(Measurement measurement);

    void delete(int ID);

}
