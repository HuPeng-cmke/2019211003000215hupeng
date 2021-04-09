<%--
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
<h1>User info</h1>
<table>
    <tr>
        <td>Username:</td>
        <td><%=request.getAttribute("username")%></td>
    </tr>
    <tr>
        <td>Password:</td>
        <td><%=request.getAttribute("password")%></td>
    </tr>
    <tr>
        <td>Email</td>
        <td><%=request.getAttribute("email")%></td>
    </tr>
    <tr>
        <td>Gender</td>
        <td><%=request.getAttribute("gender")%></td>
    </tr>
    <tr>
        <td>Birth Date</td>
        <td><%=request.getAttribute("birthdate")%></td>
    </tr>
</table>
</body>
</html>
