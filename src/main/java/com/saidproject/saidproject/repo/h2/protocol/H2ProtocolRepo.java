package com.saidproject.saidproject.repo.h2.protocol;

import com.google.common.collect.Iterables;
import com.saidproject.saidproject.dao.mappers.ProtocolExtractor;
import com.saidproject.saidproject.dao.protocol.Protocol;
import com.saidproject.saidproject.repo.api.IProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Repository
public class H2ProtocolRepo implements IProtocol {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ProtocolExtractor protocolExtractor;


    @Override
    public Protocol findById(int id) {
        var sql = "select * from protocol left join measurements on measurements.protocol_id = protocol.id left join descriptions on descriptions.measurement_id = measurements.id where protocol_id = " + id;
        List<Protocol> query = jdbcTemplate.query(sql, protocolExtractor);
        Protocol protocol = Iterables.getFirst(query, new Protocol());
        return Objects.isNull(protocol) ? new Protocol() : protocol;
    }

    @Override
    public List<Protocol> findAll() {
        var sql = "select * from protocol left join measurements on measurements.protocol_id = protocol.id left join descriptions on descriptions.measurement_id = measurements.id";
        return new ArrayList<>(jdbcTemplate.query(sql, protocolExtractor));
    }

    @Override
    public Protocol save(Protocol protocol) {
        var sql = "insert into protocol (title)" + "values (?)";
        System.out.println("dupa idzie z h2 " + protocol);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> setValuesInPreparedStatement(connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS), protocol), keyHolder);
        protocol.setId(keyHolder.getKey().intValue());
        return Objects.isNull(protocol) ? new Protocol() : protocol;
    }

    @Override
    public boolean update(Protocol entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    private PreparedStatement setValuesInPreparedStatement(PreparedStatement preparedStatement, Protocol protocol) throws SQLException {
        preparedStatement.setString(1, protocol.getTitle());
        return preparedStatement;
    }
}
