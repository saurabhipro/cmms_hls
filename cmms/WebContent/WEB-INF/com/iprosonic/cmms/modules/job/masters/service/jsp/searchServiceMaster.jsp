<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<script  type="text/javascript" src="js/searchasset.js">
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
		<s:form id="formValidate" theme="qxhtml"
			action="./SearchServiceMasterAction.action" method="post">
			<s:push value="serviceMstBean">

				<s:select label="Service Type"
					list="#{'-Select-':'-Select-'
						,'CH':'CH'
						,'OH':'OH'
						,'CIS':'CIS'
						,'TCP':'TCP'
						,'PLT':'PLT'						
						,'IO':'IO'}"
					name="serviceType" headerKey="0" cssStyle="width:145px;">
				</s:select>

				<sj:submit button="true" value="Search" />
			</s:push>
		</s:form>
	</center>

	<table align="center" style="border:0px solid black" width="50%">
		<tr>
		<td>
		<div 
		style="overflow: auto; height:600px;width:1100px">
		<table class="userTable" align="center">
			<tr class="even">
				<th>EDIT</th>
				<th>SL No</th>
				<th>Service Type</th>
				<th>Service Name</th>
				<th>Explosive</th>
				<th>Deepest Depth</th>
				<th>Meterage Logged</th>
				<th>CH Runs</th>	
				<th>CHMis Runs</th>
				<th>Meterage Perforated</th>
				<th>SPF</th>
				<th>Cores Count</th>
				<th>Surface Pressure</th>
				<th>Level Count</th>
				<th>Pretest Count</th>
				<th>DryTest Count</th>
				<th>PumpOut Time</th>
				<th>Pvt Sample</th>
				<th>Normal Sample</th>
				<th>Revenue</th>
				<th>Remarks</th>
				<th>Failure Group</th>
				<th>Gun Size</th>
				<th>LogSentFrom Base</th>
				<th>LogRecieved AtHo</th>
				<th>LqaDone Date</th>
				<th>Lqat points</th>
				<th>Lqap points</th>
				
			</tr>

			<c:forEach items="${serviceList}" var="serviceMstBean">

				<tr
					class="<s:if test="#userStatus.odd == true ">odd</s:if><s:else>even</s:else>">
					<td><a href="EditServiceAction.action?id=${serviceMstBean.id}">Edit</a>
					</td>
					<td>${serviceMstBean.id}</td>

					<td>${serviceMstBean.serviceType}</td>

					<td>${serviceMstBean.serviceName}</td>

					<c:choose>
						<c:when test="${serviceMstBean.exp== 'Y'}">
							<td align="center" bgcolor="lightgreen" style="font: 20px;">
								<b> ${serviceMstBean.exp}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>${serviceMstBean.exp}</b>
							</td>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${serviceMstBean.deepestDepth== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.deepestDepth}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;">
								${serviceMstBean.deepestDepth}</td>
						</c:otherwise>
					</c:choose>




					<c:choose>
						<c:when test="${serviceMstBean.meterageLogged== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.meterageLogged}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.meterageLogged}</b>
							</td>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${serviceMstBean.chRuns== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.chRuns}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.chRuns}</b>
							</td>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${serviceMstBean.chMisRuns== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.chMisRuns}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.chMisRuns}</b>
							</td>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${serviceMstBean.meteragePerforated== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.meteragePerforated}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.meteragePerforated}</b>
							</td>
						</c:otherwise>
					</c:choose>



					<c:choose>
						<c:when test="${serviceMstBean.spf== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.spf}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.spf}</b>
							</td>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${serviceMstBean.coresCount== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.coresCount}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.coresCount}</b>
							</td>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${serviceMstBean.surfacePressure== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.surfacePressure}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.surfacePressure}</b>
							</td>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${serviceMstBean.levelCount== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.levelCount}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.levelCount}</b>
							</td>
						</c:otherwise>
					</c:choose>



					<c:choose>
						<c:when test="${serviceMstBean.pretestCount== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.pretestCount}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.pretestCount}</b>
							</td>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${serviceMstBean.dryTestCount== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.dryTestCount}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.dryTestCount}</b>
							</td>
						</c:otherwise>
					</c:choose>



					<c:choose>
						<c:when test="${serviceMstBean.pumpOutTime== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.pumpOutTime}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.pumpOutTime}</b>
							</td>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${serviceMstBean.pvtSample== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.pvtSample}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.pvtSample}</b>
							</td>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${serviceMstBean.normalSample== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.normalSample}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.normalSample}</b>
							</td>
						</c:otherwise>
					</c:choose>



					<c:choose>
						<c:when test="${serviceMstBean.revenue== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.revenue}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.revenue}</b>
							</td>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${serviceMstBean.remarks== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.remarks}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.remarks}</b>
							</td>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${serviceMstBean.failureGroup== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.failureGroup}</b></td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.failureGroup}</b></td>
						</c:otherwise>
					</c:choose>

					<c:choose>
						<c:when test="${serviceMstBean.gunSize== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.gunSize}</b></td>
						</c:when>
						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.gunSize}</b></td>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${serviceMstBean.logSentFromBase== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.logSentFromBase}</b>
							</td>
						</c:when>
						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.logSentFromBase}</b>
							</td>
						</c:otherwise>
					</c:choose>



					<c:choose>
						<c:when test="${serviceMstBean.logRecievedAtHo== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.logRecievedAtHo}</b>
							</td>
						</c:when>
						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.logRecievedAtHo}</b>
							</td>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${serviceMstBean.lqaDoneDate== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.lqaDoneDate}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.lqaDoneDate}</b>
							</td>
						</c:otherwise>
					</c:choose>


					<c:choose>
						<c:when test="${serviceMstBean.lqaTpoints== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.lqaTpoints}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.lqaTpoints}</b>
							</td>
						</c:otherwise>
					</c:choose>



					<c:choose>
						<c:when test="${serviceMstBean.lqaPpoints== 'Y'}">
							<td bgcolor="lightgreen" style="font: 20px;" align="center"><b>
									${serviceMstBean.lqaPpoints}</b>
							</td>

						</c:when>

						<c:otherwise>
							<td align="center" style="font: 20px;"><b>
									${serviceMstBean.lqaPpoints}</b>
							</td>
						</c:otherwise>
					</c:choose>
					
				</tr>
			</c:forEach>

		</table>
	</div>
		
		</td>
		</tr>
	</table>
	
	


</body>
</html>