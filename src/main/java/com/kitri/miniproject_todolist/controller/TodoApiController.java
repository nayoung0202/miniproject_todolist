package com.kitri.miniproject_todolist.controller;

import com.kitri.miniproject_todolist.dto.RequestTodo;
import com.kitri.miniproject_todolist.dto.ResponseTodo;
import com.kitri.miniproject_todolist.mappers.TodoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoApiController {

    @Autowired
    TodoMapper todoMapper;

    @GetMapping //조회
    public ArrayList<ResponseTodo> todos(){
        ArrayList<ResponseTodo> responseTodos = (ArrayList<ResponseTodo>) todoMapper.findAll();
        return responseTodos;
    }

    @PostMapping //등록
    public void add(@RequestBody RequestTodo todo){
        todoMapper.save(todo);
    }

    @PutMapping("{id}") //수정
    public void update(@PathVariable Long id){
        todoMapper.update(id);
    }

    @DeleteMapping ("{id}") //삭제
    public void deleteById(@PathVariable Long id){
        todoMapper.deleteById(id);
    }

}
