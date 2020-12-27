package com.saidproject.saidproject.service.user;

import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.exceptions.NotFoundException;
import com.saidproject.saidproject.repo.api.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepo userRepo;

    public User findByUsername(String name) {
        return userRepo.findByUserName(name).orElse(null);
    }

    public User findById(int id) throws NotFoundException {
        User user = userRepo.findById(id);
        if (user == null) {
            throw new NotFoundException("User not found");
        }
        return user;
    }

    public List<User> findAll() throws NotFoundException {
        List<User> users = userRepo.findAll();
        if (users.isEmpty()) {
            throw new NotFoundException("Users not found");
        }
        return users;
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
