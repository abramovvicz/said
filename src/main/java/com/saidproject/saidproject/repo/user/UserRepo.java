package com.saidproject.saidproject.repo.user;

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

    @Override
    public User findByUsername(String name) {
        //TODO
        return null;
    }

    @Override
    public User findById(int id) {
        //TODO
        return null;
    }

    @Override
    public List<User> findAll() {
        //TODO
        return null;
    }

    @Override
    public void save(User entity) {
        //TODO
    }

    @Override
    public void update(User entity) {
        var sql = "update users set name=?, surname=?, username=?, password=?, role,created_at, updated_at" +
                "where id = ?";
        jdbcTemplate.update(sql, entity.getName(), entity.getSurname(), entity.getUserName(),
                entity.getPassword(), entity.getRole(), entity.getCreatedAt(), entity.getUpdatedAt(), entity.getId());
    }

    @Override
    public void delete(int id) {
        //TODO
    }
}
