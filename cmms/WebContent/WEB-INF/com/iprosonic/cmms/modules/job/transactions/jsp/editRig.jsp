<%@page import="com.iprosonic.cmms.modules.job.transactions.job.domain.JobRigBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" language="javascript" src="js/job/job.js"></script>
<script type="text/javascript" language="javascript"
	src="js/job/datetimepicker.js"></script>
<script type="text/javascript" language="javascript"
	src="js/job/popup.js"></script>
<script type="text/javascript" language="javascript"
	src="js/job/edit.js"></script>
<script type="text/javascript" language="javascript"
	src="js/job/datetimepicker.js"></script>




<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Rig</title>

<link rel="stylesheet" type="text/css" href="css/style.css">
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

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Run</title>
<link rel="stylesheet" type="text/css" href="css/style.css">

<script type="text/javascript" language="javascript" src="js/job.js"></script>
<script type="text/javascript">
	function updateRig() {
		document.editrig.submit();
		

	
		
	}

	
</script>


<link rel="stylesheet" type="text/css" href="css/style1.css" />
<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script src="js/jquery.autocomplete.js"></script>

<script>
	jQuery(function() {
		$("#partCd").autocomplete("getPartCd.jsp");
	});
</script>

</head>

<body>
	<div align="center" style="padding-top: 2%">

		<form name='editrig' id="editrig" action="UpdateRigJobAction.action" >

			<%
				JobRigBean jobRigBean = (JobRigBean) request
						.getAttribute("jobRigBean");
			%>

			<input type="hidden" name="rigNo" value='<%=jobRigBean.getRigNo()%>'>
			<input type="hidden" name="jobNo" value='<%=jobRigBean.getJobNo()%>'>

			<input type="hidden" name="referer"
				value='<%=request.getHeader("referer")%>'>
			<div align="center">
				<TABLE style="border:1px" cellpadding="10px">
					<tr>
						<td align="center" colspan="10"
							style="background: red; font-size: 100%">EDIT RIG</td>
					</tr>
					<tr class="rig">
						<td>Rig up Start</td>
						<td><input id="rigUpStart" type="text" size="25"
							value='<%=jobRigBean.getRigUpStart()%>' name="rigUpStart"> <a
							href="javascript:NewCal('rigUpStart','ddmmmyyyy',true,24)"><img
								src="images/cal.gif" width="16" height="16" border="0"
								alt="Pick a date"> </a></td>
						
						<td>Rig up end</td>
						<td><input id="rigUpEnd" type="text" size="25"
							value='<%=jobRigBean.getRigUpEnd()%>' name="rigUpEnd"> <a
							href="javascript:NewCal('rigUpEnd','ddmmmyyyy',true,24)"><img
								src="images/cal.gif" width="16" height="16" border="0"
								alt="Pick a date"> </a></td>


						
						<td>RigDownStart</td>
						<td><input id="rigDownStart" type="text" size="25"
							value='<%=jobRigBean.getRigDownStart()%>' name="rigDownStart"> <a
							href="javascript:NewCal('rigDownStart','ddmmmyyyy',true,24)"><img
								src="images/cal.gif" width="16" height="16" border="0"
								alt="Pick a date"> </a></td>


						<td>Rig DownEnd</td>
						<td><input id="rigDownEnd" type="text" size="25"
							value='<%=jobRigBean.getRigDownEnd()%>' name="rigDownEnd"> <a
							href="javascript:NewCal('rigDownEnd','ddmmmyyyy',true,24)"><img
								src="images/cal.gif" width="16" height="16" border="0"
								alt="Pick a date"> </a></td>

						
					</tr>


					<tr>
						<td colspan="8" align="center">
							<div class="myHeader" align="center">
								    <input type="button" value="Update" id="update" class="myButton"
									onclick="updateRig();" id="submit" /> <input type="button"
									value="Close" id="close" class="myButton"
									onclick="self.close();" id="submit" />


							</div>
						</td>


					</tr>

				</table>
			</div>

			<br /> <br /> <br /> <br />
		</form>

	</div>

</body>
</html>