var abled_cell_backround_color = "yellow";
var disabled_cell_backround_color = "#D3E397";

var role = "NA";
function setRole(roleSess) {
	role = roleSess;
}

function disableField() {
	if (role == "FSQC") {
		document.getElementById("logRcieveAtHo").readOnly=false;
		document.getElementById("lqaDoneDate").readOnly=false;
		document.getElementById("lqaTechnical").readOnly=false;
		document.getElementById("lqaPresentation").readOnly=false;
		document.getElementById("lqaPresentation").readOnly=false;

	}

	else {
		document.getElementById("logRcieveAtHo").readOnly=true;
		document.getElementById("lqaDoneDate").readOnly=true;
		document.getElementById("lqaTechnical").readOnly=true;
		document.getElementById("lqaPresentation").readOnly=false;
		//document.getElementById("logSendFromBase").readOnly=true;
		
	}

}

function disable_fields_in_service(obj) {
	var serviceName = obj.value;
	var data=document.getElementById("serviceType");
	var ser_id = obj.id;
	var fieldsId = ";";
	var fields = ";";
	var inputs = document.getElementsByTagName("input");
	for ( var i = 0; i < inputs.length; i++) {
		if (inputs[i].getAttribute('type') == 'text') {
			fields = inputs[i].getAttribute('name');
			if (fields != "lossTime" && fields != "serialNo"&& fields != "assetCd") {
				fieldsId += inputs[i].getAttribute('name') + ";";
			}
		}
	}	

	url = 'GetListAction.action?param=getServiceFlg&serviceName='
			+ serviceName;
	            $.post(
					url,
					function(results) {
						$('.result').html(results);
						var map_to_enable_fields_in_ser = new Array();
						map_to_enable_fields_in_ser = results.split(";");
						fieldIdArr = fieldsId.split(";");
						for ( var i = 1; i < 24; i++) {
							if (map_to_enable_fields_in_ser[i] == "Y") {
								document.getElementById(fieldIdArr[i]).readOnly=false;
								document.getElementById(fieldIdArr[i]).style.backgroundColor = abled_cell_backround_color;
								document.getElementById(fieldIdArr[i]).style.borderColor = abled_cell_border_color;								
							} else {
								document.getElementById(fieldIdArr[i]).style.backgroundColor = disabled_cell_backround_color;
								document.getElementById(fieldIdArr[i]).style.borderColor = disabled_cell_border_color;
								document.getElementById(fieldIdArr[i]).readOnly=true;							
							}

						}

					});

}
