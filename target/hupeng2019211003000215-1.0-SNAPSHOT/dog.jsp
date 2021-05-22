<%@ page import="com.hupeng.week11.demo.Dog" %>
<%@ page import="com.hupeng.week11.demo.Person" %><%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2021/5/14
  Time: 22:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Dog dog=new Dog();
    dog.setName("Tommy");
    Person person=new Person();
    person.setName("Evan");
    person.setDog(dog);
    pageContext.setAttribute("person",person);
%>
<h1>Get Person' Dog name Using java code</h1>
<%
    Person p=(Person) request.getAttribute("person");
    Dog d=p.getDog();
    out.println(d.getName());
%>
<h1>Get Person' Dog name Using EL code</h1>
${person.dog.name}

</body>
</html>
