package com.mikemunhall.jara.service;

import com.mikemunhall.jara.dao.IUserDao;
import com.mikemunhall.jara.model.User;

public class UserService {

    private IUserDao userDao;

    public UserService(IUserDao dao) {
        this.userDao = dao;
    }

    public User getUserByUsername(String username) throws InvalidUserException {
        User user = userDao.getUserByUsername(username);

        if (user == null) {
            throw new InvalidUserException("User " + username + " not found.");
        } else {
            return user;
        }
    }
}
