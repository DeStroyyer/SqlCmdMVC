package org.base.controller;

import com.google.gson.Gson;
import org.base.model.User;
import org.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {
    private Gson gson;

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setGson(Gson gson) {
        this.gson = gson;
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String returnIndexPage() {
        return "index";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    @ResponseBody
    public String start() {
        List<User> list = userService.getList();
        String json = gson.toJson(list);
        return json;
    }


}


