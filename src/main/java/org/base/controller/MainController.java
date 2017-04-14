package org.base.controller;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;



@Controller
public class MainController {

    private final Logger logger=Logger.getLogger(MainController.class.getName());

    private Service service;

    public void setService(Service service) {
        this.service = service;
    }

    @RequestMapping(value = "/")
    public String start() {
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm() throws SQLException {
        return "login";
    }
    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    public String loginSubmit(@RequestParam String name, @RequestParam String pass, Model model) throws SQLException {
        if (service.getUser(name).getName().equals(name) & service.getUser(name).getPassword().equals(pass)) {
            service.setLogined(true);
            model.addAttribute("name", name);
            logger.info("Loginned successful.");
            return "menu";


        } else {
            return "accessdeny";
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registration() throws SQLException {
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registration(@RequestParam String name, @RequestParam String email, @RequestParam String pass) throws SQLException {
        String table = "user";
        if (!service.getUser(name).getName().equals(name) & !service.getUser(name).getEmail().equals(email)) {
            String[] params = {name, email, pass};
            service.insertUser(table, params);
            return "redirect:login";
        } else {
            return "redirect:register";
        }
    }


}


