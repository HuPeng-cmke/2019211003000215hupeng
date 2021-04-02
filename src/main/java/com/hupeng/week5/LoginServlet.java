package com.hupeng.week5;

import com.mysql.cj.xdevapi.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection connection=null;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Statement statement=null;
        PrintWriter out= response.getWriter();
        ResultSet result;
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String sql="select * from usertable where UserName='"+username+"'and Password='"+password+"'";
        System.out.println(sql);

        try {
            statement=connection.createStatement();
            result=statement.executeQuery(sql);
           if(result.next()){
               out.println("<html><body>");
               out.println("<h1>"+"Login Successs!!!"+"</h1>");
               out.println("<h1>"+"Welcome,"+username+"<h1>");
               out.println("</body></html>");
           }else{
               out.println("<html><body>");
               out.println("<h1>"+"Login Errot!!!"+"</h1>");
               out.println("</body></html>");
           }
        } catch (SQLException throwables) {
            System.out.println("错了");
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request, response);
    }

    @Override
    public void init() throws ServletException {
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("Username");
        String password = getServletContext().getInitParameter("Password");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("错了");
        }
    }
}
