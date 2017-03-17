package org.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.base.service.Service;
import org.base.utils.ConnectProperty;

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
        list.add(1, "command1");
        list.add(2, "command2");
        model.addAttribute("commands", list);
        return "index";
    }

    @RequestMapping(value = "/connect")
    public String connect(HttpServletRequest req) throws SQLException {
        String driver = req.getParameter("driver");
        String url = property.getProperty("url");
        String username = req.getParameter("name");
        String pass = req.getParameter("pass");
        service.connect(driver, url, username, pass);
        return "connect";
    }

    @RequestMapping(value = "/help")
    public String help(HttpServletRequest request) {
        request.setAttribute("manual", service.help());
        return "help";
    }

    @RequestMapping(value = "/hello")
    public String printData(Model model, HttpServletRequest request) {
        String userName = request.getParameter("name");
        model.addAttribute("message", userName);
        return "hello";
    }
}
