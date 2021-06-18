package com.saidproject.saidproject.repo.postgres.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.repo.api.IDescriptionRepo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DescriptionRepo implements IDescriptionRepo {


    @Override
    public Description findById(int id) {
        return null;
    }

    @Override
    public List<Description> findAll() {
        return null;
    }

    @Override
    public Description save(Description entity) {
        return null;
    }

    @Override
    public boolean update(Description entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public List<Description> findAllForMeasurement(Integer measurementId) {
        return null;
    }

    @Override
    public List<Description> saveAll(List<Description> descriptionList) {
        return null;
    }
}
