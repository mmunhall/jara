package com.mikemunhall.jara.service;

import com.mikemunhall.jara.dao.mongodb.UserDao;
import com.mikemunhall.jara.model.User;
import org.testng.annotations.*;
import static org.mockito.Mockito.*;
import static org.testng.AssertJUnit.*;

public class UserServiceTest {

    private UserDao userDao;
    private UserService userService;

    @BeforeTest
    public void setUpUserServiceAndDependencies() {
        userDao = mock(UserDao.class);
        userService = new UserService(userDao);
    }

    @Test
    public void getUserByUsername_ValidUser_ReturnsUser() {
        when(userDao.getUserByUsername(anyString())).thenReturn(new User());

        User user = null;

        try {
            user = userService.getUserByUsername("un1");
        } catch (Exception e) {
            fail("Exception thrown, but not expected: " + e.getMessage());
        }

        assertNotNull(user);
        assert(user instanceof User);
    }

    public void getUserByUsername_InvalidUser_ThrowsInvalidUserException() {
        when(userDao.getUserByUsername(anyString())).thenReturn(null);

        try {
            User user = userService.getUserByUsername("un1");
            fail("Expected InvalidUserException");
        } catch (InvalidUserException e) {
            // passes
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass());
        }

    }
}
