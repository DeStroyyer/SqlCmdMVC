package org.base.dao.daoImplementation;

import org.base.dao.Dao;
import org.base.dao.DaoFactory;
import org.junit.Test;
import org.base.utils.ConnectProperty;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ManagerDaoFactoryTest {
    ConnectProperty properties = new ConnectProperty("connect.properties");
    DaoFactory factory = new ManagerDaoFactory();
    Dao dao = factory.getManagerDao();

    @Test
    public void shouldConnectToDb() throws SQLException {
        factory.initDaoFactory();
        Connection connection = factory.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void shouldReturnCarDaoTest() {
        assertNotNull(dao);
    }

}