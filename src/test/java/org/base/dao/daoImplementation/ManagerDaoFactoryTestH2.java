package org.base.dao.daoImplementation;


import org.base.dao.Dao;
import org.base.dao.DaoFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/testContext.xml"})
public class ManagerDaoFactoryTestH2 {

    private Dao dao;

    private DaoFactory daoFactory;
@Autowired
    public void setDaoFactory(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Test
    public void shouldConnectToDb() throws SQLException {

        Connection connection = daoFactory.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void shouldReturnDaoTest() {
        assertNotNull(dao=daoFactory.getManagerDao());
    }

}
