package com.saidproject.saidproject.service.user;

import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.repo.user.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepo userRepo;

    public User findByUsername(String name) {
        //TODO
        return null;
    }

    public User findById(int id) {
        //TODO
        return null;
    }

    public List<User> findAll() {
        //TODO
        return null;
    }

    public void save(User entity) {
        //TODO
    }

    public void update(User entity) {
        //TODO
    }

    public void delete(int id) {
        //TODO
    }
}
