package com.spring.mvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Mark-Z
 * @version 0.0.1
 * @implNote spring-MVC拦截器：用于拦截于控制器方法执行之前和之后和视图渲染之后的请求的方法
 */
@Controller
@RequestMapping(value = "/Interceptor")
public class InterceptorController {

    @RequestMapping(value = "/home")
    public String home(){
        return "interceptor/home";
    }

    @RequestMapping(value = "/start")
    @ResponseBody
    public String start(){
        return "InterceptorController.start哈哈";
    }
}
