package com.mikemunhall.jara.adpater.mongodb;

import com.mikemunhall.jara.adapter.mongodb.RecipeAdapter;
import com.mikemunhall.jara.model.Recipe;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import org.bson.types.ObjectId;
import org.testng.annotations.*;
import static org.testng.AssertJUnit.*;

public class RecipeAdapterTest {

    private RecipeAdapter recipeAdapter = new RecipeAdapter();

    @Test
    public void adapt_ProperlyBindsProperties() {
        BasicDBObject obj = (BasicDBObject) new BasicDBObjectBuilder().
            add("_id", new ObjectId()).
            add("userId", new ObjectId()).
            add("recipeName", "Recipe Name").
            add("description", "Recipe Description").
            add("servings", 22).
            add("totalPrepTime", 60000l).
            add("totalCookTime", 120000l).
            add("totalActiveTime", 240000l).
            get();

        BasicDBList tagListObj = new BasicDBList();
        BasicDBObject tagObj1 = new BasicDBObject();
        BasicDBObject tagObj2 = new BasicDBObject();
        tagObj1.put("index", 1);
        tagObj2.put("index", 2);
        tagObj1.put("description", "tag one");
        tagObj2.put("description", "tag two");
        tagListObj.add(tagObj1);
        tagListObj.add(tagObj2);
        obj.put("tags", tagListObj);

        BasicDBList directionListObj = new BasicDBList();
        BasicDBObject directionObj1 = new BasicDBObject();
        BasicDBObject directionObj2 = new BasicDBObject();
        directionObj1.put("index", 1);
        directionObj2.put("index", 2);
        directionObj1.put("description", "dir one");
        directionObj2.put("description", "dir two");
        directionListObj.add(directionObj1);
        directionListObj.add(directionObj2);
        obj.put("directions", directionListObj);

        BasicDBList ingredientListObj = new BasicDBList();
        BasicDBObject ingredientObj1 = new BasicDBObject();
        BasicDBObject ingredientObj2 = new BasicDBObject();
        ingredientObj1.put("index", 1);
        ingredientObj2.put("index", 2);
        ingredientObj1.put("description", "ingredient one");
        ingredientObj2.put("description", "ingredient two");
        ingredientObj1.put("unit", "unit one");
        ingredientObj2.put("unit", "unit two");
        ingredientObj1.put("quantity", 1);
        ingredientObj2.put("quantity", 2.0);
        ingredientListObj.add(ingredientObj1);
        ingredientListObj.add(ingredientObj2);
        obj.put("ingredients", ingredientListObj);

        Recipe recipe = recipeAdapter.adapt(obj);

        assertEquals(24, recipe.getId().length());
        assertEquals(24, recipe.getUserId().length());
        assertEquals("Recipe Name", recipe.getRecipeName());
        assertEquals("Recipe Description", recipe.getDescription());
        assertEquals(22, recipe.getServings());
        assertEquals(1, recipe.getTotalPrepTime().toStandardMinutes().getMinutes());
        assertEquals(2, recipe.getTotalCookTime().toStandardMinutes().getMinutes());
        assertEquals(4, recipe.getTotalActiveTime().toStandardMinutes().getMinutes());
        assertEquals(2, recipe.getTags().size());
        assertEquals("tag one", recipe.getTags().get(0).getDescription());
        assertEquals("tag two", recipe.getTags().get(1).getDescription());
        assertEquals(1, recipe.getTags().get(0).getIndex());
        assertEquals(2, recipe.getTags().get(1).getIndex());
        assertEquals(2, recipe.getDirections().size());
        assertEquals("dir one", recipe.getDirections().get(0).getDescription());
        assertEquals("dir two", recipe.getDirections().get(1).getDescription());
        assertEquals(1, recipe.getDirections().get(0).getIndex());
        assertEquals(2, recipe.getDirections().get(1).getIndex());
        assertEquals(2, recipe.getIngredients().size());
        assertEquals("ingredient one", recipe.getIngredients().get(0).getDescription());
        assertEquals("ingredient two", recipe.getIngredients().get(1).getDescription());
        assertEquals(1, recipe.getIngredients().get(0).getIndex());
        assertEquals(2, recipe.getIngredients().get(1).getIndex());
        assertEquals(1f, recipe.getIngredients().get(0).getQuantity());
        assertEquals(2f, recipe.getIngredients().get(1).getQuantity());
        assertEquals("unit one", recipe.getIngredients().get(0).getUnit());
        assertEquals("unit two", recipe.getIngredients().get(1).getUnit());
    }
}
