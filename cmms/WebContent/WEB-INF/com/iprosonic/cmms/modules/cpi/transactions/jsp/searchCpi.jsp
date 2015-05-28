<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search CPI</title>
<sj:head jqueryui="true" />
<s:head />
</head>

<body>

	<div class="myHeader">Search CPI</div>

	<form action="SearchCpiAction" method="post">
		<s:push value="cpiBean">
			<table align="center">
				<tr>
					<td>From Date:</td>
					<td><sj:datepicker value="%{dateOfCpi}" name="fromDate"
							displayFormat="yy-mm-dd" cssStyle="width:108px">
						</sj:datepicker></td>
				<tr>
					<td>To Date:</td>
					<td><sj:datepicker value="%{dateOfCpi}" name="toDate"
							displayFormat="yy-mm-dd" cssStyle="width:108px">
						</sj:datepicker></td>

				</tr>

				<s:select list="#session.cpiCd" headerKey="-Select-"
					headerValue="-Select-" name="cpiCd" label="CPI Code"
					cssStyle="width:145px" />

				<s:select list="#session.cpiStatus" headerKey="-Select-"
					headerValue="-Select-" name="cpiStatus" label="CPI Status"
					cssStyle="width:145px" />


				<s:select list="#session.assetCd" headerKey="-Select-"
					headerValue="-Select-" name="assetName" label="Asset Code"
					cssStyle="width:145px" />


				<s:select list="#session.sectionSerialNo" headerKey="-Select-"
					headerValue="-Select-" name="sectionSerialNo"
					label="Section Serial No" cssStyle="width:145px" />

			</table>
			<br/>
			<s:submit align="center" value="search" cssClass="myButton" />
		</s:push>
	</form>

	<br>

	<s:if test="cpiBeanList.size()> 0">
		<div class="content">
			<table class="userTable" cellpadding="5px" width="100%">
				<tr class="even">
					<th>Edit</th>
					<th>SL No</th>
					<th>CPI Cd</th>
					<th>CPI Status</th>

					<th>AssetCd</th>
					<th>SectionSrNo</th>


					<th>LocationCd</th>
					<th>UnitCd</th>
					<th>ClientCd</th>
					<th>MaintainenceType</th>
					<th>Priority</th>

				</tr>

				<s:iterator value="cpiBeanList">
					<tr
						class="<s:if test="#userStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td><s:url id="editURL" action="EditCpiAction">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}">Edit</s:a></td>

						<td><s:property value="id" /></td>
						<td><s:property value="cpiCd" /></td>
						<td><s:property value="cpiStatus" /></td>

						<td><s:property value="assetName" /></td>
						<td><s:property value="sectionSerialNo" /></td>
						<td><s:property value="locationCd" /></td>
						<td><s:property value="unitCd" /></td>
						<td><s:property value="clientCd" /></td>
						<td><s:property value="maintanenceType" /></td>
						<td><s:property value="priority" /></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</s:if>

</body>
</html>