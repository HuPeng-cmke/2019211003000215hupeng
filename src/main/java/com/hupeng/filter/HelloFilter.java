package com.hupeng.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter(filterName = "HelloFilter",/*urlPatterns = {"/hello"}*//*urlPatterns = {"/*"}*/urlPatterns = {"/login",
"/home","/register.jsp"})
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in HelloFilter -->init()");
    }

    public void destroy() {
        System.out.println("i am in HelloFilter -->destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in HelloFilter -->doFilter() - before servlet-(request come here)");
        chain.doFilter(request, response);
        System.out.println("i am in HelloFilter -->doFilter() - after servlet-(response come here)");
    }
}
