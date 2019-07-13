<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Successfully</title>
</head>
<body>
<%
String email=(String)session.getAttribute("email");
String name=(String)session.getAttribute("name");
out.println("<h1 style=color:#0000b3;>Welcome "+name+"</h1>");
out.println("Our Loan Exective will contact you soon....");
out.println("Your email is "+ email);
%>
<br/>
<a href="Home.jsp">HOME</a><br/>
<a href="changepass.html">CHANGE PASSWORD </a><br/>
<a href="transfer.html">TRANSFER AMOUNT</a><br/>
<a href="GetSatatment">GET STATEMENT</a><br/>
<a href="loan.html">APPLY LOGIN</a><br/>
<a href="Logout">LOGOUT</a><br/>
</body>
</html>