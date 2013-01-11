package com.mikemunhall.jara.adapter.mongodb;

import com.mikemunhall.jara.adapter.IRecipeAdapter;
import com.mikemunhall.jara.model.Direction;
import com.mikemunhall.jara.model.Ingredient;
import com.mikemunhall.jara.model.Recipe;
import com.mikemunhall.jara.model.Tag;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.types.ObjectId;
import org.joda.time.Duration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecipeAdapter implements IRecipeAdapter {

    public Recipe adapt(DBObject obj) {
        Recipe recipe = new Recipe(obj.get("userId").toString());
        recipe.setId(obj.get("_id").toString());
        recipe.setRecipeName((String) obj.get("recipeName"));
        recipe.setDescription((String) obj.get("description"));
        recipe.setServings((Integer) obj.get("servings"));
        recipe.setTotalPrepTime(new Duration(obj.get("totalPrepTime")));
        recipe.setTotalCookTime(new Duration(obj.get("totalCookTime")));
        recipe.setTotalActiveTime(new Duration(obj.get("totalActiveTime")));

        List<Tag> tags = new ArrayList<Tag>();
        Iterator tagsIt = ((BasicDBList) obj.get("tags")).iterator();
        while (tagsIt.hasNext()) {
            BasicDBObject tagObj = (BasicDBObject) tagsIt.next();
            Tag tag = new Tag();
            tag.setIndex(tagObj.getInt("index"));
            tag.setDescription(tagObj.getString("description"));
            tags.add(tag);
        }
        recipe.setTags(tags);

        List<Direction> directions = new ArrayList<Direction>();
        Iterator directionsIt = ((BasicDBList) obj.get("directions")).iterator();
        while (directionsIt.hasNext()) {
            BasicDBObject directionObj = (BasicDBObject) directionsIt.next();
            Direction direction = new Direction();
            direction.setIndex(directionObj.getInt("index"));
            direction.setDescription(directionObj.getString("description"));
            directions.add(direction);
        }
        recipe.setDirections(directions);

        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        Iterator ingredientsIt = ((BasicDBList) obj.get("ingredients")).iterator();
        while (ingredientsIt.hasNext()) {
            BasicDBObject ingredientObj = (BasicDBObject) ingredientsIt.next();
            Ingredient ingredient = new Ingredient();
            ingredient.setIndex(ingredientObj.getInt("index"));
            ingredient.setDescription(ingredientObj.getString("description"));
            ingredient.setQuantity((float) ingredientObj.getDouble("quantity"));
            ingredient.setUnit(ingredientObj.getString("unit"));
            ingredients.add(ingredient);
        }
        recipe.setIngredients(ingredients);

        return recipe;
    }

}
