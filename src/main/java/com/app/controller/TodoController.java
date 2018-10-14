package com.app.controller;


import com.app.model.Todo;
import com.app.service.LoginService;
import com.app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String showAddTodoPage(ModelMap model, @ModelAttribute Todo todo){

        model.addAttribute("todo", new Todo(0,(String)model.get("name_key")," ",new Date(), false));
        return "todo";
    }


    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }

        todoService.addTodo((String)model.get("name_key"),todo.getDesc(),new Date(),false);
        return "redirect:/list-todos";
    }

    /*****
     *
     * Delete Todo
     *
     */
    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id){
        todoService.deleteTodo(id);

        return "redirect:/list-todos";
    }


    /*****
     *
     * Update Todo
     *
     */
    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showupdateTodoPage(@RequestParam int id, ModelMap model){
     Todo todo = todoService.retriveTodoForUpdate(id);

     model.put("todo", todo);

        return "todo";
    }


    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model,@Valid Todo todo, BindingResult result){
        if (result.hasErrors()) {
            return "todo";
        }

        todo.setUser((String) model.get("name_key"));
        todoService.updatTodo(todo);

        return "redirect:/list-todos";
    }







}
