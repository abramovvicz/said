package com.saidproject.saidproject.controller.user;

import com.saidproject.saidproject.controller.IController;
import com.saidproject.saidproject.dao.user.User;
import com.saidproject.saidproject.repo.AbstractEntity;

import java.util.Map;

public interface IUserController extends IController<Map<String, Object>, User> {
}
