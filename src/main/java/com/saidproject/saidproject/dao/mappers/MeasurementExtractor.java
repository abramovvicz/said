package com.saidproject.saidproject.dao.mappers;

import com.saidproject.saidproject.dao.Description;
import com.saidproject.saidproject.dao.HydrantDiameter;
import com.saidproject.saidproject.dao.HydrantSubType;
import com.saidproject.saidproject.dao.HydrantType;
import com.saidproject.saidproject.dao.Measurement;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MeasurementExtractor implements ResultSetExtractor<List<Measurement>> {
    @Override
    public List<Measurement> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        Map<Integer, Measurement> measurementMap = new HashMap();

        while(resultSet.next()) {
            var measurementId = resultSet.getInt("measurements.id");
            var measurement = measurementMap.get(Objects.isNull(measurementId) ? 0 : measurementId);
            if (measurement == null) {
                var id = resultSet.getInt("id");
                var address = resultSet.getString("address");
                var hydrantType = resultSet.getString("hydrant_type");
                var hydrantSubType = resultSet.getString("hydrant_subtype");
                var hydrantDiameter = resultSet.getString("hydrant_diameter");
                var measurementDate = resultSet.getDate("measurement_date");
                long time = Objects.isNull(measurementDate) ? 0L : measurementDate.getTime();
                Date date = new Date(time);

                measurement = new Measurement();
                measurement.setId(id);
                measurement.setAddress(StringUtils.isEmpty(address) ? "" : address);
                measurement.setHydrantType(StringUtils.isEmpty(hydrantType) ? HydrantType.UNDEFINED : HydrantType.valueOf(hydrantType));
                measurement.setHydrantSubType(StringUtils.isEmpty(hydrantSubType) ? HydrantSubType.UNDEFINED : HydrantSubType.valueOf(hydrantSubType));
                measurement.setHydrantDiameter(StringUtils.isEmpty(hydrantDiameter) ? HydrantDiameter.UNDEFINED : HydrantDiameter.valueOf(hydrantDiameter));
                measurement.setDateOfMeasurement(date);
                measurement.setDescriptions(new ArrayList<>());
            }

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

            measurement.getDescriptions().add(description);

            measurementMap.put(measurementId, measurement);
        }

        return List.copyOf(measurementMap.values());
    }
}
