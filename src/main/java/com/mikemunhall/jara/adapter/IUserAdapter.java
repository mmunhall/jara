package com.mikemunhall.jara.adapter;

import com.mikemunhall.jara.model.User;
import com.mongodb.BasicDBObject;

public interface IUserAdapter {

    User adapt(BasicDBObject obj);

}
