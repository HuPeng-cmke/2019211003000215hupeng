package com.hupeng.week3;

import com.example.hupeng2019211003000215.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class register extends HelloServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out =response.getWriter();
            String name=request.getParameter("username");
            String password=request.getParameter("password");
            String email=request.getParameter("email");
            String gender=request.getParameter("sex");
            String birth=request.getParameter("birth");
            out.println("<html><body>");
            out.println("<h1>"+"username:"+name+"</h1>");
            out.println("<h1>"+"password:"+password+"<h1>");
            out.println("<h1>"+"email:"+email+"<h1>");
            out.println("<h1>"+"gender:"+gender+"<h1>");
            out.println("<h1>"+"birthDate:"+birth+"<h1>");
            out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
