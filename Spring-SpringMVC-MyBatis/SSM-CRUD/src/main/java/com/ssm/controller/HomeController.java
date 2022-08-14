package com.ssm.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "/goToTheHomePage" ,  method = RequestMethod.GET)
    public String goToTheHomePage(){
        return "home";
    }
}
