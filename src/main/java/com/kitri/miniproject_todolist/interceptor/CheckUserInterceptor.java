package com.kitri.miniproject_todolist.interceptor;

import com.kitri.miniproject_todolist.dto.SignUpMember;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;


@Slf4j
public class CheckUserInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        SignUpMember signUpMember = (SignUpMember) request.getSession().getAttribute("memberSession");
        if(signUpMember != null){
            return true; // 다음페이지를 넘어가기 위해선 리턴 true;
        }
        response.sendRedirect("http://localhost:8080/login/fail.html");
        return false;
    }
    //등록 -> WebConfig에서 호출
}
