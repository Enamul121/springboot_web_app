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

import java.util.Date;

@Controller
@SessionAttributes("name_key")
public class TodoController {


    @Autowired
    TodoService todoService;


    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model){

       String name =(String)model.get("name_key");
        model.put("todos", todoService.retrieveTodos("in28Minutes"));
        return "list-todos";
    }




    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showAddTodoPage(ModelMap model){
        return "todo";
    }


    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String desc){

        todoService.addTodo((String)model.get("name_key"),desc,new Date(),false);
        return "redirect:/list-todos";
    }






}
