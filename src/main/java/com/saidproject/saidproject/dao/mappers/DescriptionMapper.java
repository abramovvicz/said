package com.saidproject.saidproject.dao.mappers;

import com.saidproject.saidproject.dao.description.Description;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

public class DescriptionMapper implements RowMapper<Description> {

    @Override
    public Description mapRow(ResultSet resultSet, int i) throws SQLException {
        var descriptionId = resultSet.getInt("id");
        var measurementParentId = resultSet.getInt("measurement_id");
        var descriptionName = resultSet.getString("name");
        var descriptionStatus = resultSet.getString("status");
        var descriptionComments = resultSet.getString("comments");

        Description description = new Description();
        description.setId(Objects.isNull(descriptionId) ? 0 : descriptionId);
        description.setMeasurementId(Objects.isNull(measurementParentId) ? 0 : measurementParentId);
        description.setName(StringUtils.isEmpty(descriptionName) ? "" : descriptionName);
        description.setComments(StringUtils.isEmpty(descriptionComments) ? "" : descriptionComments);
        description.setStatus(StringUtils.isEmpty(descriptionStatus) ? "" : descriptionStatus);
        return description;
    }
}
