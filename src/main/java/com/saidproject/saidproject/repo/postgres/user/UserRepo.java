package com.saidproject.saidproject.repo.postgres.user;

import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.repo.AbstractEntity;
import com.saidproject.saidproject.repo.api.IUserRepo;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo extends AbstractEntity implements IUserRepo {


    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findAll(Sort sort) {
        return null;
    }

    @Override
    public User getOne(Integer integer) {
        return null;
    }

    @Override
    public User save(User entity) {
        return null;
    }

    @Override
    public boolean update(User entity) {
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        return false;
    }

    @Override
    public User findByUserName(String name) {
        return null;
    }
}
