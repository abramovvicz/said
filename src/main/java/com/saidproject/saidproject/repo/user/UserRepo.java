package com.saidproject.saidproject.repo.user;

import com.saidproject.saidproject.dao.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo implements IUserRepo {
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
        //TODO
    }

    @Override
    public void delete(int id) {
        //TODO
    }
}
