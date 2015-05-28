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
    <fieldset>
    <form method="post">
		<s:push value="cpiBean">
			<table align="center">
				<tr>
					<s:select list="#session.cpiCd" 
						headerKey="-Select-"
						headerValue="-Select-" 
						name="cpiCd" 
						label="Cpi Code" 
						cssStyle="width:145px"
						/>
						
				<s:submit action="PrintCpiAction" align="center" value="GeneratePDF" />
				<s:submit align="center" name="excel" action="GenerateExcel" value="GenerateExcel" />
				
        </table>
		</s:push>
	</form>
	</fieldset>
	
</body>

</html>