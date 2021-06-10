<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/15/2021
  Time: 11:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>validate</title>
</head>
<body>
<%--Todo 1: Use <jsp:useBean> to create a Login bean instance in request scope --%>
<jsp:useBean id="user" class="com.hupeng.lab2.Login" scope="request"/>
    <%--Todo 2: Use <jsp:setProperty> to set  beans' property username and password--%>
<jsp:setProperty name="user" property="*"/>
<%
    if(user.getUsername().equals("admin")&&user.getPassword().equals("admin")){
        session=request.getSession(false);
        session.setAttribute("user",user);
        System.out.println(session);
        System.out.println("插入session");


   //todo 3: use if check username is admin and ppassword is admin
%>
    <%--todo 4: use jsp:forward to welcome.jsp page--%>
<jsp:forward page="welcome.jsp"></jsp:forward>
    <%--todo 5: else part{ --%>

<%
    }else{
        out.write("username or password error");

// todo 6: print username or password error message

%>
    <%--todo 7: use jsp:include login.jsp page --%>
<jsp:include page="login.jsp"/>
<%
    }
%>
    <%--todo 8: close else --%>

</body>
</html>