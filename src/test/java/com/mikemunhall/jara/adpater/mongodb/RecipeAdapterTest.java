package com.mikemunhall.jara.adpater.mongodb;

import com.mikemunhall.jara.adapter.mongodb.RecipeAdapter;
import com.mikemunhall.jara.adapter.mongodb.UserAdapter;
import com.mikemunhall.jara.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.testng.annotations.*;
import static org.testng.AssertJUnit.*;

public class RecipeAdapterTest {

    private RecipeAdapter recipeAdapter = new RecipeAdapter();

    @Test
    public void adapt_ProperlyBindsProperties() {
        fail("Not implemented");
    }
}
