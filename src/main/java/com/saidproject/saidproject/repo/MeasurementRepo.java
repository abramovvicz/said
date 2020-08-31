package com.saidproject.saidproject.repo;

import com.saidproject.saidproject.dao.Measurement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class MeasurementRepo implements IMeasurementRepo {

    protected RowMapper<Measurement> rowMapper = (resultSet, rowNum) -> {
        var id = resultSet.getInt("id");
        var address = resultSet.getString("address");
        var dateOfMeasurement = resultSet.getDate("dateOfMeasurement");

        Measurement measurement = new Measurement();
        measurement.setId(id);
        measurement.setAddress(address);
        measurement.setDateOfMeasurement(dateOfMeasurement);
        return measurement;
    };
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
        var sql = "select * from user";
        return new ArrayList<>(jdbcTemplate.query(sql, rowMapper));
    }

    @Override
    public void save() {

    }

}
