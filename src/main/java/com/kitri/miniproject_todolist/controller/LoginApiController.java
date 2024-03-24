package com.kitri.miniproject_todolist.controller;

import com.kitri.miniproject_todolist.dto.LoginMember;
import com.kitri.miniproject_todolist.dto.ResponseTodo;
import com.kitri.miniproject_todolist.dto.SignUpMember;
import com.kitri.miniproject_todolist.mappers.TodoMapper;
import com.mysql.cj.log.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/login")
public class LoginApiController {
    @Autowired
    TodoMapper todoMapper;

    @PostMapping
    public Long login(@RequestBody LoginMember member){
        String mlogin = member.getEmail();
        String plogin = member.getPassword();
        ArrayList<SignUpMember> todoLogin  = (ArrayList<SignUpMember>) todoMapper.findMember();

        for (SignUpMember login : todoLogin){
            if (login.getEmail().equals(mlogin) && login.getPassword().equals(plogin)){

            }
        }

        return null;
    }

}
