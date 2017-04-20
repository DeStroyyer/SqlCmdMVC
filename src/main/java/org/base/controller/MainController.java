package org.base.controller;

import com.google.gson.Gson;

import org.base.model.User;
import org.base.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.json.Json;
import java.util.List;

@Controller
public class MainController {
    private Gson gson;

    private UserService userService;

    public MainController(Gson gson, UserService userService) {
        this.gson = gson;
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String returnIndexPage() {
        return "index";
    }


    @RequestMapping(value = "/userlist", method = RequestMethod.GET)
    public
    @ResponseBody
    String retrieveUsersList() {
        List<User> list = userService.getList();
        String jsonlist = gson.toJson(list);
        return jsonlist;
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public
    @ResponseBody
    void addUser(@RequestBody String json) {
        User user = gson.fromJson(json, User.class);
        userService.addUser(user);

    }

    @RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
    public
    @ResponseBody
    void deleteUser(@RequestBody String json) {
        int id=gson.fromJson(json,Integer.class);
        User user = userService.getUser(id);
        userService.deleteUser(user);
    }
    @RequestMapping(value = "/updateuser", method = RequestMethod.POST)
    public
    @ResponseBody
    void updateUser(@RequestBody String json) {
        User newUserData=gson.fromJson(json,User.class);
        int id=newUserData.getId();
        User oldUserData = userService.getUser(id);
        if(!newUserData.getName().equals(null))
        userService.editUser();
    }


}


