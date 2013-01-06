package com.mikemunhall.jara.service;

import com.mikemunhall.jara.dao.mongodb.RecipeDao;
import com.mikemunhall.jara.model.Recipe;
import org.bson.types.ObjectId;
import org.testng.annotations.*;
import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.*;

public class RecipeServiceTest {

    private RecipeDao recipeDao;
    private RecipeService recipeService;

    @BeforeClass
    public void setUpRecipeServiceAndDependencies() {
        recipeDao = mock(RecipeDao.class);
        recipeService = new RecipeService(recipeDao);
    }

    @Test
    public void create_ReturnsRecipeWithGivenUser() {
        ObjectId objId = new ObjectId();
        when(recipeDao.save(any(Recipe.class))).thenReturn(new Recipe(new ObjectId().toString()));

        Recipe recipe = recipeService.create(objId.toString());

        assert(recipe instanceof Recipe);
        assertEquals(objId.toString(), recipe.getUserId());
    }

    @Test
    public void getRecipesByUser_ReturnsArrayListOfRecipesWithSameUser() {
        fail("Not implemented");
    }

}
