package org.base.controller;

import org.base.service.Service;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ManagerControllerTest {
@Autowired
    public void setService(Service service) {
        this.service = service;
    }
    Service service;

    @Test
    public void loginSubmit() throws Exception {
    String tables=service.tables();
   /* String username=service.getUser("user").getName();
        String password=service.getUser("user").getPassword();*/
        assertEquals("user",tables);
       /* assertEquals(username,"user");
        assertEquals(password,"pass");*/
    }

    @Test
    public void registration() throws Exception {

    }

}