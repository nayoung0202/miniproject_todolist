package com.kitri.miniproject_todolist.controller;

import com.kitri.miniproject_todolist.dto.LoginMember;
import com.kitri.miniproject_todolist.dto.SignUpMember;
import com.kitri.miniproject_todolist.mappers.TodoMapper;
import com.mysql.cj.log.Log;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.ArrayList;

@Controller
@RequestMapping("/login")
public class LoginLogoutController {

    @Autowired
    TodoMapper todoMapper;

    @GetMapping
    public String form(HttpServletRequest request) {

        SignUpMember memberSession = (SignUpMember) request.getSession().getAttribute("memberSession");
        if(memberSession != null){
            //잘못된 접근입니다.
            return "redirect:/login/fail.html";
        }
        return "redirect:/login/login.html";
    }

    @PostMapping
    public String loginChk(LoginMember form, BindingResult bindingResult, HttpServletRequest request) {

        if (bindingResult.hasErrors()) {
            return "redirect:/login/login.html";
        }

        ArrayList<SignUpMember> members = (ArrayList<SignUpMember>) todoMapper.findMember();
        for (SignUpMember member : members) {
            if (member.getEmail().equals(form.getEmail()) && member.getPassword().equals(form.getPassword())) {
                HttpSession session = request.getSession();

                Long id = member.getId();
                String email = member.getEmail();
                String name = member.getName();
                String password = member.getPassword();

                SignUpMember memberSession = new SignUpMember(id, email, name, password);
                System.out.println(memberSession);
                session.setAttribute("memberSession", memberSession);
                return "/todo/todos";
            }
        }
        return "redirect:/login/login.html";
    }

    @GetMapping("/logout")
    public String logoutSession(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/login/login.html";
    }

    //회원가입
    @PostMapping("/signup")
    public String signupChk(SignUpMember form, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "redirect:/login/signup.html";
        }
        ArrayList<SignUpMember> members = (ArrayList<SignUpMember>) todoMapper.findMember();
        for(SignUpMember member : members){
            if(!(member.getEmail().equals(form.getEmail()))){
                if(form.getPassword().equals(form.getPasswordChk())){
                    todoMapper.signup(form.getEmail(), form.getName(), form.getPassword());
                    return "redirect:/login/signUpSuccess.html";
                }
            }
        }
        return "redirect:/login/signup.html";
    }
}
