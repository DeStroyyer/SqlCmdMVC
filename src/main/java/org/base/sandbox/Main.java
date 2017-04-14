package org.base.sandbox;


import org.base.dao.RoleDao;
import org.base.dao.UserDao;
import org.base.dao.UserRolesDao;
import org.base.dao.daoImplementation.RoleDaoImpl;
import org.base.dao.daoImplementation.UserDaoImpl;
import org.base.dao.daoImplementation.UserRolesDaoImpl;
import org.base.model.Role;
import org.base.model.User;
import org.base.model.UserRoles;


import javax.persistence.PersistenceException;
import java.sql.SQLException;


public class Main {
    public static void main(String args[]) throws PersistenceException, SQLException {
       /* ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Dao dao = (Dao) context.getBean("dao");*/

        UserDao userDao = new UserDaoImpl();
        RoleDao roleDao = new RoleDaoImpl();
        UserRolesDao userRolesDao = new UserRolesDaoImpl();

      /*  Role role = new Role();
        role.setName("moderator");
        role.setBenefits("edit content");
        roleDao.addRole(role);

        User user=new User();
        user.setName("Tolyan");
        user.setEmail("tolyan@gmail.com");
        user.setPassword("1111");
        userDao.addUser(user);

        UserRoles userRoles = new UserRoles();
        userRoles.setRole(role);
        userRoles.setUser(user);
        userRolesDao.addUserRole(userRoles);
*/
        System.out.println(userDao.getUsers());
        System.out.println(userRolesDao.getUserRoles());

    }
} 