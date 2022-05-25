package com.saidproject.saidproject.service.user;

import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.service.IService;

public interface IUserService extends IService<User> {
    User findByUsername(String name);
}
