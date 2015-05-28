<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<script language="javascript" type="text/javascript"
	src="js/searchasset.js">
	
</script>
<link rel="stylesheet" type="text/css"
	href="css/table.css" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<sj:head jqueryui="true" />
<style type="text/css">
@import url(css/tablestyle.css);
</style>

<sj:head />
</head>

<body>

	<center>
		<s:form id="formValidate" theme="qxhtml"
			action="JobBonusReportAction.action" method="post">

           			<s:push value="jobBean">
           

			<tr>

				<td>From Date</td>
				<td><sj:datepicker displayFormat="yy-mm-dd" name="fromDate"
						id="fromDate" label="Job Date" value="%{jobDate}" />

				</td>
			</tr>
			<tr>
				<td>To Date</td>
				<td><sj:datepicker displayFormat="yy-mm-dd" name="toDate"
						id="toDate" label="Job Date" value="%{jobDate}" /></td>
			</tr>
			<tr>
				<td><s:select label="Job No" list="#session.jobNoList"
						name="jobNo" headerKey="-Select-" cssStyle="width:190px"
						headerValue="-Select-">
					</s:select>
				</td>
			</tr>

           

			<sj:submit button="true" value="Search" />
</s:push>
		</s:form>
	</center>
   <hr/>
   <%String bonusReport= (String)request.getAttribute("bonusReport");
     if(bonusReport!=null)
     {%>
    	 <%=bonusReport%>
     <%} %>
   


</html>
</body>
</html>