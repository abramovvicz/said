package com.saidproject.saidproject.repo.h2.user;

import com.saidproject.saidproject.dao.mappers.UserMapper;
import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.repo.AbstractEntity;
import com.saidproject.saidproject.repo.api.IUserRepo;
import com.saidproject.saidproject.utils.Constants;
import com.saidproject.saidproject.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Repository
public class H2UserRepo extends AbstractEntity implements IUserRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String name) {
        var sql = "select * from users where name= ?" + name;
        User user = jdbcTemplate.queryForObject(sql, userMapper);
        return Objects.isNull(user) ? new User() : user;
    }

    @Override
    public User findById(int id) {
        var sql = "select * from users where id= " + id;
        User user = jdbcTemplate.queryForObject(sql, userMapper);
        return Objects.isNull(user) ? new User() : user;
    }

    @Override
    public List<User> findAll() {
        var sql = "select * from users";
        List<User> users = jdbcTemplate.query(sql, userMapper);
        return users.isEmpty() ? Collections.emptyList() : users;
    }

    @Override
    public User save(User user) {
        var sql = "insert into users (name, surname, username, password, role, created_at, updated_at) values(?, ?, ?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> setValuesInPreparedStatement(connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS), user), keyHolder);
        user.setId(keyHolder.getKey().intValue());
        return Objects.isNull(user) ? new User() : user;
    }

    @Override
    public boolean update(User user) {
        var sql = "update users set name= ?, surname= ?, username= ?, password= ?, role= ? ,created_at = ? , updated_at= ? where id = " + user.getId();
        return jdbcTemplate.update(sql, getUserSetter(user)) == Constants.SQL_OPERATION_SUCCESS;
    }

    @Override
    public boolean delete(Integer id) {
        var sql = "delete users where id = " + id;
        return jdbcTemplate.update(sql, id) == Constants.SQL_OPERATION_SUCCESS;
    }

    private PreparedStatementSetter getUserSetter(User user) {
        return preparedStatement -> {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getUserName());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getRole().toString());
            preparedStatement.setDate(6, Utils.convertToSqlDate(user.getCreatedAt()));
            preparedStatement.setDate(7, Utils.convertToSqlDate(user.getUpdatedAt()));
        };
    }

    private PreparedStatement setValuesInPreparedStatement(PreparedStatement preparedStatement, User user) throws SQLException {
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setString(3, user.getUserName());
        preparedStatement.setString(4, user.getPassword());
        preparedStatement.setString(5, user.getRole().toString());
        preparedStatement.setDate(6, Utils.convertToSqlDate(user.getCreatedAt()));
        preparedStatement.setDate(7, Utils.convertToSqlDate(user.getUpdatedAt()));

        return preparedStatement;
    }
}
