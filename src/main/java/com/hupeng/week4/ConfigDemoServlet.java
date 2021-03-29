package com.hupeng.week4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet(value = "/config",initParams = {@WebInitParam(name="username" ,value = "hupeng"),
        @WebInitParam(name="studentId",value = "2019211003000215")})
public class ConfigDemoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter =resp.getWriter();
//        printWriter.println("<html><body>");
//        printWriter.println("<h1>"+"name:"+getServletContext().getInitParameter("username")+"<h1>");
//        printWriter.println("<h1>"+"studentId:"+getServletContext().getInitParameter("studentId")+"<h1>");
//        printWriter.println("</body></html>");
        printWriter.println("<html><body>");
        printWriter.println("<h1>"+"name:"+getServletConfig().getInitParameter("username")+"<h1>");
        printWriter.println("<h1>"+"studentId:"+getServletConfig().getInitParameter("studentId")+"<h1>");
        printWriter.println("</body></html>");
    }





    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
