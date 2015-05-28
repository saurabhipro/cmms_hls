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
</head>

<body>

	<center>
		<s:form id="formValidate" theme="qxhtml" action="SearchAssetAction"
			method="post">
			<s:push value="assetBean">

				<s:select label="Asset Type" list="#session.assetType"
					name="assetType" headerKey="-Select-" cssStyle="width:145px"
					headerValue="-Select-" onchange="getAssetCd(this)">
				</s:select>

				<s:select label="Asset Code" list="#{'-Select-':'-Select-'}"
					name="assetCd" headerKey="0" cssStyle="width:145px">
				</s:select>

				<sj:submit button="true" value="Search" />
			</s:push>
		</s:form>
	</center>

	<s:if test="assetBeansList.size()> 0">
		<div class="content">
			<table class="userTable" cellpadding="5px" width="100%">
				<tr class="even">
					<th>SL No</th>
					<th>RegionCd</th>
					<th>LocationCd</th>
					<th>UnitCd</th>
					<th>ClientCd</th>
					<th>AssetType</th>
					<th>AssetCd</th>
					<th>SectionCd</th>
					<th>SectionSrNo</th>
					<th>EDIT</th>
				</tr>

				<s:iterator value="assetBeansList">
					<tr
						class="<s:if test="#userStatus.odd == true ">odd</s:if><s:else>even</s:else>">
						<td><s:property value="id" /></td>

						<td><s:property value="regionCd" />
						</td>
						<td><s:property value="locationCd" />
						</td>
						<td><s:property value="unitCd" />
						</td>
						<td><s:property value="clientCd" />
						</td>
						<td><s:property value="assetType" />
						</td>
						<td><s:property value="assetCd" />
						</td>
						<td><s:property value="sectionCd" />
						</td>
						<td><s:property value="sectionSerialNo" />
						</td>
						<td><s:url id="editURL" action="EditAssetAction">
								<s:param name="id" value="%{id}"></s:param>
							</s:url> <s:a href="%{editURL}">Edit</s:a>
						</td>

					</tr>
				</s:iterator>
			</table>
		</div>
	</s:if>



</body>
</html>