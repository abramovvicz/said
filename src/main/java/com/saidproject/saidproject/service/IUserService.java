package com.saidproject.saidproject.service;

import com.saidproject.saidproject.dao.user.User;

public interface IUserService extends IService<User> {
    User findByUsername(String name);
}
