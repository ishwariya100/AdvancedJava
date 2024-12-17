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
	String error = (String)request.getAttribute("error");
	if(error != null){ 
		out.println(error);
	}
%>
<form action="RegisterPersonalInfoServlet" method="post">
Firstname <input name="firstname" type="text"></br>
Lastname <input name="lastname" type="text"></br>
Middlename <input name="middlename" type="text"></br>
<label for="gender">Gender:</label>
<input type="radio" name="gender" value="male"> Male<br>
<input type="radio" name="gender" value="female"> Female<br>
<button type="submit">Submit</button>
</form>
</body>
</html>