package com.hupeng.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter")
public class AuthFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in AuthFilter -->doFilter() - before servlet-(request come here)"+System.currentTimeMillis());
        HttpServletRequest request1=(HttpServletRequest)request;
        System.out.println(" getRequestURL "+request1.getRequestURI());
        System.out.println(" getScheme "+request1.getScheme());
        System.out.println(" getServerName "+request1.getServerName());
        System.out.println(" getServerPort "+request1.getServerPort());
        System.out.println(" getRequestURI "+request1.getRequestURI());
        System.out.println(" getServletPath "+request1.getServletPath());
        System.out.println(" getQueryString "+request1.getQueryString());
        System.out.println(" getMethod "+request1.getMethod());
        chain.doFilter(request, response);
        /*chain.doFilter(request, response);*/
        System.out.println("i am in AuthFilter -->doFilter() - after servlet"+System.currentTimeMillis());

    }
}
