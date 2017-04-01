package org.base.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/testContext.xml"})
public class ManagerServiceTest {
    private Service service;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @Before
    public void prepare() throws SQLException {
        String[] params = {"1", "Rostyslav", "rostyslavpaliuha@gmail.com", "1111"};
        service.createTable("User");
        service.inputUser("User", params);

    }
    @After
    public void cleartable () throws SQLException {
        service.drop("user");
    }

    @Test
    public void tables() throws Exception {
        String expected = "USER";
        String actual = service.tables();
        assertEquals(expected, actual);

    }

    @Test
    public void clear() throws Exception {
        String exepected = "Table cleared successful.";
        String actual = service.clear("user");
        assertEquals(exepected, actual);

    }

    @Test
    public void drop() throws Exception {
        String expected = "Operation done successful.";
        service.createTable("TEST");
        String actual = service.drop("TEST");
        assertEquals(expected, actual);

    }

    @Test
    public void create() throws Exception {
        String expected = "Table User1 created successful.";
        String actual = service.createTable("User1");
        assertEquals(expected, actual);
        service.drop("user1");
            }

    @Test
    public void find() throws Exception {
        String expected = "User{id=1, name=Rostyslav, email=rostyslavpaliuha@gmail.com, password=1111}\n";
        String actual = service.showUser("Rostyslav");
        assertEquals(expected, actual);

    }

}