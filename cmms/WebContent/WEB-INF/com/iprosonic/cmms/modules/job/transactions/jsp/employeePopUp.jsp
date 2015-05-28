<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crew List</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" language="javascript"
	src="js/job/popup.js"></script>
<script type="text/javascript" language="javascript" src="js/job/job.js"></script>
<script language="javascript">
	function changeparent(field) {
		var value = "";
		var test = document.getElementsByName(field);
		var sizes = test.length;
		var engiId='<%= request.getParameter("id")%>';
		for (i = 0; i < sizes; i++) {
			if (test[i].checked == true) {
				value += test[i].value + ";";
				
				if(engiId != 'undefined'){
					window.opener.document.getElementById(engiId).value=value;
					
				}else{
					window.opener.document.getElementById("engineer").value = value;
				}	

			}
		}
		window.close();
	}
</script>
</head>

<body>

	<form class="form-horizontal">
		<div align="center"
			style="padding-left: 10%; padding-right: 10%; padding-top: 2%;">
			<table align="center" width=100% " border="1">
		
		        <tr style="background-color: red">
					<td colspan="8">Employee </td>
				</tr>
				
				<tr>
					<td>Submit</td>
					<td>Select</td>
					<td>Short Name</td>
					<td>Name</td>
					<td>Role</td>
				</tr>
				<s:iterator value="employeeBeansList" status="employeeStatus">
					<tr>
						<td><input type="button" value="Submit"
							onclick="changeparent('employeeShortName')" /></td>
						<td><input type="checkbox" name="employeeShortName"
							id="employeeShortName"
							value='<s:property value="employeeShortName"/>'>
						</td>
						<td><s:property value="employeeShortName" /></td>
						<td><s:property value="employeeName" /></td>
						<td><s:property value="roleCd" /></td>
					</tr>
				</s:iterator>
				<tr>
					<td colspan="7"><input type="submit" value="Submit"
						onclick="changeparent('employeeShortName')" /></td>
				</tr>
			</table>
		</div>
	</form>
	<br />
	<br />
	<br />
	<br />
</body>
</html>