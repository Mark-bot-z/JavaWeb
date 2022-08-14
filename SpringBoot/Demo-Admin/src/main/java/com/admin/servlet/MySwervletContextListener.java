package com.admin.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MySwervletContextListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContextListener.super.contextDestroyed(sce);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContextListener.super.contextInitialized(sce);
    }
}
