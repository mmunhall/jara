package com.mikemunhall.jara.dao;

import com.mikemunhall.jara.model.User;

public interface IUserDao {

    User getUserByUsername(String username);

}
