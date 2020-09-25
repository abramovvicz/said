package com.saidproject.saidproject.repo.user;

import com.saidproject.saidproject.dao.mappers.UserMapper;
import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.repo.AbstractEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo extends AbstractEntity implements IUserRepo {

    private static final int SQL_OPERATION_SUCCESS = 1;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String name) {
        var sql = "select * from users where name= ?" + name;
        return jdbcTemplate.queryForObject(sql, userMapper);
    }

    @Override
    public User findById(int id) {
        var sql = "select * from users where id= " + id;
        return jdbcTemplate.queryForObject(sql, userMapper);
    }

    @Override
    public List<User> findAll() {
        var sql = "select * from users";
        return jdbcTemplate.query(sql, userMapper);
    }

    @Override
    public boolean save(User entity) {
        var sql = "insert into users (name, surname, username, password, role, created_at, updated_at) values(?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, entity.getName(), entity.getSurname(), entity.getUserName(), entity.getPassword(), entity.getRole().toString(), entity.getCreatedAt(), entity.getUpdatedAt()) == SQL_OPERATION_SUCCESS;
    }

    @Override
    public boolean update(User entity) {
        var sql = "update users set name= ?, surname= ?, username= ?, password= ?, role= ? ,created_at = ? , updated_at= ? where id = " + entity.getId();
        return jdbcTemplate.update(sql, entity.getName(), entity.getSurname(), entity.getUserName(), entity.getPassword(), entity.getRole().toString(), entity.getCreatedAt(), entity.getUpdatedAt()) == SQL_OPERATION_SUCCESS;
    }

    @Override
    public boolean delete(Integer id) {
        var sql = "delete users where id = " + id;
        return jdbcTemplate.update(sql, id) == SQL_OPERATION_SUCCESS;
    }

}
