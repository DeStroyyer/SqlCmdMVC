package org.base.dao.daoImplementation;

import org.base.dao.RoleDao;
import org.base.model.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleDaoImpl implements RoleDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addRole(Role role) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(role);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Role getRole(int id) {
        Role role = null;
        try (Session session = sessionFactory.openSession()) {
            role = session.get(Role.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }
}
