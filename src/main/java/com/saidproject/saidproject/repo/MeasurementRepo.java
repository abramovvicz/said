package com.saidproject.saidproject.repo;

import com.saidproject.saidproject.dao.Measurement;
import com.saidproject.saidproject.dao.mappers.MeasurementExtractor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MeasurementRepo implements IMeasurementRepo {

    private static final Logger logger = LogManager.getLogger(MeasurementRepo.class.getSimpleName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private MeasurementExtractor measurementMapper = new MeasurementExtractor();

    @Override
    public Measurement findById(long ID) {
        var sql = "select * from user where ID= ?";
        Map<String, Object> stringObjectMap = jdbcTemplate.queryForMap(sql, ID);
        Measurement measurement = new Measurement();
        measurement.setId((int) stringObjectMap.get("id"));
        return measurement;
    }

    @Override
    public List<Measurement> findAll() {
        var sql = "SELECT * FROM measurements right join descriptions on measurements.id = descriptions.measurement_id;";
        return new ArrayList<>(jdbcTemplate.query(sql, measurementMapper));
    }

    @Override
    public void save() {

    }

}
