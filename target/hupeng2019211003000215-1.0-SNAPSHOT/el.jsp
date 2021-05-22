<%@ page import="com.hupeng.week11.demo.Dog" %>
<%@ page import="com.hupeng.week11.demo.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 5/11/2021
  Time: 8:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL </title>
</head>
<body>
<h1>Demo #1</h1>
<%
//set att in page , request , session and application
    pageContext.setAttribute("x","in page");//name=value
    request.setAttribute("x","in request");//name=value
    session.setAttribute("x","in session");//name=value
    application.setAttribute("x","in application");//name=value
%>
att ":<%=pageContext.findAttribute("x")%><!-- which one >-->
<h2>Use el to find attribute </h2>
 value --> ${x}<!-- what does it mean ? pagecontext.findAttribute("x")-->
<hr>
<h1>Demo #2 </h1>
<%
//set
    Dog dog=new Dog();
    dog.setName("Tommy");

    Person person=new Person();
    person.setName("Tom");
    person.setDog(dog);
    //must attribute in any one scope -
    request.setAttribute("person",person);
%>
<h2> Get persons' dog name - use java code </h2>
<% Person p=(Person) pageContext.findAttribute("person");//part 1
    Dog d=p.getDog();//part 2
    out.println(p.getName()+" Persons' Dog name : "+d.getName());// part 3

%>
<h2> Get persons' dog name - use EL code </h2>
  ${person.name} -->Persons' Dog name : ${person.dog.name}
<hr>
<h1>Demo #3 </h1>

<%
//create array list ,map
    //array
    String[] firstName={"Bill","Scott","Larry"};
    //arraylist
    ArrayList<String> lastName=new ArrayList<String>();
    lastName.add("Ellison");
    lastName.add("Gates");
    lastName.add("McNealy");
//map
    HashMap<String,String> companyName=new HashMap<String,String>();
    companyName.put("Ellison","sun");
    companyName.put("Gates","Orecle");
    companyName.put("McNealy","MicroSoft");

//set attribute in any one scope
    request.setAttribute("first",firstName);//array
    request.setAttribute("last",lastName);//arraylist- 0,1,2,3,....
    request.setAttribute("company",companyName);//map

%>
<h2>Get items from array , list --> map using EL </h2>
${first[0]}, ${last[0]}--> ${company["Ellison"]}<br>
${first[1]}, ${last[1]}--> ${company["Gates"]}<br>
${first[2]}, ${last[2]}--> ${company["McNealy"]}<br>
<hr>
<h1>Demo #4</h1>
<h1> use param </h1>
<%
//java code
    request.getParameter("name");
%>
 name : ${param.name}<br>
    ID : ${param.ID}<br>
<h1>use header</h1>
host name : ${header.host}<br>
<h1>use cookie</h1>
${cookie.JSESSIONID.value}<br>
<h2>USE INITPARAM</h2>
${initParam.url}<br>
${initParam.driver}<br>

<h2>use pageContext (in el )</h2>
${pageContext.session.id}<br>

<h1>get from any one scope </h1>
${pageScope.x}<br>
${requestScope.x}<br>
${sessionScope.x}<br>
${applicationScope.x}<br>
<hr>
<h1>Demo #5</h1>
${empty ""}<br>
${empty "str"}<br>
${empty param.name}<br>
${empty param.xxxxxx}<br>
</body>
</html>
