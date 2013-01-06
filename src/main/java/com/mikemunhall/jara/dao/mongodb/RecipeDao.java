package com.mikemunhall.jara.dao.mongodb;

import com.mikemunhall.jara.adapter.IRecipeAdapter;
import com.mikemunhall.jara.dao.IRecipeDao;
import com.mikemunhall.jara.model.Direction;
import com.mikemunhall.jara.model.Ingredient;
import com.mikemunhall.jara.model.Recipe;
import com.mikemunhall.jara.model.Tag;
import com.mongodb.*;
import org.bson.types.ObjectId;

import java.util.*;

public class RecipeDao implements IRecipeDao {

    private IRecipeAdapter recipeAdapter;
    private DBCollection recipeCollection;

    public RecipeDao(DB db, IRecipeAdapter recipeAdapter) {
        recipeAdapter = recipeAdapter;
        recipeCollection = db.getCollection("recipes");
    }

    public Recipe save(Recipe recipe) {
        BasicDBObjectBuilder builder = BasicDBObjectBuilder.start("userId", new ObjectId(recipe.getUserId())).
            append("recipeName", recipe.getRecipeName()).
            append("description", recipe.getDescription()).
            append("servings", recipe.getServings()).
            append("totalPrepTime", recipe.getTotalPrepTime().toStandardMinutes().getMinutes()).
            append("totalCookTime", recipe.getTotalCookTime().toStandardMinutes().getMinutes()).
            append("totalActiveTime", recipe.getTotalActiveTime().toStandardMinutes().getMinutes()).
            append("tags", tagsAsStringArray(recipe)).
            append("ingredients", ingredientsAsMapArray(recipe)).
            append("directions", directionsAsStringArray(recipe));

        if (recipe.getId() == null) {
            builder.append("_id", new ObjectId());
        } else {
            builder.append("_id", new ObjectId(recipe.getId()));
        }

        DBObject recipeObj = builder.get();
        DBObject queryObj = new BasicDBObject("_id", recipeObj.get("id"));

        recipeCollection.update(queryObj, recipeObj, true, false);

        recipe.setId(recipeObj.get("_id").toString());

        return recipe;
    }

    public ArrayList<Recipe> getRecipesByUser(String userId) {
        DBObject query = new BasicDBObject();
        query.put("userId", new ObjectId(userId));

        DBCursor cursor = recipeCollection.find(query);

        ArrayList<Recipe> recipes = new ArrayList<Recipe>();
        Iterator<DBObject> it = cursor.iterator();
        while (it.hasNext()) {
            DBObject obj = it.next();
            Recipe r = recipeAdapter.adapt(obj);
            recipes.add(r);
        }

        return recipes;
    }

    private List<String> tagsAsStringArray(Recipe recipe) {
        List<String> tagsList = new ArrayList<String>();
        for (Tag t : recipe.getTags()) {
            tagsList.add(t.getDescription());
        }
        return tagsList;
    }

    private List<Map> ingredientsAsMapArray(Recipe recipe) {
        List<Map> ingredientsList = new ArrayList<Map>();
        for (Ingredient ing : recipe.getIngredients()) {
            HashMap<String, Object> ingredientAsMap = new HashMap<String, Object>();
            ingredientAsMap.put("quantity", ing.getQuantity());
            ingredientAsMap.put("unit", ing.getUnit());
            ingredientAsMap.put("description", ing.getDescription());
            ingredientsList.add(ingredientAsMap);
        }
        return ingredientsList;
    }

    private List<String> directionsAsStringArray(Recipe recipe) {
        List<String> directionsList = new ArrayList<String>();
        for (Direction d : recipe.getDirections()) {
            directionsList.add(d.getDescription());
        }
        return directionsList;
    }

}
