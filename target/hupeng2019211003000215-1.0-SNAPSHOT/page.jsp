<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/8/2021
  Time: 2:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>page context demo </title>
</head>
<body>
<!-- set , get and remove attribute in 4 scopes -page , request , session , application-->
<h2> way 1 : use jsp objects</h2>
<%
//set a attribute in 4 scope
    pageContext.setAttribute("attname","in page");//name = value
    request.setAttribute("attname","in request");
    session.setAttribute("attname","in session");
    application.setAttribute("attname","in application");
%>
<h3>Get att using jsp objects </h3>
att : <%=pageContext.getAttribute("attname")%><br>
att : <%=request.getAttribute("attname")%><br>
att : <%=session.getAttribute("attname")%><br>
att : <%=application.getAttribute("attname")%><br>
<h2> way 2: use pageContext to set ,get , remove attribute in page , request , session ,application-->
</h2>
<h3>get att from 4 scopes  using pageContext </h3>
att : <%=pageContext.getAttribute("attname",PageContext.PAGE_SCOPE)%><br>
att : <%=pageContext.getAttribute("attname",PageContext.REQUEST_SCOPE)%><br>
att : <%=pageContext.getAttribute("attname",PageContext.SESSION_SCOPE)%><br>
att : <%=pageContext.getAttribute("attname",PageContext.APPLICATION_SCOPE)%><br>
<h3>remove att - use pagecontext</h3>
<%
// remove att form request
   // request.removeAttribute("attname");
// way 2 use pagecontext
pageContext.removeAttribute("attname",PageContext.REQUEST_SCOPE);
//remove from page
    pageContext.removeAttribute("attname",PageContext.PAGE_SCOPE);
%>
<h3>get att from 4 scopes  using pageContext </h3>
att : <%=pageContext.getAttribute("attname",PageContext.PAGE_SCOPE)%><br>
att : <%=pageContext.getAttribute("attname",PageContext.REQUEST_SCOPE)%><br>
att : <%=pageContext.getAttribute("attname",PageContext.SESSION_SCOPE)%><br>
att : <%=pageContext.getAttribute("attname",PageContext.APPLICATION_SCOPE)%><br>
<h2>use pagecontext findAttribute -- search in --> page --> request--> session -->application -- > null</h2>
find att : <%=pageContext.findAttribute("attname")%><!--which one?-->

<j
</body>
</html>
