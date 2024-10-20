<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<%

if((String)session.getAttribute("error") != null){
	out.print((String)session.getAttribute("error"));
	session.removeAttribute("error");
}

%>
<Form action="registrationController" method="post">
Firstname : <input name="firstname" type="text">
Lastname : <input name="lastname" type="text">
Username : <input name="username" type="text">
Password : <input name="password" type="text">
<input type="submit">
</Form>
</body>
</html>