<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% 
if((String)request.getAttribute("error") != null)
	out.print((String)request.getAttribute("error"));
%>
<form action="loginController" method="post">
username : <input name="username" type="text">
password : <input name="password" type="text">
<input type="submit">
</form>
</body>
</html>