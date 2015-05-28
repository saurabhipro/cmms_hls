<%@ page contentType="text/html; charset=ISO-8859-1" language="java"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crew Details</title>

<style type="text/css">
@import url(css/tablestyle.css);
</style>

<style type="text/css">
.evenHeader{
background-color:red;
}
</style>

<script type="text/javascript">
function pushBack()
{	
	 //alert("Parameters:--"+window.location.search.substring(1));
	var elementId=window.location.search.substring(1);
	var chk = document.crewDetailForm.crewName.length;
	var crewNames = "";
	for(i=0;i<chk;i++){
		if(document.crewDetailForm.crewName[i].checked){
			crewNames=crewNames+document.crewDetailForm.crewName[i].value+"~"+document.crewDetailForm.qty[i].value+",";
			//alert(crewNames);
		}
	}
//	alert("Element ID:--"+elementId+ "Element ID Object"+window.opener.document.getElementById(elementId))
alert("Element ID:---"+elementId)
	window.opener.document.getElementById(elementId).value=crewNames;
	window.close();
	}
</script>
</head>
<body>
<s:form name="crewDetailForm" >
	 
	 
		<div id="one">
			<div class="content">
				<table class="userTable" cellpadding="5px" width="100%" style=" color: #222222;font-size: 0.8em;text-align: center;">
					<tr class="evenHeader">
						<th>Explosive Code</th>
						<th>Explosive Name</th>
						<th>Qty</th>
						<th>Select</th>			
					</tr>
<%! int i=1; %>
					<s:iterator value="explosivesList">
					
						<tr class="<s:if test="i%2 != 0">odd</s:if><s:else>even</s:else>">
							<td><s:property value="explCd" /></td>
							<td><s:property value="explName" /></td>
							<td><input type="text" name="qty" width="22" /></td>
							<td><input type="checkbox" name="crewName" id="crewName" value="<s:property value="explCd" />"></td>							
						</tr>
						<% i++; %>
					</s:iterator>
				</table>
			</div>
		</div>
	 <input type="button" name="Submit" value="Submit" onclick="pushBack()">
	
	</s:form>
</body>
</html>