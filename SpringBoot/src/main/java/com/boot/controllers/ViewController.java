package com.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/success")
    public String success(Model model){
        model.addAttribute("hw","hello world");
        return "success" ;
    }

}
