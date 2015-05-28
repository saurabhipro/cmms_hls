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
		var crewId='<%=request.getParameter("id")%>';
		for (i = 0; i < sizes; i++) {
			/* if (test[i].checked == true) {
				value += test[i].value + ";";
				window.opener.document.getElementById("crew").value = value;

			} */
			if (test[i].checked == true) {
				value += test[i].value + ";";
			}

		}
		if (crewId == 'undefined') {
			window.opener.document.getElementById("crew").value = value;
		} else {
			window.opener.document.getElementById(crewId).value=value;
		}

		window.close();

	}
</script>
</head>

<body>
	<form class="form-horizontal">
		<div align="center"
			style="padding-left: 10%; padding-right: 10%; padding-top: 2%;">
			<table align="center" width=500px border="1%">
				<tr style="background-color: red">
					<td colspan="8">Employee</td>
				</tr>

				<tr>
					<td>Submit</td>
					<td>Select</td>
					<td>Short Name</td>
					<td>Name</td>
					<td>Role</td>
				</tr>
				<tr>
					<s:iterator value="employeeBeansList" status="employeeStatus">
						<td><input type="button" value="Submit"
							onclick="changeparent('employeeShortName')" /></td>
						<td><input type="checkbox" name="employeeShortName"
							id="employeeShortName"
							value='<s:property value="employeeShortName"/>'></td>

						<td><s:property value="employeeShortName" /></td>

						<td><s:property value="employeeName" /></td>


						<td><s:property value="roleCd" /></td>
				</tr>

				</s:iterator>
				<tr>
					<td></td>

					<td colspan="3"><input type="submit" value="Submit"
						onclick="changeparent('employeeShortName')" /></td>
					<td></td>

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