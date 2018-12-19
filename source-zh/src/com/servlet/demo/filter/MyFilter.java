package com.servlet.demo.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebFilter(filterName = "filter1", initParams = {@WebInitParam(name = "encode", value = "utf-8")}, urlPatterns = "/*")
public class MyFilter implements Filter {
    private String chartSet;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.chartSet = filterConfig.getInitParameter("charset");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");// 一处理请求过来的编码

        // 处理cros跨域问题
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE，PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Expose-Headers","isLogin");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with, isLogin");


        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
