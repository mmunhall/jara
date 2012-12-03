package com.mikemunhall.jara;

import com.mikemunhall.jara.model.User;
import com.mikemunhall.jara.service.InvalidUserException;
import com.mikemunhall.jara.service.ServiceFactory;
import com.mikemunhall.jara.service.UserService;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class SmokeTest extends TestCase {

    public SmokeTest(String testName) {
        super( testName );
    }

    public static Test suite() {
        return new TestSuite( SmokeTest.class );
    }

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
