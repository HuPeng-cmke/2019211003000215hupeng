package com.hupeng.week3;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/register")
public class register extends HttpServlet {
    Connection connection=null;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
/*
        response.sendRedirect("/2019211003000215hupeng_war/login.jsp");
*/
        request.getRequestDispatcher("WEB-INF/views/register.jsp").forward(request,response);


        /*Statement statement=null;

        try {
             statement=connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String sex=request.getParameter("sex");
        String birth=request.getParameter("birth");
        try {
        String sql1="insert into usertable(UserName,Password,Email,Gender,Birthdate)" +
                " values('"+username+"','"+password+"','"+email+"','"+sex+"','"+birth+"')";
        statement.executeUpdate(sql1);
        PrintWriter printWriter =response.getWriter();
            ResultSet resultSet=null;

        String sql="select * from usertable";
         resultSet=statement.executeQuery(sql);
         *//*while(resultSet.next()) {
             System.out.println(resultSet.getString("UserName"));
             System.out.println(resultSet.getString("Password"));
             System.out.println(resultSet.getString("Email"));
             System.out.println(resultSet.getString("Gender"));
             System.out.println(resultSet.getString("Birthdate"));

         }*//*
            printWriter.println("<html>");
            printWriter.println("   <head>");
            printWriter.println("       <meta charset='UTF-8'>");
            printWriter.println("       <title>??????????????????</title>");
            printWriter.println("   </head>");
            printWriter.println("   <body>");
            printWriter.println("       <table border='1'>");
            printWriter.println("           <tr>");
            printWriter.println("               <td>ID</td>");
            printWriter.println("               <td>UserName</td>");
            printWriter.println("               <td>Password</td>");
            printWriter.println("               <td>Email</td>");
            printWriter.println("               <td>Gender</td>");
            printWriter.println("               <td>Birthdate</td>");
            printWriter.println("           </tr>");
            while(resultSet.next()){
                printWriter.println("           <tr>");
                printWriter.println("               <td>"+resultSet.getInt("ID")+"</td>");
                printWriter.println("               <td>"+resultSet.getString("UserName")+"</td>");
                printWriter.println("               <td>"+resultSet.getString("Password")+"</td>");
                printWriter.println("               <td>"+resultSet.getString("Email")+"</td>");
                printWriter.println("               <td>"+resultSet.getString("Gender")+"</td>");
                printWriter.println("               <td>"+resultSet.getString("Birthdate")+"</td>");
                printWriter.println("           </tr>");
            }
            printWriter.println("       </table>");
            printWriter.println("   </body>");
            printWriter.println("</html>");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }*/



    }

    @Override
    public void init() {
        try {
            super.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        connection=(Connection) getServletContext().getAttribute("connection");
        /*String driver = getServletContext().getInitParameter("driver");
        String url = getServletContext().getInitParameter("url");
        String username = getServletContext().getInitParameter("Username");
        String password = getServletContext().getInitParameter("Password");
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);

            System.out.println(connection);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("??????");
        }*/
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        String sex=request.getParameter("gender");
        String birth=request.getParameter("birthdate");
        Statement statement=null;

        try {
            statement=connection.createStatement();
            String sql1="insert into usertable(UserName,Password,Email,Gender,Birthdate)" +
                    " values('"+username+"','"+password+"','"+email+"','"+sex+"','"+birth+"')";
            int n=statement.executeUpdate(sql1);
            System.out.println("n--->"+n);
            /*PrintWriter printWriter =response.getWriter();*/
            /*ResultSet resultSet=null;
            String sql="select * from usertable";
            resultSet=statement.executeQuery(sql);*/
             /*System.out.println(resultSet.getString("UserName"));
             System.out.println(resultSet.getString("Password"));
             System.out.println(resultSet.getString("Email"));
             System.out.println(resultSet.getString("Gender"));
             System.out.println(resultSet.getString("Birthdate"));*/


            /* printWriter.println("<html>");
             printWriter.println("   <head>");
             printWriter.println("       <meta charset='UTF-8'>");
             printWriter.println("       <title>??????????????????</title>");
             printWriter.println("   </head>");
             printWriter.println("   <body>");
             printWriter.println("       <table border='1'>");
             printWriter.println("           <tr>");
             printWriter.println("               <td>ID</td>");
             printWriter.println("               <td>UserName</td>");
             printWriter.println("               <td>Password</td>");
             printWriter.println("               <td>Email</td>");
             printWriter.println("               <td>Gender</td>");
             printWriter.println("               <td>Birthdate</td>");
             printWriter.println("           </tr>");
             while (resultSet.next()) {
                 printWriter.println("           <tr>");
                 printWriter.println("               <td>" + resultSet.getInt("ID") + "</td>");
                 printWriter.println("               <td>" + resultSet.getString("UserName") + "</td>");
                 printWriter.println("               <td>" + resultSet.getString("Password") + "</td>");
                 printWriter.println("               <td>" + resultSet.getString("Email") + "</td>");
                 printWriter.println("               <td>" + resultSet.getString("Gender") + "</td>");
                 printWriter.println("               <td>" + resultSet.getString("Birthdate") + "</td>");
                 printWriter.println("           </tr>");
             }
             printWriter.println("       </table>");
             printWriter.println("   </body>");
             printWriter.println("</html>");*/
             response.sendRedirect("login");
    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
