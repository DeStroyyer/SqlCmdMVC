package org.base.sandbox;

import org.base.dao.Dao;
import org.base.dao.DaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String args[]) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Dao dao = (Dao) context.getBean("dao");
        System.out.println(dao);
        DaoFactory application = (DaoFactory) context.getBean("daoFactory");
        System.out.println("Application Details : " + application);
    }
}
