package com.kitri.miniproject_todolist.mappers;

import com.kitri.miniproject_todolist.dto.LoginMember;
import com.kitri.miniproject_todolist.dto.RequestTodo;
import com.kitri.miniproject_todolist.dto.ResponseTodo;
import com.kitri.miniproject_todolist.dto.SignUpMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {

    //기존 DAO의 역할
    //쿼리 날려주는 역할 -> 조회, 등록, 수정, 삭제 CRUD
    //마이바티스의 어노테이션
    //@Mapper로 읽어서 스프링 @Bean으로 등록하는 과정

    List<ResponseTodo> findAll(); //전체조회
    ResponseTodo findById(Long id); //하나만 조회
    void save(RequestTodo todo); //등록
    void update(Long id); //수정
    void deleteById(Long id); //삭제

    List<SignUpMember> findMember(); //회원조회

    void signup(String email, String name, String password); //회원가입

}
