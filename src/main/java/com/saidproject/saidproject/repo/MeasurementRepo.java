package com.saidproject.saidproject.repo;

import com.saidproject.saidproject.dao.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class MeasurementRepo implements IMeasurementRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;

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
        return null;
    }

    @Override
    public void save() {

    }
}
