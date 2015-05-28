
<%@page import="com.iprosonic.cmms.modules.job.transactions.job.domain.JobServiceBean"%>
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
	alert("Service updated successfully please close these window and referce parent window manually");
	self.close();
		
		
	}

function insertService() {
	document.editservice.submit();
	alert("Service insert successfully please close these window and referce parent window manually");
	self.close();
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
</script>
<head>

 <%String serviceName =jobServiceBean.getServiceName();%>
<script type="text/javascript">
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
<body  onload="disableField();setRole(role);disable_fields_in_service(serviceName)">

	
	<div align="center" style="padding-top: 2%">
		<form name="editservice" id="editservice" action="InsertJobServiceAction.action">
			    
				
				<input type="hidden"
				name="serviceNo" value='<%=jobServiceBean.getServiceNo()%>'>
				
				<input
				type="hidden" name="runNo" value='<%=jobServiceBean.getRunNo()%>'>
			    
			    <input type="hidden" name="jobNo"
				value='<%=jobServiceBean.getJobNo()%>'> 
				

			<div id="header1" align="center"
				style="background-color: RED; width: 90%; font: 400PX; font-size: 18PX;">
				<b>Insert Service</b>
			</div>

			<s:push value="jobServiceBean">
		     <table cellpadding="5%" width="90%" style="border: 1px solid black;">
					<tr>
						<td style="width: 166px; height: 1px;"><s:select
								name="serviceType" cssClass="ser" label="Service Type"
								labelposition="left" cssStyle="bgColor:red;width:160px;"
								list="#{'-Select-':'-Select-', 'OH':'OH', 'CH':'CH', 'I/O':'I/O','OH/CH':'OH/CH'}"
								style="width: 160px;" onclick="getServiceName(this)">
							</s:select></td>


						<td class="ser">Service Name</td>
						<td class="ser"><select name="serviceName" id="serviceName"
							style="width: 130px;" onchange="disable_fields_in_service(this)">
								<option value=""></option>

						</select></td>

						<td class="ser">Loss Time</td>
						<td class="ser">
						
						<input id="lossTime" type="text" value="" size="17" value='0'
								name="lossTime"/> 
						</td>
						<td class="ser">Serial No.</td>
						<td class="ser"><input type="text" name="serialNo"
							id="serialNo" value="" />
						</td>
					</tr>



					<tr class='ser'>
						<td>Asset Code</td>
						<td><input type="text" id="assetCd" name="assetCd"
							id="assetCd" value="" /></td>

						<td>Deepest Depth</td>
						<td><input type="text" name="deepestDepth" id="deepestDepth"
							value="" />
						</td>


						<td>Meterage Logged</td>
						<td><input type="text" name="meterageLogged"
							id="meterageLogged"
							value="" />
						</td>

						<td>Meterage Perforated</td>
						<td><input type="text" name="meteragePerforated"
							id="meteragePerforated"
							value="" />
						</td>



					</tr>



					<tr class='ser'>

						<td>Chruns</td>
						<td><input type="text" name="chruns" id="chruns"
							 />
						</td>

						<td>Chmis Runs</td>
						<td><input type="text" name="chmisRuns" id="chmisRuns"
							 />
						</td>

						<td>Spf</td>
						<td><input type="text" name="spf" id="spf"
							 />
						</td>



						<td>Cores Count</td>
						<td><input type="text" name="coresCount"
							 id="coresCount" />
						</td>


					</tr>

					<tr class="ser">
						<td>Surface Pressure</td>
						<td><input type="text" name="surfacePressure"
							id="surfacePressure"
							 />
						</td>

						<td>Level Count</td>
						<td><input type="text" name="levelCount" id="levelCount"
							 />
						</td>
						<td>Pretest Count</td>
						<td><input type="text" name="pretestCount" id="pretestCount"
							 />
						</td>

						<td>DryTest Count</td>
						<td><input type="text" name="dryTestCount" id="dryTestCount"
							 />
						</td>




					</tr>

					<tr class='ser'>

						<td>PumpOut Time</td>
						<td><input type="text" name="pumpOutTime" id="pumpOutTime"
							 />
						</td>


						<td>PVT Sample</td>
						<td><input type="text" name="pvtSample" id="pvtSample"
							 />
						</td>


						<td>Normal Sample</td>
						<td><input type="text" name="normalSample" id="normalSample"
							 />
						</td>

						<td>Rev($)</td>
						<td><input type="text" name="rev" id="rev"
							 />
						</td>
					</tr>

					<tr class='ser'>


						<td>Remarks</td>
						<td><input type="text" name="remarks" id="remarks"
							 />
						</td>

						<td>FailureGroup</td>
						<td><input type="text" name="failureGroup" id="failureGroup"
							/>
						</td>

				      <td>Gun Size</td>
						 <td><input type="text" name="gunSize"
							id="gunSize"
							/>
						</td>
		
						
						<td>LogSend From Base</td>
						<td><input type="text" name="logRcieveAtBase"
							id="logRcieveAtBase"
							/>
						</td>

					</tr>


        

					<tr class='ser'>

						<td>LogRcieveAt Ho</td>
						<td><input type="text" name="logRcieveAtHo"
							id="logRcieveAtHo"  />
						</td>

						
		

						<td>LqaDone Date</td>
						<td><input type="text" name="lqaDoneDate" id="lqaDoneDate"
							/>
						</td>


						<td>
						   <s:select name="lqaTechnical" id="lqaTechnical" 
						   
						cssClass="ser" 
						
								labelposition="left" cssStyle="bgColor:red;width:160px;"	
								label="Lqa Technical"
								list="#{'-Select-':'-Select-', '1':'1', '2':'2', '3':'3','4':'4'}">

							</s:select> 
							<s:select name="lqaPresentation" id="lqaPresentation" 
								cssClass="ser" 
						
								labelposition="left" cssStyle="bgColor:red;width:160px;"	
						        label="Lqa Presentation"
								list="#{'-Select-':'-Select-', '1':'1', '2':'2', '3':'3','4':'4'}">

							</s:select></td>
						<td>Snp Snd</td>
						<td><input type="text" name="snpSnd"
							id="snpSnd"
							 />
						</td>
						<td>TCP Miss Run</td>
						<td><input type="text" name="tcpmissrun"
							id="tcpmissrun"
							 />
						</td>


					</tr>




					<tr>
						<td colspan="8" align="center">
							<div class="myHeader" align="center">
							<input type="button" value="Insert" id="update" class="myButton"
									onclick="insertService();" id="submit" />
								
							
								 <input type="button"
									value="Close" id="close" class="myButton"
									onclick="self.close();" id="submit" />


							</div></td>

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