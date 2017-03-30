package org.base.dao.daoImplementation;

import org.base.dao.Dao;
import org.base.model.User;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/testContext.xml"})
public class ManagerDaoTest {

    private Dao dao;

    @Autowired
    public void setDao(Dao dao) {
        this.dao = dao;
    }

    @Before
    public void prepare() throws SQLException {
        String[] insertParams = {"Rostyslav", "rostyslavpaliuha@gmail.com", "1111"};
        String[] insertParams1 = {"Rostyslav1", "rostyslavpaliuha@gmail.com", "1111"};
        String[] insertParams2 = {"Rostyslav2", "rostyslavpaliuha@gmail.com", "1111"};
        dao.createTable("USER");
        dao.insertUser("USER", insertParams);
        dao.insertUser("USER", insertParams1);
        dao.insertUser("USER", insertParams2);

    }

    @After
    public void clear() throws SQLException {
        dao.dropTable("User");
    }


    @Test
    public void shouldShowExistedTables() throws Exception {
        List actual = dao.tablesList();
        assertEquals("USER", actual.get(0));

    }

    @Test
    public void shouldClearDataFromTable() throws Exception {
        dao.deleteTable("User");
        List expected = new ArrayList();
        List actual = dao.showUsers("User");
        assertEquals(expected, actual);

    }

    @Test
    public void shouldDeleteTableFromDB() throws Exception {
        String actual = dao.dropTable("User");
        String expected = "Table User was droped.";
        assertEquals(expected, actual);
        dao.createTable("User");

    }

    @Test
    public void shouldCreateTable() throws Exception {
        String[] params = {"name", "email", "password"};
        String actual = dao.createTable("TEST");
        assertEquals("Table TEST created successful.", actual);
        List actualtablesList = dao.tablesList();
        assertEquals("TEST", actualtablesList.get(0));
        String dropedTest = dao.dropTable("TEST");
        assertEquals("Table TEST was droped.", dropedTest);


    }

    @Test
    public void shouldReadDataFromTable() throws Exception {
        String expected = "User{id=1, name=Rostyslav, email=rostyslavpaliuha@gmail.com, password=1111}";
        List<User> actualList = dao.showUsers("User");
        String actual = actualList.get(0).toString();
        assertEquals(expected, actual);

    }

    @Test
    public void shouldReadDataAboutOneUser() throws SQLException {
        String expected = "User{id=1, name=Rostyslav, email=rostyslavpaliuha@gmail.com, password=1111}";
        User actual = dao.showUser("USER", "Rostyslav");
        assertEquals(actual.getId(), 1);
        assertEquals(actual.getName(), "Rostyslav");
        assertEquals(actual.getEmail(), "rostyslavpaliuha@gmail.com");
        assertEquals(actual.getPassword(), "1111");

        assertEquals(expected, actual.toString());

    }

}
