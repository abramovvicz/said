package com.saidproject.saidproject.service.user;

import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.repo.user.IUserRepo;
import com.saidproject.saidproject.repo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepo userRepo;

    public User findByUsername(String name) {
     return userRepo.findByUserName(name);
    }

    public User findById(int id) {
        return userRepo.findById(id);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public User save(User entity) {
        return userRepo.save(entity);
    }

    @Override
    public boolean update(User entity) {
        return userRepo.update(entity);
    }

    @Override
    public boolean delete(Integer id) {
        return userRepo.delete(id);
    }
}
