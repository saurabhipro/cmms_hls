<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>

<script>
	function clientList() {
		document.tab2.action = "ListAlgorithmAction";
		document.tab2.submit();

	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Client Page</title>
<sj:head jqueryui="true" />
<s:head />
</head>
<body>

	<div class="container">
		<s:form id="clientform" theme="qxhtml" method="post"
			action="SaveServiceMasterAction.action">
			<s:bean name="java.util.HashMap" id="qTableLayout">
				<s:param name="tablecolspan" value="%{8}" />
			</s:bean>

			<s:div cssClass="myHeader">Create New service</s:div>
			<s:push value="serviceMstBean">
				<s:hidden name="id" />
				<s:select label="Service Type"
					list="#{'-Select-':'-Select-'
						,'CH':'CH'
						,'OH':'OH'
						,'CIS':'CIS'
						,'PLT':'PLT'
						,'TCP':'TCP'
						,'IO':'IO'}"
					name="serviceType" headerKey="0" cssClass="textfield">
				</s:select>


				<s:textfield name="serviceName" label="Servive Name"
					cssClass="textfield"></s:textfield>


				<s:select label="Explosive"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="exp" headerKey="0" cssClass="textfield">
				</s:select>



				<s:select label="Deepest Depth"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="deepestDepth" headerKey="0" cssClass="textfield">
				</s:select>




				<s:select label="Meterage Logged"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="meterageLogged" headerKey="0" cssClass="textfield">
				</s:select>



				<s:select label="CH Runs"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="chRuns" headerKey="0" cssClass="textfield">
				</s:select>


				<s:select label="CHMis Runs"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="chMisRuns" headerKey="0" cssClass="textfield">
				</s:select>


				<s:select label="Meterage Perforated"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="meteragePerforated" headerKey="0" cssClass="textfield">
				</s:select>




				<s:select label="Spf"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="spf" headerKey="0" cssClass="textfield">
				</s:select>



				<s:select label="Cores Count"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="coresCount" headerKey="0" cssClass="textfield">
				</s:select>



				<s:select label="Surface Pressure"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="surfacePressure" headerKey="0" cssClass="textfield">
				</s:select>



				<s:select label="Level Count"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="levelCount" headerKey="0" cssClass="textfield">
				</s:select>



				<s:select label="Pretest Count"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="pretestCount" headerKey="0" cssClass="textfield">
				</s:select>




				<s:select label="DryTest Count"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="dryTestCount" headerKey="0" cssClass="textfield">
				</s:select>



				<s:select label="PumpOut Time"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="pumpOutTime" headerKey="0" cssClass="textfield">
				</s:select>




				<s:select label="Pvt Sample"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="pvtSample" headerKey="0" cssClass="textfield">
				</s:select>



				<s:select label="Normal Sample"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="normalSample" headerKey="0" cssClass="textfield">
				</s:select>


				<s:select label="Revenue"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="revenue" headerKey="0" cssClass="textfield">
				</s:select>





				<s:select label="Remarks"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="remarks" headerKey="0" cssClass="textfield">
				</s:select>




				<s:select label="Failure Group"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="failureGroup" headerKey="0" cssClass="textfield">
				</s:select>


				<s:select label="LogSentFrom Base"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="logSentFromBase" headerKey="0" cssClass="textfield">
				</s:select>



				<s:select label="Log RecievedAtHo"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="logRecievedAtHo" headerKey="0" cssClass="textfield">
				</s:select>



				<s:select label="LqaDone Date"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="lqaDoneDate" headerKey="0" cssClass="textfield">
				</s:select>

				<s:select label="Lqat points"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="lqaTpoints" headerKey="0" cssClass="textfield">
				</s:select>



				<s:select label="Lqap points"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="lqaPpoints" headerKey="0" cssClass="textfield">
				</s:select>

				<s:select label="GUN size"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="gunSize" headerKey="0" cssClass="textfield">
				</s:select>

				<s:select label="SND SNP"
					list="#{'-Select-':'-Select-'
						,'Y':'Y'
						,'N':'N'}"
					name="snpSnd" headerKey="0" cssClass="textfield">
				</s:select>

				<br />


				<table align="center">
					<tr>
							<td><s:submit type="Submit" align="center" value="Save"
									cssClass="myButton" /></td>
						</center>
					</tr>
				</table>


			</s:push>


		</s:form>
	</div>
</body>
</html>