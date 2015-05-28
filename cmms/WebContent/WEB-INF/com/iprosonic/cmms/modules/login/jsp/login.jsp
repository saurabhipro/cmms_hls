<%@ taglib uri="/struts-tags" prefix="s"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
<script src="js/jquery.js" type="text/javascript"></script>
<script src="js/jquery.validate.pack.js" type="text/javascript"></script>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

<title>Login Form</title>
<link rel="stylesheet" href="css/login.css">


<style>
.error {
	color: red;
	font-size: 10px;
}
</style>
<script type="text/javascript">
	function getLocationName() {
		$('#loadingmessage').show();
		url = 'GetLocationNameAction.action';
		var tag="<select name='locationCd' style='height:26px;'>";
		$.post(url, function(results) {
			var arr=results.split(":");
			for (i = 0; i < arr.length; i++) {
				tag=tag+"<option value="+arr[i]+">"+arr[i]+"</option>";
			}
			tag=tag+"</select>";
			$('#loadingmessage').hide();
			document.getElementById("loc").innerHTML=tag;
		});

	}

</script>
<script type="text/javascript">
	$(function() {

		$("#login_form").validate();
	});
</script>
</head>
<header>
	<div id="fullBg">
		<h1 class="logo">
			<a href="index.php"> <img alt="HLS Asia"
				src="images/hls-logo.png">
			</a>
		</h1>

		<h1 class="logo1">
			<a href="index.php"> <img alt="Iprosonic"
				src="images/logo-bright.png" width="208" height="115">
			</a>
		</h1>
	</div>

</header>



<body onload="getLocationName()">
	<section class="container">
		<div class="login">
			<h1>HLS Work Order Management System</h1>
			
			<s:form name="login_form" accept-charset="UTF-8"
					action="LoginAction.action" class="validate" id="new_lead"
					method="post">
				<p>
					<s:textfield name="employeeCd" placeholder="UserId" />
				</p>
				<p>
					<s:password class="field required refresh "
							data-initial="password" id="password" name="password" size="30"
							title="Password is required" type="password" placeholder="Password" />
				</p>

			 <tr>
				<td style="text-align: center;">		<div id='loadingmessage' style='display: show'>
				
									<img src="images/pIkfp.gif" />
								</div>	
					<div id="loc"></div>
				 </td>
			</tr>
			
			<tr>
				<td>	 
				<p class="remember_me">
					<label> <input type="checkbox" name="remember_me"
						id="remember_me"> Remember me on this computer
					</label>
				</p>
				<p class="submit">
					<s:submit value="Submit" styleClass="button" ></s:submit>
				
				</p>
				</td>
			</tr>
		</s:form>
		</div>


	</section>


</body>
</html>





