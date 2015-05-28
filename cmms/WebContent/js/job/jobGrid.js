var role = "NA";

var rowCount;
var table = "";

var counter_date_time_picker = 0;
var counter_partCd_auto_complete = 0;
var counter_assetCd_auto_complete = 0;
var counter_serialCd_auto_complete = 0;

var counter_x = 0;
var counter_y = 0;
var visibility_switch = "visible";
var fields_width_disabled = "200px";
var fields_width_grid = "80px";
var fields_width_date_time_grid = "110px";
var abled_cell_border_color = "red";
var disabled_cell_border_color = "";
var abled_cell_backround_color = "#FFFF66";
var disabled_cell_backround_color = "#f5c8b4";

var rigCount = 0;
var runCount = 0;
var serCount = 0;
var explCount = 0;

var data = 'undefined';
var datacrew = 'undefined';

var rig = [ [ 'Rig Id', 'text', 'rig' ],
		[ 'Rig Up Start', 'datetime', 'rigUpStart' ],
		[ 'Rig Up End', 'datetime', 'rigUpEnd' ],
		[ 'Rig Down Start', 'datetime', 'rigDownStart' ],
		[ 'Rig Down End', 'datetime', 'rigDownEnd' ] ];
var run = [ [ 'Run Id', 'text', 'run' ], [ 'BHT', 'text', 'bht' ],
		[ 'Operating time start', 'datetime', 'rih' ],
		[ 'Operating time stop', 'datetime', 'pooh' ], [ 'WT', 'text', 'wt' ],
		[ 'OT', 'text', 'ot' ] ];

var ser = [ [ 'Service Id', 'text', 'ser', '' ],
		[ 'Service Type', 'select', 'serviceType', 'IO;CH;OH;TCP-PERFO' ],
		[ 'Service Name', 'select', 'serviceName', 'Select' ],
		[ 'Loss Time', 'text', 'lossTime', '' ],
		[ 'Deepest Depth', 'text', 'deepestdepth', '' ],
		[ 'Meterage Logged', 'text', 'meterageLogged', '' ],
		[ 'Rev($)', 'text', 'revenue', '' ],
		[ 'Failure Group', 'text', 'failureGroup', '' ],
		[ 'Pretest Count', 'text', 'preTestCount', '' ],
		[ 'Pump Out Time', 'text', 'pumpOutTime', '' ],
		[ 'DryTest Count', 'text', 'dryTestCount', '' ],
		[ 'PVT Sample', 'text', 'pvtSample', '' ],
		[ 'Normal Sample', 'text', 'normalSample', '' ],
		[ 'Level Count', 'text', 'levelCount', '' ],
		[ 'Cores Count', 'text', 'coresCount', '' ],
		[ 'Gun Size', 'text', 'gunSize', '' ], [ 'SPF', 'text', 'spf', '' ],
		[ 'Meterage Perforated', 'text', 'meteragePerforated', '' ],
		[ 'Surface Pressure', 'text', 'surfacePressure', '' ],
		[ 'CH Runs', 'text', 'chRuns', '' ],
		[ 'CH Mis Runs', 'text', 'chMisRuns', '' ],
		[ 'TCPMissRun', 'text', 'tcp', '' ],
		[ 'Asset Cd', 'autocomplete', 'assetCd', '' ],
		[ 'Serial No', 'autocomplete', 'serialNo', '' ],
		[ 'EngName', 'text', 'engi', '' ], [ 'CrewName', 'text', 'crew', '' ],
		[ 'Remarks', 'text', 'remarks', '' ],
		[ 'Log Send from  Base:', 'datetime', 'LogSentFromBase', '' ],
		[ 'Log recieved at HO', 'datetime', 'logRecievedAtHo', '' ],
		[ 'LQA Done date', 'datetime', 'lqaDoneDate', '' ],
		[ 'LQA Technical', 'select', 'lqaTpoints', '-Select-;-1;2;3;4;5' ],
		[ 'LQA Presentation', 'select', 'lqaPpoints', '-Select-;1;2;3;4;5' ],
		[ 'SND SNP', 'text', 'snpSnd', '' ] ];

var expl = [ [ 'Part Id', 'text', 'exp' ],
		[ 'Part No', 'autocomplete', 'partCd' ], [ 'Qty', 'text' ],
		[ 'UOM', 'select', 'Feet;No;DETO;RED DETO;CHARGE;BOOSTER;INDICATOR' ] ];

function setRigCount(rigct) {
	rigCount = rigct;
}

function setRunCount(runct) {
	runCount = runct;
}

function setSerCount(serct) {
	serCount = serct;
}

function setExpCount(expct) {
	explCount = expct;
}

function setRole(roleSess) {
	role = roleSess;
}

function enableServiceOnClick(obj) {
	ser_id = obj.id.split("-")[1];
}

function getServiceNames(obj) {

	$('#loadingmessage').show();
	var len = obj.id.length;
	var serviceType = obj.value;
	url = 'GetListAction.action?param=getServiceName' + '&serviceType='
			+ serviceType;
	$.post(url, function(results) {
		$('.result').html(results);
		$('#loadingmessage').hide();
		destinationCombo = document.getElementById(obj.id.substring(0, len - 2)
				+ "-2");
		appValuesInCombo(results, destinationCombo);
	});
}

function disable_fields_in_service(obj) {
	var serviceName = obj.value;

	url = 'GetListAction.action?param=getServiceFlg' + '&serviceName='
			+ serviceName;
	$
			.post(
					url,
					function(results) {
						$('.result').html(results);
						var map_to_enable_fields_in_ser = new Array();
						map_to_enable_fields_in_ser = results.split(";");

						if (map_to_enable_fields_in_ser[23] == "N") {
							document.getElementById('exp').disabled = true;
						} else {
							document.getElementById('exp').disabled = false;
						}
						var countcolumn = 1;
						console.log(ser.length - 4 + "-"
								+ map_to_enable_fields_in_ser.length);
						for (var i = 4; i < ser.length; i++) {
							var len = obj.id.length;
							id = obj.id.substring(0, len - 2) + "-" + i;

							if (map_to_enable_fields_in_ser[countcolumn] == "Y") {
								document.getElementById(id).style.backgroundColor = abled_cell_backround_color;
								document.getElementById(id).style.borderColor = abled_cell_border_color;
								document.getElementById(id).value = "0";
								document.getElementById(id).disabled = false;
							} else {
								document.getElementById(id).style.backgroundColor = disabled_cell_backround_color;
								document.getElementById(id).style.borderColor = disabled_cell_border_color;
								document.getElementById(id).value = "0";
								document.getElementById(id).disabled = true;
							}

							if (i > 26 || i == 14) {
								if (role == "FSQC") {
									document.getElementById(id).style.backgroundColor = abled_cell_backround_color;
									document.getElementById(id).style.borderColor = abled_cell_border_color;
									document.getElementById(id).value = "";
									document.getElementById(id).disabled = false;

								} else {
									document.getElementById(id).style.backgroundColor = disabled_cell_backround_color;
									document.getElementById(id).style.borderColor = disabled_cell_border_color;
									document.getElementById(id).value = "-Select-";
									document.getElementById(id).disabled = true;
								}
							}
							if (i == 24) {
								document.getElementById(id).style.backgroundColor = abled_cell_backround_color;
								document.getElementById(id).style.borderColor = abled_cell_border_color;
								document.getElementById(id).value = document
										.getElementById("engineer").value;
								document.getElementById(id).disabled = false;
							}
							if (i == 25) {
								document.getElementById(id).style.backgroundColor = abled_cell_backround_color;
								document.getElementById(id).style.borderColor = abled_cell_border_color;
								document.getElementById(id).value = document
										.getElementById("crew").value;
								document.getElementById(id).disabled = false;
							}

							countcolumn++;
						}
					});
}

function addRig(ref) {

	var unitLeftBase = document.getElementById("unitLeftBase").value;
	var unitReachedWellSite = document.getElementById("unitReachedSite").value;
	var unitLeftSite = document.getElementById("unitLeftSite").value;
	var unitReachedBase = document.getElementById("unitReachedBase").value;

	if (new Date(unitLeftBase) > new Date(unitReachedWellSite)) {
		alert("Your Unit Left Base date can not be more than Unit Reached WellSite");
		resetGrid();
		return false;
	}
	if (new Date(unitLeftSite) > new Date(unitReachedBase)) {
		alert("Your Unit Left Site can not be more than Unit Reached Base");
		resetGrid();
		return false;
	}

	if (!validate()) {
		return false;
	}

	btnFunctuion(ref);
	rigCount++;
	table = document.getElementById("datatable");
	rowCount = table.rows.length;
	var row = table.insertRow(rowCount);
	var newCell;
	var component = "";
	newCell = row.insertCell(0);
	newCell.className = "rig";
	component = document.createElement("input");
	component.type = "radio";
	component.value = "rig";
	component.name = "radio";

	newCell.appendChild(component);
	document.getElementById('rigcount').value = rigCount;

	counter_x = 0;
	counter_y = 0;

	for (var i = 1; i < (rig.length * 2) + 2; i++) {
		newCell = row.insertCell(i);
		newCell.className = "rig";
		if (i % 2 != 0) {
			newCell.innerHTML = rig[counter_y][0] + ':';
			counter_y = counter_y + 1;
		} else {
			id = 'rig-' + rigCount + "-" + counter_x;
			if (rig[counter_x][1] == 'datetime') {
				var d = new Date();
				component = document.createElement("input");
				component.type = "text";
				component.style.width = fields_width_date_time_grid;
				component.style.borderColor = abled_cell_border_color;
				component.value = d.format('d') + "-" + d.format('M') + "-"
						+ d.format('Y') + " " + d.format('H:i');
				component.id = id;
				component.name = id;
				component.readOnly = true;
				component.onclick = function() {
					NewCal(this.id, 'ddmmmyyyy', true, 24);
				};
				newCell.appendChild(component);
				counter_x++;
				continue;
			}
			if (rig[counter_x][1] == 'text') {
				component = document.createElement("input");
				component.type = "text";
				component.style.borderColor = abled_cell_border_color;
				component.style.width = fields_width_grid;
				if (counter_x == 0) {
					component.value = id;
					component.disabled = true;
				} else {
					component.value = "";
				}
				component.id = id;
				component.name = id;

				component.onblur = function() {
					resetToZero(this);
				};
				newCell.appendChild(component);
				counter_x++;
				continue;
			}
		}
	}
}

function addRun(ref) {

	if (!validate()) {
		return false;
	}

	btnFunctuion(ref);

	runCount++;
	table = document.getElementById("datatable");
	rowCount = table.rows.length;

	var row = table.insertRow(rowCount);
	var newCell;
	var component = "";

	newCell = row.insertCell(0);
	newCell.className = "run";
	component = document.createElement("input");
	component.type = "radio";
	component.value = "run";
	component.name = "radio";

	newCell.appendChild(component);
	document.getElementById('runcount').value = rigCount;

	counter_x = 0;
	counter_y = 0;

	var j = 1;
	for (var i = 1; i < (run.length * 2) + 2; i++) {

		// Row Splitter
		if (i % 12 == 0) {
			rowCount++;
			row = table.insertRow(rowCount);
			j = 0;
		}
		newCell = row.insertCell(j);
		j++;

		newCell.className = "run";
		if (i % 2 != 0) {
			newCell.innerHTML = run[counter_y][0] + ":";
			counter_y++;
		} else {
			id = 'rig-' + rigCount + '-run-' + runCount + "-" + counter_x;
			value = "";
			if (run[counter_x][1] == 'datetime') {
				var d = new Date();
				component = document.createElement("input");
				component.type = "text";
				component.style.borderColor = abled_cell_border_color;
				component.style.width = fields_width_date_time_grid;
				component.value = d.format('d') + "-" + d.format('M') + "-"
						+ d.format('Y') + " " + d.getHours() + ":"
						+ d.getMinutes() + ":" + d.getSeconds();
				component.id = id;
				component.name = id;
				component.readOnly = 'true';
				component.onclick = function() {
					NewCal(this.id, 'ddmmmyyyy', true, 24);
				};

				newCell.appendChild(component);
				counter_x++;
				counter_date_time_picker++;
				continue;
			}

			if (run[counter_x][1] == 'text') {
				component = document.createElement("input");
				component.type = "text";
				component.style.borderColor = abled_cell_border_color;
				component.style.width = fields_width_grid;
				component.value = "";
				if (counter_x == 0) {
					component.value = id;
					component.disabled = true;
				}

				component.id = id;
				component.name = id;
				console.log(counter_x);
				if (counter_x == 5) {
					component.onchange = function() {
						var decimal = /^-{0,1}\d*\.{0,1}\d+$/;
						if (!this.value.match(decimal)) {
							alert('WT it Should be like : (1.30)');
							this.value = "";
							return false;
						}

					};
				} else {

					component.onblur = function() {
						resetToZero(this);
					};
				}
				newCell.appendChild(component);
				counter_x++;
				continue;
			}
		}
	}
}

function resetToZero(textObject) {
	if (textObject.value == "") {
		textObject.value = '0';
	}
}

function addSer(ref) {
	
	if (!validate()) {
		return false;
	}


	btnFunctuion(ref);
	document.getElementById('exp').disabled = true;
	serCount++;
	table = document.getElementById("datatable");
	rowCount = table.rows.length;
	var row = table.insertRow(rowCount);
	var newCell;
	var component = "";
	newCell = row.insertCell(0);
	newCell.className = "ser";
	component = document.createElement("input");
	component.type = "radio";
	component.value = "ser";
	component.name = "radio";

	newCell.appendChild(component);

	counter_x = 0;
	counter_y = 0;

	document.getElementById('sercount').value = serCount;
	var j = 1;
	for (var i = 1; i < (ser.length * 2) + 2; i++) {

		// Row spliter
		if (i == 9 || i == 17 || i == 27 || i == 31 || i == 39 || i == 45
				|| i == 55) {
			rowCount++;
			row = table.insertRow(rowCount);
			j = 0;
		}

		newCell = row.insertCell(j);
		j++;

		newCell.className = "ser";

		if (serCount < 10) {
			id = 'rig-' + rigCount + "-run-" + runCount + "-ser-0" + serCount
					+ "-" + counter_x;
		} else {
			id = 'rig-' + rigCount + "-run-" + runCount + "-ser-" + serCount
					+ "-" + counter_x;
		}
		value = "";

		if (i % 2 != 0) {
			if (counter_y < 33) {
				newCell.innerHTML = ser[counter_y][0] + ":";
			}

			counter_y++;
		} else {
			if (ser[counter_x][1] == 'datetime') {
				component = document.createElement("input");
				component.type = "text";
				component.style.borderColor = abled_cell_border_color;
				component.style.width = fields_width_date_time_grid;
				component.value = "";
				component.id = id;
				component.name = id;

				component.onclick = function() {
					NewCal(this.id, 'ddmmmyyyy', false, 24);
				};

				newCell.appendChild(component);
				counter_x++;
				counter_date_time_picker++;
				continue;
			}

			if (ser[counter_x][1] == 'text') {
				component = document.createElement("input");
				component.type = "text";
				component.style.borderColor = abled_cell_border_color;
				component.style.width = fields_width_grid;
				component.id = id;
				component.name = id;
				component.onblur = function() {
					resetToZero(this);
				};
				if (counter_x == 0) {
					component.value = id;
					component.disabled = true;
				} else if (counter_x == 24) {
					component.name = 'engi';
					component.readOnly = true;

					component.value = document.getElementById("engineer").value;

					component.onclick = function() {
						openEngListForService()();
					};

				} else if (counter_x == 25) {
					component.name = 'crew';
					component.readOnly = true;
					component.value = document.getElementById("crew").value;

					component.onclick = function() {
						openCrewListForService();
					};
				} else {
					component.value = "";
				}
				newCell.appendChild(component);
				counter_x++;
				continue;
			}

			if (ser[counter_x][1] == 'select' && counter_x == 1) {
				component = document.createElement("select");
				component.class = "ser";
				component.style.borderColor = abled_cell_border_color;
				component.style.width = fields_width_grid;
				len = ser[counter_x][3].split(";").length;
				var serArr = ser[counter_x][3].split(";");
				component.addEventListener('change', function() {
					enableServiceOnClick(this);
				}, false);
				component.addEventListener('change', function() {
					getServiceNames(this);
				}, false);

				component.addEventListener('change', function() {

					disable_fields_in_service(this);
				}, false);

				for (var l = 0; l < len; l++) {
					var option1 = document.createElement("option");
					option1.text = serArr[l];
					option1.value = serArr[l];
					component.add(option1);
				}
				component.id = id;
				component.name = id;
				newCell.appendChild(component);
				counter_x++;
				continue;
			}

			if (ser[counter_x][1] == 'select' && counter_x == 2) {
				component = document.createElement("select");
				component.class = "ser";
				component.style.borderColor = abled_cell_border_color;
				component.style.width = fields_width_grid;
				len = ser[counter_x][3].split(";").length;
				var serArr = ser[counter_x][3].split(";");
				for (var l = 0; l < len; l++) {
					var option1 = document.createElement("option");
					option1.text = serArr[l];
					option1.value = serArr[l];
					component.add(option1);
				}
				component.addEventListener('change', function() {
					disable_fields_in_service(this);
				}, false);
				component.id = id;
				component.name = id;
				newCell.appendChild(component);
				counter_x++;
				continue;
			}

			if (ser[counter_x][1] == 'select'
					&& (counter_x == 29 || counter_x == 30 || counter_x == 31)) {
				component = document.createElement("select");
				component.style.borderColor = abled_cell_border_color;
				component.style.width = fields_width_grid;
				len = ser[counter_x][3].split(";").length;
				var serArr = ser[counter_x][3].split(";");
				for (var l = 0; l < len; l++) {
					var option1 = document.createElement("option");
					option1.text = serArr[l];
					option1.value = serArr[l];
					component.add(option1);
				}
				component.id = id;
				component.name = id;
				newCell.appendChild(component);
				counter_x++;
				continue;
			}

			if (ser[counter_x][1] == 'autocomplete') {
				component = document.createElement("input");
				component.type = "text";
				component.style.width = fields_width_grid;
				component.style.borderColor = abled_cell_border_color;
				// component.disabled = true;
				if (ser[counter_x][0] == "Asset Cd") {
					component.value = "";
					component.id = id;
					component.name = id;
					var n = '#'.concat(id);
					component.onclick = function() {
						jQuery(function() {
							$(n).autocomplete("getPartCd.jsp");
						});
					};
				}

				if (ser[counter_x][0] == "Serial No") {
					component.value = "";
					component.id = id;
					component.name = id;
					component.style.borderColor = abled_cell_border_color;
					var n = '#'.concat(id);
					component.onclick = function() {
						jQuery(function() {
							$(n).autocomplete("getPartCd.jsp");
						});
					};
				}
				newCell.appendChild(component);
				counter_x++;
				continue;
			}
		}
	}

	$('#datatable tbody').append("<tr><td colspan='15'><hr></td></tr>");

}

function addExpl(ref) {
	explCount++;
	table = document.getElementById("datatable");
	rowCount = table.rows.length;
	var row = table.insertRow(rowCount);
	var newCell;
	var component = "";
	// Create single radio
	newCell = row.insertCell(0);
	newCell.className = "expl";
	component = document.createElement("input");

	component.type = "radio";
	component.value = "exp";
	component.name = "radio";

	newCell.appendChild(component);
	document.getElementById('explcount').value = explCount;

	counter_x = 0;
	counter_y = 0;

	if (serCount < 10) {
		id = 'rig-' + rigCount + "-run-" + runCount + "-ser-0" + serCount
				+ "-exp-" + explCount;
	} else {
		id = 'rig-' + rigCount + "-run-" + runCount + "-ser-" + serCount
				+ "-exp-" + explCount;
	}

	for (var i = 1; i < (expl.length * 2) + 2; i++) {
		newCell = row.insertCell(i);
		newCell.className = "expl";
		if (i % 2 != 0) {
			newCell.innerHTML = expl[counter_y][0] + ':';
			counter_y++;
		} else {
			if (expl[counter_x][1] == 'text') {
				component = document.createElement("input");
				component.type = "text";
				component.style.width = fields_width_grid;
				component.style.borderColor = abled_cell_border_color;
				component.value = 0;
				if (counter_x == 0) {
					component.value = id;
					component.disabled = true;
				} else {
					component.value = "0";
				}
				component.id = id;
				component.name = id;
				newCell.appendChild(component);
				counter_x++;
				continue;
			}

			if (expl[counter_x][1] == 'autocomplete') {
				component = document.createElement("input");
				component.type = "text";
				component.style.borderColor = abled_cell_border_color;
				component.style.width = fields_width_grid;
				component.value = "";
				component.id = id;
				component.name = id;
				var n = '#'.concat(id);
				component.onclick = function() {
					jQuery(function() {
						$(n).autocomplete("getPartCd.jsp");
					});
				};
				counter_partCd_auto_complete++;
				newCell.appendChild(component);
				counter_x++;
				continue;
			}

			if (expl[counter_x][1] == 'select') {
				component = document.createElement("select");
				component.class = "expl";
				component.style.borderColor = abled_cell_border_color;
				component.style.width = fields_width_grid;
				len = expl[counter_x][2].split(";").length;
				var explArr = expl[counter_x][2].split(";");
				for (var l = 0; l < len; l++) {
					var option1 = document.createElement("option");
					option1.text = explArr[l];
					option1.value = explArr[l];
					component.add(option1);
				}
				component.id = id;
				component.name = id;
				newCell.appendChild(component);
				counter_x++;
				continue;
			}
		}
	}
}

function datTimeDference(pooh, rih) {
	var startDate = new Date(pooh);
	var endDate = new Date(rih);
	var one_day = 1000 * 60 * 60 * 24;
	var startDate_ms = startDate.getTime();
	var endDate_ms = endDate.getTime();
	var difference_ms = startDate_ms - endDate_ms;
	difference_ms = difference_ms / 1000;
	var seconds = Math.floor(difference_ms % 60);
	difference_ms = difference_ms / 60;
	var minutes = Math.floor(difference_ms % 60);
	difference_ms = difference_ms / 60;
	var hours = Math.floor(difference_ms % 24);
	var days = Math.floor(difference_ms / 24);

}

function validate() {

	var crew = document.getElementById("crew").value;
	if (crew == "") {
		alert("Please Enter the Crew Members.");
		return false;
	}
	var engineer = document.getElementById("engineer").value;
	if (engineer == "") {
		alert("Please Enter the Engineer(s).");
		return false;
	}

	var dropdownIndex = document.getElementById('clientName').selectedIndex;
	var clientName = document.getElementById('clientName')[dropdownIndex].text;

	if (document.getElementById('clientName').value.trim() == "-Select-") {
		alert("Please select client name.");
		return false;
	}

	if (document.getElementById('jobNoHlsa').value.trim() == "") {
		alert("Please enter a valid jobNoHlsa .");
		document.getElementById('jobNoHlsa').style.backgroundColor = abled_cell_backround_color;
		document.getElementById('jobNoHlsa').focus();
		return false;
	} else {
		document.getElementById('jobNoHlsa').style.backgroundColor = "white";
	}

	if (document.getElementById('wellNo').value.trim() == "") {
		alert("Please enter a valid well no.");
		document.getElementById('wellNo').style.backgroundColor = abled_cell_backround_color;
		document.getElementById('wellNo').focus();
		return false;
	} else {
		document.getElementById('wellNo').style.backgroundColor = "white";
	}

	if (document.getElementById('crew').value == "") {
		alert("Please enter valid Crew members.");
		document.getElementById('crew').style.backgroundColor = abled_cell_backround_color;
		document.getElementById('crew').focus();
		return false;
	} else {
		document.getElementById('wellNo').style.backgroundColor = "white";
	}

	if (document.getElementById('engineer').value == "") {
		alert("Please enter a valid Engineer(s).");
		document.getElementById('engineer').style.backgroundColor = abled_cell_backround_color;
		document.getElementById('engineer').focus();
		return false;
	} else {
		document.getElementById('engineer').style.backgroundColor = "white";
	}
	if (document.getElementById('truckMileage').value == "") {
		alert("Please enter a Truck Mileage.");
		document.getElementById('truckMileage').style.backgroundColor = abled_cell_backround_color;
		document.getElementById('truckMileage').focus();
		return false;
	} else {
		document.getElementById('truckMileage').style.backgroundColor = "white";
	}
	if (document.getElementById('truckMileage').value == "") {
		alert("Please enter a Truck Mileage.");
		document.getElementById('truckMileage').style.backgroundColor = abled_cell_backround_color;
		document.getElementById('truckMileage').focus();
		return false;
	} else {
		document.getElementById('truckMileage').style.backgroundColor = "white";
	}
	if (document.getElementById('remarks').value == "") {
		alert("Please enter Remarks.");
		document.getElementById('remarks').style.backgroundColor = abled_cell_backround_color;
		document.getElementById('remarks').focus();
		return false;
	} else {
		document.getElementById('remarks').style.backgroundColor = "white";
	}

	return true;

}

function editRow(ref, tableID) {
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length;
	var x = document.getElementsByTagName("input");
	if (rowCount == 0) {
		alert('There is no row to edit');
		return false;
	} else {
		var x = document.getElementsByTagName("input");
		for (var i = 0; i < x.length; i++) {
			var input = x[i];
			if (input.type == "radio" && input.checked) {
				len = input.value.split("-").length - 2;
				type = input.value.split("-")[len];
				actionCall(x[i + 1].value, type);
				break;
			}
		}
	}
}

function actionCall(value, type) {
	window
			.open(
					'PopUpAction?type=' + type + '&value=' + value,
					'popUpWindow',
					'height=300,width=600,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
}

function sendToENG(value) {
	var newUrl = 'UpdateJobWorkFlowAction.action?jobStatus=' + value;
	document.forms['createJob'].action = newUrl;
	document.forms['createJob'].submit();
	return true;
}

function sendToFSQC(value) {

	var newUrl = 'UpdateJobWorkFlowAction.action?jobStatus=' + value;
	document.forms['createJob'].action = newUrl;
	document.forms['createJob'].submit();
	return true;
}

function closeJob(value) {
	var newUrl = 'UpdateJobWorkFlowAction.action?jobStatus1=' + value;
	document.forms['createJob'].action = newUrl;
	document.forms['createJob'].submit();
	return true;
}

function deleteJob(value) {
	var newUrl = 'UpdateJobWorkFlowAction.action?jobStatus=' + value;
	document.forms['createJob'].action = newUrl;
	document.forms['createJob'].submit();
	return true;
}

function editJob() {
	var newUrl = 'EditJob.action';
	document.forms['createJob'].action = newUrl;
	document.forms['createJob'].submit();
	return true;
}

function editWellJob() {
	var newUrl = 'EditWell.action';
	document.forms['createJob'].action = newUrl;
	document.forms['createJob'].submit();
	return true;
}
function editEjcsJob() {
	var newUrl = 'EditWell.action';
	document.forms['createJob'].action = newUrl;
	document.forms['createJob'].submit();
	return true;
}

function downloadJobExcel() {
	var newUrl = './DownloadExcelAction.action';
	document.forms['createJob'].action = newUrl;
	document.forms['createJob'].submit();
	return true;

}

function btnFunctuion(ref) {
	if (ref.id == "rig") {
		document.getElementById('rig').disabled = true;
		document.getElementById('run').disabled = false;
		document.getElementById('exp').disabled = true;
		document.getElementById('ser').disabled = true;
	} else if (ref.id == "run") {
		document.getElementById('run').disabled = true;
		document.getElementById('rig').disabled = true;
		document.getElementById('ser').disabled = false;
		document.getElementById('exp').disabled = true;
	} else if (ref.id == "ser") {
		document.getElementById('run').disabled = false;
		document.getElementById('rig').disabled = false;
		document.getElementById('ser').disabled = false;
		document.getElementById('exp').disabled = false;
	} else if (ref.id == "exp") {
		document.getElementById('run').disabled = false;
		document.getElementById('rig').disabled = false;
		document.getElementById('ser').disabled = false;
		document.getElementById('exp').disabled = false;

	}
}

function appValuesInCombo(str, combo) {

	for (i = combo.options.length - 1; i >= 0; i--)
		combo.remove(i);
	var arr = str.split(":");
	for (i = 0; i < arr.length; i++) {
		var option = document.createElement("option");
		option.text = arr[i];
		option.value = arr[i];
		try {
			combo.add(option, null);
		} catch (error) {
			combo.add(option);
		}
	}
}

function openEmployeeList() {
	type = 'emp';
	window
			.open(
					'PopUpAction.action?type=' + type + "&id=" + data,
					'popUpWindow',
					'height=500,width=600,left=250,top=250,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
}

function openEmployeeListForEdit(idd) {
	type = 'emp';
	window.open('PopUpAction.action?type=' + type + "&id=" + idd,
			'popupWindow',
			'resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,status=yes');
}

function latLongAngle() {
	type = 'latlongangle';
	window
			.open(
					'PopUpAction.action?type=' + type + "&id=" + latlongangle,
					'popUpWindow',
					'height=700,width=1000,left=0,top=250,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
}

function openCrewList() {

	type = 'crew';
	window
			.open(
					'PopUpAction.action?type=' + type + "&id=undefined",
					'popUpWindow',
					'height=500,width=600,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');
}

function openCrewListForService() {

	var flageY = true;
	table = document.getElementById("datatable");
	var rowCount = table.rows.length;
	for (var i = 0; i < rowCount; i++) {
		var row = table.rows[i];
		var radio = row.cells[0].childNodes[0];

		if (true == radio.checked && radio.value == 'ser') {

			datacrew = row.cells[2].childNodes[0].id;
			flageY = false;
		}
	}
	if (flageY && datacrew == 'undefined') {
		alert("Please select service radio button to enter the crew.");
		return false;
	}
	type = 'crew';
	window
			.open(
					'PopUpAction.action?type=' + type + "&id="
							+ datacrew.substring(0, datacrew.length - 2)
							+ "-25",
					'popUpWindow',
					'height=500,width=600,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');

}

function openEngListForService() {

	var flageX = true;
	table = document.getElementById("datatable");
	var rowCount = table.rows.length;
	for (var i = 0; i < rowCount; i++) {
		var row = table.rows[i];
		var radio = row.cells[0].childNodes[0];
		if (true == radio.checked && radio.value == 'ser') {

			data = row.cells[2].childNodes[0].id;
			flageX = false;
		}
	}
	if (flageX && data == 'undefined') {
		alert("Please select service radio button to enter the Eng.");
		return false;
	}

	type = 'emp';
	window
			.open(
					'PopUpAction.action?type=' + type + "&id="
							+ data.substring(0, data.length - 2) + "-24",
					'popUpWindow',
					'height=500,width=600,left=100,top=100,resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,location=no,directories=no, status=yes');

}

function openCrewListForEdit(serid) {
	type = 'crew';
	window.open('PopUpAction.action?type=' + type + "&id=" + serid,
			'popupWindow',
			'resizable=yes,scrollbars=yes,toolbar=yes,menubar=no,status=yes');
}

function deleteRow() {
	try {
		table = document.getElementById("datatable");
		var rowCount = table.rows.length;
		for (var i = 0; i < rowCount; i++) {
			var row = table.rows[i];
			var radio = row.cells[0].childNodes[0];
			if (radio != null && true == radio.checked) {
				if (rowCount <= 1) {
					alert("Cannot delete all the rows.");
					break;
				} else {
					if (radio.value == "rig") {
						table.deleteRow(i);
						rigCount--;
						document.getElementById('rig').disabled = true;
						document.getElementById('run').disabled = false;
						document.getElementById('ser').disabled = false;
						document.getElementById('exp').disabled = true;
						break;
					}
					if (radio.value == "run") {
						table.deleteRow(i + 1);
						table.deleteRow(i);
						runCount--;
						document.getElementById('rig').disabled = true;
						document.getElementById('run').disabled = false;
						document.getElementById('ser').disabled = true;
						document.getElementById('exp').disabled = true;
						break;
					}
					if (radio.value == "ser") {
						table.deleteRow(i + 8);
						table.deleteRow(i + 7);
						table.deleteRow(i + 6);
						table.deleteRow(i + 5);
						table.deleteRow(i + 4);
						table.deleteRow(i + 3);
						table.deleteRow(i + 2);
						table.deleteRow(i + 1);
						table.deleteRow(i);
						serCount--;
						document.getElementById('rig').disabled = true;
						document.getElementById('run').disabled = true;
						document.getElementById('ser').disabled = false;
						document.getElementById('exp').disabled = true;

						break;
					}
					if (radio.value == "expl") {
						table.deleteRow(i);
						explCount--;
						break;
					}
				}
			}
		}
	} catch (e) {
		alert(e);
	}
}

function resetGrid() {
	try {

		table = document.getElementById("datatable");
		var rowCount = table.rows.length;
		for (var i = rowCount - 1; i >= 0; i--) {
			table.deleteRow(i);
		}
		rigCount = 0;
		runCount = 0;
		serCount = 0;
		explCount = 0;
		document.getElementById('rig').disabled = false;
		document.getElementById('run').disabled = true;
		document.getElementById('ser').disabled = true;
		document.getElementById('exp').disabled = true;
	} catch (e) {
		alert(e);
	}
}

function generateSubmitURL() {

	if (validate()) {
	} else {
		return false;
	}

	var x = document.forms["createJob"].elements;
	var hiddenRig = '';
	var hiddenRun = '';
	var hiddenSer = '';
	var hiddenExpl = '';

	var len = document.forms["createJob"].elements.length;

	for (var i = 0; i < len; i++) {
		var id = document.forms["createJob"].elements[i].id;
		var type = document.forms["createJob"].elements[i].type;
		var value = document.forms["createJob"].elements[i].value;
		var name = document.forms["createJob"].elements[i].name;

		if (type == "radio") {
			if (value == 'rig') {
				var tempRig = x[i + 1].value + ',' + x[i + 2].value + ','
						+ x[i + 3].value + ',' + x[i + 4].value + ','
						+ x[i + 5].value + '/';
				hiddenRig = hiddenRig + tempRig;
			}

			if (value == 'run') {
				for (var j = 1; j < 7; j++) {

					if (x[i + j].value.search("/") > 0) {
						alert("Please Remove / from the field-->"
								+ x[i + j].value);
						return false;
					}
				}
				var tempRun = (x[i + 1].value).replace(",", "") + ','
						+ (x[i + 2].value).replace(",", "") + ','
						+ (x[i + 3].value).replace(",", "") + ','
						+ (x[i + 4].value).replace(",", "") + ','
						+ (x[i + 5].value).replace(",", "") + ','
						+ (x[i + 6].value).replace(",", "") + ','
						+ (x[i + 7].value).replace(",", "");
				tempRun = tempRun.replace("/", "") + "/";
				hiddenRun = hiddenRun + tempRun;

			}
			if (value == 'ser') {
				for (var j = 1; j < 34; j++) {

					if (x[i + j].value.search("/") > 0) {
						alert("Please Remove / from the field-->"
								+ x[i + j].value);
						return false;
					}
				}
				if (x[i + 33].value == "") {
					x[i + 33].value = "NA";
				}

				var tempSer = x[i + 1].value + ',' + x[i + 2].value + ','
						+ x[i + 3].value + ',' + x[i + 4].value + ','
						+ x[i + 5].value + ',' + x[i + 6].value + ','
						+ x[i + 7].value + ',' + x[i + 8].value + ','
						+ x[i + 9].value + ',' + x[i + 10].value + ','
						+ x[i + 11].value + ',' + x[i + 12].value + ','
						+ x[i + 13].value + ',' + x[i + 14].value + ','
						+ x[i + 15].value + ',' + x[i + 16].value + ','
						+ x[i + 17].value + ',' + x[i + 18].value + ','
						+ x[i + 19].value + ',' + x[i + 20].value + ','
						+ x[i + 21].value + ',' + x[i + 22].value + ','
						+ x[i + 23].value + ',' + x[i + 24].value + ','
						+ x[i + 25].value + ',' + x[i + 26].value + ','
						+ x[i + 27].value + ',' + x[i + 28].value + ','
						+ x[i + 29].value + ',' + x[i + 30].value + ','
						+ x[i + 31].value + ',' + x[i + 32].value + ','
						+ x[i + 33].value + '/';

				hiddenSer = hiddenSer + encodeURI(tempSer);
			}

			if (value == 'exp') {
				var dd = x[i + 2].value;
				if (dd.indexOf("/") > 0) {
					alert("please remove the '/' from partCd");
					return false;
				}

				var tempExp = x[i + 1].value + ',' + dd + ',' + x[i + 3].value
						+ ',' + x[i + 4].value + '/';
				hiddenExpl = hiddenExpl + tempExp;
			}
		}
	}

	document.getElementById('hiddenRig').value = hiddenRig;
	document.getElementById('hiddenRun').value = hiddenRun;
	document.getElementById('hiddenSer').value = hiddenSer;
	document.getElementById('hiddenExpl').value = hiddenExpl;

	document.getElementById("createJob").submit();

}

function insSer(ref, tableID) {
	var table = document.getElementById("datatable");
	var rowCount = table.rows.length;
	var x = document.getElementsByTagName("input");
	if (rowCount == 0) {
		alert('There is no row to edit');
		return false;
	} else {
		for (var i = 0; i < x.length; i++) {
			var input = x[i];
			if (input.type == "radio" && input.checked) {
				len = input.value.split("-").length - 2;
				type = "insSer";
				actionCall(x[i + 1].value, type);
				break;
			}
		}
	}
}
function deleteService() {
	var table = document.getElementById("datatable");
	var rowCount = table.rows.length;
	var x = document.getElementsByTagName("input");
	if (rowCount == 0) {
		alert('There is no row to edit');
		return false;
	} else {
		for (var i = 0; i < x.length; i++) {
			var input = x[i];
			if (input.type == "radio" && input.checked) {
				len = input.value.split("-").length - 2;
				var url = 'DeleteJobAction?id=' + (x[i + 1].value);
				$.get(url, function(results) {
					$('.result').html(results);
					alert("Delete Successfull...");
				});
				break;
			}
		}
	}
}
function insExplosive(ref, tableID) {
	var table = document.getElementById("datatable");
	var rowCount = table.rows.length;
	var x = document.getElementsByTagName("input");
	if (rowCount == 0) {
		alert('There is no row to edit');
		return false;
	} else {
		for (var i = 0; i < x.length; i++) {
			var input = x[i];
			if (input.type == "radio" && input.checked) {
				len = input.value.split("-").length - 2;
				type = "insExp";
				actionCall(x[i + 1].value, type);
				break;
			}
		}
	}
}

function insertSer(ref) {
	try {
		table = document.getElementById("datatable");
		var rowCount = table.rows.length;
		var y = 0;
		for (var i = 0; i < rowCount; i++) {
			var row = table.rows[i];
			var radio = row.cells[0].childNodes[0];
			if (radio != null && true == radio.checked) {
				if (rowCount <= 1) {
					alert("Cannot insert Service First Add Service");
					break;
				} else {
					var crid = row.cells[2].childNodes[0].id;
					crid = crid.substring(0, 11);
					btnFunctuion(ref);
					document.getElementById('exp').disabled = true;
					serCount++;
					table = document.getElementById("datatable");
					rowCount = i + 2;
					var row = table.insertRow(rowCount);
					var newCell;
					var component = "";
					newCell = row.insertCell(0);
					newCell.className = "ser";
					component = document.createElement("input");
					component.type = "radio";
					component.value = "ser";
					component.name = "radio";
					newCell.appendChild(component);

					counter_x = 0;
					counter_y = 0;

					document.getElementById('sercount').value = serCount;
					var j = 1;
					for (var i = 1; i < (ser.length * 2) + 2; i++) {

						// Row spliter
						if (i % 14 == 0) {
							rowCount++;
							row = table.insertRow(rowCount);
							j = 0;
						}
						newCell = row.insertCell(j);
						j++;

						if (i < 48) {
							newCell.className = "ser";
						} else {
							newCell.className = "serFsqc";
						}

						if (serCount < 10) {
							id = crid + "-" + "ser-0" + serCount + "-"
									+ counter_x;
						} else {
							id = crid + "-" + "ser-" + serCount + "-"
									+ counter_x;
						}
						value = "";

						if (i % 2 != 0) {
							newCell.innerHTML = ser[counter_y][0] + ':';
							counter_y++;
						} else {
							if (ser[counter_x][1] == 'datetime') {
								component = document.createElement("input");
								component.type = "text";
								component.style.borderColor = abled_cell_border_color;
								component.style.width = fields_width_date_time_grid;
								component.value = "";
								component.id = id;
								component.name = id;
								component.onclick = function() {
									NewCal(this.id, 'ddmmmyyyy', true, 24);
								};
								newCell.appendChild(component);
								counter_x++;
								counter_date_time_picker++;
								continue;
							}

							if (ser[counter_x][1] == 'text') {
								component = document.createElement("input");
								component.type = "text";
								component.style.borderColor = abled_cell_border_color;
								component.style.width = fields_width_grid;
								component.id = id;
								component.name = id;

								if (counter_x == 0) {
									component.value = id;
									component.disabled = true;
								} else {
									component.value = "";
								}
								newCell.appendChild(component);
								counter_x++;
								continue;
							}

							if (ser[counter_x][1] == 'select' && counter_x == 1) {
								component = document.createElement("select");
								component.class = "ser";
								component.style.borderColor = abled_cell_border_color;
								component.style.width = fields_width_grid;
								len = ser[counter_x][3].split(";").length;
								var serArr = ser[counter_x][3].split(";");
								component.addEventListener('change',
										function() {
											enableServiceOnClick(this);
										}, false);
								component.addEventListener('change',
										function() {
											getServiceNames(this);
										}, false);

								component.addEventListener('change',
										function() {
											disable_fields_in_service(this);
										}, false);

								for (var l = 0; l < len; l++) {
									var option1 = document
											.createElement("option");
									option1.text = serArr[l];
									option1.value = serArr[l];
									component.add(option1);
								}
								component.id = id;
								component.name = id;
								newCell.appendChild(component);
								counter_x++;
								continue;
							}

							if (ser[counter_x][1] == 'select' && counter_x == 2) {
								component = document.createElement("select");
								component.class = "ser";
								component.style.borderColor = abled_cell_border_color;
								component.style.width = fields_width_grid;
								len = ser[counter_x][3].split(";").length;
								var serArr = ser[counter_x][3].split(";");
								for (var l = 0; l < len; l++) {
									var option1 = document
											.createElement("option");
									option1.text = serArr[l];
									option1.value = serArr[l];
									component.add(option1);
								}
								component.addEventListener('change',
										function() {
											disable_fields_in_service(this);
										}, false);
								component.id = id;
								component.name = id;
								newCell.appendChild(component);
								counter_x++;
								continue;
							}

							if (ser[counter_x][1] == 'select'
									&& (counter_x == 26 || counter_x == 27 || counter_x == 28)) {
								component = document.createElement("select");
								component.style.borderColor = abled_cell_border_color;
								component.style.width = fields_width_grid;
								len = ser[counter_x][3].split(";").length;
								var serArr = ser[counter_x][3].split(";");
								for (var l = 0; l < len; l++) {
									var option1 = document
											.createElement("option");
									option1.text = serArr[l];
									option1.value = serArr[l];
									component.add(option1);
								}
								component.id = id;
								component.name = id;
								newCell.appendChild(component);
								counter_x++;
								continue;
							}

							if (ser[counter_x][1] == 'autocomplete') {
								component = document.createElement("input");
								component.type = "text";
								component.style.width = fields_width_grid;
								component.style.borderColor = abled_cell_border_color;
								// component.disabled = true;
								if (ser[counter_x][0] == "Asset Cd") {
									component.value = "";
									component.id = id;
									component.name = id;
									var n = '#'.concat(id);
									component.onclick = function() {
										jQuery(function() {
											$(n).autocomplete("getPartCd.jsp");
										});
									};
								}

								if (ser[counter_x][0] == "Serial No") {
									component.value = "";
									component.id = id;
									component.name = id;
									component.style.borderColor = abled_cell_border_color;
									var n = '#'.concat(id);
									component.onclick = function() {
										jQuery(function() {
											$(n).autocomplete("getPartCd.jsp");
										});
									};
								}
								newCell.appendChild(component);
								counter_x++;
								continue;
							}
						}
					}

				}
			}
		}
	} catch (e) {
		alert(e);
	}

}
