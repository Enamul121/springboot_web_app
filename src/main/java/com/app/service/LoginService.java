package com.app.service;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class LoginService {



    public boolean validUser(String userId, String pass){
        return userId.equalsIgnoreCase("in28Minutes")&& pass.equalsIgnoreCase("123");


    }
}
