<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> cmms
</title>
</head>
<body>
	<table border="0" cellpadding="0" cellspacing="0" align="center"
		width="80%">
		<tr>
			<td>
				<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>
<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setDateHeader("Expires", -1);
%>
<link type="text/css" href="css/menu.css" rel="stylesheet" />

<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/table.css" />
<link rel="stylesheet" type="text/css" href="css/tab.css" />
 

<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
<script type="text/javascript" src="js/jquery.autocomplete.js"></script>
<div>
	<table width="100%" border="0" align="center" cellpadding="0"
		cellspacing="0">
		<tr>
			<td width="500px" height="90px" align="center" valign="bottom">
				<img src="images/workorder-topbar.png" width="1110px">

			</td>
		<tr>
		<tr>
			<td colspan="2">
				<hr />
			</td>
		</tr>
	</table>
</div>
</head>
			</td>
		</tr>
		<tr>
			<td>
				<link rel="stylesheet" type="text/css" href="css/header.css" />
<link rel="stylesheet" type="text/css" href="css/button.css" />

<%@ taglib uri="/struts-tags" prefix="s"%>
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
				</div>
			</li>
		</s:if>
	</ul>
	<ul class="menu">
		<s:if test="%{#session.module2.equalsIgnoreCase('Cpi')}">
			<li><a href="#" class="parent" tabindex="-2"><span>CPI</span>
			</a>
				<div>
					<ul>
						<li><a href="InitCPIAction.action"><span> New CPI
									&nbsp;</span> </a></li>
						<li><a href="InitSearchCPIAction.action"><span>
									Search CPI &nbsp;</span> </a></li>
						<li><a href="InitPrintCpiAction.action"><span>
									Print CPI &nbsp;</span> </a></li>
					</ul>
				</div>
			</li>
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
				</div>
			</li>
		</s:if>
	</ul>

	<ul class="menu">
		<s:if test="%{#session.module4.equalsIgnoreCase('Report')}">
			<li><a href="#" class="parent" tabindex="-2"><span>REPORT</span>
			</a>
				<div>

					<ul>
						 
						<li><a href="EngWiseConsolidateServiceReport.action"><span>
									Service Report Consolidate(Engineer) </span> </a>
						</li>
						<li><a href="ReportEngWise.action"><span>
									Service Report Detail(Engineer)</span> </a>
						</li>
						<li><a href="CrewWiseConsolidateServiceReport.action"><span>
									 Service Report Consolidate(Crew)</span> </a>
						</li>
						<li><a href="ReportCrewWise.action"><span>
									 Service Report Detailed(Crew)</span> </a>
						</li>
					</ul>
				</div></li>
		</s:if>
		</ul>
 
		<ul class="menu">
		   <li><a href="Dashboard.action" class="parent" tabindex="-2"><span>DashBoard</span>
			</a>
			</li>
		
		</ul>
 
		 
		
		
</div>
<center>
	<table border="0" width="100%" >
		 
			 
				<tr align="center">
					<td>
						Welcome : <s:property	value="#session.employeeName" /> 
					</td>
					<td>
						Location : <s:property value="#session.locationCd"/>
					</td>
					<td>
						Role : <s:property value="#session.role"/>
					</td>
					<td>
						<a href="LogOutAction.action">LogOut</a>
					</td>
					
					
				</tr>
			
		 
		 
	</table>
</center>
				
			</td>
		</tr>
		<tr>
			<td> 
					<%@ page import="java.util.Date"%>
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


<body style="height:800px;">
	<center>
		<div style="background-color: #F0DC82; width: 60%; margin-top: 200px">
			<font size="6" color="red"><b> Welcome to Work Order
					Management System</b> </font>
		</div>

	</center>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
</body>
</html>
				
			</td>
		</tr>
		<tr>
			<td><center>
<br/>
	<a href="http://www.iprosonic.com">Designed by www.iprosonic.com</a>
</center>
</td>
		</tr>
	</table>
</body>
</html>
