package com.saidproject.saidproject.repo.measurement;

import com.google.common.collect.Iterables;
import com.saidproject.saidproject.dao.mappers.MeasurementExtractor;
import com.saidproject.saidproject.dao.measurement.Measurement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MeasurementRepo implements IMeasurementRepo {

    private static final int SQL_OPERATION_SUCCESS = 1;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MeasurementExtractor measurementExtractor;

    @Override
    public Measurement findById(int id) {
        var sql = "select * from measurements inner join descriptions on descriptions.measurement_id = measurements.id where measurements.id = " + id;
        ArrayList<Measurement> measurements = new ArrayList<>(jdbcTemplate.query(sql, measurementExtractor));
        return Iterables.getFirst(measurements, new Measurement());
    }

    @Override
    public List<Measurement> findAll() {
        var sql = "SELECT * FROM measurements right join descriptions on measurements.id = descriptions.measurement_id;";
        return new ArrayList<>(jdbcTemplate.query(sql, measurementExtractor));
    }

    @Override
    public boolean save(Measurement measurement) {
        var sql = "insert into measurements (address, hydrant_type, hydrant_subtype, hydrant_diameter, created_at, photo)" + "values (?,?,?,?,?,?)";
        return jdbcTemplate.update(sql, measurement.getAddress(), measurement.getHydrantType().toString(), measurement.getHydrantSubType().toString(), measurement.getHydrantDiameter().toString(), measurement.getCreatedAt(), measurement.getPhoto()) == SQL_OPERATION_SUCCESS;
    }

    @Override
    public boolean update(Measurement measurement) {
        var sql = "update measurements set address = ?, hydrant_type = ?, hydrant_subtype = ?, hydrant_diameter = ?, created_at = ?, photo = ? WHERE id = " + measurement.getId();
        return jdbcTemplate.update(sql, measurement.getAddress(), measurement.getHydrantType().toString(), measurement.getHydrantSubType().toString(), measurement.getHydrantDiameter().toString(), measurement.getCreatedAt(), measurement.getPhoto()) == SQL_OPERATION_SUCCESS;
    }

    @Override
    public boolean delete(Integer id) {
        var sql = "DELETE from measurements where ID=  " + id;
        return jdbcTemplate.update(sql) == SQL_OPERATION_SUCCESS;
    }
}
