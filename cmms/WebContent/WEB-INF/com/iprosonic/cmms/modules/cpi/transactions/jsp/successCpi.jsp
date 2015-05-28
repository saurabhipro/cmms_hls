<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
	<s:form id="formValidate" theme="qxhtml"
		action="SaveOrUpdateUserAction">
		
			<s:textfield id="cpiCd" name="cpiCd" 
				cssStyle="font-size:15px;border:none" />
			<td>no generated successfully.</td>
		

	</s:form>
	</center>
</body>
</html>