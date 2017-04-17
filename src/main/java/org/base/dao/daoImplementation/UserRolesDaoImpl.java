package org.base.dao.daoImplementation;

import org.base.dao.UserRolesDao;
import org.base.model.UserRoles;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserRolesDaoImpl implements UserRolesDao {
    private SessionFactory sessionFactory;
@Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUserRole(UserRoles userRoles) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(userRoles);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<UserRoles> getUserRoles() {
        List<UserRoles> users = null;
        try (Session session = sessionFactory.openSession()) {
            users = session.createCriteria(UserRoles.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;

    }
}

