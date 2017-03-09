package dao.daoImplementation;

import dao.Dao;
import dao.DaoFactory;
import org.junit.Test;
import utils.ConnectProperty;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ManagerDaoFactoryTest {
    ConnectProperty properties = new ConnectProperty("connect.properties");
    DaoFactory factory = new ManagerDaoFactory();
    Dao dao = factory.getManagerDao();

    @Test
    public void shouldConnectToDb() throws SQLException {
        factory.createManagerDaoFactory(properties.getProperty("driver"), properties.getProperty("url"), "", "");
        Connection connection = factory.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void shouldReturnCarDaoTest() {
        assertNotNull(dao);
    }

}