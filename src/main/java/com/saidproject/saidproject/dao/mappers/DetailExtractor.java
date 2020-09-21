package com.saidproject.saidproject.dao.mappers;

import com.saidproject.saidproject.dao.description.Description;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DetailExtractor implements ResultSetExtractor<List<Description>> {
    @Override
    public List<Description> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Description> descriptionList = new ArrayList<>();

        while (resultSet.next()) {
            var descriptionId = resultSet.getInt("descriptions.id");
            var measurementParentId = resultSet.getInt("descriptions.measurement_id");
            var descriptionName = resultSet.getString("descriptions.name");
            var descriptionStatus = resultSet.getInt("descriptions.status");
            var descriptionComments = resultSet.getString("descriptions.comments");

            Description description = new Description();
            description.setId(Objects.isNull(descriptionId) ? 0 : descriptionId);
            description.setMeasurementId(Objects.isNull(measurementParentId) ? 0 : measurementParentId);
            description.setName(StringUtils.isEmpty(descriptionName) ? "" : descriptionName);
            description.setComments(StringUtils.isEmpty(descriptionComments) ? "" : descriptionComments);
            description.setStatus(Objects.isNull(descriptionStatus) ? 0 : descriptionStatus);
            descriptionList.add(description);
        }
        return descriptionList;
    }
}
