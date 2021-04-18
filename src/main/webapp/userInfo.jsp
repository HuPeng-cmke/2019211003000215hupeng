<%@ page import="com.hupeng.model.User" %><%--
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
    User user=(User) request.getAttribute("user");
%>
<h1>User info</h1>
<table>
    <tr>
        <td>Username:</td>
        <td><%=user.getUsername()%></td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><%=user.getPassword()%></td>
    </tr>
    <tr>
        <td>Email</td>
        <td><%=user.getEmail()%></td>
    </tr>
    <tr>
        <td>Gender</td>
        <td><%=user.getGender()%></td>
    </tr>
    <tr>
        <td>Birth Date</td>
        <td><%=user.getBirthDate()%></td>
    </tr>
</table>
</body>
</html>
