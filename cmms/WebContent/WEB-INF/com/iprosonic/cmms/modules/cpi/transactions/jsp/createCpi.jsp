<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<script type="text/javascript" src="js/cpi.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CPI</title>
<sj:head locale="de" jquerytheme="lightness" />
<sj:head jqueryui="true" />
</head>
<body>
	<div class="container">
		<s:form id="formValidate" theme="qxhtml" action="SaveCPIAction"
			method="post">
			<s:push value="cpiBean">
				<s:hidden id="id" />
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{10}" />
				</s:bean>


				<div class="myHeader">CPI Header Details</div>


				<s:select label="Region Code" list="#session.regionCd"
					cssClass="searchCombo" name="regionCd" headerKey="-Select-"
					headerValue="-Select-" onchange="getLocationCd(this)">
				</s:select>

				<s:select label="Location Code" list="#{'-Select-':'-Select-'}"
					cssClass="searchCombo" name="locationCd" headerKey="-Select-"
					onchange="getUnitCd(this)">
				</s:select>

				<s:select label="Unit Code" list="#{'-Select-':'-Select-'}"
					cssClass="searchCombo" name="unitCd" headerKey="-Select-"
					onchange="getClientCd(this)">
				</s:select>


				<s:select label="Client Code" list="#{'-Select-':'-Select-'}"
					cssClass="searchCombo" name="clientCd" headerValue="-0-">
				</s:select>


				<s:select label="Priority" list="#session.priority" name="priority"
					headerKey="-Select-" headerValue="-Select-" cssClass="searchCombo">
				</s:select>

				<s:select label="CPI Type" list="#session.cpiType" name="cpiType"
					cssClass="searchCombo" headerKey="-Select-" headerValue="-Select-">
				</s:select>

				<s:select label="Maintenance Type"
					list="#session.maintenanceTypeList" name="maintanenceType"
					headerKey="-Select-" cssClass="searchCombo" headerValue="-Select-">
				</s:select>

				<s:text name="">Date Of CPI</s:text>
				<sj:datepicker value="%{dateOfCpi}" id="dateOfCpi" name="dateOfCpi"
					cssClass="searchCombo" displayFormat="yy-mm-dd">
				</sj:datepicker>

				<s:text name="">Update Date Of CPI</s:text>

				<sj:datepicker value="%{updateDate}" id="updateDate"
						name="updateDate" cssClass="searchCombo" displayFormat="yy-mm-dd">
					</sj:datepicker>

				<s:textfield id="" name="" label="" cssStyle="display:none" />
				<s:textfield id="" name="" label="" cssStyle="display:none" />
				<s:textfield id="" name="" label="" cssStyle="display:none" />

				<tr>
					<th colspan="10" align="left">
						<div class="myHeader">Stack + Acquisition System</div>

						<hr>
					</th>
				</tr>
				<s:select label="Ast Type1" list="#session.assetType1"
					name="assetType1" headerKey="-Select-" cssClass="searchCombo"
					headerValue="-Select-" onchange="getAssetCd1(this)">
				</s:select>


				<s:select label="Ast Code 1" list="#{'-Select-':'-Select-'}"
					cssClass="searchCombo" name="assetName1" headerKey="-Select-"
					onchange="getAssetSrNo1(this)">
				</s:select>

				<s:select label="Ast Sr No1" list="#{'-Select-':'-Select-'}"
					cssClass="searchCombo" name="assetSrNo1" headerKey="-Select-"
					onchange="getSectionName1(this)">
				</s:select>
				<s:select label="Sec Name1" list="#{'-Select-':'-Select-'}"
					name="sectionName1" headerKey="-Select-" cssClass="searchCombo"
					onchange="getSectionSerialNo1(this)">
				</s:select>
				<s:select label="Sec Sr No1" list="#{'-Select-':'-Select-'}"
					name="sectionSerialNo1" headerKey="-Select-" cssClass="searchCombo">
				</s:select>


				<s:select label="Ast Type2" list="#session.assetType1"
					name="assetType2" headerKey="-Select-" cssClass="searchCombo"
					headerValue="-Select-" onchange="getAssetCd2(this)">
				</s:select>

				<s:select label="Ast Code 2" list="#{'-Select-':'-Select-'}"
					name="assetName2" headerKey="-Select-" cssClass="searchCombo"
					onchange="getAssetSrNo2(this)">

				</s:select>

				<s:select label="Ast Sr No2" list="#{'-Select-':'-Select-'}"
					name="assetSrNo2" headerKey="-Select-" cssClass="searchCombo"
					onchange="getSectionName2(this)">
				</s:select>
				<s:select label="Sec Name2" list="#{'-Select-':'-Select-'}"
					name="sectionName2" headerKey="-Select-" cssClass="searchCombo"
					onchange="getSectionSerialNo2(this)">
				</s:select>
				<s:select label="Sec Sr No2" list="#{'-Select-':'-Select-'}"
					name="sectionSerialNo2" headerKey="-Select-" cssClass="searchCombo">
				</s:select>


				<s:select label="Ast Type3" list="#session.assetType1"
					name="assetType3" headerKey="-Select-" cssClass="searchCombo"
					headerValue="-Select-" onchange="getAssetCd3(this)">
				</s:select>

				<s:select label="Ast Code 3" list="#{'-Select-':'-Select-'}"
					name="assetName3" headerKey="-Select-" cssClass="searchCombo"
					onchange="getAssetSrNo3(this)">
				</s:select>

				<s:select label="Ast Sr No3" list="#{'-Select-':'-Select-'}"
					name="assetSrNo3" headerKey="-Select-" cssClass="searchCombo"
					onchange="getSectionName3(this)">
				</s:select>
				<s:select label="Sec Name3" list="#{'-Select-':'-Select-'}"
					name="sectionName3" headerKey="-Select-" cssClass="searchCombo"
					onchange="getSectionSerialNo3(this)">
				</s:select>
				<s:select label="Sec Sr No3" list="#{'-Select-':'-Select-'}"
					name="sectionSerialNo3" headerKey="-Select-" cssClass="searchCombo">
				</s:select>

				<s:select label="Ast Type4" list="#session.assetType1"
					name="assetType4" headerKey="-Select-" cssClass="searchCombo"
					headerValue="-Select-" onchange="getAssetCd4(this)">
				</s:select>

				<s:select label="Ast Code 4" list="#{'-Select-':'-Select-'}"
					name="assetName4" headerKey="-Select-" cssClass="searchCombo"
					onchange="getAssetSrNo4(this)">
				</s:select>

				<s:select label="Ast Sr No4" list="#{'-Select-':'-Select-'}"
					name="assetSrNo4" headerKey="-Select-" cssClass="searchCombo"
					onchange="getSectionName4(this)">
				</s:select>
				<s:select label="Sec Name4" list="#{'-Select-':'-Select-'}"
					name="sectionName4" headerKey="-Select-" cssClass="searchCombo"
					onchange="getSectionSerialNo4(this)">
				</s:select>
				<s:select label="Sec Sr No4" list="#{'-Select-':'-Select-'}"
					name="sectionSerialNo4" headerKey="-Select-" cssClass="searchCombo">
				</s:select>

				<s:select label="Ast Type5" list="#session.assetType1"
					name="assetType5" headerKey="-Select-" cssClass="searchCombo"
					headerValue="-Select-" onchange="getAssetCd5(this)">
				</s:select>

				<s:select label="Ast Code 5" list="#{'-Select-':'-Select-'}"
					cssClass="searchCombo" name="assetName5" headerKey="-Select-"
					onchange="getAssetSrNo5(this)">
				</s:select>

				<s:select label="Ast Sr No5" list="#{'-Select-':'-Select-'}"
					cssClass="searchCombo" name="assetSrNo5" headerKey="-Select-"
					onchange="getSectionName5(this)">
				</s:select>
				<s:select label="Sec Name5" list="#{'-Select-':'-Select-'}"
					cssClass="searchCombo" name="sectionName5" headerKey="-Select-"
					onchange="getSectionSerialNo5(this)">
				</s:select>
				<s:select label="Sec Sr No5" list="#{'-Select-':'-Select-'}"
					cssClass="searchCombo" name="sectionSerialNo5" headerKey="-Select-">
				</s:select>




				<s:select label="Ast Type6" list="#session.assetType1"
					name="assetType6" headerKey="-Select-" cssClass="searchCombo"
					headerValue="-Select-" onchange="getAssetCd6(this)">
				</s:select>

				<s:select label="Ast Code 6" list="#{'-Select-':'-Select-'}"
					cssClass="searchCombo" name="assetName6" headerKey="-Select-"
					onchange="getAssetSrNo6(this)">
				</s:select>

				<s:select label="Ast Sr No6" list="#{'-Select-':'-Select-'}"
					cssClass="searchCombo" name="assetSrNo6" headerKey="-Select-"
					onchange="getSectionName6(this)">
				</s:select>
				<s:select label="Sec Name6" list="#{'-Select-':'-Select-'}"
					cssClass="searchCombo" name="sectionName6" headerKey="-Select-"
					onchange="getSectionSerialNo6(this)">
				</s:select>
				<s:select label="Sec Sr No6" list="#{'-Select-':'-Select-'}"
					cssClass="searchCombo" name="sectionSerialNo6" headerKey="-Select-">
				</s:select>

				<tr>
					<th colspan="10" align="left">
						<div class="myHeader">Problem</div>
						<hr>
					</th>
				</tr>

				<s:textarea name="problem" cols="130" rows="5">
					<s:param name="labelcolspan" value="%{10}" />
					<s:param name="inputcolspan" value="%{10}" />
				</s:textarea>

				<tr>
					<th colspan="8" align="left">Uphole / Downhole <s:checkbox
							name="updownFlag" label="uphole" onclick="disable();"></s:checkbox>
						<hr></th>
				</tr>
				<tr>
					<th colspan="10" align="left">
						<div class="myHeader">Bore Hole Condition</div>
					</th>
				</tr>

				<s:textfield name="depth" label="Depth (Meter)"
					cssClass="searchCombo" />
				<s:textfield name="mudType" label="Mud Type" cssClass="searchCombo" />
				<s:textfield name="bht" label="BHT (Celcius)" cssClass="searchCombo" />
				<s:textfield name="mudWeight" label="Mud Weight (g/cc)"
					cssClass="searchCombo" />
				<s:textfield name="pressure" label="Pressure (PSI)"
					cssClass="searchCombo" />
				<s:textfield name="holeCondition" label="Hole Condition"
					cssClass="searchCombo" />
				<s:textfield name="bitSize" label="BIT SIZE (Cm)"
					cssClass="searchCombo" />
				<s:textfield name="deviation" label="DEVIATION"
					cssClass="searchCombo" />
			</s:push>

			<sj:submit button="true" value="Save" />
		</s:form>
	</div>
</body>
</html>


