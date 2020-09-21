package com.saidproject.saidproject.repo.description;

import com.saidproject.saidproject.dao.description.Description;
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
        //TODO
        return null;
    }

    @Override
    public void saveAll(List<Description> descriptionList) {
        //TODO
    }

    @Override
    public Description findById(int id) {
        //TODO
        return null;
    }

    @Override
    public List<Description> findAll() {
        //TODO
        return null;
    }

    @Override
    public void save(Description description) {
        //TODO
    }

    @Override
    public void update(Description description) {
        //TODO
    }

    @Override
    public void delete(int id) {
        //TODO
    }

}
