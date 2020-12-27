package com.saidproject.saidproject.repo.api;

import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.repo.IRepo;

import java.util.Optional;

public interface IUserRepo extends IRepo<User> {
    Optional<User> findByUserName(String name);
}
