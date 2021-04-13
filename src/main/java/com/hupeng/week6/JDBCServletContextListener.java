package com.hupeng.week6;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@WebListener
public class JDBCServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context= sce.getServletContext();
        String driver = context.getInitParameter("driver");
        String url = context.getInitParameter("url");
        String username = context.getInitParameter("Username");
        String password = context.getInitParameter("Password");
        try{
            Class.forName(driver);
            Connection connection= DriverManager.getConnection(url,username,password);
            System.out.println("i am in contextInitialized -->"+connection);

            context.setAttribute("connection",connection);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /*System.out.println("i am in contextDestroyed");
        sce.getServletContext().removeAttribute("connection");*/
    }
}
