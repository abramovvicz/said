package com.saidproject.saidproject.repo.measurement;

import com.saidproject.saidproject.dao.Measurement;
import com.saidproject.saidproject.dao.mappers.MeasurementExtractor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MeasurementRepo implements IMeasurementRepo {

    private static final Logger logger = LogManager.getLogger(MeasurementRepo.class.getSimpleName());

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private MeasurementExtractor measurementExtractor = new MeasurementExtractor();


    @Override
    public Measurement findById(long id) {
        Measurement measurement = new Measurement();
        List<Measurement> all = findAll();
        for (Measurement data : all) {
            if (data.getId() == id) {
                return data;
            }
        }
        return measurement;
    }

    @Override
    public List<Measurement> findAll() {
        var sql = "SELECT * FROM measurements right join descriptions on measurements.id = descriptions.measurement_id;";
        return new ArrayList<>(jdbcTemplate.query(sql, measurementExtractor));
    }

    @Override
    public void save() {

    }

}
