package com.mikemunhall.jara.dao.mongodb;

import com.mikemunhall.jara.adapter.IUserAdapter;
import com.mikemunhall.jara.dao.IUserDao;
import com.mikemunhall.jara.model.User;
import com.mongodb.*;

public class UserDao implements IUserDao {

    private IUserAdapter userAdapter;
    private DBCollection userCollection;

    public UserDao(DB db, IUserAdapter userAdapter) {
        this.userAdapter = userAdapter;
        userCollection = db.getCollection("users");
    }

    public User getUserByUsername(String userName) {
        BasicDBObject userDoc = (BasicDBObject) userCollection.findOne(new BasicDBObject("username", userName));

        if (userDoc == null) {
            return null;
        }

        return userAdapter.adapt(userDoc);
    }

}
