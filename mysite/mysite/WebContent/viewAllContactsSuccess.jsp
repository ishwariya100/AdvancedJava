<%@include file="header.html"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="assign.dbaccess.EMailAddressVOO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View All Contacts </title>
</head>
<body>

    <table border="1" cellpadding="5" cellspacing="0" width="80%">
        <thead>
            <tr>
                <th>Email ID</th>
                <th>First Name</th>
                <th>Middle Name</th>
                <th>Last Name</th>
                <th>Home Phone</th>
                <th>Mobile Phone</th>
                <th>Work Phone</th>
                <th>Group ID</th>
            </tr>
        </thead>
        <tbody>
            <%
                ArrayList<EMailAddressVOO> list = (ArrayList<EMailAddressVOO>) request.getSession().getAttribute("emaillist");
                if (list != null && !list.isEmpty()) {
                    for (EMailAddressVOO email : list) {
                    	
                    	String groupName = "";
                        switch (email.getgroupID()) {
                            case "7":
                                groupName = "Friends";
                                break;
                            case "8":
                                groupName = "Personal";
                                break;
                            case "9":
                                groupName = "Relatives";
                                break;
                        }
            %>
                        <tr>
                            <td><%= email.geteMailID() %></td>
                            <td><%= email.getfName() %></td>
                            <td><%= email.getmName() %></td>
                            <td><%= email.getlName() %></td>
                            <td><%= email.gethPhone() %></td>
                            <td><%= email.getmPhone() %></td>
                            <td><%= email.getwPhone() %></td>
                            <td><%= groupName %></td>
                        </tr>
            <%
                    }
                } else {
            %>
                    <tr>
                        <td colspan="8">No contacts found.</td>
                    </tr>
            <%
                }
            %>
        </tbody>
    </table>
</body>
</html>