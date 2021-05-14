<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2021/5/14
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String[] firstName={"Bill","Scott","Larry"};
    List<String> lastName=new ArrayList<String>();
    lastName.add("Ellison");
    lastName.add("Gates");
    lastName.add("McNealy");
    Map<String,String> companyName=new HashMap<String,String>();
    companyName.put("Ellison","Sun");
    companyName.put("Gates","Oracle");
    companyName.put("McNealy","Microsoft");
    pageContext.setAttribute("first",firstName);
    pageContext.setAttribute("last",lastName);
    pageContext.setAttribute("company",companyName);
%>
<h2>Accessing Collection Using EL</h2>
<ul>
    <li>${first[0]} ${last[0]}--> ${company["Ellison"]}</li>
    <li>${first[1]} ${last[1]}--> ${company["Gates"]}</li>
    <li>${first[2]} ${last[2]}--> ${company["McNealy"]}</li>
</ul>

</body>
</html>
