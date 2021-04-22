<%@ page import="com.hupeng.model.User" %>
<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2021/4/9
  Time: 20:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
<%
    User user1=(User) session.getAttribute("user");
%>
<h1>User info</h1>
<%
    /*Cookie [] allCookies=request.getCookies();
    for(Cookie c :allCookies){
        out.println("<br/>"+c.getName()+"-----"+c.getValue());
    }*/
%>
<table>
    <tr>
        <td>Username:</td>
        <td><%=user1.getUsername()%></td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><%=user1.getPassword()%></td>
    </tr>
    <tr>
        <td>Email</td>
        <td><%=user1.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender</td>
        <td><%=user1.getGender()%></td>
    </tr>
    <tr>
        <td>Birth Date</td>
        <td><%=user1.getBirthDate()%></td>
    </tr>
    <tr>
        <td><a href="updateUser">updateUser</a></td>
    </tr>
</table>
</body>
</html>
