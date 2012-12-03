package com.mikemunhall.jara.dao.mongodb;

import org.testng.annotations.*;
import static org.testng.AssertJUnit.*;

public class UserDaoTest {

    @BeforeTest
    public void initUsersCollection() {

    }

    @Test
    public void getUserByUsername_ValidUser_FindsAndReturnsCorrectUser() {
        fail("Not implemented");
    }

    @Test
    public void getUserByUser_InvalidUser_ReturnsNull() {
        fail("Not implemented");
    }
}
