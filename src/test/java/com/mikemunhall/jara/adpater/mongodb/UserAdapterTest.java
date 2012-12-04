package com.mikemunhall.jara.adpater.mongodb;

import com.mikemunhall.jara.adapter.mongodb.UserAdapter;
import com.mikemunhall.jara.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.testng.annotations.*;
import static org.testng.AssertJUnit.*;

public class UserAdapterTest {

    private UserAdapter userAdapter = new UserAdapter();

    @Test
    public void adapt_ProperlyBindsProperties() {
        BasicDBObject obj = (BasicDBObject) new BasicDBObjectBuilder().
            add("_id", new ObjectId()).
            add("firstName", "Bitsy").
            add("lastName", "Spider").
            add("username", "bspider").
            add("password", "wat3rsp0ut").
            add("email", "downcametherain@gmail.com").
            add("createDate", new DateTime(2012, 2, 12, 0, 0, 0).toDate()).
            get();

        User user = userAdapter.adapt(obj);

        assertEquals("Bitsy", user.getFirstName());
        assertEquals("Spider", user.getLastName());
        assertEquals("bspider", user.getUsername());
        assertEquals("wat3rsp0ut", user.getPassword());
        assertEquals("downcametherain@gmail.com", user.getEmail());
        assertEquals(2012, user.getCreateDate().getYear());
        assertEquals(2, user.getCreateDate().getMonthOfYear());
        assertEquals(12, user.getCreateDate().getDayOfMonth());
    }
}
