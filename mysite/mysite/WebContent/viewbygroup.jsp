<%@include file="header.html"%>
<html>
<head>
<title>View by Group</title>
</head>

<body bgcolor="#ffffee" leftmargin="10px" rightmargin="10px">
<%
	String error = (String) request.getSession().getAttribute("Errors");
	if(error != null)
		out.println(error);
%>
	<center>
		<h2>View by Group</h2>
	</center>
	<!--Body: view by group information-->
	<center>
		<form method="post" action="/mysite/servlet/getAllEMailListbyGroup">
			<table cellpadding="0" cellspacing="0" width="50%"">
				<tr>
					<td bgcolor="#FAFAF9" style="padding-left: 10px;">GroupId</td>
					</td>
					<td><select name="group" id="group">
							<option value="7">Friends</option>
							<option value="8">Personal</option>
							<option value="9">Relatives</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2" align="right"><br>
						<table width="50%">
							<tr>
								<td><input type="submit" name="save" value="View by Group" /></td>
								<td width="201"><input type="reset" name="clear"
									value="Clear" />&nbsp;</td>
							</tr>
						</table></td>
				</tr>
			</table>
		</form>
	</center>
</body>



</html>
<%@include file="footer.html"%>

</body>
