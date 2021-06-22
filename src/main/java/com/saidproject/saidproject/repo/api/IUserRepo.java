package com.saidproject.saidproject.repo.api;

import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.repo.IRepo;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends IRepo<User> {
    User findByUserName(String name);
}
