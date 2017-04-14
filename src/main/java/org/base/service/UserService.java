package org.base.service;

import org.base.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserService {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<User> getList(){
         Session session=sessionFactory.openSession();
        session.beginTransaction();
        List<User> users=session.createCriteria(User.class).list();
        session.getTransaction().commit();
        return users;
    }
}
