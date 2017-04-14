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
import org.base.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import javax.persistence.PersistenceException;
import java.sql.SQLException;


public class Main {
    public static void main(String args[]) throws PersistenceException, SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        UserDao userDao = (UserDao) context.getBean("dao1");
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService.getList());
    }}

