package com.mikemunhall.jara.adapter.mongodb;

import com.mikemunhall.jara.adapter.IRecipeAdapter;
import com.mikemunhall.jara.model.Recipe;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;

public class RecipeAdapter implements IRecipeAdapter {

    public Recipe adapt(DBObject obj) {
        return new Recipe(new ObjectId().toString());
    }

}
