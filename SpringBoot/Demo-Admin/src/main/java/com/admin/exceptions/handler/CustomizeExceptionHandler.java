package com.admin.exceptions.handler;

import com.admin.exceptions.DataNotFindException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@Order(value = Ordered.HIGHEST_PRECEDENCE)//优先级
/*
* 使用@ControllerAdvice可以将所有的@ExceptionHandler方法都集中在一个类中，统一处理
    1、@ControllerAdvice默认拦截所有控制器
    2、@ControllerAdvice（annotaions={UserController.class}）配置指定需要拦截的控制器
    3、ControllerAdvice(basePackages = “com.demo”) 配置需要拦截的指定路径下的控制器
* */
@ControllerAdvice
public class CustomizeExceptionHandler {

    @ExceptionHandler(value = {ArithmeticException.class, NullPointerException.class, DataNotFindException.class})
    public String getExc(Model model , Exception e){
        model.addAttribute("msg",e.getMessage());
//        可以返回页面模板，也可以返回json数据
        return "error/5xx";
    }

}
