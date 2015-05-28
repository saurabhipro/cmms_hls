<%@page import="com.iprosonic.cmms.modules.job.transactions.job.domain.JobRunBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//Dtd HTML 4.01 transitional//EN" "http://www.w3.org/tr/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
	function updateRun() {
		document.editrun.submit();
		
		
	}
</script>

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

</head>
<body>
	<%
		JobRunBean jobRunBean = (JobRunBean) request
				.getAttribute("jobRunBean");
	%>

<div align="center" style="padding-top:2%">

	<form name='editrun' id='editrun' action="UpdateRunJobAction.action">

		
		<input type="hidden" name="runNo" value='<%=jobRunBean.getRunNo()%>'>
		<input type="hidden" name="rigNo" value='<%=jobRunBean.getRigNo()%>'>
		<input type="hidden" name="jobNo" value='<%=jobRunBean.getJobNo()%>'>

		<div id="header1" align="center"
			style="background-color: RED; width: 90%; font: 400PX; font-size: 18PX;">
			<b>EDIT Run</b>
		</div>
		



		<TABLE cellpadding="0% " width="90%" align="center"
			style="border: 1px solid black;">
			<tr class="run">

				 

				<td>BHT</td>
				<td><input type="text" name="bht" id="bht"
					value='<%=jobRunBean.getBht()%>' />
				</td>
				<td>Operating time start</td>
				<td>
					<input
				  name ="rih" type="text" size="17" value='<%=jobRunBean.getRih()%>' id="rih"
								name="unitLeftBase"> <a
								href="javascript:NewCal('rih','ddmmmyyyy',true,24)"><img
									src="images/cal.gif" width="12" height="16" border="0"
									alt="Pick a date"> </a>
									
				
				
				<td>Operating time stop</td>
				
				<td>
				<input
				  name ="pooh" type="text" size="17" value='<%=jobRunBean.getPooh()%>' id="pooh"
								name="unitLeftBase"> <a
								href="javascript:NewCal('pooh','ddmmmyyyy',true,24)"><img
									src="images/cal.gif" width="12" height="16" border="0"
									alt="Pick a date"> </a>
									
				
				</td>
                     <td>OT</td>
				
		         <td><input type="text" name="ot" id="ot"
					value='<%=jobRunBean.getOt()%>' />
				</td>
				
		     <td>WT</td>
				
		         <td><input type="text" name="wt" id="wt"
					value='<%=jobRunBean.getWt()%>' />
				</td>
				
			</tr>

			<tr>
                   
				<td colspan="10" align="center">
					<br/>
					<div class="myHeader" align="center">
						<input type="button" value="Update" id="update" class="myButton"
							onclick="updateRun();" id="submit" /> <input type="button"
							value="Close" id="close" class="myButton" onclick="self.close();"
							id="submit" />


					</div>
				</td>


			</tr>

		</TABLE>

		<br /> <br /> <br /> <br />
	</form>
	</div>
</body>
</html>