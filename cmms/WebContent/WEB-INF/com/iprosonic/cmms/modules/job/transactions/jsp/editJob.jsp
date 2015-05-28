<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CREATE JOB</title>
<link rel="stylesheet" type="text/css" href="css/gridstyle.css" />
<link rel="stylesheet" type="text/css"	href="css/jquery.autocomplete.css" />
<script type="text/javascript" src="js/job/datetimepicker.js"></script>
<script type="text/javascript" src="/js/jquery.combobox.js"></script>
<script type="text/javascript" src="/js/jquery.combobox.js"></script>
<script type="text/javascript" src="js/stdlib.js"></script>
<script src="js/job/jobGrid.js"></script>

<script type="text/javascript">
    var rigCount='<%=request.getAttribute("rigcount")%>';
    var runCount='<%=request.getAttribute("runcount")%>';
    var serCount='<%=request.getAttribute("sercount")%>';
    var expCount='<%=request.getAttribute("expcount")%>';
    var role = '<%=session.getAttribute("role")%>';
</script>
</head>
<body
	onload="setRigCount(rigCount);setRunCount(runCount);setSerCount(serCount);setExpCount(expCount);setRole(role);">
	<div class="container">
		<table style="border: 1px;">
			<tr>
				<td>
					<form name="createJob" id="createJob" method="post"
						action="UpdateJobAction.action">

						<table border="0" width="100%">
							<tr align="center">
								<td>Job No : <s:property value="jobBean.jobNo" />
								</td>
								<td>Job Status : <s:property value="jobBean.jobStatus" />
								</td>
							</tr>
						</table>
						<input type="hidden" name="jobNo" id="jobNo" readonly="readonly"
							value="<s:property value="jobBean.jobNo"/>" /> <input
							type="hidden" readonly="readonly" name="jobStatus" id="jobStatus"
							value="<s:property value="jobBean.jobStatus"/>" /> <input
							type="hidden" readonly="readonly" name="jobStatus" id="jobStatus"
							value="NER" /> <input type="hidden" name="jobId"
							value="<s:property value="jobWellBean.jobId"/>">
						<table id="wellInfotable" cellpadding="1" cellspacing="1"
							border="0">



							<s:if test="%{!#session.jobStatus.equalsIgnoreCase('CLOSE_JOB')}">
								<tr>
									<td colspan="6">
										<div class="myHeader" align="center">
											<input type="button" id="rig" value="Update Job"
												class="myEditButton" onclick="editJob();" />
										</div>
									</td>
								</tr>
							</s:if>
							<tr>

								<td><b>Unit No</b></td>
								<td><b><input type="text" name="unitNo" id="unitNo"
										value="<s:property value="jobBean.unitNo"/>" /> </b></td>

								<td><b> Unit left Base/WellSite</b></td>
								<td><input type="text" name="unitLeftBase"
									id="unitLeftBase" style="width: 132px;"
									value="<s:property value="jobBean.unitLeftBase"/>" /> <a
									href="javascript:NewCal('unitLeftBase','ddmmmyyyy',true,24)"><img
										src="images/cal.gif" width="24" height="16" border="0"
										alt="Pick a date"> </a></td>
								<td><b>Safety meet</b></td>
								<td><input type="text" name="safetyMeet" id="safetyMeet"
									value="<s:property value="jobBean.safetyMeet"/>" /></td>
							</tr>
							<tr>
								<td><b>Job No (HLSA)</b></td>
								<td><input type="text" name="jobNoHlsa" id="jobNoHlsa"
									value="<s:property value="jobBean.jobNoHlsa"/>" /></td>

								<td><b>Unit Reached Well site</b></td>
								<td><input id="unitReachedSite" type="text" size="17"
									value="<s:property value="jobBean.unitReachedSite"/>" value='0'
									name="unitReachedSite" style="width: 130px;"> <a
									href="javascript:NewCal('unitReachedSite','ddmmmyyyy',true,24)"><img
										src="images/cal.gif" width="16" height="16" border="0"
										alt="Pick a date"> </a></td>

								<td><b>EJCS1</b></td>
								<td><input type="text" name="ejcs1" id="ejcs1"
									value="<s:property value="jobBean.ejcs1"/>" /></td>

							</tr>
							<tr>
								<td><b>Job Date</b></td>
								<td><input id="jobDate" type="text" size="17"
									value="<s:property value="jobBean.jobDate"/>" name="jobDate"
									readonly="readonly"> <a
									href="javascript:NewCal('jobDate','ddmmyyyy',false,24)"><img
										src="images/cal.gif" width="16" height="16" border="0"
										alt="Pick a date"> </a></td>

								<td><b>Unit left Well site</b></td>
								<td><input type="text" name="unitLeftSite"
									id="unitLeftSite" style="width: 130px;"
									value="<s:property value="jobBean.unitLeftSite"/>" /> <a
									href="javascript:NewCal('unitLeftSite','ddmmmyyyy',true,24)"><img
										src="images/cal.gif" width="24" height="16" border="0"
										alt="Pick a date"> </a></td>


								<td><b>EJCS2</b></td>

								<td><input type="text" name="ejcs2" id="ejcs2"
									value="<s:property value="jobBean.ejcs2"/>" /></td>
							</tr>

							<tr>
								<td><b> Client Name </b></td>
								<td><s:select theme="simple" cssStyle='width:130px'
										list="clientNameMap" value="clientName" name="clientName"
										id="clientName">

									</s:select></td>
								<td><b>Unit Reached Base / Wellsite</b></td>
								<td><input type="text" name="unitReachedBase"
									id="unitReachedBase" style="width: 133px;"
									value="<s:property value="jobBean.unitReachedBase"/>" /> <a
									href="javascript:NewCal('unitReachedBase','ddmmmyyyy',true,24)"><img
										src="images/cal.gif" width="24" height="16" border="0"
										alt="Pick a date"> </a></td>

								<td><b>EJCS3</b></td>

								<td><input type="text" name="ejcs3" id="ejcs3"
									value="<s:property value="jobBean.ejcs3"/>" /></td>


							</tr>
							<tr>

								<td><b>Well No</b></td>
								<td><input type="text" name="wellNo" id="wellNo"
									value="<s:property value="jobBean.wellNo"/>" /></td>
								<td><b>Weak Point(lbs)</b></td>
								<td><input type="text" name="wp" id="wp"
									value="<s:property value="jobWellBean.weekPoint"/>" /></td>
								<td><b>EJCS4</b></td>
								<td><input type="text" name="ejcs4" id="ejcs4"
									value="<s:property value="jobBean.ejcs4"/>" /></td>

							</tr>
							<tr>

								<td><b>Engineer</b></td>
								<td><input type="text" name="engineer" id="engineer"
									onclick="openEmployeeList();"
									value="<s:property value="jobBean.engineer"/>" /></td>

								<td><b>Expl Van Mileage(kms)</b></td>
								<td><input type="text" name="vanMileage" id="vanMileage"
									value="<s:property value="jobBean.vanMileage"/>" /></td>

								<td><b>EJCS5</b></td>
								<td><input type="text" name="ejcs5" id="ejcs5"
									value="<s:property value="jobBean.ejcs5"/>" readonly='true' />
								</td>
							</tr>

							<tr>
								<td><b>Crew</b></td>
								<td><input type="text" name="crew" id="crew"
									onclick="openCrewList();"
									value="<s:property value="jobBean.crew"/>" /></td>

								<td><b>Logging Truck Mileage(kms)</b></td>
								<td><input type="text" name="truckMileage"
									id="truckMileage"
									value="<s:property value="jobBean.truckMileage"/>" /></td>


							</tr>
							<tr>
								<td><b>Remarks</b></td>
								<td colspan="8"><textarea rows="2" cols="100"
										name="remarks" id="remarks">
							<s:property value="jobBean.remarks" />
								</textarea></td>
							</tr>



							<s:if test="%{!#session.jobStatus.equalsIgnoreCase('CLOSE_JOB')}">
								<tr>
									<td colspan="6">
										<div class="myHeader" align="center">
											<input type="button" id="rig"
												value="Update Well & Mud Details" class="myEditButton"
												onclick="editWellJob()" />
										</div>
									</td>
								</tr>
							</s:if>

							<tr>
								<td><b>Latitude</b></td>
								<td>Deg.<input type="text" name="latitude_d"
									id="latitude_d"
									value='<s:property value="jobWellBean.latitude_d" />'
									style="width: 20px" />Min.<input type="text" name="latitude_m"
									id="latitude_m"
									value='<s:property value="jobWellBean.latitude_m" />'
									style="width: 20px" />Sec.<input type="text" name="latitude_s"
									id="latitude_s"
									value='<s:property value="jobWellBean.latitude_s" />'
									style="width: 35px" /></td>


								<td><b>Longitude</b></td>
								<td>Deg.<input type="text" name="longitude_d"
									id="longitude_d"
									value='<s:property value="jobWellBean.longitude_d" />'
									style="width: 20px" />Min.<input type="text"
									name="longitude_m" id="longitude_m"
									value='<s:property value="jobWellBean.longitude_m" />'
									style="width: 20px" />Sec.<input type="text"
									name="longitude_s" id="longitude_s"
									value='<s:property value="jobWellBean.longitude_s" />'
									style="width: 35px" /></td>
							</tr>

							<tr>
								<td><b>Rig Name</b></td>
								<td><input type="text" name="rigName" id="rigName"
									value="<s:property value="jobWellBean.rigName"/>" /></td>
								<td><b>Field</b></td>
								<td><input type="text" name="field" id="field"
									value="<s:property value="jobWellBean.field"/>" /></td>

							</tr>

							<tr>
								<td><b>DF(m)</b></td>
								<td><input type="text" name="dl" id="dl"
									value="<s:property value="jobWellBean.dl"/>" /></td>

								<td><b>KB(m)</b></td>
								<td><input type="text" name="kb" id="kb"
									value="<s:property value="jobWellBean.kb"/>" /></td>


								<td><b>GL(m)</b></td>
								<td><input type="text" name="gf" id="gf"
									value="<s:property value="jobWellBean.gf"/>" /></td>

							</tr>



							<tr>
								<td><b>Casing Size(in)</b></td>
								<td><input type="text" name="casing_size" id="casing_size"
									value="<s:property value="jobWellBean.casingSize"/>" /></td>
								<td><b>CS Depth (m)</b></td>
								<td><input type="text" name="casing_size_at_depth"
									id="casing_size_at_depth"
									value="<s:property value="jobWellBean.casingSizeDepth"/>" /></td>
								<td><b>CS Driller(m)</b></td>
								<td><input type="text" name="csDriller" id="csDriller"
									value="<s:property value="jobWellBean.csDriller"/>" /></td>
							</tr>

							<tr>
								<td><b>TD Driller(m) </b></td>
								<td><input type="text" name="tdDriller" id="tdDriller"
									value="<s:property value="jobWellBean.tdDriller"/>" /></td>
								<td><b>Bit Size(in) </b></td>
								<td><input type="text" name="bitSize" id="bitSize"
									value="<s:property value="jobWellBean.bitSize"/>" /></td>
								<td><b>Deviation(Degrees)</b></td>
								<td><input type="text" name="deviation" id="deviation"
									value="<s:property value="jobWellBean.deviation"/>" /></td>
							</tr>

							<tr>
								<td><b>Start Circulation</b></td>
								<td><input type="text" name="startCirculation"
									id="startCirculation"
									value="<s:property value="jobWellBean.startCirculation"/>" />
									<a
									href="javascript:NewCal('startCirculation','ddmmmyyyy',true,24)"><img
										src="images/cal.gif" width="24" height="16" border="0"
										alt="Pick a date"> </a></td>
								<td><b>Stop Circulation </td>

								<td><input type="text" name="stopCirculation"
									id="stopCirculation"
									value="<s:property value="jobWellBean.stopCirculation"/>" /> <a
									href="javascript:NewCal('stopCirculation','ddmmmyyyy',true,24)"><img
										src="images/cal.gif" width="12" height="16" border="0"
										alt="Pick a date"> </a></td>

							</tr>

							<tr>
								<td colspan="6">
									<div class="myHeader">Mud Parameters</div>
								</td>
							<tr>
							<tr>
								<td><b>Density(gm/cc) </td>
								<td><input type="text" name="density" id="density"
									value="<s:property value="jobWellBean.density"/>" /></td>
								<td><b>Viscosity (cptm) </td>
								<td><input type="text" name="viscosity" id="viscosity"
									value="<s:property value="jobWellBean.viscosity"/>" /></td>
								<td><b>PH(numerical value)</b></td>
								<td><input type="text" name="ph" id="ph"
									value="<s:property value="jobWellBean.ph"/>" /></td>
							</tr>
							<tr>
								<td><b>Salinity(ppm)<b></td>
								<td><input type="text" name="salinity" id="salinity"
									value="<s:property value="jobWellBean.salinity"/>" /></td>
								<td><b>Barities </td>
								<td><input type="text" name="barities" id="barities"
									value="<s:property value="jobWellBean.barities"/>" /></td>
								<td><b>Solid</b></td>
								<td><input type="text" name="solid" id="solid"
									value="<s:property value="jobWellBean.solid"/>" /></td>
							</tr>

							<tr>
								<td colspan="6">
									<div class="myHeader">Mud Resistivity Parameters</div>
								</td>
							</tr>

							<tr>
								<td><b>RM(ohm-m) </b></td>
								<td><input type="text" name="rmValue" id="rmValue"
									value="<s:property value="jobWellBean.rmValue"/>" /></td>

								<td><b>RMF(ohm-m)</b></td>
								<td><input type="text" name="rmf" id="rmf"
									value="<s:property value="jobWellBean.rmf"/>" /></td>

								<td><b>RMC(ohm-m)</b></td>
								<td><input type="text" name="rmc" id="rmc"
									value="<s:property value="jobWellBean.rmc"/>" /></td>

							</tr>

							<tr>
								<td><b>RM Temperature (F)</b></td>
								<td><input type="text" name="rmTemp" id="rmTemp"
									value="<s:property value="jobWellBean.rmTemp"/>" /></td>
							</tr>



							<s:if
								test="%{!#session.role.equalsIgnoreCase('FSQC') && !#session.jobStatus.equalsIgnoreCase('PENDING_WITH_FSQC')}">
								<tr style="background-color: lightgrey; height: 50px">
									<td colspan="8" align="center"><s:if
											test="%{!#session.jobStatus.equalsIgnoreCase('CLOSE_JOB')}">
											<input type="button" id="rig" class="myButton"
												value="(+) Rig Up" onclick="addRig(this)" />
											<input type="button" id="run" class="myButton"
												value="(+) Run" onclick="addRun(this)" />
											<input type="button" id="ser" class="myButton"
												value="(+) Service" onclick="addSer(this)" />
											<input type="button" id="exp" class="myButton"
												value="(+) Exp" onclick="addExpl(this)" />
											<input type="button" class="myButton" id="edit" value="Edit"
												onclick="editRow(this,'datatable')" />
											<input type="button" class="myButton" id="edit"
												value="Refresh" onclick="location.reload();" />
											<input class="myButton" type="button" id="delete"
												value="(-) Delete" onclick="deleteService()" />
											<input class="myButton" type="button" id="insertService"
												value="Insert Service" onclick="insSer(this,'datatable')" />
											<input class="myButton" type="button" id="insertService"
												value="Insert Exp" onclick="insExplosive(this, 'datatable')" />
										</s:if></td>

								</tr>
							</s:if>
							<tr>
								<td colspan="8">
									<div align="center" style="background-color: yellow;">
										<marquee> Note - All time format are in 24 hrs
											sholuld be entered.</marquee>
										<br>
									</div>
								</td>
							</tr>



							<tr style="visibility: hidden">
								<td colspan="8"><input type="text" id="hiddenRig"
									name="hiddenRig" value=''> <input type="text"
									id="hiddenRun" name="hiddenRun" value=''> <input
									type="text" id="hiddenSer" name="hiddenSer" value=''> <input
									type="text" id="hiddenExpl" name="hiddenExpl" value=''>
								</td>
							</tr>

							<tr style="visibility: hidden">
								<td colspan="8"><input type="text" id="hiddenRig"
									name="hiddenRig" value=''> <input type="text"
									id="hiddenRun" name="hiddenRun" value=''> <input
									type="text" id="hiddenSer" name="hiddenSer" value=''> <input
									type="text" id="hiddenExpl" name="hiddenExpl" value=''>
							</tr>


							<tr>
								<td colspan="8">
									<div
										style="width: 1100px; height: 500px; overflow: scroll; margin-top: -37px;">
										<table id="datatable">
											<tr>
												<td colspan="10"><%=request.getAttribute("editRigToExplosive")%></td>
											</tr>
										</table>
									</div>
								</td>
							</tr>




						</table>

						<br> <br /> <br />
						<tr style="background-color: lightgrey; height: 50px">
							<td align="center"><s:if
									test="%{!#session.jobStatus.equalsIgnoreCase('CLOSE_JOB') && !#session.role.equalsIgnoreCase('FSQC')}">
									<input type="button" value='Update' class="myButton"
										onclick="generateSubmitURL();">
								</s:if> <s:if
									test="%{!#session.jobStatus.equalsIgnoreCase('CLOSE_JOB') && !#session.role.equalsIgnoreCase('FSQC')}">
									<input type="submit" id='PENDING_WITH_FSQC' class="myButton"
										name="status" value='Send FSQC' onclick="sendToFSQC(this.id);">
								</s:if> <s:if
									test="%{!#session.jobStatus.equalsIgnoreCase('CLOSE_JOB') && #session.role.equalsIgnoreCase('FSQC')}">
									<input type="submit" id="PENDING_WITH_ENGINEER"
										class="myButton" name="status" value='Send to ENG'
										onclick="sendToENG(this.id);">
								</s:if> <s:if
									test="%{#session.role.equalsIgnoreCase('FSQC') && #session.jobStatus.equalsIgnoreCase('PENDING_WITH_FSQC')}">
									<input type="submit" id="CLOSE_JOB" value="Close" name="status"
										class="myButton" value='Close' onclick="closeJob(this.id);">
								</s:if></td>
						</tr>
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


