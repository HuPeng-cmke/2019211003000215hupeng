<%--
  Created by IntelliJ IDEA.
  User: 哈哈哈
  Date: 2021/6/15
  Time: 22:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<script>
    function oneFunction(){
        var x=document.getElementById("firstVal").value;
        var y=document.getElementById("secondVal").value;

        if(isNaN(x)){
            alert("First Value is not a Number");
        }else if(isNaN(y)){
            alert("Second Value is not a Number");
        }
    }
    function twoFunction(){
        var z=document.getElementById("name").value;
        if(!isNaN(z)||z==""){
            alert("Name is not valid")
        }
    }
    function threeFunction(){
        document.getElementById("myForm").reset();

    }
</script>
<body>
<%
    Cookie [] allCookies=request.getCookies();
    String firstVal="",secondVal="",result="",name="",length="";
    if(allCookies!=null){
        for(Cookie c:allCookies){
            if(c.getName().equals("cFirstVal")){
                firstVal=c.getValue();
            }
            if(c.getName().equals("cSecondVal")){
                secondVal=c.getValue();
            }
            if(c.getName().equals("cResult")){
                result=c.getValue();
            }
            if(c.getName().equals("cName")){
                    name=c.getValue();
            }
            if(c.getName().equals("cLength")){
                length=c.getValue();
            }
        }
    }
%>
<form method="post" action="CalServlet" id="myForm">
First Val:    <input type="text" id="firstVal" name="firstVal" value="<%=firstVal%>"/> Enter a name:<input type="text" id="name" name="name" value="<%=name%>"/><br/>
    Second Val:<input type="text" id="secondVal" name="secondVal"value="<%=secondVal%>"/>Length :   <input type="text" value="<%=length%>"/><br/>
    Result :<input type="text" value="<%=result%>"><br>
    <input type="submit" onclick="oneFunction()" name="action" value="Add">
<input type="submit" onclick="oneFunction()" name="action" value="Subtract">
<input type="submit" onclick="oneFunction()" name="action" value="Multiply">
<input type="submit" onclick="oneFunction()" name="action" value="Divide">
<input type="submit" onclick="twoFunction()" name="action" value="Computer Length">
<input type="button" onclick="threeFunction()"value="Reset">
</form>

</body>
</html>
