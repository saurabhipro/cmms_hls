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
	<s:form action="SaveOrUpdateRoleAction">
		<s:hidden name="id" />
		<s:textfield name="roleName" label="Role Name" />
		<s:textfield name="roleCd" label="Role Cd" />
		<s:submit name="Save" />
	</s:form>

	<s:if test="roleList.size()>0">
		<div class="content">
			<table class="userTable" cellpadding="5px" width="100%">
				<tr class="even">
					<th>Role Name</th>
					<th>Role Cd</th>					
				</tr>

				<s:iterator value="roleList" status="roleStatus">
					<tr>
						<td><s:property value="roleName" />
						</td>
						<td><s:property value="roleCd" />
						</td>						
					</tr>
				</s:iterator>
			</table>
		</div>
	</s:if>
</body>
</html>