package com.saidproject.saidproject.repo.postgres.measurement;

import com.google.common.collect.Iterables;
import com.saidproject.saidproject.dao.mappers.MeasurementExtractor;
import com.saidproject.saidproject.dao.measurement.Measurement;
import com.saidproject.saidproject.repo.IRepo;
import com.saidproject.saidproject.repo.api.IMeasurementRepo;
import com.saidproject.saidproject.utils.Constants;
import com.saidproject.saidproject.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class MeasurementRepo implements IMeasurementRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private MeasurementExtractor measurementExtractor;

    @Override
    public Measurement findById(int id) {
        var sql = "SELECT measurements.id AS \"measurements.id\", title, protocol, address, hydrant_type, hydrant_subtype, hydrant_diameter, static_pressure, dynamic_pressure, hydrant_efficiency, photo, measurements.created_at AS \"measurements.created_at\", measurements.updated_at AS \"measurements.updated_at\",\n" +
                "descriptions.id AS \"descriptions.id\", descriptions.measurement_id AS \"descriptions.measurement_id\", descriptions.name AS \"descriptions.name\", descriptions.status AS \"descriptions.status\", descriptions.comments AS \"descriptions.comments\", descriptions.created_at AS \"descriptions.created_at\", descriptions.updated_at AS \"descriptions.updated_at\"\n" +
                "FROM measurements LEFT JOIN descriptions ON descriptions.measurement_id = measurements.id where measurements.id = " + id;
        ArrayList<Measurement> measurements = new ArrayList<>(jdbcTemplate.query(sql, measurementExtractor));
        Measurement measurement = Iterables.getFirst(measurements, new Measurement());
        return Objects.isNull(measurement) ? new Measurement() : measurement;
    }

    @Override
    public List<Measurement> findAll() {
        var sql =  "SELECT measurements.id AS \"measurements.id\", title, protocol, address, hydrant_type, hydrant_subtype, hydrant_diameter, static_pressure, dynamic_pressure, hydrant_efficiency, photo, measurements.created_at as \"measurements.created_at\", measurements.updated_at as \"measurements.updated_at\",\n" +
                "descriptions.id AS \"descriptions.id\", descriptions.measurement_id AS \"descriptions.measurement_id\", descriptions.name AS \"descriptions.name\", descriptions.status AS \"descriptions.status\", descriptions.comments AS \"descriptions.comments\", descriptions.created_at AS \"descriptions.created_at\", descriptions.updated_at AS \"descriptions.updated_at\"\n" +
                "FROM measurements LEFT JOIN descriptions ON measurements.id = descriptions.measurement_id;";
        return new ArrayList<>(jdbcTemplate.query(sql, measurementExtractor));
    }

    @Override
    public Measurement save(Measurement measurement) {
        var sql = "insert into measurements (title, protocol, address, hydrant_type, hydrant_subtype, hydrant_diameter, static_pressure, dynamic_pressure, hydrant_efficiency, created_at, updated_at, photo)" + "values (?,?,?,?,?,?,?,?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> setValuesInPreparedStatement(connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS), measurement), keyHolder);
        measurement.setId((Integer)keyHolder.getKeys().get("id"));
        return Objects.isNull(measurement) ? new Measurement() : measurement;
    }

    @Override
    public boolean update(Measurement measurement) {
        var sql = "update measurements set address = ?, hydrant_type = ?, hydrant_subtype = ?, hydrant_diameter = ?, static_pressure = ?, dynamic_pressure = ?, hydrant_efficiency = ?, created_at = ?, updated_at = ?, photo = ? WHERE id = " + measurement.getId();
        return jdbcTemplate.update(sql, getMeasurementSetter(measurement)) == Constants.SQL_OPERATION_SUCCESS;
    }

    @Override
    public boolean delete(Integer id) {
        var sql = "DELETE from measurements where ID=  " + id;
        return jdbcTemplate.update(sql) == Constants.SQL_OPERATION_SUCCESS;
    }

    private PreparedStatementSetter getMeasurementSetter(Measurement measurement) {
        return preparedStatement -> {
            preparedStatement.setString(1, measurement.getTitle());
            preparedStatement.setString(2, measurement.getProtocol());
            preparedStatement.setString(3, measurement.getAddress());
            preparedStatement.setString(4, measurement.getHydrantType().toString());
            preparedStatement.setString(5, measurement.getHydrantSubType().toString());
            preparedStatement.setString(6, measurement.getHydrantDiameter().toString());
            preparedStatement.setDouble(7, measurement.getStaticPressure());
            preparedStatement.setDouble(8, measurement.getDynamicPressure());
            preparedStatement.setDouble(9, measurement.getHydrantEfficiency());
            preparedStatement.setDate(10, Utils.convertToSqlDate(measurement.getCreatedAt()));
            preparedStatement.setDate(11, Utils.convertToSqlDate(measurement.getUpdatedAt()));
            preparedStatement.setBlob(12, Utils.convertByteArrayToBlob(measurement.getPhoto()));
        };
    }

    private PreparedStatement setValuesInPreparedStatement(PreparedStatement preparedStatement, Measurement measurement) throws SQLException {
        preparedStatement.setString(1, measurement.getTitle());
        preparedStatement.setString(2, measurement.getProtocol());
        preparedStatement.setString(3, measurement.getAddress());
        preparedStatement.setString(4, measurement.getHydrantType().toString());
        preparedStatement.setString(5, measurement.getHydrantSubType().toString());
        preparedStatement.setString(6, measurement.getHydrantDiameter().toString());
        preparedStatement.setDouble(7, measurement.getStaticPressure());
        preparedStatement.setDouble(8, measurement.getDynamicPressure());
        preparedStatement.setDouble(9, measurement.getHydrantEfficiency());
        preparedStatement.setDate(10, Utils.convertToSqlDate(measurement.getCreatedAt()));
        preparedStatement.setDate(11, Utils.convertToSqlDate(measurement.getUpdatedAt()));
        preparedStatement.setBlob(12, Utils.convertByteArrayToBlob(measurement.getPhoto()));

        return preparedStatement;
    }
}
