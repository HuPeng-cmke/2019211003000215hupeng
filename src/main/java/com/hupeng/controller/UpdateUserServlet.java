package com.hupeng.controller;

import com.hupeng.dao.UserDao;
import com.hupeng.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

@WebServlet(name = "UpdateUserServlet", value = "/updateUser")
public class UpdateUserServlet extends HttpServlet {
    private static DateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    Connection connection=null;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/updateUser.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao userDao=new UserDao();
        int id=Integer.parseInt(request.getParameter("id"));
         String username=request.getParameter("username");
         String password=request.getParameter("password");
         String Email=request.getParameter("email");
         String Gender=request.getParameter("gender");
        Date birth= null;
        try {
            birth =new Date(sdf.parse(request.getParameter("birth")).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User uo=new User();
        uo.setId(id);
        uo.setUsername(username);
        uo.setBirthDate(birth);
        uo.setPassword(password);
        uo.setEmail(Email);
        uo.setGender(Gender);
        try {
            int row=userDao.updateUser(connection,uo);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        HttpSession session =request.getSession();
        session.setAttribute("user",uo);
        request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);


    }

    @Override
    public void init() throws ServletException {
        connection=(Connection)getServletContext().getAttribute("connection");
    }
}
