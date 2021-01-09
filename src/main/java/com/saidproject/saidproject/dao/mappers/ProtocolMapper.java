package com.saidproject.saidproject.dao.mappers;

import com.saidproject.saidproject.dao.measurement.Measurement;
import com.saidproject.saidproject.dao.protocol.Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

public class ProtocolMapper implements RowMapper<Protocol> {

    @Autowired
    MeasurementExtractor measurementExtractor;

    @Override
    public Protocol mapRow(ResultSet resultSet, int i) throws SQLException {
        var protocolId = resultSet.getInt("id");
        var protocolTitle = resultSet.getString("title");
        Protocol protocol = new Protocol();
        protocol.setId(Objects.isNull(protocolId) ? 0 : protocolId);
        protocol.setTitle(StringUtils.isEmpty(protocolTitle) ? "" : protocolTitle);
        List<Measurement> measurements = measurementExtractor.extractData(resultSet);
        protocol.setMeasurements(measurements);
        return protocol;
    }
}
