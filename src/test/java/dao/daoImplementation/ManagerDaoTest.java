package dao.daoImplementation;

import dao.Dao;
import dao.DaoFactory;
import org.junit.*;
import utils.ConnectProperty;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ManagerDaoTest {

    ConnectProperty properties = new ConnectProperty("connect.properties");
    DaoFactory factory;
    Dao dao;

    @Before
    public void prepare() throws SQLException {
        String[] createParams = {"name", "email", "password"};
        String[] insertParams = {"1", "Rostyslav", "rostyslavpaliuha@gmail.com", "1111"};
        factory.createManagerDaoFactory(properties.getProperty("driver"), properties.getProperty("url"), "", "");
        dao = factory.getManagerDao();
        dao.create("USER");
        dao.insert("USER", insertParams);


    }


    @Test
    public void shouldShowExistedTables() throws Exception {
        List actual = dao.tablesList();
        assertEquals("USER", actual.get(0));
        dao.drop("USER");
    }

    @Test
    public void shouldClearDataFromTable() throws Exception {
        dao.delete("User");
        List expected = new ArrayList();
        List actual = dao.read("User");
        assertEquals(expected, actual);
        dao.drop("USER");
    }

    @Test
    public void shouldDeleteTableFromDB() throws Exception {
        String actual = dao.drop("USER");
        String expected = "Table USER was droped.";
        assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateTable() throws Exception {
        String[] params = {"name", "email", "password"};
        String actual = dao.create("TEST");
        assertEquals("Table TEST created successful.", actual);
        dao.drop("USER");
    }

    @Test
    public void shouldReadDataFromTable() throws Exception {
        String expected = "User{id=1, name=Rostyslav, email=rostyslavpaliuha@gmail.com, password=1111}";
        List actual = dao.read("User");
        assertEquals(expected, actual.get(0).toString());
        dao.drop("USER");
    }

}