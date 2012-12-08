package com.mikemunhall.jara.dao.mongodb;

import com.mikemunhall.jara.adapter.IRecipeAdapter;
import com.mikemunhall.jara.dao.IRecipeDao;
import com.mongodb.*;

public class RecipeDao implements IRecipeDao {

    private IRecipeAdapter recipeAdapter;
    private DBCollection recipeCollection;

    public RecipeDao(DB db, IRecipeAdapter recipeAdapter) {
        this.recipeAdapter = recipeAdapter;
        recipeCollection = db.getCollection("recipes");
    }

}
