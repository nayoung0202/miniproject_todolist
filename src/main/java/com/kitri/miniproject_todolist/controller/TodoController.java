package com.kitri.miniproject_todolist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todos")
public class TodoController {


    @GetMapping("")
    public String form(){
        return "/todo/todos";
    }











}
