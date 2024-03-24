package com.kitri.miniproject_todolist.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpMember {

    @NotEmpty
    Long id;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 입력은 필수 입니다.")
    String email;

    @NotNull
    String name;

    @Size(min = 8)//최소 8글자
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$") //영문숫자 특수기호 8자리 이상
    String password; //비밀번호

    @Size(min = 8)//최소 8글자
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,20}$") //영문숫자 특수기호 8자리 이상
    String passwordChk;

    public SignUpMember(Long id, String email, String name, String password) {
        this.id = id;
        this.email = email;
        this.name = name;
        this.password = password;
    }
}
