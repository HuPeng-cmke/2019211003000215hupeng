package com.hupeng.week2;

import com.example.hupeng2019211003000215.HelloServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HomeWork1 extends HelloServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        Date date=new Date();
        out.println("<html><body>");
        out.println("<h1>"+"Name: Hu Peng "+"</h1>");
        out.println("<h1>"+"ID: 2019211003000215"+"<h1>");
        out.println("<h1>"+date.toString()+"<h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
