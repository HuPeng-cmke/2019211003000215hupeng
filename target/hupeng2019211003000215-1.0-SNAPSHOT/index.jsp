<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<>
<h1><%= "Hello World!" %>
</h1>
<br/>
<body>
<%@include file="header.jsp" %>
Welcome to my home page.<br/>

<a href="hello-servlet">Hello Servlet</a><br/>
<a href="/2019211003000215hupeng_war/config">ConfigDemoServlet-week4</a><br/>
<a href="/2019211003000215hupeng_war/register">register-week3</a><br/>
<a href="week2/register.jsp">register.jsp-week2</a><br/>
<a href="/2019211003000215hupeng_war/hello">HomeWork1-week2</a><br/>
<a href="login.jsp">login.jsp-week5</a><br/>
<a href="/2019211003000215hupeng_war/login">LoginServlet-week5</a><br/>
<%@include file="footer.jsp" %>
</body>
</html>