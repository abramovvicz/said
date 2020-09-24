package com.saidproject.saidproject.dao.mappers;

import com.saidproject.saidproject.dao.user.User;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.util.StringUtils;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        var id = resultSet.getInt("id");
        var name = resultSet.getString("name");
        var surname = resultSet.getString("surname");
        var userName = resultSet.getString("username");
        var password = resultSet.getString("password");
        var role = resultSet.getString("role");
        var createDate = resultSet.getDate("created_at");
        var updateDate = resultSet.getDate("updated_at");

        User user = new User();
        user.setId(id);
        user.setName(StringUtils.isEmpty(name) ? "" : name);
        user.setSurname(StringUtils.isEmpty(surname) ? "" : surname);
        user.setUserName(StringUtils.isEmpty(userName) ? "" : userName);
        user.setPassword(StringUtils.isEmpty(password) ? "" : password);
        user.setRole(StringUtils.isEmpty(role) ? User.Role.USER : User.Role.valueOf(role));
        user.setCreatedAt(createDate);
        user.setUpdatedAt(updateDate);
        return user;
    }
}
