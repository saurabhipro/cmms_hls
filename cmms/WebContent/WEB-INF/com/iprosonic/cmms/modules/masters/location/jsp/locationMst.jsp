<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
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
	<s:form action="SaveLocationMstAction">
	<s:push value="locationmst">
		<s:hidden name="id"></s:hidden>
		<s:textfield name="locationName" label="Enter Location Name"></s:textfield>
		<s:submit/>
	</s:push>
	</s:form>
	
	
	
	<s:if test="locationName!=null">
	<h2>Operation Successfull.</h2> 
	</s:if>	
	<div class="content">




		<table  class="userTable" align="center" cellpadding="5px" width="90%">




			<tr class="even">
				<th>Location Id</th>
				<th>Location Name</th>
				<th>Edit</th>
				<th>Delete</th>
			</tr>

			

				<s:iterator value="locationMstList" status="employeeStatus">
					<tr
						class="<s:if test="#employeeStatus.odd == true ">odd
							</s:if><s:else>even</s:else>">
						<td><s:property value="id" />
						</td>
						<td><s:property value="locationName" />
						</td>
						
						<td><a href="EditLocationMst.action?id=<s:property value="id" />&locationName=<s:property value="locationName"/>" >Edit</a>
						</td>
						<td><a href="DeleteLocationMst.action?id=<s:property value="id" />&locationName=<s:property value="locationName" />">Delete</a>
						</td>

					</tr>
				</s:iterator>
		</table>

	</div>
	</center>
	


</body>

</html>