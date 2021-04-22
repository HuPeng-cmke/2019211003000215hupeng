<%@ page import="com.hupeng.model.User" %>
<%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2021/4/22
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="header.jsp"%>
<h1>User Update</h1>
<%
    User user2=(User) session.getAttribute("user");
%>
<form method="post"  action="/2019211003000215hupeng_war/updateUser">
    <input type="hidden" name="id" value="<%=user2.getId()%>">
    username:<input type="text"  name="username" value="<%=user2.getUsername()%>"><br/>
    password:<input type="password"  name="password" value="<%=user2.getPassword()%>"><br/>
    Email:<input type="text" name="email" value="<%=user2.getEmail()%>"><br/>
    Gender:<input type="radio" name="gender" value="male" <%="male".equals(user2.getGender())?"checked":""%>>Male
    <input type="radio" name="gender" value="female"<%="female".equals(user2.getGender())?"checked":""%>>Female<br/>
    Date of Birth :<input type="text" name="birth" value="<%=user2.getBirthDate()%>"><br/>
    <input type="submit" value="Save Changes"/><br/>
</form>