package com.saidproject.saidproject.dao.mappers;

import com.saidproject.saidproject.dao.HydrantDiameter;
import com.saidproject.saidproject.dao.HydrantSubType;
import com.saidproject.saidproject.dao.HydrantType;
import com.saidproject.saidproject.dao.Measurement;
import com.saidproject.saidproject.repo.IMeasurementRepo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MeasurementRowMapper{

    public RowMapper<Measurement> rowMapper = (resultSet, rowNum) -> {

        var id = resultSet.getInt("id");
        var address = resultSet.getString("address");
        var hydrantType = resultSet.getString("hydrant_type");
        var hydrantSubType = resultSet.getString("hydrant_subtype");
        var hydrantDiameter = resultSet.getString("hydrant_diameter");
        var measurementDate = resultSet.getDate("measurement_date");

        Measurement measurement = new Measurement();
        measurement.setId(id);
        measurement.setAddress(address);
        measurement.setHydrantType(HydrantType.valueOf(hydrantType));
        measurement.setHydrantSubType(HydrantSubType.valueOf(hydrantSubType));
        measurement.setHydrantDiameter(HydrantDiameter.valueOf(hydrantDiameter));
        long time = measurementDate.getTime();
        Date date = new Date(time);
        measurement.setDateOfMeasurement(date);


        //todo: dodać metode, kotra sprawdza dany typ ze istnieje
        return measurement;
    };
}
