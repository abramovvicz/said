package com.saidproject.saidproject.repo.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.dao.mappers.DescriptionMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class DescriptionRepo implements IDescriptionRepo {

    private static final int SQL_OPERATION_SUCCESS = 1;

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
    public boolean saveAll(List<Description> descriptions) {
        var sql = "insert into descriptions (measurement_id, name, status, comments, created_at, updated_at) values(?, ?, ?, ?, ?, ?)";
        int[] result = jdbcTemplate.batchUpdate(sql, setParameters(descriptions));
        return Arrays.stream(result).allMatch(singleResult -> singleResult == SQL_OPERATION_SUCCESS);
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
    public boolean save(Description description) {
        var sql = "insert into descriptions (measurement_id, name, status, comments, created_at, updated_at) values(?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, mapDescription(description)) == SQL_OPERATION_SUCCESS;
    }

    @Override
    public boolean update(Description description) {
        var sql = "update descriptions set measurement_id = ?, name = ?, status = ?, comments = ?, created_at = ?, updated_at = ? where id = " + description.getId();
        return jdbcTemplate.update(sql, mapDescription(description)) == SQL_OPERATION_SUCCESS;
    }

    @Override
    public boolean delete(Integer id) {
        var sql = "delete descriptions where id = " + id;
        return jdbcTemplate.update(sql) == SQL_OPERATION_SUCCESS;
    }

    private List<Object[]> setParameters(List<Description> descriptions) {
        List<Object[]> objects = new ArrayList<>();
        for (Description description : descriptions) {
            objects.add(new Object[]{description.getMeasurementId(), description.getName(), description.getStatus(), description.getComments(), description.getCreatedAt(), description.getUpdatedAt()});
        }
        return objects;
    }

    private PreparedStatementSetter mapDescription(Description description) {
        return preparedStatement -> {
            preparedStatement.setInt(1, description.getMeasurementId());
            preparedStatement.setString(2, description.getName());
            preparedStatement.setInt(3, description.getStatus());
            preparedStatement.setString(4, description.getComments());
            preparedStatement.setDate(5, convertToSqlDate(description.getCreatedAt()));
            preparedStatement.setDate(6, convertToSqlDate(description.getUpdatedAt()));
        };
    }

    private java.sql.Date convertToSqlDate(java.util.Date dateToConvert) {
        return new java.sql.Date(dateToConvert.getTime());
    }
}
