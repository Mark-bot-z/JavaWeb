package com.spring.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "/shared")
public class SharedController {

    @RequestMapping(value = "/home")
    public String home() {
        return "shared/home";
    }

    //(请求域对象)原生方法
    @RequestMapping(value = "/success1")
    public String shared(HttpServletRequest request) {
        request.setAttribute("success", "hello world");
        return "shared/shared";
    }

    //(请求域对象)通过ModelAndView
    @RequestMapping(value = "/success2")
    public ModelAndView shared(ModelAndView modelAndView) {
        modelAndView.addObject("success", "ModelAndView");
        modelAndView.setViewName("shared/shared");
        return modelAndView;
    }

    //(请求域对象)通过Model
    @RequestMapping(value = "/success3")
    public String shared(Model model) {
        model.addAttribute("success", "Model");
        return "shared/shared";
    }

    //(请求域对象)通过Map
    @RequestMapping(value = "/success4")
    public String shared(Map<String, Object> map) {
        map.put("success", "map");
        return "shared/shared";
    }

    //(请求域对象)通过ModelMap
    @RequestMapping(value = "/success5")
    public String shared(ModelMap map) {
        map.addAttribute("success", "modelmap");
        return "shared/shared";
    }

    //(session域对象)通过session
    @RequestMapping(value = "/success6")
    public String shared(HttpSession session) {
        session.setAttribute("success", "session");
        return "shared/shared";
    }

    //(Application域对象)通过session
    @RequestMapping(value = "/success7")
    public String shared(HttpSession session        ,int i) {
        ServletContext context = session.getServletContext();
        context.setAttribute("success","application");
        return "shared/shared";
    }


}
