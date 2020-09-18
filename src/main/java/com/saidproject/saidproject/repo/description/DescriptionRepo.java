package com.saidproject.saidproject.repo.description;

import com.saidproject.saidproject.dao.Description;
import com.saidproject.saidproject.repo.description.IDescriptionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DescriptionRepo implements IDescriptionRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Description> findAllForMeasurement(Integer measurementId) {
        //
        return null;
    }

    @Override
    public Description findById(Integer descriptionId) {
        //TODO
        return null;
    }

    @Override
    public void save(Description description) {
        //TODO
    }

    @Override
    public void saveAll(List<Description> descriptionList) {
        //TODO
    }

    @Override
    public void update(Description description) {
        //TODO
    }

    @Override
    public void delete(Integer descriptionId) {
        //TODO
    }
}
