package dao.daoImplementation;

import dao.Dao;
import dao.DaoFactory;
import org.junit.Test;
import utils.ConnectProperty;

import java.sql.Connection;
import java.sql.SQLException;

import static org.junit.Assert.*;

public class ManagerDaoFactoryTest {
    ConnectProperty properties = new ConnectProperty();
    DaoFactory factory = new ManagerDaoFactory(properties.getDriver(), properties.getUrl(), properties.getUser(), properties.getPassword());
    Dao dao = factory.getManagerDao();

    @Test
    public void shouldConnectToDb() throws SQLException {
        Connection connection = factory.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void shouldReturnCarDaoTest() {
        assertNotNull(dao);
    }

}