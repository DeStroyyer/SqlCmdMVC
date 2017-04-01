package org.base.sandbox;

import org.base.dao.Dao;
import org.base.dao.DaoFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String args[]) throws SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        DaoFactory factory = (DaoFactory) context.getBean("daoFactory");
        System.out.println(factory);
        Connection connection = factory.getConnection();
        System.out.println(connection);
        Dao managerDao = (Dao)context.getBean("dao");
        System.out.println(managerDao);
    }
}
