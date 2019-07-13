<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Apna Bank</title>
</head>
<body>
<%
String name=(String)session.getAttribute("name");
int accno=(Integer)session.getAttribute("acc_no");
out.println("<h1 style=color:#0000b3;>Welcome "+name+"</h1>");
out.println("<h2 style=color:#0000b3;>YOUR ACCOUNT NUMBER IS  "+accno+"</h2>");
%>
<br/>
<form action="http://localhost:9898/BANK/Balance">
<a href="Balance">CHECK BALANCE</a><br/>
</form>
<a href="changepass.html">CHANGE PASSWORD</a><br/>
<a href="transfer.html">TRANSFER AMOUNT</a><br/>
<a href="GetStatement">GET STATEMENT</a><br/>
<a href="loan.html">APPLY LOAN</a><br/>
<a href="Logout">LOGOUT</a><br/>
</body>
</html>