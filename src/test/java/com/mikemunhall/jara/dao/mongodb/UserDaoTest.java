package com.mikemunhall.jara.dao.mongodb;

import com.mikemunhall.jara.AbstractMongoDBTest;
import com.mikemunhall.jara.adapter.mongodb.UserAdapter;
import com.mikemunhall.jara.model.User;
import com.mongodb.*;
import org.bson.types.ObjectId;
import org.joda.time.DateTime;
import org.testng.annotations.*;
import static org.testng.AssertJUnit.*;

public class UserDaoTest extends AbstractMongoDBTest {

    private UserDao dao;

    @BeforeTest
    public void initUserDataAndDao() {
        System.out.println(":::1:::");
        Mongo mongo = getMongo();
        DB db = mongo.getDB("jaraUnitTest");
        DBCollection userCollection = db.getCollection("users");

        BasicDBObject itsyObj = (BasicDBObject) new BasicDBObjectBuilder().
            add("_id", new ObjectId()).
            add("firstName", "Itsy").
            add("lastName", "Spider").
            add("username", "ispider").
            add("password", "wat3rsp0ut").
            add("email", "downcametherain@gmail.com").
            add("createDate", new DateTime(2012, 2, 12, 0, 0, 0).toDate()).
            get();

        BasicDBObject bitsyObj = (BasicDBObject) new BasicDBObjectBuilder().
            add("_id", new ObjectId()).
            add("firstName", "Bitsy").
            add("lastName", "Spider").
            add("username", "bspider").
            add("password", "wat3rsp0ut").
            add("email", "downcametherain@gmail.com").
            add("createDate", new DateTime(2012, 5, 04, 0, 0, 0).toDate()).
            get();

        userCollection.insert(itsyObj);
        userCollection.insert(bitsyObj);

        dao = new UserDao(db, new UserAdapter());
    }

    @Test
    public void getUserByUsername_ValidUser_FindsAndReturnsCorrectUser() {
        User user = dao.getUserByUsername("bspider");
        assertNotNull(user);
        assertTrue(user instanceof User);
        assertEquals("Bitsy", user.getFirstName());
    }

    @Test
    public void getUserByUser_InvalidUser_ReturnsNull() {
        User user = dao.getUserByUsername("notYourSandwich");
        assertNull(user);
    }
}
