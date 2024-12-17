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

String error = (String) request.getAttribute("error");
if(error != null){  
	    out.println(error); 
	    session.removeAttribute("personalId");  
} 
%>
<form action="RegisterContactInfoServlet" method="post">
       Address : <input name="address">
City : <input name="city">
State : <input name="state">
Country : 
  <select name="country">
    <option value="usa">United States</option>
    <option value="canada">Canada</option>
    <option value="uk">United Kingdom</option>
    <option value="australia">Australia</option>
    <option value="india">India</option>
  </select><br>
Phone : <input name="phone">
<input type="submit">
    </form>
</body>
</html>