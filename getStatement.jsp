<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ 
 page import="java.util.ArrayList"
 %>
 
<html>
<head>
<meta charset="ISO-8859-1">
<title>STATEMENT DISPLAY</title>
</head>
<body>
 
<%
ArrayList al1=(ArrayList)session.getAttribute("debit");
out.println("Your debit details are"+al1);
%>
<br></br>
<%
ArrayList al2=(ArrayList)session.getAttribute("credit");
out.println("Your credit details are"+al2);
%>
<br/><a href="Home.jsp">HOME</a><br/>
<a href="Logout">LOGOUT</a><br/>
</body>
</html>