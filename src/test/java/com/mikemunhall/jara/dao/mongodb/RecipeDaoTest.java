package com.mikemunhall.jara.dao.mongodb;

import com.mikemunhall.jara.AbstractMongoDBTest;
import com.mikemunhall.jara.adapter.mongodb.RecipeAdapter;
import com.mikemunhall.jara.model.Direction;
import com.mikemunhall.jara.model.Ingredient;
import com.mikemunhall.jara.model.Recipe;
import com.mikemunhall.jara.model.Tag;
import com.mongodb.*;
import org.bson.types.ObjectId;
import org.joda.time.Duration;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.List;
import static org.testng.AssertJUnit.*;

public class RecipeDaoTest extends AbstractMongoDBTest {

    private RecipeDao dao;
    DBCollection recipeCollection;

    @BeforeClass
    public void initRecipeDataAndDao() throws Exception {
        super.setUpMongo();
        Mongo mongo = getMongo();
        DB db = mongo.getDB("jaraUnitTest");
        recipeCollection = db.getCollection("recipes");
        dao = new RecipeDao(db, new RecipeAdapter());
    }

    @AfterClass
    public void tearDownMongo() throws Exception {
        super.tearDownMongo();
    }

    @Test
    public void testSaveNewWithDefaultProperties_PersistsCorrectly() {
        Recipe recipe = new Recipe(ObjectId.get().toString());
        assert(recipe.getId() == null);
        dao.save(recipe);

        assertNotNull(recipe.getId());
        assertEquals(24, recipe.getId().length());
        assertNotNull(recipe.getUserId());
        assertEquals(24, recipe.getUserId().length());
        assertEquals("New Recipe Created", recipe.getRecipeName().substring(0, 18));
        assertEquals("", recipe.getDescription());
        assertEquals(4, recipe.getServings());
        assertEquals(0, recipe.getTotalPrepTime().getMillis());
        assertEquals(0, recipe.getTotalCookTime().getMillis());
        assertEquals(0, recipe.getTotalActiveTime().getMillis());
        assertEquals(0, recipe.getTags().size());
        assertEquals(0, recipe.getIngredients().size());
        assertEquals(0, recipe.getDirections().size());
    }

    @Test
    public void testSaveNewWithAllProperties_PersistsCorrectly() {
        List<Tag> tags = new ArrayList<Tag>();
        tags.add(new Tag("one", 0));
        tags.add(new Tag("two", 1));

        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(new Ingredient(1, "Oz", "ingredient 1", 0));
        ingredients.add(new Ingredient(2, "Lb", "ingredient 2", 1));

        List<Direction> directions = new ArrayList<Direction>();
        directions.add(new Direction("direction one", 0));
        directions.add(new Direction("direction two", 1));

        Recipe recipe = new Recipe(ObjectId.get().toString());
        recipe.setRecipeName("Unit Test Recipe");
        recipe.setDescription("Unit Test Recipe Description");
        recipe.setServings(22);
        recipe.setTotalPrepTime(new Duration(60000));
        recipe.setTotalCookTime(new Duration(120000));
        recipe.setTotalActiveTime(new Duration(240000));
        recipe.setTags(tags);
        recipe.setIngredients(ingredients);
        recipe.setDirections(directions);

        dao.save(recipe);

        DBObject recipeFromDb = recipeCollection.findOne(new BasicDBObject("_id", new ObjectId(recipe.getId())));

        assert(recipeFromDb.get("_id") instanceof ObjectId);
        assert(recipeFromDb.get("userId") instanceof ObjectId);
        assertEquals("Unit Test Recipe", recipeFromDb.get("recipeName"));
        assertEquals("Unit Test Recipe Description", recipeFromDb.get("description"));
        assertEquals(22, recipeFromDb.get("servings"));
        assertEquals(1, recipeFromDb.get("totalPrepTime"));
        assertEquals(2, recipeFromDb.get("totalCookTime"));
        assertEquals(4, recipeFromDb.get("totalActiveTime"));
        assertEquals(2, ((ArrayList) recipeFromDb.get("tags")).size());
        assertEquals("one", ((ArrayList) recipeFromDb.get("tags")).get(0));
        assertEquals("two", ((ArrayList) recipeFromDb.get("tags")).get(1));
        assertEquals("Oz", ((BasicDBObject) ((ArrayList) recipeFromDb.get("ingredients")).get(0)).get("unit"));
        assertEquals("ingredient 1", ((BasicDBObject) ((ArrayList) recipeFromDb.get("ingredients")).get(0)).get("description"));
        assertEquals(1.0, ((BasicDBObject) ((ArrayList) recipeFromDb.get("ingredients")).get(0)).get("quantity"));
        assertEquals("Lb", ((BasicDBObject) ((ArrayList) recipeFromDb.get("ingredients")).get(1)).get("unit"));
        assertEquals("ingredient 2", ((BasicDBObject) ((ArrayList) recipeFromDb.get("ingredients")).get(1)).get("description"));
        assertEquals(2.0, ((BasicDBObject) ((ArrayList) recipeFromDb.get("ingredients")).get(1)).get("quantity"));
        assertEquals("direction one", ((ArrayList) recipeFromDb.get("directions")).get(0));
        assertEquals("direction two", ((ArrayList) recipeFromDb.get("directions")).get(1));
    }

    @Test
    void getRecipesByUser_ReturnsAllRecipesForGiveUser() {
        fail("Not implemented");
    }
}
