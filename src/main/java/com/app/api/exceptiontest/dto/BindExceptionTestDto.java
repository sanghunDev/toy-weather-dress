package com.app.api.exceptiontest.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BindExceptionTestDto {

    @NotBlank(message = "제목은 필수 값 입니다")
    private String title;

    @Max(value = 20 , message = "나이는 20살을 넘을 수 없습니다")
    private String age;
}
