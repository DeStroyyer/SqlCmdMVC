package org.base.service;

import org.base.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.soap.SOAPBinding;
import java.sql.SQLException;
import java.util.List;

public class UserService {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<User> getList() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<User> users = session.createCriteria(User.class).list();
        session.getTransaction().commit();
        return users;
    }

    public void deleteUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void editUser(int id, String name, String email, String password) {

        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            User user = session.load(User.class, id);
            user.setName(name);
            user.setEmail(email);
            user.setPassword(password);
            session.update(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User getUser(int id) {
        User user = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            user = session.get(User.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
