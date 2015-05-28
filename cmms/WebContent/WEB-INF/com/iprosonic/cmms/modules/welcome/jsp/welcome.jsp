<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>WASCPI Dashboard</title>
<link rel="stylesheet" href="../Contents/Style.css" type="text/css" />
<script language="JavaScript" src="js/FusionCharts.js"></script>
</head>

<body>
<table width="98%" border="0" cellspacing="0" cellpadding="3" align="center">
  <tr> 
    <td valign="top" class="text" align="center"> <div id="chartdiv1" align="center"> 
        </div>
      <script type="text/javascript">
		   var chart = new FusionCharts("swf/FCF_MSColumn3DLineDY.swf", "ChartId", "600", "350");
		   chart.setDataURL("xml_data/Col3DLineDY.xml");		   
		   chart.render("chartdiv1");
		</script> 	
	</td>
	<td valign="top" class="text" align="center"> <div id="chartdiv2" align="center"> 
        </div>
      <script type="text/javascript">
		   var chart = new FusionCharts("swf/FCF_MSColumn3DLineDY.swf", "ChartId", "600", "350");
		   chart.setDataURL("xml_data/Col3DLineDY.xml");		   
		   chart.render("chartdiv2");
		</script> 	
	</td>
  </tr>
  <tr> 
    <td valign="top" class="text" align="center"> <div id="chartdiv3" align="center"> 
        </div>
      <script type="text/javascript">
		   var chart = new FusionCharts("swf/FCF_MSColumn3DLineDY.swf", "ChartId", "600", "350");
		   chart.setDataURL("xml_data/Col3DLineDY.xml");		   
		   chart.render("chartdiv3");
		</script> 	
	</td>
	<td valign="top" class="text" align="center"> <div id="chartdiv" align="center"> 
        </div>
      <script type="text/javascript">
		   var chart = new FusionCharts("swf/FCF_Doughnut2D.swf", "ChartId", "600", "350");
		   chart.setDataURL("xml_data/Doughnut2D.xml");		   
		   chart.render("chartdiv");
		</script> </td>
  </tr>
  
</table>
</body>
</html>
