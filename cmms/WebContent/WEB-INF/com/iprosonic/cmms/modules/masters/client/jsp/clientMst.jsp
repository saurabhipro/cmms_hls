<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Page</title>
<sj:head jqueryui="true" />
<s:head />
<style type="text/css">
@import url(css/tablestyle.css);
</style>
</head>
<body>
	<center>
	<s:form action="SaveClientMstAction">
	<s:push value="clientMasterBean">
		<s:hidden name="id"></s:hidden>
		<s:textfield name="clientName" label="Enter Client Name"></s:textfield>
		<s:submit/>
		</s:push>
	</s:form>
	
	
	
	<s:if test="clientName!=null">
	<h2>Operation Successfull.</h2> 
	</s:if>
	<div class="content">




		<table  class="userTable" align="center" cellpadding="5px" width="90%">




			<tr class="even">
				<th>Client Id</th>
				<th>Client Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			

				<s:iterator value="clientMasterList" status="employeeStatus">
					<tr
						class="<s:if test="#employeeStatus.odd == true ">odd
							</s:if><s:else>even</s:else>">
						<td><s:property value="id" />
						</td>
						<td><s:property value="clientName" />
						</td>
						
						<td>	<a href="EditClientMst.action?id=<s:property value="id" />&clientName=<s:property value="clientName"/>" >Edit</a>
						</td>
						<td><a href="DeleteClientMst.action?id=<s:property value="id" />&clientName=<s:property value="clientName" />">Delete</a>
						</td>

					</tr>
				</s:iterator>
		</table>

	</div>
	</center>
	


</body>

</html>