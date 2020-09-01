package com.saidproject.saidproject.dao.mappers;

import com.saidproject.saidproject.dao.Measurement;
import org.springframework.jdbc.core.RowMapper;

public class MeasurementRowMapper {

    public RowMapper<Measurement> rowMapper = (resultSet, rowNum) -> {
        var id = resultSet.getInt("id");
        var address = resultSet.getString("address");
        var dateOfMeasurement = resultSet.getDate("dateOfMeasurement");

        Measurement measurement = new Measurement();
        measurement.setId(id);
        measurement.setAddress(address);
        measurement.setDateOfMeasurement(dateOfMeasurement);
        return measurement;
    };
}
