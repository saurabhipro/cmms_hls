<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="js/ editcpi.js">
	
</script>
<title>Update CPI / Work Order</title>
<sj:head jqueryui="true" />
</head>
<body>
	<div class="container">
		<s:form id="formValidate" action="UpdateCpiAction" method="post">
			<s:push value="cpiBean">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{8}" />
				</s:bean>
				<s:hidden id="id"></s:hidden>

				<s:textfield id="cpiCd" name="cpiCd" label="CPI Code"
					readonly="true" cssClass="textfield" />

				<s:select key="CPI Process" name="cpiProcess" list="cpiProcessList"
					headerKey="-Select-" headerValue="-Select-" cssClass="textfield">
				</s:select>
				<s:textfield id="id" name="id" cssStyle="display:none" />

				<tr>
					<th colspan="10" align="left">
						<hr>
					</th>
				</tr>
				<s:select key="CPI Status" name="cpiStatus" list="cpiStatusList"
					headerKey="-Select-" headerValue="-Select-" cssClass="textfield">
				</s:select>

				<s:select key="Why Open" name="whyOpen" headerKey="-Select-"
					headerValue="-Select-" cssStyle="width:145px" list="cpiWhyOpenList">
				</s:select>


				<s:textfield id="whyOpenOthers" name="whyOpenOthers" label="Other"
					readonly="false" />
				<td>Job Successfully Done</td>
				<td><sj:datepicker value="%{jobSuccessfullyDone}"
						id="jobSuccessfullyDone" name="Job Successfully Done"
						displayFormat="yy-mm-dd" cssStyle="width:100px">
					</sj:datepicker></td>


				<tr>
					<th colspan="10" align="left">
						<hr>
					</th>
				</tr>

				<td>PM2 Status</td>
				<td><sj:datepicker value="%{pm2status}" id="pm2status"
						name="pm2status" cssStyle="width:100px" displayFormat="yy-mm-dd">
					</sj:datepicker></td>

				<td>Last Calibration Date</td>
				<td><sj:datepicker value="%{lastCalibrationDate}"
						id="lastCalibrationDate" name="lastCalibrationDate"
						cssStyle="width:100px" displayFormat="yy-mm-dd">
					</sj:datepicker></td>

				<td>Last Job Done</td>
				<td><sj:datepicker value="%{lastJobDone}" id="lastJobDone"
						name="lastJobDone" displayFormat="yy-mm-dd" cssStyle="width:100px">
					</sj:datepicker></td>

				<td>Last Failure</td>
				<td><sj:datepicker value="%{lastFailure}" id="lastFailure"
						name="lastFailure" displayFormat="yy-mm-dd" cssStyle="width:100px">
					</sj:datepicker></td>


				<tr>
					<th colspan="10" align="left">
						<hr>
					</th>
				</tr>


				<s:textfield id="regionCd" name="regionCd" label="Region Code"
					readonly="true" />



				<s:textfield id="locationCd" name="locationCd" label="Location Code"
					readonly="true" />

				<s:textfield id="unitCd" name="unitCd" label="Unit Code"
					readonly="true" />

				<s:textfield id="clientCd" name="clientCd" label="Client Code"
					readonly="true" />


				<s:textfield id="originatedBy" name="originatedBy"
					label="Originated By" readonly="true" />
				<td>Date Of CPI</td>
				<td><sj:datepicker value="%{dateOfCpi}" id="date Of Cpi"
						name="dateOfCpi" displayFormat="yy-mm-dd" cssStyle="width:100px">
					</sj:datepicker></td>

				<td>Update Date</td>
				<td><sj:datepicker value="%{updateDate}" id="updateDate"
						name="updateDate" displayFormat="yy-mm-dd" cssStyle="width:100px">
					</sj:datepicker></td>
				<tr>
					<th colspan="10" align="left">Priority
						<hr>
					</th>
				</tr>

				<s:textfield id="priority" name="priority" label="Priority"
					readonly="true" />

				<s:textfield id="cpiType" name="cpiType" label="CPI Type"
					readonly="true" />


				<s:textfield id="maintanenceType" name="maintanenceType"
					label="Maintanence Type" readonly="true" />
				<s:textfield id="" name="" label="" cssStyle="display:none" />
				<s:textfield id="" name="" label="" cssStyle="display:none" />




				<tr>
					<th colspan="10" align="left">Stack Run
						<hr>
					</th>
				</tr>


				<s:textfield id="assetType1" name="assetType1" label="Ast  Type1"
					readonly="true" cssClass="textfield" />
				<s:textfield id="assetName1" name="assetName1" label="Ast  Name1"
					readonly="true" cssClass="textfield" />
				<s:textfield id="assetSrNo1" name="assetSrNo1" label="Ast  Sr No1"
					readonly="true" cssClass="textfield" />
				<s:textfield id="sectionName1" name="sectionName1"
					label="Sec  Name1" readonly="true" cssClass="textfield" />
				<s:textfield id="sectionSerialNo1" name="sectionSerialNo1"
					label="Sec  Serial No1" readonly="true" cssClass="textfield" />


				<s:textfield id="assetType2" name="assetType2" label="Ast  Type2"
					readonly="true" cssClass="textfield" />
				<s:textfield id="assetName2" name="assetName2" label="Ast  Name2"
					readonly="true" cssClass="textfield" />
				<s:textfield id="assetSrNo2" name="assetSrNo2" label="Ast  Sr No2"
					readonly="true" cssClass="textfield" />
				<s:textfield id="sectionName2" name="sectionName2"
					label="Sec  Name2" readonly="true" cssClass="textfield" />
				<s:textfield id="sectionSerialNo" name="sectionSerialNo2"
					label="Sec  Serial No2" readonly="true" cssClass="textfield" />


				<s:textfield id="assetType3" name="assetType3" label="Ast  Type3"
					readonly="true" cssClass="textfield" />
				<s:textfield id="assetName3" name="assetName3" label="Ast  Name3"
					readonly="true" cssClass="textfield" />
				<s:textfield id="assetSrNo3" name="assetSrNo3" label="Ast  Sr No3"
					readonly="true" cssClass="textfield" />
				<s:textfield id="sectionName3" name="sectionName3"
					label="Sec  Name3" readonly="true" cssClass="textfield" />
				<s:textfield id="sectionSerialNo3" name="sectionSerialNo3"
					label="Sec  Serial No3" readonly="true" cssClass="textfield" />


				<s:textfield id="assetType4" name="assetType4" label="Ast  Type4"
					readonly="true" cssClass="textfield" />
				<s:textfield id="assetName4" name="assetName4" label="Ast  Name4"
					readonly="true" cssClass="textfield" />
				<s:textfield id="assetSrNo4" name="assetSrNo4" label="Ast  Sr No4"
					readonly="true" cssClass="textfield" />
				<s:textfield id="sectionName4" name="sectionName4"
					label="Sec  Name4" readonly="true" cssClass="textfield" />
				<s:textfield id="sectionSerialNo4" name="sectionSerialNo4"
					label="Sec  Serial No4" readonly="true" cssClass="textfield" />

				<s:textfield id="assetType5" name="assetType5" label="Ast  Type5"
					readonly="true" cssClass="textfield" />
				<s:textfield id="assetName5" name="assetName5" label="Ast  Name5"
					readonly="true" cssClass="textfield" />
				<s:textfield id="assetSrNo5" name="assetSrNo5" label="Ast  Sr No5"
					readonly="true" cssClass="textfield" />
				<s:textfield id="sectionName5" name="sectionName5"
					label="Sec  Name5" readonly="true" cssClass="textfield" />
				<s:textfield id="sectionSerialNo5" name="sectionSerialNo5"
					label="Sec  Serial No5" readonly="true" cssClass="textfield" />

				<s:textfield id="assetType6" name="assetType6" label="Ast  Type6"
					readonly="true" cssClass="textfield" />
				<s:textfield id="assetName6" name="assetName6" label="Ast  Name6"
					readonly="true" cssClass="textfield" />
				<s:textfield id="assetSrNo6" name="assetSrNo6" label="Ast  Sr No6"
					readonly="true" cssClass="textfield" />
				<s:textfield id="sectionName6" name="sectionName6"
					label="Sec  Name6" readonly="true" cssClass="textfield" />
				<s:textfield id="sectionSerialNo6" name="sectionSerialNo6"
					label="Sec  Serial No6" readonly="true" cssClass="textfield" />


				<tr>
					<th colspan="10" align="left">Problem
						<hr>
					</th>
				</tr>


				<s:textarea name="problem" cols="130" rows="5">
					<s:param name="labelcolspan" value="%{10}" />
					<s:param name="inputcolspan" value="%{10}" />
				</s:textarea>


				<tr>
					<th colspan="10" align="left">Uphole / Downhole: <s:checkbox
							name="updownFlag" disabled="true"
							checked="<s:property value='updownFlag' />" label="uphole"
							onclick="disable()"></s:checkbox>
						<hr></th>
				</tr>

				<tr align="left">
					<th colspan="10" align="left">Bore Hole Condition
						<hr>
					</th>
				</tr>


				<s:textfield id="depth" name="depth" label="Depth" readonly="true"
					cssClass="textfield" />
				<s:textfield id="mudType" name="mudType" label="Mud Type"
					readonly="true" cssClass="textfield" />
				<s:textfield id="bht" name="bht" label="Bore Hole Temp"
					readonly="true" cssClass="textfield" />
				<s:textfield id="pressure" name="pressure" label="Pressure"
					readonly="true" cssClass="textfield" />
				<s:textfield id="mudWeight" name="mudWeight" label="Pressure (PSI)"
					readonly="true" cssClass="textfield" />

				<s:textfield id="holeCondition" name="holeCondition"
					label="Hole Condition" readonly="true" cssClass="textfield" />
				<s:textfield id="bitSize" name="bitSize" label="Bit Size"
					readonly="true" cssClass="textfield" />


				<s:textfield id="deviation" name="deviation" label="Deviation"
					readonly="true" cssClass="textfield" />


				<s:textfield id="" name="" label="" cssStyle="display:none" />
				<s:textfield id="" name="" label="" cssStyle="display:none" />


				<tr align="left">
					<th colspan="10" align="left" style="color: red">DIAGONOSIS
						<hr>
					</th>
				</tr>

				<tr align="left">
					<th colspan="10" align="left">Faulty
						<hr>
					</th>
				</tr>


				<s:select label="Ast  Type" name="assetType" list="assetTypeList"
					headerKey="-Select-" headerValue="-Select-" value="assetType"
					onchange="getAst Cd(this)" cssClass="textfield">
				</s:select>


				<s:select label="Ast  Name" name="assetName" list="assetNameList"
					headerKey="-Select-" headerValue="-Select-" value="assetName"
					onchange="getAst SrNo(this)" cssClass="textfield">

				</s:select>
				<s:select label="Ast  Serial No." name="assetSrNo"
					list="assetSrNoList" headerKey="-Select-" headerValue="-Select-"
					value="assetSrNo" onchange="getSectionName(this)"
					cssClass="textfield">
				</s:select>

				<s:select label="Sec Name" name="sectionName" list="sectionCdList"
					headerKey="-Select-" headerValue="-Select-" value="sectionName"
					onchange="getSectionSerialNo(this)" cssClass="textfield">
				</s:select>


				<s:select label="Sec Serial No." name="sectionSerialNo"
					list="sectionSerialNoList" headerKey="-Select-"
					value="sectionSerialNo" headerValue="-Select-" cssClass="textfield">
				</s:select>

				<tr align="left">
					<th colspan="10" align="left">CA1
						<hr>
					</th>
				</tr>
				<s:select key="correctiveActionDoneBy1"
					name="correctiveActionDoneBy1" label="CA1 Done By"
					list="correctiveActionDoneByList" headerKey="-Select-"
					headerValue="-Select-" cssClass="textfield">
				</s:select>
				<s:select label="CA Code1"
					list="#{
						'-Select-':'-Select-',
						'No parts required for fixing the tool':'No parts required for fixing the tool',
						'If parts are available with HLSA':'If parts are available with HLSA',
						'Local parts to fix the problem':'Local parts to fix the problem',
						'Parts waiting from HES/3rd party':'Parts waiting from HES/3rd party',
						'Those sent for RMAs':'Those sent for RMAs'						
						}"
					cssStyle="width:145px" name="correctiveActionCode1">
				</s:select>
				<td><s:text name="openDate1">Open Date1</s:text></td>
				<td><sj:datepicker value="%{openDate1}" id="openDate1"
						name="openDate1" cssStyle="width:100px" displayFormat="yy-mm-dd">
					</sj:datepicker></td>

				<td><s:text name="closeDate1">Close Date1</s:text></td>
				<td><sj:datepicker value="%{closeDate1}" id="closeDate1"
						name="closeDate1" displayFormat="yy-mm-dd" cssStyle="width:100px">
					</sj:datepicker></td>
				<s:textfield id="" name="" label=""
					cssStyle="display:none;backround-color:red" />
				<tr align="left">
					<th colspan="10" align="left">CA1(Corrective Action) Remarks
						<hr>
					</th>
				</tr>
				<s:textarea name="correctiveAction1" cols="130" rows="5">
					<s:param name="labelcolspan" value="%{10}" />
					<s:param name="inputcolspan" value="%{10}" />
				</s:textarea>



				<tr align="left">
					<th colspan="10" align="left">CA2
						<hr>
					</th>
				</tr>
				<s:select key="correctiveActionDoneBy2"
					name="correctiveActionDoneBy2" label="CA2 Done By"
					list="correctiveActionDoneByList" headerKey="-Select-"
					headerValue="-Select-" cssStyle="width:135px">
				</s:select>
				<s:select label="CA Code2"
					list="#{
						'-Select-':'-Select-',
						'No parts required for fixing the tool':'No parts required for fixing the tool',
						'If parts are available with HLSA':'If parts are available with HLSA',
						'Local parts to fix the problem':'Local parts to fix the problem',
						'Parts waiting from HES/3rd party':'Parts waiting from HES/3rd party',
						'Those sent for RMAs':'Those sent for RMAs'						
						}"
					cssStyle="width:145px" name="correctiveActionCode2">
				</s:select>
				<td><s:text name="openDate2">Open Date2</s:text></td>
				<td><sj:datepicker value="%{openDate2}" id="openDate2"
						name="openDate2" displayFormat="yy-mm-dd" cssStyle="width:100px">
					</sj:datepicker></td>
				<td><s:text name="closeDate2">Close Date2</s:text></td>
				<td><sj:datepicker value="%{closeDate2}"
						displayFormat="yy-mm-dd" id="closeDate2" name="closeDate2"
						cssStyle="width:100px">
					</sj:datepicker></td>
				<s:textfield id="" name="" label="" cssStyle="display:none" />
				<tr align="left">
					<th colspan="10" align="left">CA2(Corrective Action) Remarks
						<hr>
					</th>
				</tr>
				<s:textarea name="correctiveAction2" cols="130" rows="5">
					<s:param name="labelcolspan" value="%{10}" />
					<s:param name="inputcolspan" value="%{10}" />
				</s:textarea>



				<tr align="left">
					<th colspan="10" align="left">CA3
						<hr>
					</th>
				</tr>
				<s:select key="correctiveActionDoneBy3"
					name="correctiveActionDoneBy3" label="CA3 Done By"
					list="correctiveActionDoneByList" headerKey="-Select-"
					headerValue="-Select-" cssStyle="width:135px">
				</s:select>
				<s:select label="CA Code3"
					list="#{
						'-Select-':'-Select-',
						'No parts required for fixing the tool':'No parts required for fixing the tool',
						'If parts are available with HLSA':'If parts are available with HLSA',
						'Local parts to fix the problem':'Local parts to fix the problem',
						'Parts waiting from HES/3rd party':'Parts waiting from HES/3rd party',
						'Those sent for RMAs':'Those sent for RMAs'						
						}"
					cssStyle="width:145px" name="correctiveActionCode3">
				</s:select>

				<td><s:text name="openDate3">Open Date3</s:text></td>
				<td><sj:datepicker value="%{openDate3}" id="openDate3"
						name="openDate3" displayFormat="yy-mm-dd" cssStyle="width:100px">
					</sj:datepicker></td>
				<td><s:text name="closeDate3">Close Date3</s:text></td>
				<td><sj:datepicker value="%{closeDate3}" id="closeDate3"
						name="closeDate3" displayFormat="yy-mm-dd" cssStyle="width:100px">
					</sj:datepicker></td>
				<s:textfield id="" name="" label="" cssStyle="display:none" />
				<tr align="left">
					<th colspan="10" align="left">CA3(Corrective Action) Remarks
						<hr>
					</th>
				</tr>
				<s:textarea name="correctiveAction3" cols="130" rows="5">
					<s:param name="labelcolspan" value="%{10}" />
					<s:param name="inputcolspan" value="%{10}" />
				</s:textarea>



				<tr align="left">
					<th colspan="10" align="left">CA4
						<hr>
					</th>
				</tr>
				<s:select key="correctiveActionDoneBy4"
					name="correctiveActionDoneBy4" label="CA4 Done By"
					list="correctiveActionDoneByList" headerKey="-Select-"
					headerValue="-Select-" cssStyle="width:135px">
				</s:select>
				<s:select label="CA Code4"
					list="#{
						'-Select-':'-Select-',
						'No parts required for fixing the tool':'No parts required for fixing the tool',
						'If parts are available with HLSA':'If parts are available with HLSA',
						'Local parts to fix the problem':'Local parts to fix the problem',
						'Parts waiting from HES/3rd party':'Parts waiting from HES/3rd party',
						'Those sent for RMAs':'Those sent for RMAs'						
						}"
					cssStyle="width:145px" name="correctiveActionCode4">
				</s:select>
				<td><s:text name="openDate2">Open Date4</s:text></td>
				<td><sj:datepicker value="%{openDate4}" id="openDate4"
						name="openDate4" cssStyle="width:100px" displayFormat="yy-mm-dd">
					</sj:datepicker></td>
				<td><s:text name="closeDate2">Close Date4</s:text></td>
				<td><sj:datepicker value="%{closeDate4}" id="closeDate4"
						name="closeDate4" cssStyle="width:100px" displayFormat="yy-mm-dd">
					</sj:datepicker></td>
				<s:textfield id="" name="" label="" cssStyle="display:none" />
				<tr align="left">
					<th colspan="10" align="left">CA4(Corrective Action) Remarks
						<hr>
					</th>
				</tr>
				<s:textarea name="correctiveAction4" cols="130" rows="5">
					<s:param name="labelcolspan" value="%{10}" />
					<s:param name="inputcolspan" value="%{10}" />
				</s:textarea>


				<tr align="left">
					<th colspan="10" align="left">CA5
						<hr>
					</th>
				</tr>
				<s:select key="correctiveActionDoneBy5"
					name="correctiveActionDoneBy5" label="CA5 Done By"
					list="correctiveActionDoneByList" headerKey="-Select-"
					headerValue="-Select-" cssStyle="width:135px">
				</s:select>
				<s:select label="CA Code5"
					list="#{
						'-Select-':'-Select-',
						'No parts required for fixing the tool':'No parts required for fixing the tool',
						'If parts are available with HLSA':'If parts are available with HLSA',
						'Local parts to fix the problem':'Local parts to fix the problem',
						'Parts waiting from HES/3rd party':'Parts waiting from HES/3rd party',
						'Those sent for RMAs':'Those sent for RMAs'						
						}"
					cssStyle="width:145px" name="correctiveActionCode5">
				</s:select>
				<td><s:text name="openDate5">Open Date5</s:text></td>
				<td><sj:datepicker value="%{openDate5}" id="openDate5"
						name="openDate5" displayFormat="yy-mm-dd" cssStyle="width:100px">
					</sj:datepicker></td>
				<td><s:text name="closeDate5">Close Date5</s:text></td>
				<td><sj:datepicker value="%{closeDate5}" id="closeDate5"
						name="closeDate5" displayFormat="yy-mm-dd" cssStyle="width:100px">
					</sj:datepicker></td>
				<s:textfield id="" name="" label="" cssStyle="display:none" />
				<tr align="left">
					<th colspan="10" align="left">CA5(Corrective Action) Remarks
						<hr>
					</th>
				</tr>
				<s:textarea name="correctiveAction5" cols="130" rows="5">
					<s:param name="labelcolspan" value="%{10}" />
					<s:param name="inputcolspan" value="%{10}" />
				</s:textarea>




				<tr align="left">
					<th colspan="10" align="left">CA6
						<hr>
					</th>
				</tr>
				<s:select key="correctiveActionDoneBy6"
					name="correctiveActionDoneBy6" label="CA6 Done By"
					list="correctiveActionDoneByList" headerKey="-Select-"
					headerValue="-Select-" cssStyle="width:135px">
				</s:select>
				<s:select label="CA Code6"
					list="#{
						'-Select-':'-Select-',
						'No parts required for fixing the tool':'No parts required for fixing the tool',
						'If parts are available with HLSA':'If parts are available with HLSA',
						'Local parts to fix the problem':'Local parts to fix the problem',
						'Parts waiting from HES/3rd party':'Parts waiting from HES/3rd party',
						'Those sent for RMAs':'Those sent for RMAs'						
						}"
					cssStyle="width:145px" name="correctiveActionCode6">
				</s:select>
				<td><s:text name="openDate6">Open Date6</s:text></td>
				<td><sj:datepicker value="%{openDate6}" id="openDate6"
						name="openDate6" displayFormat="yy-mm-dd" cssStyle="width:100px">
					</sj:datepicker></td>
				<td><s:text name="closeDate6">Close Date6</s:text></td>
				<td><sj:datepicker value="%{closeDate6}" id="closeDate6"
						name="closeDate6" displayFormat="yy-mm-dd" cssStyle="width:100px">
					</sj:datepicker></td>
				<s:textfield id="" name="" label="" cssStyle="display:none" />
				<tr align="left">
					<th colspan="10" align="left">CA6(Corrective Action) Remarks
						<hr>
					</th>
				</tr>
				<s:textarea name="correctiveAction6" cols="130" rows="5">
					<s:param name="labelcolspan" value="%{10}" />
					<s:param name="inputcolspan" value="%{10}" />
				</s:textarea>





				<tr align="left">
					<th colspan="10" align="left">MRF NO
						<hr>
					</th>
				</tr>
				<tr>
					<s:textfield name="mrfNo" label="Mrf No" />
					<s:textfield name="remarksOnMrf" label="Remarks On Mrf" />
				</tr>


				<tr align="left">
					<th colspan="10" align="left" style="color: red">ANALYSIS
						<hr>
					</th>
				</tr>

				<tr align="left">
					<th colspan="10" align="left">Preliminary Fault Finding
						<hr>
					</th>
				</tr>

				<s:select key="prcaAssignedTo" name="prcaAssignedTo"
					label="PRCA Assigned To" list="correctiveActionDoneByList"
					headerKey="-Select-" headerValue="-Select-" cssStyle="width:135px">
				</s:select>


				<s:select key="prcaDoneBy" name="prcaDoneBy" label="Prca Done By"
					list="correctiveActionDoneByList" headerKey="-Select-"
					headerValue="-Select-" cssStyle="width:135px">
				</s:select>



				<td><s:text name="dateOfPrca">Date Of PRCA</s:text></td>
				<td><sj:datepicker value="%{dateOfPrca}" id="dateOfPrca"
						name="dateOfPrca" displayFormat="yy-mm-dd" cssStyle="width:100px"></sj:datepicker></td>

				<tr align="left">
					<th colspan="10" align="left">PRCA Report
						<hr>
					</th>
				</tr>
				<s:textarea name="prcaReport" cols="130" rows="5">
					<s:param name="labelcolspan" value="%{10}" />
					<s:param name="inputcolspan" value="%{10}" />
				</s:textarea>
				<tr align="left">
					<th colspan="10" align="left">PRCA Remarks
						<hr>
					</th>
				</tr>
				<s:textarea name="prcaRemarks" cols="130" rows="5">
					<s:param name="labelcolspan" value="%{10}" />
					<s:param name="inputcolspan" value="%{10}" />
				</s:textarea>

				<tr align="left">
					<th colspan="10" align="left">FRCA
						<hr>
					</th>
				</tr>
				<s:select key="frcaAssignedTo" name="frcaAssignedTo"
					label="FRCA Assigned To" list="correctiveActionDoneByList"
					headerKey="-Select-" headerValue="-Select-" cssStyle="width:135px">
				</s:select>


				<s:select key="frcaDoneBy" name="frcaDoneBy" label="Frca Done By"
					list="correctiveActionDoneByList" headerKey="-Select-"
					headerValue="-Select-" cssStyle="width:135px">
				</s:select>



				<td><s:text name="dateOfFrca">Date Of FRCA</s:text></td>
				<td><sj:datepicker value="%{dateOfFrca}" id="dateOfFrca"
						name="dateOfFrca" displayFormat="yy-mm-dd" cssStyle="width:100px"></sj:datepicker></td>

				<tr align="left">
					<th colspan="10" align="left">FRCA Report
						<hr>
					</th>
				</tr>
				<s:textarea name="frcaReport" cols="130" rows="5">
					<s:param name="labelcolspan" value="%{10}" />
					<s:param name="inputcolspan" value="%{10}" />
				</s:textarea>
				<tr align="left">
					<th colspan="10" align="left">FRCA Remarks
						<hr>
					</th>
				</tr>
				<s:textarea name="frcaRemarks" cols="130" rows="5">
					<s:param name="labelcolspan" value="%{10}" />
					<s:param name="inputcolspan" value="%{10}" />
				</s:textarea>

				<tr align="left">
					<th colspan="10" align="left">CPI
						<hr>
					</th>
				</tr>

				<s:select key="typeOfCpi" name="typeOfCpi" label="Nature Of CPI"
					list="typeOfCpiList" headerKey="-Select-" headerValue="-Select-"
					cssStyle="width:135px">
				</s:select>


				<s:select label="Impact To Customer"
					list="#{
						'-Select-':'-Select-',
						'None':'None',
						'Limited':'Limited',
						'Severe':'Severe'
												
						
						}"
					cssStyle="width:145px" name="impactToCoustomer">
				</s:select>


				<s:select label="Effect On Customer"
					list="#{
						'-Select-':'-Select-',
						'Damaged Well':'Damaged Well',
						'Lost Time':'Lost Time',
						'Job Failure':'Job Failure',
						'Job Completed with SQ Issue':'Job Completed with SQ Issue',
						'No Effect':'No Effect'
						}"
					cssStyle="width:145px" name="effectOnCustomer">
				</s:select>


				<s:select key="sourceOfCpi" name="sourceOfCpi" label="Source Of CPI"
					list="sourceOfCpiList" headerKey="-Select-" headerValue="-Select-"
					cssStyle="width:135px">
				</s:select>

				<s:select key="subSourceOfCpi" name="subSourceOfCpi"
					label="Sub Source Of CPI" list="subSourceOfCpiList"
					headerKey="-Select-" headerValue="-Select-" cssStyle="width:135px">
				</s:select>

				<s:select label="GroupCode"
					list="#{
						'-Select-':'-Select-',
						'Manufacturing ':'Manufacturing ',
						'Design ':'Design',
						'Usage Equip, items, tools':'Usage Equip, items, tools',
						'Usage Equip, items, tools':'Usage Equip, items, tools',
						'Maintenance-Repair-Qualification':'Maintenance-Repair-Qualification',
						'Usage (Equip, items, tools)':'Usage (Equip, items, tools)',
						'Materials / Products':'Materials / Products'				,							
						'Behavioral':'Behavioral',
						'Resource Allocation':'Resource Allocation',
						'Human Error':'Human Error',
						'Process':'Process',
						'Well Conditions':'Well Conditions',
						'Other Environment':'Other Environment'
						}"
					cssStyle="width:145px" name="groupCode">
				</s:select>



				<s:select key="subGroupCd" name="subGroupCd" label="Sub Group Code"
					list="subGroupCdList" headerKey="-Select-" headerValue="-Select-"
					cssStyle="width:135px">
				</s:select>

				<s:select key="category" name="category" label="CPI Category"
					list="cpiCategoryList" headerKey="-Select-" headerValue="-Select-"
					cssStyle="width:135px">
				</s:select>

				<s:select key="subCategory" name="subCategory"
					label="CPI Sub Category" list="cpiSubCategoryList"
					headerKey="-Select-" headerValue="-Select-" cssStyle="width:135px">
				</s:select>

				<tr align="left">
					<th colspan="10" align="left">Comments On Closer
						<hr>
					</th>
				</tr>
				<s:textarea name="commentsOnCloser" cols="130" rows="5">
					<s:param name="labelcolspan" value="%{10}" />
					<s:param name="inputcolspan" value="%{10}" />
				</s:textarea>
				<sj:submit button="true" value="Update" />
			</s:push>
		</s:form>
	</div>
</body>
</html>


