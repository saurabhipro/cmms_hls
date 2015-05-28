<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sj" uri="/struts-jquery-tags"%>
<%@ taglib prefix="sjg" uri="/struts-jquery-grid-tags"%>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/button.css" />

<script type="text/javascript">
  
  
  function callGoBack(){

	  var oldURL = document.referrer;
      url = 'GoBackAction.action';
      document.GoBackForm.action=url;
      document.GoBackForm.submit();
      return true;
  	
  }
</script>
</head>
<body>

	<center>
		<table height="80%">
			<tr align="center">
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<br>
				<b><font size="6" color="red"> <s:property value="message" />
					
				</font> </u> 
			</tr>
				<br>
				<br>
				<br>
				<br>
		
			<tr align="center">
			<td>
			     <form name="GoBackForm" action="GoBackAction.action">
			     <input type="hidden" name="oldURL"  value="<%=request.getHeader("Referer")%>"/>
			     <input type="submit" value="Back" class="myButton" onclick="callGoBack();"/>
			
			</form>
			</td>
			</tr>
		</table>
	</center>
</body>