<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", -1);
%>

<link rel="stylesheet" type="text/css" href="css/menu.css" />
<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<link rel="stylesheet" type="text/css" href="css/tab.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />
<script type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="js/jquery.autocomplete.js"></script>
</head>

<div id="menu">
	<ul class="menu">
		<s:if test="%{#session.module1.equalsIgnoreCase('MST')}">
			<li><a href="#" class="parent" tabindex="-1"><span>Masters</span>
			</a>
				<div>
					<ul>
						<li><a href="InitLocationMstAction.action"><span>
									Add Location &nbsp;</span> </a></li>
						<li><a href="InitClientMstAction.action"><span>
									Add Client &nbsp;</span> </a></li>
						<li><a href="InitEmployeeMstAction.action"><span>
									Add Employee &nbsp;</span> </a></li>
						<li><a href="InitSearchEmployeeAction.action"><span>
									Search Employee &nbsp;</span> </a></li>
						<li><a href="InitAssetAction.action"><span>Add
									Asset &nbsp;</span> </a></li>
						<li><a href="InitSearchAssetAction.action"><span>
									Search Asset &nbsp;</span> </a></li>

						<li><a href="./InitServieMasterAction.action"><span>Add
									Service &nbsp;</span> </a></li>
						<li><a href="InitSearchServiceMasterAction.action"><span>
									Search Service &nbsp;</span> </a></li>
					</ul>
				</div></li>
		</s:if>
	</ul>
	<ul class="menu">
		<s:if test="%{#session.module2.equalsIgnoreCase('Cpi')}">
			<li><a href="#" class="parent" tabindex="-2"><span>CPI</span>
			</a>
				<div>
					<ul>
						<li><a href="InitCPIAction.action"><span> Create CPI
									&nbsp;</span> </a></li>
						<li><a href="InitSearchCPIAction.action"><span>
									Search CPI &nbsp;</span> </a></li>
						<li><a href="InitPrintCpiAction.action"><span>
									Print CPI &nbsp;</span> </a></li>
					</ul>
				</div></li>
		</s:if>
	</ul>

	<ul class="menu">
		<s:if test="%{#session.module3.equalsIgnoreCase('Was')}">
			<li><a href="#" class="parent" tabindex="-2"><span>WAS</span>
			</a>
				<div>
					<ul>
						<li><a href="InitCreateJobAction.action"><span>
									Create Job &nbsp;</span> </a></li>

						<li><a href="InitSearchJobAction.action"><span>
									Search Job &nbsp;</span> </a></li>
					</ul>
				</div></li>
		</s:if>
	</ul>

	<ul class="menu">
		<s:if test="%{#session.module4.equalsIgnoreCase('Report')}">
			<li><a href="#" class="parent" tabindex="-2"><span>REPORT</span>
			</a>
				<div>

					<ul>

						<li><a href="EngWiseConsolidateServiceReport.action"><span>
									Service Report Consolidate(Engineer) </span> </a></li>
						<li><a href="ReportEngWise.action"><span> Service
									Report Detail(Engineer)</span> </a></li>
						<li><a href="CrewWiseConsolidateServiceReport.action"><span>
									Service Report Consolidate(Crew)</span> </a></li>
						<li><a href="ReportCrewWise.action"><span> Service
									Report Detailed(Crew)</span> </a></li>
					</ul>
				</div></li>
		</s:if>
	</ul>

	<ul class="menu">
		<li><a href="Dashboard.action" class="parent" tabindex="-2"><span>DashBoard</span>
		</a></li>
	</ul>
</div>
<center>
	<table border="0" width="100%">
		<tr align="center">
			<td>Welcome : <s:property value="#session.employeeName" />
			</td>
			<td>Location : <s:property value="#session.locationCd" />
			</td>
			<td>Role : <s:property value="#session.role" />
			</td>
			<td><a href="LogOutAction.action">LogOut</a></td>


		</tr>



	</table>
</center>
