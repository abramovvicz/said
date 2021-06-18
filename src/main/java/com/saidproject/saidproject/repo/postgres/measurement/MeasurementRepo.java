package com.saidproject.saidproject.repo.postgres.measurement;

import com.saidproject.saidproject.dao.measurement.Measurement;
import com.saidproject.saidproject.repo.api.IMeasurementRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MeasurementRepo implements IMeasurementRepo {


    @Override
    public Measurement findById(int id) {
        return null;
    }

    @Override
    public List<Measurement> findAll() {
        return null;
    }

    @Override
    public Measurement save(Measurement entity) {
        return null;
    }

    @Override
    public boolean update(Measurement entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }
}
