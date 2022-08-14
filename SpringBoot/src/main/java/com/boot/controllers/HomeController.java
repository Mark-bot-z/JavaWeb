package com.boot.controllers;

import com.boot.daos.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
//@RequestMapping(value = "/home")
public class HomeController {

    //访问域名至首页
    @RequestMapping("/")
    public String home(){
        //要有.html的后缀
        return "res/home.html";
    }


    /*
    * Spring Boot2.2.x版本中，将默认的favicon.ico属性移除：泄露开发框架敏感信息
    * 把favicon.ico放在以下目录，会自动转换成网站的图标
    * */

    /*
    "classpath:/META-INF/resources/"
    "classpath:/resources/"
    "classpath:/static/"
    "classpath:/public/"

    优先级 ：
    META-INF/resources > resources > static(默认) > public
        这些路径的根目录的index.html会被当成首页
     */

    @RequestMapping(value = "/testResponseOfAccept")
    @ResponseBody
    public User testResponseOfAccept(){
//        return "hello world";
        return new User("mark",null);
    }




}
