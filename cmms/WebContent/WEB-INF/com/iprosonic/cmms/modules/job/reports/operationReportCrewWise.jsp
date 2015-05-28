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
		<s:form id="formValidate" theme="qxhtml" action="ReportCrewWise.action"
			method="get">


			<tr>

				<td>From Date</td>
				<td><sj:datepicker displayFormat="yy-mm-dd" name="fromDate"
						id="fromDate" label="Job Date" value="%{fromDate}" /></td>
			</tr>
			<tr>
				<td>To Date</td>
				<td><sj:datepicker displayFormat="yy-mm-dd" name="toDate"
						id="toDate" label="Job Date" value="%{toDate}" /></td>
			</tr>
			<tr>
				<td><s:select label="Crew Name" list="crewList" name="engi"
						headerKey="-Select-" cssStyle="width:150px" headerValue="-Select-">
					</s:select></td>
			</tr>
			<tr>
				<td colspan="2"><s:submit value="Search" align="center"></s:submit>
				</td>
			</tr>
		</s:form>
	</center>


	<div class="container">
		<table class="userTable" align="center" cellpadding="5px" width="auto">
			<tr style="color:red;">

				<th style="background-color: yellow;">Service NO-<s:property
						value="noofServices" /></th>
				<th style="background-color: yellow;">No of Job-<s:property
						value="noofJobs" /></th>
				<th style="background-color: yellow;">Total ChMissRuns-<s:property
						value="totalmissruns" /></th>
				<th style="background-color: yellow;">Total ChRuns-<s:property
						value="totalchRuns" /></th>
				<th style="background-color: yellow;">Total LossTime-<s:property
						value="totallosstime" /></th>
				<th style="background-color: yellow;">Total LQAP-<s:property
						value="totallqap" /></th>
				<th style="background-color: yellow;">Total LQAT-<s:property
						value="totallqat" /></th>

			</tr>
			
			 
			<tr class="even">
				<th>Service NO</th>
				<th>JobNo</th>
				<th>ChMissRuns</th>
				<th>ChRuns</th>
				<th>LossTime</th>
				<th>LQAP</th>
				<th>LQAT</th>
			 
			</tr>

			<s:iterator value="serviceBeanList">
				<tr>
					<td><s:property value="serviceNo" /></td>
					<td><a href="EditJobAction.action?jobNo=<s:property value="jobNo" />">
					<s:property value="jobNo" /></a>
					</td>

					<s:if test="chmisRuns >= 1">
					<td style="color:yellow; background-color:red"><s:property value="chmisRuns" /></td>
					</s:if>
					<s:else>
    				<td><s:property value="chmisRuns" /></td>
					</s:else>


					<td><s:property value="chruns" /></td>
					<td><s:property value="lossTime" /></td>
					<td><s:property value="lqaPresentation" /></td>
					<td><s:property value="lqaTechnical" /></td>
					 
				</tr>
			</s:iterator>

		</table>
	</div>

</body>
</html>