package org.base.dao.daoImplementation;

import org.base.dao.Dao;
import org.base.dao.DaoFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ManagerDaoFactoryTestPostgre {

    DaoFactory factory;

    @Autowired
    public void setFactory(DaoFactory factory) {
        this.factory = factory;
    }

    @Test
    public void getConnection() throws Exception {
    Connection connection=factory.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void getManagerDao() throws Exception {
        Dao dao=factory.getManagerDao();
        assertNotNull(dao);
    }

}