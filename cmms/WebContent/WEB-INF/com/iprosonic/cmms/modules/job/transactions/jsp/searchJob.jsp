<%@page import="java.util.Date"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<script type="text/javascript" src="js/searchasset.js">
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<sj:head jqueryui="true" />
<style type="text/css">
@import url(css/tablestyle.css);
</style>

<sj:head />
<script type="text/javascript">
	$(document).ready(function() {
		$("#myTable").tablesorter();
	});
</script>
</head>
<body>




	<div class="container">

		<s:form id="formValidate" theme="qxhtml"
			action="SearchJobAction.action" method="post">

			<div class="myHeader">Search Job(s)</div>

			<s:push value="jobBean">
				<table align="center">
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
						<td><s:select list="#session.locationList"
								cssStyle="width:150px;" headerValue="-Select-"
								headerKey="-Select-" value="locationCd" name="locationCd"
								id="locationCd" label="Location">
							</s:select></td>
					</tr>

					<tr>
						<td><s:select list="#session.clientNameList"
								cssStyle="width:150px;" headerValue="-Select-"
								headerKey="-Select-" value="clientName" name="clientName"
								id="clientName" label="ClientName">
							</s:select></td>
					</tr>


					<tr>
						<td><s:select list="#session.statusList"
								cssStyle="width:150px;" headerValue="-Select-"
								headerKey="-Select-" value="status" name="jobStatus"
								id="jobStatus" label="Status">
							</s:select></td>
					</tr>



					<tr>
						<td style="align: center;"><input type="submit"
							align="center" value="Search" class="myButton" /></td>
						<td><s:if test="jobList.size()> 0">
								<a href="DownloadAllJob.action"><input class="myButton"
									type="button" value="Download"> </a>
							</s:if></td>


					</tr>
					</s:push>
					</s:form>

					<s:if test="jobList.size()> 0">
						<table id="myTable" align="center" cellpadding="5px" width="90%"
							class="tablesorter userTable">
							<thead>
								<tr class="even">
									<th>HLS Job No</th>
									<th>Job No</th>
									<th>Unit No</th>
									<th>Client Name</th>
									<th>Job Date</th>
									<th>Job Status</th>
									<th>Edit</th>
									<th>Download</th>
									<%
										if (session.getAttribute("role").equals("ADMIN")) {
									%>
									<th>Delete Job</th>
									<%
										}
									%>

								</tr>
							</thead>
							<tbody>
								<s:iterator value="jobList">
									<tr
										class="<s:if test="#userStatus.odd == true ">odd</s:if><s:else>even</s:else>">
										<td><s:property value="jobNoHlsa" /></td>

										<td><s:property value="jobNo" /></td>
										<td><s:property value="unitNo" /></td>
										<td><s:property value="clientName" /></td>
										<td><s:property value="jobDate" /></td>
										<td><s:property value="jobStatus" /></td>

										<td><s:url id="editURL" action="EditJobAction.action">
												<s:param name="jobNo" value="%{jobNo}"></s:param>
											</s:url> <s:a href="%{editURL}">Edit</s:a></td>
										<td><s:url id="editURL"
												action="./DownloadExcelAction.action">
												<s:param name="jobNo" value="%{jobNo}"></s:param>
											</s:url> <s:a href="%{editURL}">Download</s:a></td>
										<%
											if (session.getAttribute("role").equals("ADMIN")) {
										%>
										<td><s:url id="deleteURL" action="./DeleteJob.action">
												<s:param name="jobNo" value="%{jobNo}"></s:param>
											</s:url> <s:a href="%{deleteURL}">Delete Job</s:a></td>
										<%
											}
										%>
									</tr>
								</s:iterator>
							<tbody>
						</table>
					</s:if>
					</div>
</body>
</html>
<script type="text/javascript" src="js/jquery.tablesorter.js"></script>
