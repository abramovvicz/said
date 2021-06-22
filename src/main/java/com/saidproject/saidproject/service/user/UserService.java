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
        return userRepo.findByUserName(name);
    }

    public User findById(int id) throws NotFoundException {
        return userRepo.getOne(id);
    }

    public List<User> findAll() throws NotFoundException {
        List<User> users = userRepo.findAll();
        if (users.isEmpty()) {
            throw new NotFoundException("Users not found");
        }
        return users;
    }

    @Override
    public User saveDescription(User entity) {
        return userRepo.save(entity);
    }

    @Override
    public User update(User entity) {
        return userRepo.save(entity);
    }

    @Override
    public boolean delete(Integer id) {
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
            return true;
        }
        return false;
    }
}
