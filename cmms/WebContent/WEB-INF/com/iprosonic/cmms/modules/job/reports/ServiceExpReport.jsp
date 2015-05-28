<%@page import="java.util.Date"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<script language="javascript" type="text/javascript"
	src="js/searchasset.js">
	
</script>

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
			action="ServiceExpReport.action" method="post">
			

				<tr>

					<td>From Date</td>
					<td><sj:datepicker displayFormat="yy-mm-dd" name="fromDate"
							id="fromDate" label="Job Date" value="%{fromDate}" /></td>
				</tr>
				<tr>
					<td>To Date</td>
					<td><sj:datepicker displayFormat="yy-mm-dd" name="toDate"
							id="toDate" label="Job Date" value="%{toDate}" />
					</td>
				</tr>
				<tr>
				<td colspan="2" >
				<s:submit value="Search" align="center"></s:submit>
				</td>
				</tr>
		</s:form>
	</center>
	
	 
		<div class="container">
			<table class="userTable" align="center" cellpadding="5px" >
				<tr class="even">
					<th>JobNO</th>
					<th>ServiceNo</th>
					<th>Exp NO</th>
					<!-- <th>Total Qty</th> -->
					
					 
				</tr>

				<s:iterator value="bean">
				
					<tr>
					<td><s:property value="jobNo" ></s:property></td>
					<td>
					   <table>
						<s:iterator value="jobServiceNos">
					   <tr><td>
							<s:property value="serviceNo"/><br>
						</td></tr>	
						</s:iterator>
						
						</table>
					</td>
					 <td>
					 <s:iterator value="jobExplNos">
					<s:property value="explNo"/><br>
					</s:iterator>
					</td> 
				
					</tr>
				</s:iterator>
				 
			</table>
		</div>

</body>
</html>