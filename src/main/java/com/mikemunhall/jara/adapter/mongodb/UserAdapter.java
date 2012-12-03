package com.mikemunhall.jara.adapter.mongodb;

import com.mikemunhall.jara.adapter.IUserAdapter;
import com.mikemunhall.jara.model.User;
import com.mongodb.BasicDBObject;
import org.joda.time.DateTime;

public class UserAdapter implements IUserAdapter {

    public User adapt(BasicDBObject obj) {
        User user = new User();
        user.setId(obj.get("_id").toString());
        user.setFirstName(obj.getString("firstName"));
        user.setLastName(obj.getString("lastName"));
        user.setUsername(obj.getString("username"));
        user.setPassword(obj.getString("password"));
        user.setEmail(obj.getString("email"));
        user.setCreateDate(new DateTime(obj.getDate("createDate")));

        return user;
    }

}
