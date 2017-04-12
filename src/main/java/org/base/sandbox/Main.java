package org.base.sandbox;


import org.base.utils.HibernateUtil;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.persistence.PersistenceException;


public class Main {
    public static void main(String args[]) throws PersistenceException {
       /* ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Dao dao = (Dao) context.getBean("dao");*/

        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    }
}
