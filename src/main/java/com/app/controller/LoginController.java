package com.app.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(ModelMap mode){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcome(ModelMap mode){
        return "welcome";
    }





}
