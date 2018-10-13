package com.app.controller;


import com.app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {


    @Autowired
    LoginService loginService;


    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLogin(ModelMap model){
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String showWelcome(ModelMap model, @RequestParam String name,@RequestParam String pass){

      boolean isvalid = loginService.validUser(name,pass);

      if (!isvalid) {
       model.put("message","Invalid user or passwrd");
          return "login";
      }
        model.put("name_key",name);
        model.put("pass",pass);
        return "welcome";
    }





}
