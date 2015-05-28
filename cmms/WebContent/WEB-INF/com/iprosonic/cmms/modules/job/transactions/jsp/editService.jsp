<%@page
	import="com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean"%>
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


function updateService() {
	document.editservice.submit();
		
		
	}
	
	function getServiceName(obj) {
	 
		var serviceType = document.getElementById("serviceType").value;
		url = 'GetListAction.action?param=getServiceName' + '&serviceType='
				+ serviceType;
		$.post(url, function(results) {
			$('.result').html(results);
			destinationCombo = document.getElementById("serviceName");
			appValuesInCombo(results, destinationCombo);

		});
	}

</script>

 

<%
	JobServiceBean jobServiceBean = (JobServiceBean) request
			.getAttribute("jobServiceBean");
%>

<script>

	$("#assetCd1").autocomplete("getAssetCd.jsp");
script>
<head>

<%String serviceName = jobServiceBean.getServiceName();%>
<script type="text/javascrit>
	var role = "<%=session.getAttribute("role")%>";
</script>
</head>



<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Service</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<sj:head jqueryui="true" />

<style type="text/css">
</style>
</head>
<body
	onload="disableField();setRole(role);disable_fields_in_service(serviceName)">
 
	<div align="center" style="padding-top: 2%">
		<form name="editservice" id="editservice"
			action="UpdateJobServiceAction.action">


			<input type="hidden" name="serviceNo"
				value='<%=jobServiceBean.getServiceNo()%>'> <input
				type="hidden" name="runNo" value='<%=jobServiceBean.getRunNo()%>'>

			<input type="hidden" name="jobNo"
				value='<%=jobServiceBean.getJobNo()%>'>


			<div id="header1" align="center"
				style="background-color: RED; width: 90%; font: 400PX; font-size: 18PX;">
				<b>EDIT Service</b>
			</div>

			<s:push value="jobServiceBean">
				<table cellpadding="5%" width="90%" style="border: 1px solid black;">
					<tr class='ser'>
						
						<td style="width: 166px; height: 1px;"><s:select
								name="serviceType" cssClass="ser" label="Service Type"
								labelposition="left" cssStyle="bgColor:red;width:160px;"
								list="#{'-Select-':'-Select-', 'OH':'OH', 'CH':'CH', 'IO':'IO','TCP-PERFO':'TCP-PERFO'}"
								style="width: 160px;" onclick="getServiceName(this)">
							</s:select></td>


						<td class="ser">Service Name</td>
						<td class="ser"><select name="serviceName" id="serviceName"
							style="width: 130px;" onchange="disable_fields_in_service(this)">
								<option value="<%=jobServiceBean.getServiceName()%>"><%=jobServiceBean.getServiceName()%></option>

						</select></td>

						<td class="ser">Loss Time</td>
						<td class="ser"><input id="lossTime" type="text"
							value="<%=jobServiceBean.getLossTime()%>" size="17" value='0'
							name="lossTime" onblur="resetToZero(this);" /></td>
						
						<td class="ser">Deepest Depth</td>
						<td class="ser"><input type="text" name="deepestDepth" id="deepestDepth"
							value="<%=jobServiceBean.getDeepestDepth()%>" onblur="resetToZero(this);" /></td>
								
					</tr>
					
					<tr class='ser'>
							
						
						<td>Meterage Logged</td>
						<td><input type="text" name="meterageLogged"
							id="meterageLogged" onblur="resetToZero(this);"
							value="<%=jobServiceBean.getMeterageLogged()%>" /></td>
						<td>Rev($)</td>
						<td><input type="text" name="rev" id="rev" onblur="resetToZero(this);"
							value="<%=jobServiceBean.getRev()%>" /></td>
						
						<td class="ser">FailureGroup</td>
						<td class="ser"><input type="text" name="failureGroup" id="failureGroup" onblur="resetToZero(this);"
							value="<%=jobServiceBean.getFailureGroup()%>" /></td>
								
					<td>Pretest Count</td>
						<td><input type="text" name="pretestCount" id="pretestCount"
							value="<%=jobServiceBean.getPretestCount()%>" /></td>
					
					
					
					</tr>
					<tr class='ser'>
						<td>PumpOut Time</td>
						<td><input type="text" name="pumpOutTime" id="pumpOutTime" onblur="resetToZero(this);"
							value="<%=jobServiceBean.getPumpOutTime()%>" /></td>
						<td>DryTest Count</td>
						<td><input type="text" name="dryTestCount" id="dryTestCount" onblur="resetToZero(this);"
							value="<%=jobServiceBean.getDryTestCount()%>" /></td>
						
						<td>PVT Sample</td>
						<td><input type="text" name="pvtSample" id="pvtSample" onblur="resetToZero(this);"
							value="<%=jobServiceBean.getPvtSample()%>" /></td>

						<td>Normal Sample</td>
						<td><input type="text" name="normalSample" id="normalSample" onblur="resetToZero(this);"
							value="<%=jobServiceBean.getNormalSample()%>" /></td>
							
						
						
					</tr>
					<tr class='ser'>
							<td>Level Count</td>
						<td><input type="text" name="levelCount" id="levelCount"
							value="<%=jobServiceBean.getLevelCount()%>" /></td>
						<td>Cores Count</td>
						<td><input type="text" name="coresCount"
							value="<%=jobServiceBean.getCoresCount()%>" id="coresCount" /></td>
						<td>Gun Size</td>
						<td><input type="text" name="gunSize" id="gunSize" onblur="resetToZero(this);"
							value="<%=jobServiceBean.getGunSize()%>" /></td>
						
						<td>Spf</td>
						<td><input type="text" name="spf" id="spf" onblur="resetToZero(this);"
							value="<%=jobServiceBean.getSpf()%>" /></td>	
					</tr>
					
					<tr class='ser'>
						<td>Meterage Perforated</td>
						<td><input type="text" name="meteragePerforated"
							id="meteragePerforated" onblur="resetToZero(this);"
							value="<%=jobServiceBean.getMeteragePerforated()%>" /></td>
						<td>Surface Pressure</td>
						<td><input type="text" name="surfacePressure"
							id="surfacePressure"
							value="<%=jobServiceBean.getSurfacePressure()%>" /></td>
						<td>Chruns</td>
						<td><input type="text" name="chruns" id="chruns" onblur="resetToZero(this);"
							value="<%=jobServiceBean.getChruns()%>" /></td>
						<td>Chmis Runs</td>
						<td><input type="text" name="chmisRuns" id="chmisRuns" onblur="resetToZero(this);"
							value="<%=jobServiceBean.getChmisRuns()%>" /></td>

					
						
							
					</tr>
					<tr class='ser'>
						<td>TCPMissRun: </td>
						<td><input type="text"
							name="tcpmissrun" id='tcpmissrun'
							value="<%=jobServiceBean.getTcpmissrun()%>" />
						</td>
						
						<td>Asset Code</td>
						<td><input type="text" id="assetCd" name="assetCd"
							id="assetCd" onblur="resetToZero(this); value="<%=jobServiceBean.getAssetCd()%>" /></td>
							
						<td class="ser">Serial No.</td>
						<td class="ser"><input type="text" name="serialNo"
							id="serialNo" onblur="resetToZero(this);" value="<%=jobServiceBean.getSerialNo()%>" /></td>
						<td>Engi: </td><td><input type="text"
							name="engi" id='<%=jobServiceBean.getServiceNo()%>' onclick="openEmployeeListForEdit('<%=jobServiceBean.getServiceNo()%>');"
							value="<%=jobServiceBean.getEngi()%>" />
						</td>
					</tr>
					
					<tr class='ser'>
						<td>Crew: </td><td><input type="text"
							name="crew" id='crew' onclick="openCrewListForEdit('crew');"
							value="<%=jobServiceBean.getCrew()%>" />
						</td>
						
						
						<td>Remarks</td>
						<td><input type="text" name="remarks" id="remarks"
							value="<%=jobServiceBean.getRemarks()%>" /></td>
							
						<td>LogSend From Base</td>
						<td><input type="text" name="logRcieveAtBase"
							id="logRcieveAtBase"
							value="<%=jobServiceBean.getLogSendFromBase()%>" /> <a
							href="javascript:NewCal('logRcieveAtBase','ddmmmyyyy',false,24)"><img
								src="images/cal.gif" width="24" height="16" border="0"
								alt="Pick a date"> </a></td>
							
						<td>LogRcieveAt Ho</td>
						<td><input type="text" name="logRcieveAtHo"
							id="logRcieveAtHo" value="<%=jobServiceBean.getLogRcieveAtHo()%>" />
							<a href="javascript:NewCal('logRcieveAtHo','ddmmmyyyy',false,24)"><img
								src="images/cal.gif" width="24" height="16" border="0"
								alt="Pick a date"> </a></td>	
					</tr>
					<tr class='ser'>
					<td>LqaDone Date</td>
						<td><input type="text" name="lqaDoneDate" id="lqaDoneDate" />
							<a href="javascript:NewCal('lqaDoneDate','ddmmmyyyy',false,24)"><img
								src="images/cal.gif" width="24" height="16" border="0"
								alt="Pick a date"> </a></td>
								
					<td>LQA Technical:</td>
					<td><input type="text" name="lqaTechnical"
							id="lqaTechnical" value="<%=jobServiceBean.getLqaTechnical()%>" />
						</td>
									
					<td>LQA Presentation: </td>
					<td><input type="text"
							name="lqaPresentation" id="lqaPresentation"
							value="<%=jobServiceBean.getLqaPresentation()%>" />
						</td>
						
					<td>Snp Snd</td>
						<td><input type="text" name="snpSnd" id="snpSnd" onblur="resetToZero(this);"
							value="<%=jobServiceBean.getSnpSnd() == null ? "NA"
						: jobServiceBean.getSnpSnd()%>"  />
						</td>
						
					 
							
									
					</tr>


					<tr>
						<td colspan="8" align="center">
							<div class="myHeader" align="center">
								<input type="button" value="Update" id="update" class="myButton"
									onclick="updateService();" id="submit" /> <input type="button"
									value="Close" id="close" class="myButton"
									onclick="self.close();" id="submit" />


							</div>
						</td>

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

