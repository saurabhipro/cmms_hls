<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>

<sj:head jqueryui="true" />

<s:head />
<style type="text/css">
@import url(css/tablestyle.css);
</style>
</head>
<body>
	<fieldset>
		<form id="formValidate" action="MWasReportAction" method="post">
			<s:push value="cpiBean">
				<table align="center">
					<tr>
						<td>FromDate</td>
						<td><sj:datepicker value="%{new java.util.Date()}"
								name="fromDate" displayFormat="yy-mm-dd" cssStyle="width:108px">
							</sj:datepicker>
						</td>
					</tr>
					<tr>
						<td>ToDate</td>
						<td><sj:datepicker value="%{new java.util.Date()}"
								name="toDate" displayFormat="yy-mm-dd" cssStyle="width:108px">
							</sj:datepicker>
						</td>

					</tr>

					<tr>
						<s:select list="#session.cpiCd" headerKey="-Select-"
							headerValue="-Select-" name="cpiCd" label="Cpi Code"
							cssStyle="width:145px" />
					</tr>
					<tr>
						<s:select list="#session.unitCd" headerKey="-Select-"
							headerValue="-Select-" name="unitCd" label="UnitCd"
							cssStyle="width:145px" />
					</tr>
					<tr>
					  <s:select list="#session.cpiStatus" 
						headerKey="-Select-"
						headerValue="-Select-" 
						name="cpiStatus" 
						label="Cpi Status" 
						cssStyle="width:145px"
						/>
						
					</tr>
					<s:submit align="center"  value="GenerateExcel" />

				</table>
			</s:push>
		</form>
	</fieldset>

	<br>
	<s:if test="cpiBeanList.size()> 0">
		<div class="content">
			<table class="userTable" cellpadding="5px" width="100%">
				<tr class="even">
					<th>SL No</th>
					<th>CPICd</th>
					<th>Location</th>
					<th>ToolCd</th>
					<th>Tool SN</th>
					<th>Problem Details</th>
					<th>CpiOpenDate</th>
					<th>Code Of Ccorrective Action</th>
					<th>CA Assign Date</th>
					<th>CA DONE Date</th>
					<th>CaDoneBy</th>
					<th>RemarksOnCpi</th>
					<th>UpdateDateOfCpi</th>
					<th>StatusOfCpi</th>
					<th>WhyOpen</th>
					<th>MrfNo</th>
					<th>RemarksOnMrf</th>
					<th>PrimRca</th>
					<th>Date Prca Done</th>
					<th>TypeOfCpi</th>
					<th>Imapcat To Customer</th>
					<th>Effect On Customer</th>
					<th>Source Of Cpi</th>
					<th>Category Code</th>
					<th>Group Code</th>
					
				</tr>

				<s:iterator value="cpiBeanList">
					<tr
						class="<s:if test="#userStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td><s:property value="id" /></td>
						<td><s:property value="cpiCd" />
						</td>
						<td><s:property value="locationCd" />
						</td>
						<td><s:property value="assetType4" />
						</td>
						<td><s:property value="sectionSerialNo1" />
						</td>
						<td><s:property value="problem" />
						</td>
						<td><s:property value="openDate1" />
						</td>
						<td><s:property value="correctiveActionCode1" />
						</td>
						<td><s:property value="prcaAssignedTo" />
						</td>
						<td><s:property value="closeDate1" />
						</td>
						<td><s:property value="correctiveActionDoneBy1" />
						</td>
						<td><s:property value="correctiveAction1" />
						</td>
						<td><s:property value="updateDate" />
						</td>
						<td><s:property value="cpiStatus" />
						</td>
						<td><s:property value="whyOpen" />
						</td>
						<td><s:property value="mrfNo" />
						</td>
						<td><s:property value="remarksOnMrf" />
						</td>
						<td><s:property value="prcaReport" />
						</td>
						<td><s:property value="dateOfPrca" />
						</td>
						<td><s:property value="typeOfCpi" />
						</td>
						<td><s:property value="impactToCoustomer" />
						</td>
						<td><s:property value="effectOnCustomer" />
						</td>
						<td><s:property value="sourceOfCpi" />
						</td>
						<td><s:property value="category" />
						</td>
						<td><s:property value="groupCode" />
						</td>

					</tr>
				</s:iterator>
			</table>
		</div>
	</s:if>


</body>


</html>
