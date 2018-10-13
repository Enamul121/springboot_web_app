package com.app.controller;


import com.app.service.LoginService;
import com.app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {


    @Autowired
    TodoService todoService;


    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model){

       String name =(String)model.get("name_key");
        model.put("todos", todoService.retrieveTodos("in28Minutes"));
        return "list-todos";
    }






}
