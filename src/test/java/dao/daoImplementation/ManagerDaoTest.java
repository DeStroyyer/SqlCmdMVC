package dao.daoImplementation;

import dao.daoInterface.Dao;
import dao.daoInterface.DaoFactory;
import jdk.nashorn.internal.runtime.regexp.JoniRegExp;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ManagerDaoTest {
    private String driver = "org.h2.Driver";
    private String url = "jdbc:h2:mem:sqlcmd;DB_CLOSE_DELAY=-1";
    private String user = "";
    private String password = "";
    DaoFactory factory;
    Dao dao;

    @Before
    public void prepare() throws SQLException {
        factory = new ManagerDaoFactory(driver, url, user, password);
        dao = factory.getManagerDao();
        String[] createParams = {"name", "email", "password"};
        String[] insertParams = {"1", "Rostyslav", "rostyslavpaliuha@gmail.com", "1111"};
        dao.create("USER");
        dao.insert("USER", insertParams);

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
        String actual = dao.drop("USER");
        String expected = "Table USER was droped.";
        assertEquals(expected,actual);
    }

    @Test
    public void shouldCreateTable() throws Exception {

        String[] params = {"name", "email", "password"};
        String actual = dao.create("TEST");
        assertEquals("Table TEST created successful.", actual);
    }

    @Test
    public void shouldReadDataFromTable() throws Exception {
        String expected = "User{id=1, name=Rostyslav, email=rostyslavpaliuha@gmail.com, password=1111}";
        List actual = dao.read("User");
        assertEquals(expected, actual.get(0).toString());
    }

}