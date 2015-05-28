$(document).ready(function(){
	 
	
	
	 
	
	 $(".tab_content").hide(); //Hide all content
     $("ul.tabs li:first").addClass("active").show(); //Activate first tab
     $(".tab_content:first").show(); //Show first tab content
     $("ul.tabs li").click(function()
     {
         $("ul.tabs li").removeClass("active"); //Remove any "active" class
         $(this).addClass("active"); //Add "active" class to selected tab
         $(".tab_content").hide(); //Hide all tab content
         var activeTab = $(this).find("a").attr("href"); //Find the rel attribute value to identify the active tab + content
         $(activeTab).fadeIn(); //Fade in the active content
         return false;
     });
	 
     getChartFusionCharts();
     
 });


function getChartFusionCharts()
{

    var fromDate = document.getElementById('fromDate').value;
    var toDate = document.getElementById('toDate').value;
    var stype=document.getElementById('srvcType').value;
    
 
    url='FusionJobAction.action?fromDate='+fromDate+'&enddate='+toDate+'&serviceType='+stype;

  
    
    $.post(url, function(results)
    {
    	
    	var arry=results.split(";");
    	
    	
    	
        
    	var charta = new FusionCharts(
				"FusionCharts/col3D/FCF_Column3D.swf",
				"ChartIda", "350", "300", {
					debugMode : false,
					registerWithJS : true
				});
		charta.setDataXML(arry[0]);		
		charta.render("jobvseng");
		
		
		var chart23 = new FusionCharts(
				"FusionCharts/MSLine/FCF_Column2D.swf",
				"ChartIda23", "350", "300", {
					debugMode : false,
					registerWithJS : true
				});
		chart23.setDataXML(arry[1]);
		chart23.render("job23");
		
		
		var charta3 = new FusionCharts(
				"FusionCharts/COL2D/FCF_Column2D.swf",
				"ChartIda3", "350", "300", {
					debugMode : false,
					registerWithJS : true
				});
		charta3
				.setDataXML(arry[2]);
		charta3.render("job13");
		
		var chart21 = new FusionCharts(
				"FusionCharts/line21/FCF_Column2D.swf",
				"ChartIda3", "350", "300", {
					debugMode : false,
					registerWithJS : true
				});
		chart21
				.setDataXML(arry[3]);
		chart21.render("job21");
		
		
		
		var chart22 = new FusionCharts(
				"FusionCharts/MSCOL3D1/FCF_Column2D.swf",
				"ChartIda21", "350", "300", {
					debugMode : false,
					registerWithJS : true
				});
		chart22
				.setDataXML(arry[4]);
		chart22.render("job22");
		
		var charta2 = new FusionCharts(
				"FusionCharts/line2D/FCF_Column2D.swf",
				"ChartIda2", "350", "300", {
					debugMode : false,
					registerWithJS : true
				});
		charta2
				.setDataXML(arry[5]);
		charta2.render("job12");
		
    });
}