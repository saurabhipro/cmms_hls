<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<script language="javascript" type="text/javascript"
	src="js/historyCard.js">
	
</script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration Page</title>
<sj:head jqueryui="true" />
<style type="text/css">
@import url(css/tablestyle.css);
</style>
</head>
<body>
	<fieldset>
		<form id="HistoryCardReport" action="HistoryCardReportAction" method="post">
			<table align="center">
			<tr>
				<s:select label="Asset Type" list="#session.assetType"
					name="assetType" headerKey="-Select-" cssStyle="width:145px"
					headerValue="-Select-" onchange="getAssetCd(this)">
				</s:select>
				<s:select label="Asset Code " list="#{'-Select-':'-Select-'}"
					name="assetName" headerKey="-Select-" cssStyle="width:145px"
					onchange="getAssetSrNo(this)">
				</s:select>

				<s:select label="Asset Sr No" list="#{'-Select-':'-Select-'}"
					name="assetSrNo" headerKey="-Select-" cssStyle="width:145px"
					onchange="getSectionName(this)">
				</s:select>
				<s:select label="Section Name" list="#{'-Select-':'-Select-'}"
					name="sectionName" headerKey="-Select-" cssStyle="width:145px"
					onchange="getSectionSerialNo(this)">
				</s:select>
				<s:select label="Section Sr No" list="#{'-Select-':'-Select-'}"
					name="sectionSerialNo" headerKey="-Select-" cssStyle="width:145px">
				</s:select>
				</tr>
				<s:submit button="true" value="Generate History Card" />
		</table>
		</form>
	</fieldset>
	


</body>


</html>
