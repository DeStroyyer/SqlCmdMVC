package org.base.dao.daoImplementation;

import org.base.dao.Dao;
import org.base.dao.DaoFactory;
import org.base.model.User;
import org.junit.*;
import org.base.utils.ConnectProperty;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ManagerDaoTest {

    private ConnectProperty properties = new ConnectProperty("connect.properties");
    private DaoFactory factory;
    private Dao dao;

    @Before
    public void prepare() throws SQLException {
        String[] insertParams = {"Rostyslav", "rostyslavpaliuha@gmail.com", "1111"};
        String[] insertParams1 = {"Rostyslav1", "rostyslavpaliuha@gmail.com", "1111"};
        String[] insertParams2 = {"Rostyslav2", "rostyslavpaliuha@gmail.com", "1111"};
        factory = new ManagerDaoFactory();
        factory.createManagerDaoFactory(properties.getProperty("driver"), properties.getProperty("url"), "", "");
        dao = factory.getManagerDao();
        dao.create("USER");
        dao.insert("USER", insertParams);
        dao.insert("USER", insertParams1);
        dao.insert("USER", insertParams2);

    }
    @After
    public void clear() throws SQLException {
        dao.drop("User");
    }


    @Test
    public void shouldShowExistedTables() throws Exception {
        List actual = dao.tablesList();
        assertEquals("USER", actual.get(0));

    }

    @Test
    public void shouldClearDataFromTable() throws Exception {
        dao.delete("User");
        List expected = new ArrayList();
        List actual = dao.read("User");
        assertEquals(expected, actual);

    }

    @Test
    public void shouldDeleteTableFromDB() throws Exception {
        String actual = dao.drop("User");
        String expected = "Table User was droped.";
        assertEquals(expected, actual);
        dao.create("User");

    }

    @Test
    public void shouldCreateTable() throws Exception {
        String[] params = {"name", "email", "password"};
        String actual = dao.create("TEST");
        assertEquals("Table TEST created successful.", actual);
        List actualtablesList=dao.tablesList();
        assertEquals("TEST",actualtablesList.get(0));
        String dropedTest=dao.drop("TEST");
        assertEquals("Table TEST was droped.",dropedTest);



    }

    @Test
    public void shouldReadDataFromTable() throws Exception {
        String expected = "User{id=1, name=Rostyslav, email=rostyslavpaliuha@gmail.com, password=1111}";
        List<User> actualList = dao.read("User");
        String actual=actualList.get(0).toString();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldReadDataAboutOneUser() throws SQLException {
        String expected = "User{id=1, name=Rostyslav, email=rostyslavpaliuha@gmail.com, password=1111}";
        User actual = dao.readByName("USER", "Rostyslav");
        assertEquals(actual.getId(),1);
        assertEquals(actual.getName(),"Rostyslav");
        assertEquals(actual.getEmail(),"rostyslavpaliuha@gmail.com");
        assertEquals(actual.getPassword(),"1111");

        assertEquals(expected, actual.toString());

    }

}