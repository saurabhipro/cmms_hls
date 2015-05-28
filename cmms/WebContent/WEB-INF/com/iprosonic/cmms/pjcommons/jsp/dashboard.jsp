<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<sj:head jqueryui="true" />

<style type="text/css">

@import url(css/tablestyle.css);

</style>

<sj:head />
<script type="text/javascript" src="js/FusionCharts.js"></script>
<script type="text/javascript" src="js/dashboard.js"></script>
</head>

<body>

<%@page import="com.iprosonic.cmms.modules.job.transactions.job.service.SearchJobService"%>
<%
 List<String> srvType=new SearchJobService().getServiceTypes();
 Iterator<String> itstyp=srvType.iterator();

%>

<div class="container">

	
	<ul class="tabs">

		<li><a href="#tab1">JOB(Eng)</a></li>
		<li><a href="#tab1">JOB(Crew)</a></li>
		<li><a href="#tab2">CPI</a></li>


	</ul>

	<div class="tab_container">
		<!-- job	-->
		<div id="tab1" class="tab_content">

			<table style="font-size: 15px; ">
				<tr>
					<th>From <sj:datepicker displayFormat="yy-mm-dd"
							name="fromDate" id="fromDate" value="2014-01-01"
							style="width:80px" /></th>
					<th>To<sj:datepicker displayFormat="yy-mm-dd" name="toDate"
							id="toDate" value="2014-04-30" style="width:80px" />
					</th>
					<th>Client<select id="client_name"><option>-select-</option>
					</select></th>
					<th>JobStatus <select id=""><option>-select-</option>
					</select>
					</th>
                    
					<th>Engineer Name<select id=""><option>-select-</option>
					</select>
					</th>
					<th>Service Type<select id="srvcType"><option value="">-select-</option><%String typ=""; while(itstyp.hasNext()){ typ=(String)itstyp.next();%><option value="<%=typ%>"><%=typ %></option><%} %> 
					</select>
					</th>
                     <th><button id="go" onClick="getChartFusionCharts();">Go</button>
                     </th>

				</tr>
			</table>


			<table style="width: 100%;height:500px">
				<tr>
					<td>
					<div id="jobvseng" align="center">Getting Jobs..</div> <script
										type="text/javascript">
										/* var charta = new FusionCharts(
												"FusionCharts/col3D/FCF_Column3D.swf",
												"ChartIda", "350", "300", {
													debugMode : false,
													registerWithJS : true
												});
										charta.setDataURL("FusionCharts/col3D/Column3D.xml");
										charta.render("jobvseng"); */
									</script>
					
					
					
					</td>
					<td><div id="job23" align="center">Getting lost time services..</div> <script
										type="text/javascript">
									/* 	var chart23 = new FusionCharts(
												"FusionCharts/MSLine/FCF_Column2D.swf",
												"ChartIda23", "350", "300", {
													debugMode : false,
													registerWithJS : true
												});
										chart23.setDataURL("FusionCharts/MSLine/Column2D.xml");
										chart23.render("job23"); */
									</script>
					 
					
					
					
					</td>
					<td>
					     <div id="job13" align="center">Getting Services..</div> <script
										type="text/javascript">
										/* var charta3 = new FusionCharts(
												"FusionCharts/COL2D/FCF_Column2D.swf",
												"ChartIda3", "350", "300", {
													debugMode : false,
													registerWithJS : true
												});
										charta3
												.setDataURL("FusionCharts/COL2D/Column2D.xml");
										charta3.render("job13"); */
									</script>
					
					</td>
					
				</tr>

				<tr>
					<td> <div id="job21" align="center">Getting CHMissRuns..</div> <%-- <script type="text/javascript">
										var chart21 = new FusionCharts(
												"FusionCharts/line21/FCF_Column2D.swf",
												"ChartIda3", "350", "300", {
													debugMode : false,
													registerWithJS : true
												});
										chart21
												.setDataURL("FusionCharts/line21/Column2D.xml");
										chart21.render("job21");
									</script> --%></td>
					
					<td><div id="job22" align="center"> Getting Operation Time..</div> <%-- <script
										type="text/javascript">
										var chart22 = new FusionCharts(
												"FusionCharts/MSCOL3D1/FCF_Column2D.swf",
												"ChartIda21", "350", "300", {
													debugMode : false,
													registerWithJS : true
												});
										chart22
												.setDataURL("FusionCharts/MSCOL3D1/Column2D.xml");
										chart22.render("job22");
									</script> --%></td>
									
									
						<td>
						
						<div id="job12" align="center">Getting Overall Efficiency..</div> <%-- <script
										type="text/javascript">
										var charta2 = new FusionCharts(
												"FusionCharts/line2D/FCF_Column2D.swf",
												"ChartIda2", "350", "300", {
													debugMode : false,
													registerWithJS : true
												});
										charta2
												.setDataURL("FusionCharts/line2D/Column2D.xml");
										charta2.render("job12");
									</script> --%>
						
						</td>			
				</tr>

			</table>


		</div>

		<div id="tab2" class="tab_content"></div>

	</div>
</div>

</body>







