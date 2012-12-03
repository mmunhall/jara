package com.mikemunhall.jara.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceFactory {

    private static ApplicationContext appContext = new ClassPathXmlApplicationContext("resources.xml");

    public static UserService getUserService() {
        return (UserService) appContext.getBean("userService");
    }
}
