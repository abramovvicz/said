package com.saidproject.saidproject.repo.postgres.description;

import com.saidproject.saidproject.dao.description.Description;
import com.saidproject.saidproject.dao.mappers.DescriptionMapper;
import com.saidproject.saidproject.repo.api.IDescriptionRepo;
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
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
public class DescriptionRepo implements IDescriptionRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private DescriptionMapper descriptionMapper;

    @Override
    public List<Description> findAllForMeasurement(Integer measurementId) {
        var sql = "SELECT * FROM descriptions WHERE MEASUREMENT_ID= " + measurementId;
        List<Description> descriptions = jdbcTemplate.query(sql, descriptionMapper);
        return Objects.isNull(descriptions) ? Collections.emptyList() : descriptions;
    }

    @Override
    public List<Description> saveAll(List<Description> descriptions) {
        var sql = "INSERT INTO descriptions (measurement_id, name, status, comments, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, setParameters(descriptions));
        return Objects.isNull(descriptions) ? Collections.emptyList() : descriptions;
    }

    @Override
    public Description findById(int id) {
        var sql = "SELECT * FROM descriptions WHERE id= " + id;
        Description description = jdbcTemplate.queryForObject(sql, descriptionMapper);
        return Objects.isNull(description) ? new Description() : description;
    }

    @Override
    public List<Description> findAll() {
        var sql = "SELECT * FROM descriptions";
        List<Description> descriptions = jdbcTemplate.query(sql, descriptionMapper);
        return Objects.isNull(descriptions) ? Collections.emptyList() : descriptions;
    }

    @Override
    public Description save(Description description) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        var sql = "INSERT INTO descriptions (measurement_id, name, status, comments, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(connection -> setValuesInPreparedStatement(connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS), description), keyHolder);
        description.setId((Integer) keyHolder.getKeys().get("id"));
        return Objects.isNull(description) ? new Description() : description;
    }

    @Override
    public boolean update(Description description) {
        var sql = "UPDATE descriptions SET measurement_id = ?, name = ?, status = ?, comments = ?, created_at = ?, updated_at = ? where id = " + description.getId();
        return jdbcTemplate.update(sql, getDescriptionSetter(description)) == Constants.SQL_OPERATION_SUCCESS;
    }

    @Override
    public boolean delete(Integer id) {
        var sql = "DELETE FROM descriptions WHERE id = " + id;
        return jdbcTemplate.update(sql) == Constants.SQL_OPERATION_SUCCESS;
    }

    private List<Object[]> setParameters(List<Description> descriptions) {
        List<Object[]> objects = new ArrayList<>();
        for (Description description : descriptions) {
            objects.add(new Object[]{description.getMeasurementId(), description.getName(), description.getStatus(), description.getComments(), description.getCreatedAt(), description.getUpdatedAt()});
        }
        return objects;
    }

    private PreparedStatementSetter getDescriptionSetter(Description description) {
        return preparedStatement -> {
            preparedStatement.setInt(1, description.getMeasurementId());
            preparedStatement.setString(2, description.getName());
            preparedStatement.setInt(3, description.getStatus());
            preparedStatement.setString(4, description.getComments());
            preparedStatement.setDate(5, Utils.convertToSqlDate(description.getCreatedAt()));
            preparedStatement.setDate(6, Utils.convertToSqlDate(description.getUpdatedAt()));
        };
    }

    private PreparedStatement setValuesInPreparedStatement(PreparedStatement preparedStatement, Description description) throws SQLException {
        preparedStatement.setInt(1, description.getMeasurementId());
        preparedStatement.setString(2, description.getName());
        preparedStatement.setInt(3, description.getStatus());
        preparedStatement.setString(4, description.getComments());
        preparedStatement.setDate(5, Utils.convertToSqlDate(description.getCreatedAt()));
        preparedStatement.setDate(6, Utils.convertToSqlDate(description.getUpdatedAt()));

        return preparedStatement;
    }
}
