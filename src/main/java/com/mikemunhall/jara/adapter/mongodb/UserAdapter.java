package com.mikemunhall.jara.adapter.mongodb;

import com.mikemunhall.jara.adapter.IUserAdapter;
import com.mikemunhall.jara.model.User;
import com.mongodb.BasicDBObject;

public class UserAdapter implements IUserAdapter {

    public User adapt(BasicDBObject obj) {
        User user = new User();
        user.setFirstName(obj.getString("firstName"));
        return user;
    }

}
