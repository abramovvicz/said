package com.saidproject.saidproject.repo.user;

import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.repo.IRepo;

public interface IUserRepo extends IRepo<User> {
    User findByUserName(String name);
}
