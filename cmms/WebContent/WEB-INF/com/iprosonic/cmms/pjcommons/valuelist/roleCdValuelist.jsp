<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Select Role Code List</title>
<s:head/>

<style type="text/css">
@import url(css/tablestyle.css);
</style>
</head>
<body>	
	<s:if test="userList.size()>0">
		<div class="content">
			<table class="userTable" cellpadding="5px" width="100%">
				<tr class="even">
					<th>User Name</th>
					<th>Login Id</th>
					<th>Password</th>
					<th>Role Code</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>

				<s:iterator value="userList" status="userStatus">
					<tr
						class="<s:if test="#userStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td><s:property value="userName" />
						</td>
						<td><s:property value="password" />
						</td>
						<td><s:property value="userName" />
						</td>
						<td><s:property value="userName" />
						</td>
						<td><s:url id="editURL" action="EditUserAction">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}">Edit</s:a>
						</td>
						<td><s:url id="deleteURL" action="DeleteUserAction">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{deleteURL}">Delete</s:a>
						</td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</s:if>
</body>
</html>