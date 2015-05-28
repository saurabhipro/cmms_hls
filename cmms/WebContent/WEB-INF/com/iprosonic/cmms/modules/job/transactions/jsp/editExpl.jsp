<%@page import="com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>WAS</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" language="javascript" src="js/job/job.js"></script>
<script type="text/javascript" language="javascript"
	src="js/job/datetimepicker.js"></script>
<script type="text/javascript" language="javascript"
	src="js/job/popup.js"></script>
<script type="text/javascript" language="javascript"
	src="js/job/edit.js"></script>

<script type="text/javascript">
	function updateExplosive() {
		document.editexplosive.submit();
	}
</script>

<link rel="stylesheet" type="text/css" href="css/style1.css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script src="js/jquery.autocomplete.js"></script>
<link rel="stylesheet" type="text/css" href="css/gridstyle.css" />

<script>
	jQuery(function() {
		$("#partCd1").autocomplete("getPartCd.jsp");
	});
	
	jQuery(function() {
		$("#partCd2").autocomplete("getPartCd.jsp");
	});
	
</script>

</head>

<body>

	<div id="header1"  class="expl"  align="center">Edit Explosive</div>

	<div align="center" style="padding-top: 2%">
		<%
			JobExplBean jobExplBean = (JobExplBean) request.getAttribute("jobExplBean");
		%>
		<form id="editexplosive" name="editexplosive" action="UpdateJobExplosiveAction.action">
			
				<input
				type="hidden" name="jobNo" value='<%=jobExplBean.getJobNo()%>'>
			<input type="hidden" name="serviceNo"
				value='<%=jobExplBean.getServiceNo()%>'> <input
				type="hidden" name="explNo" value='<%=jobExplBean.getExplNo()%>'>

			<table id="editExpltable" border="1px;">
				

				<tr>
					<td>Part No</td>
					<td>
						
						 <input type="text"
						id="partCd" name="partCd" class="input_text" 
						value='<%=jobExplBean.getPartCd()%>'
						/>
						
						</td>
				</tr>

				<tr>
					<td>Qty</td>
					<td><input type="text" name="qty" id="qty"
						value='<%=jobExplBean.getQty()%>' /></td>
				</tr>
				<tr>
				 
					<td>
						<s:select list="UomMap" value="uomData" name="uom" id="uom" label="UOM">
						
						</s:select>
						
						
						</td>
				</tr>
				<tr>
					<td colspan=2 align="center"><input type="button"
					    value="Update"
						name="update" id="update" onclick="updateExplosive();" />
						<input type="button"
									value="Close" id="close" class="myButton"
									onclick="self.close();" id="submit" />
						</td>
						
						
				</tr>
			</table>
		</form>
	</div>

	<br />
	<br />
	<br />
	<br />
</body>
</html>