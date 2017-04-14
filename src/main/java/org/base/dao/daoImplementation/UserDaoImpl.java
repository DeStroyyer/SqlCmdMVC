package org.base.dao.daoImplementation;

import org.base.dao.UserDao;
import org.base.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) throws SQLException {

        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(User user) throws SQLException {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(user);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public User getUser(int id) throws SQLException {
        User user = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            user = (User) session.get(User.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> getUsers() throws SQLException {
        List<User> users = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            users = session.createCriteria(User.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;

    }
}
