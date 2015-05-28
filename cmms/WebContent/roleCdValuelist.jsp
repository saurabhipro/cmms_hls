<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<link rel="stylesheet" href="css/mystyle.css" type="text/css" />
</head>
<body bgcolor="#f0edd9">
	<center>
		<h2>Enter User Name and password</h2>
		<br><br>
		<table bgcolor="#f0edd9">
			<tr>
				<td> 
				<s:form action="LoginAction">
						<s:textfield name="username" label="User Name" />
						<s:password name="password" label="Password" />
						<s:select key="Type" list="#{'HO':'HO','RH':'RH'}"></s:select>
						<s:submit value="Login" />
					</s:form>
				</td>
			</tr>
		</table>
	</center>
</body>
</html>