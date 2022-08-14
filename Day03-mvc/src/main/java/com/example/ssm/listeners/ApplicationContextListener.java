package com.example.ssm.listeners;

import com.example.ssm.ioc.BeanFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Mark-Z
 * @version 0.0.1
 * @date 2022/7/7
 * @implNote 监听web应用程序上下文开始加载的类
 */
public class ApplicationContextListener implements ServletContextListener {
    /*将初始化好的ioc容器保存到Application作用域*/

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        BeanFactory.path = servletContext.getInitParameter("appXML");
        servletContext.setAttribute("ioc",new BeanFactory());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
