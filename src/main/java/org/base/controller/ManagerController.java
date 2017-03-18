package org.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import org.base.service.Service;
import org.base.utils.ConnectProperty;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ManagerController {
    @Autowired
    private Service service;
    @Autowired
    private ConnectProperty property;

    @RequestMapping(value = "/")
    public String start(Model model) {
        List<String> list = new ArrayList<String>();
        list.add("connect");
        list.add("help");
        model.addAttribute("commands", list);
        return "index";
    }

    @RequestMapping(value = "/connect",method = RequestMethod.GET)
    public String connectForm() throws SQLException {
        return "connect";
    }

    @RequestMapping(value = "/connect",method = RequestMethod.POST)
    public String connectSubmit(@RequestParam String name, @RequestParam String pass, ModelMap model) throws SQLException {
        model.addAttribute("name",name);
        model.addAttribute("pass",pass);
        return "hello";
    }

    @RequestMapping(value = "/help")
    public String help(HttpServletRequest request) {
        request.setAttribute("manual", service.help());
        return "help";
    }

}
