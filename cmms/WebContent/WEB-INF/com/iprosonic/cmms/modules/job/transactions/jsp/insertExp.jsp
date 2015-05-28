<%@page import="com.iprosonic.cmms.modules.job.transactions.job.domain.JobExplBean"%>
<%@page import="com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/button.css" />
<link rel="stylesheet" type="text/css" href="submodal/style.css" />
<link rel="stylesheet" type="text/css" href="css/gridstyle.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery.autocomplete.css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" language="javascript"
	src="js/job/datetimepicker.js"></script>
<script type="text/javascript" language="javascript"
	src="/js/jquery.combobox.js"></script>
<script type="text/javascript" src="./js/jquery.combobox.js"></script>
<script src="js/jquery.autocomplete.js"></script>
<script type="text/javascript" language="javascript" src="js/stdlib.js"></script>
<script src="js/job/jobGrid.js"></script>
<script type="text/javascript" language="javascript" src="js/stdlib.js">
</script>
<script src="js/job/updateJobService.js"></script>



<script type="text/javascript">



function insertExp() {
	document.editExp.submit();
	}	

	


	
</script>

<%
		JobExplBean jobExpBean = (JobExplBean) request
				.getAttribute("jobExpBean");
		String expId=jobExpBean.getExplNo();
%>
	
<script>
$("#assetCd1").autocomplete("getAssetCd.jsp");
</script>
<head>

<script type="text/javascript">
	var role = "<%=session.getAttribute("role")%>";
	
</script>
</head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Expl</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<sj:head jqueryui="true" />

<style type="text/css">
</style>
</head>
<body >

	
	<div align="center" style="padding-top: 2%">
		<form name="editExp" id="editExp" action="InsertServiceExplAction.action">
			    
				
				<input type="hidden"
				name="serviceNo" value='<%=jobExpBean.getServiceNo()%>'>
				<input type="hidden"
				name="jobNo" value='<%=jobExpBean.getJobNo()%>'>
				

			<div id="header1" align="center"
				style="background-color: RED; width: 90%; font: 400PX; font-size: 18PX;">
				<b>Insert Exp</b>
			</div>

			<s:push value="jobServiceBean">
		     <table cellpadding="5%" width="90%" style="border: 1px solid black;">
					<tr><td class="expl"><input type="radio" value="exp" name="radio"></td><td class="expl">Part Id:</td><td class="expl"><input type="text" name="expno" value="<%=expId %>" style="width: 80px;" /></td><td class="expl">Part No:</td><td class="expl"><input type="text" id="<%=expId %>" name="partNo" style="width: 80px;"></td><td class="expl">Qty:</td><td class="expl"><input type="text" id="<%=expId %>" name="qty" style="width: 80px;"></td><td class="expl">UOM:</td><td class="expl"><select id="<%=expId %>" name="uom" style="width: 80px;"><option value="Feet">Feet</option><option value="No">No</option></select></td><td class="expl"></td></tr>
					<tr>
						<td colspan="8" align="center">
							<div class="myHeader" align="center">
							<input type="button" value="Insert" id="update" class="myButton"
									onclick="insertExp();" id="submit" />
								
							
								 <input type="button"
									value="Close" id="close" class="myButton"
									onclick="self.close();" id="submit" />


							</div></td>

					</tr>
			  </table>
			</s:push>

		</form>
	</div>

	<br />
	<br />
	<br />
	<br />
</body>
</html>