package com.spring.mvc.controllers;

import com.spring.mvc.daos.pojo.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


/*
* @RestController注解
* 是springMVC提供的一个复合注解，标识在控制器的类上
* 就相当于为类添加了@Controller注解，并且为其中的每个方法添加了@ResponseBody注解
* */
@Controller
@RequestMapping(value = "/Http")
public class HttpController {

    //原始方法
    @RequestMapping(value = "/testResponse_1")
    public void testResponse_1(HttpServletResponse response) throws Exception{
        response.getWriter().write("hello response");
    }

    //进阶方法 1
    //@ResponseBody用于标识一个控制器方法，可以将该方法的返回值直接作为响应报文的响应体响应到浏览器
    @RequestMapping(value = "/testResponse_2")
    @ResponseBody
    public String testResponse_2(){
        return "hello response";
    }

    //进阶方法 2
    /*
    * 引入相关jar(jackson)包，并需要开启注解驱动
    * 此时在HandlerAdaptor中会自动装配一个消息转换器：MappingJackson2HttpMessageConverter
    * 可以将响应到浏览器的Java对象转换为Json格式的字符串
    * */
    //将返回的一个java对象装换成json格式的字符串（前端会解析成一个json对象）
    @RequestMapping(value = "/testResponse_3")
    @ResponseBody
    public Employee testResponse_3(){
        return new Employee(1,"qwe","kk",1);
    }




}
