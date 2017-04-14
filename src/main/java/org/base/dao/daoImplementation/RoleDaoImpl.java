package org.base.dao.daoImplementation;

import org.base.dao.RoleDao;
import org.base.model.Role;
import org.base.model.User;
import org.base.utils.HibernateUtil;
import org.hibernate.Session;

public class RoleDaoImpl implements RoleDao {
    @Override
    public void addRole(Role role) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            role = session.get(Role.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return role;
    }
}
