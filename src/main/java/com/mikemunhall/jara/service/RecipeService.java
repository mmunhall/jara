package com.mikemunhall.jara.service;

import com.mikemunhall.jara.dao.IRecipeDao;
import com.mikemunhall.jara.model.Recipe;
import java.util.ArrayList;

public class RecipeService {

    private IRecipeDao recipeDao;

    public RecipeService(IRecipeDao dao) {
        this.recipeDao = dao;
    }

    public Recipe create(String userId) {
        return new Recipe();
    }

    public ArrayList<Recipe> getRecipesByUser(String userId) {
        return new ArrayList<Recipe>();
    }

    public Recipe getRecipeById(String recipeId) {
        return new Recipe();
    }
}
