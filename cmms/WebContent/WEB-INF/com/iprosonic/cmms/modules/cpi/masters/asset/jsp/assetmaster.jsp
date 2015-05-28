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

		<div class="container">
			<s:form action="SaveAssetAction" method="post">
				<s:bean name="java.util.HashMap" id="qTableLayout">
					<s:param name="tablecolspan" value="%{8}" />
				</s:bean>
				<s:push value="assetBean">

					<s:select label="Region Code"
						list="#{
						'-Select-':'-Select-',
						'SWR':'SWR',
						'NER':'NER'
						}"
						cssStyle="width:145px" name="regionCd">
					</s:select>

					<s:select label="Location Code"
						list="#{
						'-Select-':'-Select-',
						'NAZ':'NAZ',
						'AGT':'AGT',
						'GNDR':'GNDR'
						
						}"
						cssStyle="width:145px" name="locationCd">
					</s:select>




					<s:select label="Unit Code"
						list="#{
						'-Select-':'-Select-',
						'SKD005OH':'SKD005OH',
						'SKD004OH':'SKD004OH',
						'SKD002OH':'SKD002OH',
						'SKD001OH':'SKD001OH',
						'KWT0020H':'KWT0020H',
						'SKD007OH':'SKD007OH',
						'SKD008OH':'SKD008OH'
						}"
						cssStyle="width:145px" name="unitCd">
					</s:select>


					<s:select label="Client Code"
						list="#{
						'-Select-':'-Select-',
						'ONGC-NAZ':'ONGC-NAZ',
						'ONGC-AGT':'ONGC-AGT',
						'RIL-CBM':'RIL-CBM',
						'HLSA':'HLSA'
						}"
						cssStyle="width:145px" name="clientCd">
					</s:select>
					<s:select label="Asset Type"
						list="#{
						'-Select-':'-Select-',
						'FILD':'FILD',
						'DHTL':'DHTL',
						'ACQ':'ACQ',
						'PREF':'PREF',
						'PEFR':'PEFR'
						}"
						cssStyle="width:145px" name="assetType">
					</s:select>


					<s:select label="Maintanence Type"
						list="#{
						'-Select-':'-Select-',
						'ELE':'ELE',
						'SON':'SON',
						'SAM':'SAM',
						'HEA':'HEA',
						'EFC':'EFC',
						'PRO':'PRO',
						'WHE':'WHE',
						'HSE':'HSE',
						'RDT':'RDT'
						}"
						cssStyle="width:145px" name="maintanenceType">
					</s:select>

					<s:textfield id="assetCd" name="assetCd" label="AssetCd"
						readonly="false" />
					<s:textfield id="assetSerialNo" name="assetSerialNo"
						label="AssetSerialNo" readonly="false" />
					<s:textfield id="sectionCd" name="sectionCd" label="SectionCd"
						readonly="false" />
					<s:textfield id="sectionSerialNo" name="sectionSerialNo"
						label="SectionSerialNo" readonly="false" />

					<s:textfield id="pmSchedule" name="pmSchedule" label="PmSchedule"
						readonly="false" />
					<s:textfield id="pmScheduleUnit" name="pmScheduleUnit"
						label="PmScheduleUnit" readonly="false" />
					<table align="center">
						<tr>
							<td><s:submit value="Save" cssClass="myButton" /></td>
						</tr>
					</table>
				</s:push>
			</s:form>
		</div>
</body>
</html>