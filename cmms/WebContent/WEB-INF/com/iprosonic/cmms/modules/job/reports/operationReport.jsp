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
			action="EngWiseConsolidateServiceReport.action" method="post">


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
				<td colspan="2"><s:submit value="Search" align="center"></s:submit>
				</td>
			</tr>
		</s:form>
	</center>


	<div class="container">
		<table class="userTable" align="center" cellpadding="5px">
			<tr class="even">
				<th align="center">Engineer</th>
			<!-- 	<th align="center">RigUp</th>
				<th align="center">RigDown</th> -->
				<th align="center">LQAT</th>
				<th align="center">LQAP</th>
				<th align="center">CH Runs</th>
				<th align="center">LT</th>
				<th align="center">OT</th>
				<th align="center">Jobs</th>
				<th align="center">Service</th>
				<th align="center">Service(LT)</th>
				<th align="center">OE</th>
				<th align="center">SE</th>
				<th align="center">CH MissRun</th>
				<th align="center">Run Effi.</th>
				 
			</tr>

			<s:iterator value="operationList">
				<tr>
					<td align="center"><s:property value="engName" /></td>

					<%-- <s:if test="totalRigUp != '0 Hrs,0 Mins'">
						<td style="color: rgb(20, 20, 19); background-color: rgb(12, 241, 223); " align="center"><s:property
								value="totalRigUp" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="totalRigUp" /></td>
					</s:else>


					<s:if test="totalRigDown != '0 Hrs,0 Mins'">
						<td align="center" style="color: yellow; background-color: green;"><s:property
								value="totalRigDown" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="totalRigDown" /></td>
					</s:else> --%>

					<s:if test="totalLQAT != '0%'">
						<td  align="center" style="color: rgb(100, 20, 243); background-color: rgb(51, 247, 51);"><s:property
								value="totalLQAT" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="totalLQAT" /></td>
					</s:else>

					<s:if test="totalLQAP != '0.0%'">
						<td align="center" style="color: rgb(26, 26, 24); background-color: pink;"><s:property
								value="totalLQAP" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="totalLQAP" /></td>
					</s:else>

					<s:if test="totalCHRuns != 0">
						<td align="center" style="color: yellow; background-color: gray;"><s:property
								value="totalCHRuns" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="totalCHRuns" /></td>
					</s:else>

					<s:if test="totalLT != '0.0 Hrs'">
						<td align="center" style="color: yellow; background-color: rgb(114, 21, 233);"><s:property
								value="totalLT" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="totalLT" /></td>
					</s:else>

					<s:if test="totalOT != '0 Hrs,0 Mins'">
						<td align="center" style="color: yellow; background-color: rgb(231, 74, 238);"><s:property
								value="totalOT" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="totalOT" /></td>
					</s:else>
					
					 <s:if test="totalNoJobs != 0">
						<td align="center" style="color: black; background-color: rgb(0, 224, 255);"><s:property
								value="totalNoJobs" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="totalNoJobs" /></td>
					</s:else>
					
					 <s:if test="totalNoServices != 0">
						<td align="center" style="color: black; background-color: yellow;"><s:property
								value="totalNoServices" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="totalNoServices" /></td>
					</s:else>
					

					<s:if test="totalNoLossTime >= 1">
						<td align="center" style="color:  yellow; background-color: blue"><s:property
								value="totalNoLossTime" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="totalNoLossTime" /></td>
					</s:else>
					
					<s:if test="totalOE != '0.0%'">
						<td align="center" style="color: black; background-color: orange"><s:property
								value="totalOE" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="totalOE" /></td>
					</s:else>
					
					<s:if test="totalSE != '0.0%'">
						<td align="center" style="color: yellow; background-color: red"><s:property
								value="totalSE" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="totalSE" /></td>
					</s:else>


					<s:if test="totalNoCHMissRuns >= 1">
						<td align="center" style="color: blue; background-color: yellow"><s:property
								value="totalNoCHMissRuns" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="totalNoCHMissRuns" /></td>
					</s:else>
					
					<s:if test="RunEfficiency != '0.0%'">
						<td align="center" style="color: blue; background-color: orange;"><s:property
								value="RunEfficiency" /></td>
					</s:if>
					<s:else>
						<td align="center"><s:property value="RunEfficiency" /></td>
					</s:else>
										 

				</tr>
			</s:iterator>

		</table>	
	</div>

</body>
</html>