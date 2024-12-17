<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(request.getAttribute("error") != null)
{
	out.print((String)(request.getAttribute("error")));
}
%>
<form action="LoginServlet" method="post">
username <input type="text" name="username">
password <input type="text" name="password">
<input type="submit">
</form>
</body>
</html>