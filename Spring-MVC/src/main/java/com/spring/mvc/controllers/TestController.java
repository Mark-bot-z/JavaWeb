package com.spring.mvc.controllers;

import com.spring.mvc.daos.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
@RequestMapping(value = "/Test")
public class TestController {

    @RequestMapping(value = "/home")
    public String home(){
        return "home";
    }

    @RequestMapping(
            value = {"/target1","/target2"},
            method = {RequestMethod.GET,RequestMethod.POST}
//            params = {"!name","name","name=123","name!=123"}
//            headers = {}
    )
    public String target(){
        return "target";
    }

    /*
    * 将占位符中的形参所携带的值赋值给方法中的参数(restful风格)
    * */
    @RequestMapping(value = "/target/{id}/{name}")
    public String testPath(@PathVariable(value = "id") Integer id,@PathVariable(value = "name") String name){
        System.out.println("id = " + id + ", name = " + name);
        return "target";
    }

    @RequestMapping(value = "/target" ,method = {RequestMethod.POST})
    public String testParams(HttpServletRequest request){
        //获取session，每次请求将携带由这个JSESSIONID的cookie
        System.out.println(request.getSession().toString());
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
        return "target";
    }

    @RequestMapping(value = "/target",method = {RequestMethod.GET})
    public String testParams(
//            能够匹配上请求参数中username的key，作用：当和方法参数名不一样时
            @RequestParam(value = "username",defaultValue = "mark")
                    String username,
            String password , String[] hobbies){
        System.out.println("username = " + username + "," +
                           " password = " + password + ", " +
                           "hobbies = " + Arrays.deepToString(hobbies)
        );
        return "target";
    }

    @RequestMapping(value = "/target/params")
    public String testParams(User user, @CookieValue("JSESSIONID") String jSessionID){
        System.out.println("user = " + user.toString());
        System.out.println("jSessionID = " + jSessionID);
        return "target";
    }








}
