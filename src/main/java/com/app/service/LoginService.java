package com.app.service;


import org.springframework.stereotype.Component;

@Component
public class LoginService {



    public boolean validUser(String userId, String pass){
        return userId.equalsIgnoreCase("enam")&& pass.equalsIgnoreCase("12345");


    }
}
