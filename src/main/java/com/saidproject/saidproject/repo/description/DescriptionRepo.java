package com.saidproject.saidproject.repo.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.dao.mappers.DescriptionMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DescriptionRepo implements IDescriptionRepo {

    private static final Logger logger = LogManager.getLogger(DescriptionRepo.class.getSimpleName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DescriptionMapper descriptionMapper;

    @Override
    public List<Description> findAllForMeasurement(Integer measurementId) {
        var sql = "select * from descriptions where MEASUREMENT_ID= " + measurementId;
        return jdbcTemplate.query(sql, descriptionMapper);
    }

    @Override
    public void saveAll(List<Description> descriptions) {
        var sql = "insert into descriptions (measurement_id, name, status, comments, created_at) values(?, ?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, setParameters(descriptions));

    }

    @Override
    public Description findById(int id) {
        var sql = "select * from descriptions where id= " + id;
        return jdbcTemplate.queryForObject(sql, descriptionMapper);
    }

    @Override
    public List<Description> findAll() {
        var sql = "select * from descriptions";
        return jdbcTemplate.query(sql, descriptionMapper);
    }

    @Override
    public void save(Description description) {
        var sql = "insert into descriptions (measurement_id, name, status, comments, created_at) values(?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, description.getMeasurementId(), description.getName(), description.getStatus(), description.getComments(), description.getCreatedAt());
    }

    @Override
    public void update(Description description) {
        var sql = "update descriptions set measurement_id = ?, name = ?, status = ?, comments = ?, updated_at =? where id = " + description.getId();
        jdbcTemplate.update(sql, description.getMeasurementId(), description.getName(), description.getStatus(), description.getComments(), description.getUpdatedAt());
    }

    @Override
    public void delete(int id) {
        var sql = "delete descriptions where id = " + id;
        jdbcTemplate.update(sql, id);
    }

    private List<Object[]> setParameters(List<Description> descriptions) {
        List<Object[]> objects = new ArrayList<>();
        for (Description description : descriptions) {
            objects.add(new Object[]{description.getMeasurementId(), description.getName(), description.getStatus(), description.getComments(), description.getUpdatedAt()});
        }
        return objects;
    }
}
