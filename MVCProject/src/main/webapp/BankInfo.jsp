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
} 
%>
 <form action="RegisterBankInfoServlet" method="post">
        BankName: <input type="text" name="bankname"><br>
        Account: <input type="text"  name="account"><br>
        SSN: <input type="text" name="ssn" required><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>