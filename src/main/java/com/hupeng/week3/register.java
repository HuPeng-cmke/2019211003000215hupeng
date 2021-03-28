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
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter printWriter =response.getWriter();
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
            String sql="select * from usertable";
        try {
         preparedStatement=connection.prepareStatement(sql);
         resultSet=preparedStatement.executeQuery();
        /* while(resultSet.next()) {
            *//* System.out.println(resultSet.getInt("ID"));
             System.out.println(resultSet.getString("UserName"));
             System.out.println(resultSet.getInt("Password"));
             System.out.println(resultSet.getString("Email"));
             System.out.println(resultSet.getString("Gender"));
             System.out.println(resultSet.getDate("Birthdate"));*//*

         }*/
            printWriter.println("<html>");
            printWriter.println("   <head>");
            printWriter.println("       <meta charset='UTF-8'>");
            printWriter.println("       <title>查询所有人员</title>");
            printWriter.println("   </head>");
            printWriter.println("   <body>");
            printWriter.println("       <table border='1'>");
            printWriter.println("           <tr>");
            printWriter.println("               <td>ID</td>");
            printWriter.println("               <td>UserName</td>");
            printWriter.println("               <td>Password</td>");
            printWriter.println("               <td>Email</td>");
            printWriter.println("               <td>Birthdate</td>");
            printWriter.println("           </tr>");
            while(resultSet.next()){
                printWriter.println("           <tr>");
                printWriter.println("               <td>"+resultSet.getInt("ID")+"</td>");
                printWriter.println("               <td>"+resultSet.getString("UserName")+"</td>");
                printWriter.println("               <td>"+resultSet.getInt("Password")+"</td>");
                printWriter.println("               <td>"+resultSet.getString("Email")+"</td>");
                printWriter.println("               <td>"+resultSet.getDate("Birthdate")+"</td>");
                printWriter.println("           </tr>");
            }
            printWriter.println("       </table>");
            printWriter.println("   </body>");
            printWriter.println("</html>");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }




    }

    @Override
    public void init() {
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


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
