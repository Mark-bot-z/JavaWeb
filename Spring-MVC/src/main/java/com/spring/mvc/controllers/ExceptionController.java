package com.spring.mvc.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice将当前类标识为异常处理的组件
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class})
    public String getExs(Exception e, Model model) {
        model.addAttribute("ex", e.getMessage());
        //返回的是一个视图名称（页面地址）
        return "error";
    }
}
