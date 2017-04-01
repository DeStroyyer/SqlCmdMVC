package org.base.dao.daoImplementation;

import org.base.dao.Dao;
import org.base.dao.DaoFactory;
import org.base.model.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class DaoTestPostgre {

    private Dao dao;

    @Autowired
    public void setDao(Dao dao) {
        this.dao = dao;
    }


    @Test
    public void tablesList() throws Exception {

        List actual = dao.tablesList();

        assertEquals("user", actual.get(0));
    }

    @Test
    public void deleteTable() throws Exception {
        String expected = "All Rows In The Table delete Successfully deleted";
        String[] insertParams = {"1", "Rostyslav", "rostyslavpaliuha@gmail.com", "1111"};
        dao.insertUser("delete", insertParams);
        String actual = dao.deleteTable("delete");
        assertEquals(expected, actual);


    }

    @Test
    public void dropTable() throws Exception {
        String expected = "Table drop was droped.";
        dao.createTable("drop");
        String actual = dao.dropTable("drop");
        assertEquals(expected, actual);

    }

    @Test
    public void insertUser() throws Exception {
        dao.deleteTable("inserttest");
        String expected = "Data inserted in table: inserttest successful.";
        String[] insertParams = {"1", "Rostyslav", "rostyslavpaliuha@gmail.com", "1111"};
        String actual = dao.insertUser("inserttest", insertParams);
        assertEquals(expected, actual);

    }

    @Test
    public void createTable() throws Exception {
        dao.dropTable("createtest");
        String expected = "Table createtest created successful.";
        String actual = dao.createTable("createtest");
        assertEquals(expected, actual);

    }

    @Test
    public void showUsers() throws Exception {
        List actual = dao.showUsers("showuserstest");
        assertNotNull(actual.get(0));
        assertNotNull(actual.get(1));
        assertNotNull(actual.get(2));

    }

    @Test
    public void showUser() throws Exception {
        String expected = "User{id=1, name=Rostyslav, email=rostyslavpaliuha@gmail.com, password=1111}";
        User user = dao.showUser("showuserstest", "Rostyslav");
        assertNotNull(user);
        assertEquals(expected, user.toString());

    }

}