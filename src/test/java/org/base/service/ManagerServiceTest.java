package org.base.service;

import org.junit.Before;
import org.junit.Test;
import org.base.service.ServiceImplementation.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

import static org.junit.Assert.assertEquals;


public class ManagerServiceTest {
    private Service service;

    @Autowired
    public void setService(Service service) {
        this.service = service;
    }

    @Before
    public void prepare() throws SQLException {
        String[] params = {"1", "Rostyslav", "rostyslavpaliuha@gmail.com", "1111"};
        service.create("TEST");
        service.input("TEST", params);

    }

    @Test
    public void tables() throws Exception {
        String expected = "TEST";
        String actual = service.tables();
        assertEquals(expected, actual);
        service.drop("TEST");

    }

    @Test
    public void clear() throws Exception {
        String exepected = "Table cleared successful.";
        String actual = service.clear("TEST");
        assertEquals(exepected, actual);
        service.drop("TEST");
    }

    @Test
    public void drop() throws Exception {
        String expected = "Operation done successful.";
        String actual = service.drop("TEST");
        assertEquals(expected, actual);
    }

    @Test
    public void create() throws Exception {
        String expected = "Table TEST1 created successful.";
        String actual = service.create("TEST1");
        assertEquals(expected, actual);
        service.drop("TEST");
        service.drop("TEST1");
    }

    @Test
    public void find() throws Exception {
        String expected = "User{id=1, name=Rostyslav, email=rostyslavpaliuha@gmail.com, password=1111}\n";
        String actual = service.find("TEST");
        assertEquals(expected, actual);
        service.drop("TEST");
    }

}