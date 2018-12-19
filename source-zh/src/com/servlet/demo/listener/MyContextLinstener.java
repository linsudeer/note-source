package com.servlet.demo.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class MyContextLinstener implements ServletContextListener {

    private Map<String, String> conf = new HashMap<String, String>();

    @Override
    public void contextInitialized(ServletContextEvent evnt) {
        ServletContext sc = evnt.getServletContext();
        conf.put("contextPath", sc.getContextPath());
        // 保存一些全局的变量
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

        conf.clear();
    }
}
