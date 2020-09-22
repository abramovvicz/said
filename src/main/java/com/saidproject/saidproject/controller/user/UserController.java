package com.saidproject.saidproject.controller.user;

import com.saidproject.saidproject.controller.IController;
import com.saidproject.saidproject.repo.user.UserRepo;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class UserController implements IController<UserRepo> {
    @Override
    public ResponseEntity<UserRepo> findById(int id) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserRepo>> findAll() {
        return null;
    }

    @Override
    public void save(UserRepo entity) {

    }

    @Override
    public void update(UserRepo entity) {

    }

    @Override
    public void delete(int id) {

    }
}
