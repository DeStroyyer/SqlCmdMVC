package org.base.controller;

import org.base.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.sql.SQLException;
import java.util.List;

@Controller
public class MenuController {
    private Service service;


    public void setService(Service service) {
        this.service = service;
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public String showMenu() {

        if (service.isLogined()) {
            return "menu";
        } else {
            return "login";
        }
    }


    @RequestMapping(value = "/menu/list", method = RequestMethod.GET)
    public String listOfUsers(Model model) throws SQLException {
        if (service.isLogined()) {
            List list = service.showUsers("users");
            model.addAttribute("list", list);
            return "list";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/menu/adduser", method = RequestMethod.GET)
    public String addUser() {
        return "addform";
    }

    @RequestMapping(value = "/menu/adduser", method = RequestMethod.POST)
    public String addUser(@RequestParam String name, @RequestParam String email, @RequestParam String password) throws SQLException {
        if (service.isLogined()) {
            String[] params = {name, email, password};
            service.insertUser("users", params);
            return "redirect:/menu";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "/edit/{id}/{name}", method = RequestMethod.GET)
    public String editform(@PathVariable String id, @PathVariable String name, Model model) {
        if (service.isLogined()) {
            model.addAttribute("id", id);
            model.addAttribute("name", name);
            return "editform";
        } else {
            return "login";
        }
    }

    @RequestMapping(value = "menu/list/edit/{id}", method = RequestMethod.POST)
    public String edit(@RequestParam String name, @RequestParam String email, @RequestParam String password, @PathVariable String id) throws SQLException {
        if (service.isLogined()) {
            String[] params = {name, email, password, id};
            service.editUser(params);

            return "menu/list";
        } else {
            return "login";
        }
    }
}




