package com.kitri.miniproject_todolist.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RequestTodo {

    @NotEmpty
    Long id;

    @NotNull
    String content;
    Boolean done;
    Long memberId;

}
