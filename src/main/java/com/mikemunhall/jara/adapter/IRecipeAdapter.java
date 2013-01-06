package com.mikemunhall.jara.adapter;

import com.mikemunhall.jara.model.Recipe;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

public interface IRecipeAdapter {

    public Recipe adapt(DBObject obj);

}