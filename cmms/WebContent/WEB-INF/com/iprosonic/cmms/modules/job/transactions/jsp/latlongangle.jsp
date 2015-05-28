<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns='http://www.w3.org/1999/xhtml'>
<head>
    <title>Latitude and Longitude Picker jQuery plugin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <link rel="stylesheet" type="text/css" href="css/demo.css"/>
    <link rel="stylesheet" href="css/ol2/theme/default/style.css" type="text/css"/>

    <!-- Dependencies: JQuery and OpenLayer API should be loaded first -->
    <script src="js/jquery-1.7.2.min.js"></script>
    <script src="js/OpenLayers.js"></script>

    <!-- CSS and JS for our code -->
    <link href="css/jquery-position-picker.css" rel="stylesheet" type="text/css"/>
    <script src="js/jquery-position-picker.debug.js"></script>
   <script language="javascript">
	function changeparent() {

	     var lat=document.getElementById("lat").value;		
	     var long=document.getElementById("long").value;
	     
	     var degree=parseInt(lat, 10);
	     var min=lat-degree;
	     min=min*60;
	     var sec=min-parseInt(min);
	     min=parseInt(min);
	     sec=parseInt(sec*60);
	    
	     var degree1=parseInt(long, 10);
	     var min1=long-degree1;
	     min1=min1*60;
	     var sec1=min1-parseInt(min1);
	     min1=parseInt(min1);
	     sec1=parseInt(sec1*60);
	     
	     
		           window.opener.document.getElementById("latlongangle").value =degree+"° "+ min + "' " + sec + "\""; 
					window.opener.document.getElementById("longitude").value =degree1+"° "+ min1 + "' " + sec1 + "\"";
			
		window.close();
	}
</script>
 
</head>
<body>

 
    
    <fieldset class="gllpLatlonPicker">
    	
        <div class="gllpMap"></div>
        <hr>
        Search Location: <input type="text" class="gllpSearchField">
        <input type="button" class="gllpSearchButton" value="GO!"><br/>
        <hr>
        Latitude: <input type="text" class="gllpLatitude" name="lat" id="lat" value="28"/>
        Longitude: <input type="text" class="gllpLongitude" name="long" id="long" value="77"/><br/>
		<input type="text" style="visibility:hidden;" class="gllpZoom" value="3"/>
        <hr>
        Name of Position: <input type="text" class="gllpLocationName" size=42/>
        <input type="button" class="gllpSearchButton" value="Submit"
						onclick="changeparent()" />
        <br/>
        
    </fieldset>

 
</body>
</html>
