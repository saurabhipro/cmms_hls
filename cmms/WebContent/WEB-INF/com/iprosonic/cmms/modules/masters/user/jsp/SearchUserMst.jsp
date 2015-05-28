<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>

<sj:head jqueryui="true" />

<s:head />
<style type="text/css">
@import url(css/tablestyle.css);
</style>
</head>

<body>
		<form action="SearchEmployeeAction.action" method="post">
			<s:push value="employeeBean">

				<table align="center">
					<tr>

						<td><s:textfield name="employeeName" label="Employee Name"></s:textfield>
						</td>

						<td><s:textfield name="employeeCd" label="Employee Code"></s:textfield>
						</td>
					<tr>

					</tr>




					<s:submit align="center" value="search" />

				</table>
			</s:push>
		</form>


	<br>

	<div class="content">




		<table  class="userTable" align="center" cellpadding="5px" width="90%">




			<tr class="even">
				<th>Employee Name</th>
				<th>Short Name</th>
				
				<th>Employee Code</th>
				
				<th>Department Name</th>
				<th>Role Code</th>
				<th>Status</th>

				<th>Edit</th>

			</tr>

			

				<s:iterator value="employeeList" status="employeeStatus">
					<tr
						class="<s:if test="#employeeStatus.odd == true ">odd
							</s:if><s:else>even</s:else>">
						<td><s:property value="employeeName" />
						</td>
						
						<td><s:property value="employeeShortName" />
						</td>
						
						
						<td><s:property value="employeeCd" />
						</td>
						<td><s:property value="departmentName" />
						</td>
						<td><s:property value="roleCd" />
						</td>
						<td><s:property value="Status" />
						</td>

						<td><s:url id="editURL" action="EditEmployeeAction">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}">Edit</s:a>
						</td>


					</tr>
				</s:iterator>
		</table>

	</div>

</body>
</html>