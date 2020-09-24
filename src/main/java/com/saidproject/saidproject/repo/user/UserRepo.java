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

    private static final Logger logger = LogManager.getLogger(UserRepo.class.getSimpleName());


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
    public void save(User entity) {
        var sql = "insert into users (name, surname, username, password, role, created_at, updated_at) values(?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, entity.getName(), entity.getSurname(), entity.getUserName(), entity.getPassword(), entity.getRole().toString(), entity.getCreatedAt(), entity.getUpdatedAt());
    }

    @Override
    public void update(User entity) {
        var sql = "update users set name= ?, surname= ?, username= ?, password= ?, role= ? ,created_at = ? , updated_at= ? where id = " + entity.getId();
        jdbcTemplate.update(sql, entity.getName(), entity.getSurname(), entity.getUserName(), entity.getPassword(), entity.getRole().toString(), entity.getCreatedAt(), entity.getUpdatedAt());
    }

    @Override
    public void delete(int id) {
        var sql = "delete users where id = " + id;
        jdbcTemplate.update(sql, id);
    }

}
