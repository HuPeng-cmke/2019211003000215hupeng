package com.hupeng.lab2;

import com.hupeng.model.User;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@WebFilter(filterName = "LoginFilter",urlPatterns = {"/lab2/validation.jsp","/lab2/welcome.jsp"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
        System.out.println("i am in LoginFilter--init()");
    }

    public void destroy() {
        System.out.println("i am in LoginFilter--destroy()");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("i am in LoginFilter--doFilter-- request before chain");
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse res=(HttpServletResponse) response;
        HttpSession session= req.getSession();
        if(session.getAttribute("user")!=null){
            System.out.println("跳转welcome");
            System.out.println(req.getSession());
            Login user=(Login)session.getAttribute("user");
            System.out.println(user.getUsername());
            request.setAttribute("user",user);
            req.getRequestDispatcher("/lab2/welcome.jsp").forward(request,response);
        }else {
            System.out.println("跳转login");
            res.sendRedirect("login.jsp");
        }
        chain.doFilter(request, response);
        System.out.println("i am in LoginFilter--destroy()-- response after chain");

    }
}
