package com.mikemunhall.jara;

import com.mikemunhall.jara.model.User;
import com.mikemunhall.jara.service.InvalidUserException;
import com.mikemunhall.jara.service.ServiceFactory;
import com.mikemunhall.jara.service.UserService;
import org.testng.annotations.*;

public class SmokeTest {

    @Test
    public void testApp()
    {
        UserService userService = ServiceFactory.getUserService();
        try {
            User user = userService.getUserByUsername("dmunhall");
            System.out.println(user.getFirstName());
        } catch (InvalidUserException e) {
            System.out.println(e.getMessage());
        }

    }
}
