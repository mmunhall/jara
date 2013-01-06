package com.mikemunhall.jara.dao;

import com.mikemunhall.jara.model.Recipe;

import java.util.ArrayList;

public interface IRecipeDao {

    public Recipe save(Recipe recipe);
    public ArrayList<Recipe> getRecipesByUser(String userId);

}
