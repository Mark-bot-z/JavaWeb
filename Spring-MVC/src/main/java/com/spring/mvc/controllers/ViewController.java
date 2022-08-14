package com.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/view")
public class ViewController {

    @RequestMapping(value = "/home")
    public String home(){
        return "view/home";
    }

    @RequestMapping(value = "/getView")
    public String getView(){
        return "view/view";
    }

    //通过服务器内部转发进行视图获取
    @RequestMapping(value = "/getViewForward")
    public String getViewForward(){
        // /getView
        return "forward:/view/getView";
    }

    //通过重定向进行视图获取
    @RequestMapping(value = "/getViewRedirect")
    public String getViewRedirect(){
        return "redirect:/view/getView";
    }

    @RequestMapping(value = "/getViewRedirectBaidu")
    public String getViewRedirectBaidu(){
        return "redirect:https://www.baidu.com";
    }
}
