<%@ page import="com.hupeng.week10.StringBean" %><%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2021/5/15
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
 This is my JSP page.<br>
 <jsp:useBean id="bean" class="com.hupeng.week10.StringBean"/>

<%
    /*bean=new StringBean();
    bean.setMessage("Hello Mr Bean");*/
%>
<jsp:setProperty name="bean" property="message" value="Hello Mr Bean"/>
<%//=bean.getMessage()%>
<jsp:getProperty name="bean" property="message"/>

</body>
</html>
