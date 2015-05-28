<%@ page import="java.util.Date"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ include file="/WEB-INF/com/iprosonic/cmms/pjcommons/jsp/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CREATE JOB</title>
<link rel="stylesheet"	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="css/gridstyle.css" />
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>


<script type="text/javascript" src="js/stdlib.js"></script>
<script type="text/javascript" src="js/job/jobGrid.js"></script>
<script type="text/javascript" src="js/job/datetimepicker.js"></script>
<script type="text/javascript" src="js/jquery.combobox.js"></script>


<script type="text/javascript">
	var rigCount = '0';
	var role = '<%=session.getAttribute("role")%>';


	function disableButton() {
		disableButtonOnload('run');
		disableButtonOnload('ser');
		disableButtonOnload('exp');
	}
</script>

<style type="text/css">
label {
	font-weight: bold;
}
</style>
</head>


<body onload="setRigCount(rigCount);setRole(role);disableButton();">
	<div class="container">
		<s:if test="hasActionErrors()">
			<div class="errors">
				<s:actionerror />
			</div>
		</s:if>

		<table>
			<tr>
				<td>
					<form name="createJob" id="createJob" method="post"
						action="SaveJobAction.action">
						<table cellpadding="1" cellspacing="0">
							<div class="myHeader">
								<b>Create Job</b>
							</div>
							</br>
							<tr>
								<td><s:select label="UnitNo" id="unitNo" tabindex="1"
										list="#session.locationMstList" name="unitNo"
										headerKey="-Select-" cssStyle="width:150px;"
										headerValue="-Select-">
									</s:select></td>
								<td><b>Unit left Base/WellSite</b></td>
								<td><input id="unitLeftBase" type="text" size="17"
									value='0' name="unitLeftBase" readonly="readonly"> <a
									href="javascript:NewCal('unitLeftBase','ddmmmyyyy',true,24)"><img
										src="images/cal.gif" width="24" height="16" border="0"
										alt="Pick a date"> </a></td>


								<td><b>Safety Meet</b></td>
								<td><select name="safetyMeet" id="safetyMeet"
									style="width: 150px">
										<option value="-Select-">-Select-</option>
										<option value="Y">Y</option>
										<option value="N">N</option>
								</select></td>

							</tr>
							<tr>

								<td><b>Job No (HLSA)</b></td>
								<td><input type="text" name="jobNoHlsa" id="jobNoHlsa"
									tabindex="2" value="" /></td>
								<td><b>Unit reached WellSite</b></td>
								<td><input id="unitReachedSite" type="text" size="17"
									value='0' name="unitReachedSite" readonly="readonly"> <a
									href="javascript:NewCal('unitReachedSite','ddmmmyyyy',true,24)"><img
										src="images/cal.gif" width="24" height="16" border="0"
										alt="Pick a date"> </a></td>

								<td><b>EJCS1</b></td>

								<td><input type="text" name="ejcs1" id="ejcs1" value="" />
								</td>
							</tr>
							<tr>
								<td><b>Job Date</b></td>
								<td><input id="jobDate" type="text" size="17"
									value="${jobDate} " name="jobDate" readonly="readonly">
									<a href="javascript:NewCal('jobDate','ddmmyyyy',false,24)"><img
										src="images/cal.gif" width="24" height="16" border="0"
										alt="Pick a date" /> </a></td>

								<td><b>Unit left Wellsite</b></td>
								<td><input id="unitLeftSite" type="text" size="17"
									value='0' name="unitLeftSite" readonly="readonly"> <a
									href="javascript:NewCal('unitLeftSite','ddmmmyyyy',true,24)"><img
										src="images/cal.gif" width="24" height="16" border="0"
										alt="Pick a date"> </a></td>
								<td><b>EJCS2</b></td>
								<td><input type="text" name="ejcs2" id="ejcs2" value="" />
								</td>
							</tr>
							
							<tr>
								<td><s:select label="Client Name" id="clientName"
										list="#session.clientNameList" name="clientName"
										headerKey="-Select-" cssStyle="width:150px;"
										headerValue="-Select-">
									</s:select></td>

								<td><b>Unit reached Base/Wellsite</b></td>
								<td><input id="unitReachedBase" type="text" size="17"
									value='0' name="unitReachedBase" readonly="readonly"> <a
									href="javascript:NewCal('unitReachedBase','ddmmmyyyy',true,24)"><img
										src="images/cal.gif" width="24" height="16" border="0"
										alt="Pick a date"> </a></td>
								<td><b>EJCS3</b></td>
								<td><input type="text" name="ejcs3" id="ejcs3" value="" />
								</td>

							</tr>

							<tr>
								<td><b>Well No</b></td>
								<td><input type="text" name="wellNo" id="wellNo" /></td>

								<td><b>Weak Point(lbs)</b></td>
								<td><input type="text" name="wp" id="wp" value="" /></td>

								<td><b>EJCS4</b></td>

								<td><input type="text" name="ejcs4" id="ejcs4" value="" />
								</td>
							</tr>

							<tr>
								<td><b>Engineer</b></td>
								<td><input type="text" onclick="openEmployeeList();"
									name="engineer" id="engineer" value="" readonly="readonly" />
								</td>

								<td><b>Expl Van Mileage (kms)</b></td>
								<td><input type="text" name="vanMileage" id="vanMileage"
									value="" /></td>

								<td><b>EJCS5</b></td>

								<td><input type="text" name="ejcs5" id="ejcs5" value=""
									readonly='true' /></td>

							</tr>

							<tr>
								<td><b>Crew</b></td>
								<td><input type="text" name="crew" id="crew" value=""
									onclick="openCrewList();" readonly="readonly"></input></td>

								<td><b>Logging Truck Mileage (kms)</b></td>
								<td><input type="text" name="truckMileage"
									id="truckMileage" value="" /></td>


							</tr>

							<tr>
								<td><b>Remarks</b></td>
								<td colspan="8"><textarea rows="2" cols="110"
										name="remarks" id="remarks" value="NA"></textarea></td>
							</tr>


							<tr>
								<td colspan="6">
									<div class="myHeader">Well Information</div>
								</td>
							<tr>
							<tr>
								<td><b>Latitude</b></td>
								<td>Deg.<input type="text" name="latitude_d"
									id="latitude_d" value="" style="width: 20px" /> Min<input
									type="text" name="latitude_m" id="latitude_m" value=""
									style="width: 20px" /> Sec.<input type="text"
									name="latitude_s" id="latitude_s" value="" style="width: 35px" /></td>

								<td><b>Longitude</b></td>
								<td>Deg.<input type="text" name="longitude_d"
									id="longitude_d" value="" style="width: 20px" /> Min <input
									type="text" name="longitude_m" id="longitude_m" value=""
									style="width: 20px" /> Sec.<input type="text"
									name="longitude_s" id="longitude_s" value=""
									style="width: 40px" /></td>
							</tr>



							<tr>
								<td><b>Rig Name</b></td>
								<td><input type="text" name="rigName" id="rigName" value="" />
								</td>
								<td><b>Field</b></td>
								<td><input type="text" name="field" id="field" value="" />
								</td>
							</tr>
							<tr>
								<td><b>DF(m)</b></td>
								<td><input type="text" name="dl" id="dl" value="" /></td>
								<td><b>KB(m)</b></td>
								<td><input type="text" name="kb" id="kb" value="" /></td>
								<td><b>GL(m)</b></td>
								<td><input type="text" name="gf" id="gf" value="" /></td>
							</tr>


							<tr>
								<td><b>Casing Size(in)</b></td>
								<td><input type="text" name="casing_size" id="casing_size"
									value="" /></td>
								<td><b>CS Depth (m)</b></td>
								<td><input type="text" name="casing_size_at_depth"
									id="casing_size_at_depth" value="" /></td>
								<td><b>CS driller</b></td>
								<td><input type="text" name="csDriller" id="csDriller"
									value="" /></td>

							</tr>

							<tr>
								<td><b>TD Driller(m)</b></td>
								<td><input type="text" name="tdDriller" id="tdDriller"
									value="" /></td>
								<td><b>Bit size(in)</b></td>
								<td><input type="text" name="bitSize" id="bitSize" value="" />

								</td>
								<td><b>Deviation(degrees)</b></td>
								<td><input type="text" name="deviation" id="deviation"
									value="" /></td>
							</tr>

							<tr>
								<td><b>Start Circulation</b></td>
								<td><input id="startCirculation" type="text" size="17"
									value='0' name="startCirculation" readonly="readonly">
									<a
									href="javascript:NewCal('startCirculation','ddmmmyyyy',true,24)"><img
										src="images/cal.gif" width="24" height="16" border="0"
										alt="Pick a date"> </a></td>
								<td><b>Stop circulation</b></td>
								<td><input id="stopCirculation" type="text" size="17"
									value='0' name="stopCirculation" readonly="readonly"> <a
									href="javascript:NewCal('stopCirculation','ddmmmyyyy',true,24)"><img
										src="images/cal.gif" width="24" height="16" border="0"
										alt="Pick a date"> </a></td>
							</tr>
							<tr>
								<td colspan="6">
									<div class="myHeader">Mud Paramters</div>
								</td>
							<tr>
							<tr>
								<td><b>Density(gm/cc)</b></td>
								<td><input type="text" name="density" id="density" value="" />
								</td>
								<td><b>Viscosity(cptm) </b></td>
								<td><input type="text" name="viscosity" id="viscosity"
									value="" /></td>
								<td><b>PH(numerical value)</b></td>
								<td><input type="text" name="ph" id="ph" value="" /></td>
							</tr>

							<tr>
								<td><b>Salinity(ppm)</b></td>
								<td><input type="text" name="salinity" id="salinity"
									value="" /></td>
								<td><b>Barities</b></td>
								<td><input type="text" name="barities" id="barities"
									value="" /></td>
								<td><b>Solid</b></td>
								<td><input type="text" name="solid" id="solid" value="" />
								</td>
							</tr>

							<tr>
								<td colspan="6">
									<div class="myHeader">Mud Resistivity Parameters</div>
								</td>
							<tr>
							<tr>
								<td><b>RM(ohm-m) </b></td>
								<td><input type="text" name="rmValue" id="rmValue" value="" />
								</td>
								<td><b>RMF(ohm-m) </b></td>
								<td><input type="text" name="rmf" id="rmf" value="" /></td>
								<td><b>RMC(ohm-m) </b></td>
								<td><input type="text" name="rmc" id="rmc" value="" /></td>
							</tr>

							<tr>
								<td><b>RM Temperature (F)</b></td>
								<td><input type="text" name="rmTemp" id="rmTemp" value="" />
								</td>
							</tr>

							<tr>
								<td style="visibility: hidden;"><input type="text"
									name="mud" id="mud" value="NA" /></td>
								<td style="visibility: hidden;"><input type="text"
									name="mudResistivityParameters" id="mudResistivityParameters"
									value="NA" /></td>

							</tr>



							<tr style="background-color: lightgrey; height: 50px">
								<td colspan="6" align="center"><input type="button"
									class="myButton" id="rig" value="(+) Rig Up"
									onclick="addRig(this)" /> <input class="myButton"
									type="button" id="run" value="(+) Run" onclick="addRun(this)" />
									<input class="myButton" type="button" id="ser"
									value="(+) Service" onclick="addSer(this)" /> <input
									class="myButton" type="button" id="exp" value="(+) Exp"
									onclick="addExpl(this)" /> <input class="myButton"
									type="button" id="delete" value="(-) Row" onclick="deleteRow()" />
									<input class="myButton" type="button" id="reset"
									value="Reset Grid" onclick="resetGrid()" />
							</tr>

							<tr style="background-color: lightgrey;">
								<td colspan="6" align="center">
									<div id='loadingmessage' style='display: none'>
										<img src="images/pIkfp.gif" />
									</div>
								</td>

							</tr>
							<tr>
								<td colspan="8">
									<div align="center" style="background-color: yellow;">
										<marquee> Note - All time format are in 24 hrs
											sholuld be entered.</marquee>
										<br>
									</div>
								</td>
							</tr>



							<tr>
								<td colspan="8"><input type="hidden" id="hiddenRig"
									name="hiddenRig" value=''> <input type="hidden"
									id="hiddenRun" name="hiddenRun" value=''> <input
									type="hidden" id="hiddenSer" name="hiddenSer" value=''>
									<input type="hidden" id="hiddenExpl" name="hiddenExpl" value=''>
								</td>
							</tr>
							<tr>
								<td colspan="8">

									<div style="width: 1100px; height: 500px; overflow: scroll;">
										<table id="datatable"></table>
									</div>

								</td>
							</tr>

							<tr style="background-color: lightgrey; height: 50px">
								<td colspan="6" align="center"><input type="button"
									class="myButton" value='Save job' onclick="generateSubmitURL()">
							</tr>
						</table>
					</form>
				</td>
			</tr>
		</table>
	</div>
</body>

<div style="visibility: hidden;">
	Rigcount<input type="text" id="rigcount" value='0' readonly
		style="width: 70px;" /> Runcount<input type="text" id="runcount"
		value='0' readonly style="width: 70px;" /> Sercount<input type="text"
		id="sercount" value='0' readonly style="width: 70px;" /> Expcount<input
		type="text" id="explcount" value='0' readonly style="width: 70px;" />
</div>
</html>
<%@ include file="/WEB-INF/com/iprosonic/cmms/pjcommons/jsp/footer.jsp"%>
