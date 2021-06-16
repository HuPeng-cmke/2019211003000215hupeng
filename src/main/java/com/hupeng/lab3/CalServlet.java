package com.hupeng.lab3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CalServlet", value = "/lab3/CalServlet")
public class CalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String action=request.getParameter("action");

        int result=0;
        if(action.equals("Add")){
            int firstVal=Integer.parseInt(request.getParameter("firstVal"));
            int secondVal=Integer.parseInt(request.getParameter("secondVal"));
            result=add(firstVal,secondVal);
            System.out.println(result);
            Cookie cFirstVal=new Cookie("cFirstVal",request.getParameter("firstVal") );
            Cookie cSecondVal=new Cookie("cSecondVal",request.getParameter("secondVal"));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));

            cFirstVal.setMaxAge(5);
            cSecondVal.setMaxAge(5);
            cResult.setMaxAge(5);

            response.addCookie(cFirstVal);
            response.addCookie(cSecondVal);
            response.addCookie(cResult);
            response.sendRedirect("cal.jsp");
        }else if(action.equals("Subtract")){
            int firstVal=Integer.parseInt(request.getParameter("firstVal"));
            int secondVal=Integer.parseInt(request.getParameter("secondVal"));
            result=subtract(firstVal,secondVal);
            System.out.println(result);
            Cookie cFirstVal=new Cookie("cFirstVal",request.getParameter("firstVal") );
            Cookie cSecondVal=new Cookie("cSecondVal",request.getParameter("secondVal"));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));

            cFirstVal.setMaxAge(5);
            cSecondVal.setMaxAge(5);
            cResult.setMaxAge(5);

            response.addCookie(cFirstVal);
            response.addCookie(cSecondVal);
            response.addCookie(cResult);
            response.sendRedirect("cal.jsp");
        }else if(action.equals("Multiply")){
            int firstVal=Integer.parseInt(request.getParameter("firstVal"));
            int secondVal=Integer.parseInt(request.getParameter("secondVal"));
            result=multiply(firstVal,secondVal);
            System.out.println(result);
            Cookie cFirstVal=new Cookie("cFirstVal",request.getParameter("firstVal") );
            Cookie cSecondVal=new Cookie("cSecondVal",request.getParameter("secondVal"));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));

            cFirstVal.setMaxAge(5);
            cSecondVal.setMaxAge(5);
            cResult.setMaxAge(5);

            response.addCookie(cFirstVal);
            response.addCookie(cSecondVal);
            response.addCookie(cResult);
            response.sendRedirect("cal.jsp");
        }else if(action.equals("Divide")){
            int firstVal=Integer.parseInt(request.getParameter("firstVal"));
            int secondVal=Integer.parseInt(request.getParameter("secondVal"));
            result=divide(firstVal,secondVal);
            System.out.println(result);
            Cookie cFirstVal=new Cookie("cFirstVal",request.getParameter("firstVal") );
            Cookie cSecondVal=new Cookie("cSecondVal",request.getParameter("secondVal"));
            Cookie cResult=new Cookie("cResult",String.valueOf(result));

            cFirstVal.setMaxAge(5);
            cSecondVal.setMaxAge(5);
            cResult.setMaxAge(5);

            response.addCookie(cFirstVal);
            response.addCookie(cSecondVal);
            response.addCookie(cResult);
            response.sendRedirect("cal.jsp");
        }else if(action.equals("Computer Length")){
            String name=request.getParameter("name");
            result=computerLength(name);
            System.out.println(result);
            Cookie cN=new Cookie("cName",request.getParameter("name") );
            Cookie cR=new Cookie("cLength",String.valueOf(result));

            cN.setMaxAge(5);
            cR.setMaxAge(5);

            response.addCookie(cN);
            response.addCookie(cR);
            response.sendRedirect("cal.jsp");
        }
    }
    public int add(int firstVal,int secondVal){

        return firstVal+secondVal;
    }
    public int subtract(int firstVal,int secondVal){
            return firstVal-secondVal;
    }
    public int multiply(int firstVal,int secondVal){
                return firstVal*secondVal;
    }
    public int divide(int firstVal,int secondVal){
            return firstVal/secondVal;
    }
    public int computerLength(String name){
        return name.length();

    }
}
