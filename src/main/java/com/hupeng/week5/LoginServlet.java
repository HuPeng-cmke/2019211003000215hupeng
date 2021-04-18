package com.hupeng.week5;

import com.hupeng.dao.UserDao;
import com.hupeng.model.User;
import com.mysql.cj.xdevapi.Result;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection connection=null;

    @Override
    protected void doPost(HttpServletRequest  request, HttpServletResponse response) throws ServletException, IOException {
        Statement statement=null;
        User user=new User();
        PrintWriter out= response.getWriter();
        ResultSet result;
        String username=request.getParameter("username");
        String password=request.getParameter("password");

        UserDao userDao=new UserDao();
        try {
             user=userDao.findByUsernamePassword(connection,username,password);
             if(user!=null){
                 request.setAttribute("user",user);
                 request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
             }else {
                 request.setAttribute("message","Username or Password error!!!");
                 request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
             }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        /*String sql="select * from usertable where UserName='"+username+"'and Password='"+password+"'";
        System.out.println(sql);

        try {
            statement=connection.createStatement();
            result=statement.executeQuery(sql);
           if(result.next()){
               *//*out.println("<html><body>");
               out.println("<h1>"+"Login Successs!!!"+"</h1>");
               out.println("<h1>"+"Welcome,"+username+"<h1>");
               out.println("</body></html>");*//*
               *//*request.setAttribute("id",result.getInt("ID"));
               request.setAttribute("username",result.getString("UserName"));
               request.setAttribute("password",result.getString("Password"));
               request.setAttribute("email",result.getString("Email"));
               request.setAttribute("gender",result.getString("Gender"));
               request.setAttribute("birthdate",result.getString("Birthdate"));*//*
               user.setId(result.getInt("ID"));
               user.setUsername(result.getString("UserName"));
               user.setPassword(result.getString("Password"));
               user.setEmail(result.getString("Email"));
               user.setGender(result.getString("Gender"));
               user.setBirthDate(result.getDate("Birthdate"));
               request.setAttribute("user",user);
               request.getRequestDispatcher("userInfo.jsp").forward(request,response);
           }else{
               *//*out.println("<html><body>");
               out.println("<h1>"+"Login Errot!!!"+"</h1>");
               out.println("</body></html>");*//*
               request.setAttribute("message","Username or Password error!!!");
               request.getRequestDispatcher("login.jsp").forward(request,response);
           }
        } catch (SQLException throwables) {
            System.out.println("错了");
        }*/



    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           // doPost(request, response);
            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }

    @Override
    public void init() throws ServletException {
                connection=(Connection)getServletContext().getAttribute("connection");
        /*String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("Username");
        String password = getServletContext().getInitParameter("Password");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("错了");
        }*/
    }
}
