package org.base.dao.daoImplementation;

import org.base.dao.UserRolesDao;
import org.base.model.User;
import org.base.model.UserRoles;
import org.base.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class UserRolesDaoImpl implements UserRolesDao {
    @Override
    public void addUserRole(UserRoles userRoles) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            users = session.createCriteria(UserRoles.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;

    }
}

