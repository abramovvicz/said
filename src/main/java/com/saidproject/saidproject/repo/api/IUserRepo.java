package com.saidproject.saidproject.repo.api;

import com.saidproject.saidproject.dao.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

public interface IUserRepo extends JpaRepository<User, Integer> {
}
