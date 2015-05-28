function disable1() {
	alert('Hi');
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
function getLocationCd(obj) {

	var regionCd = obj.value;
	url = 'GetListAction.action?param=getLocationCd' + '&regionCd=' + regionCd;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document
				.getElementById("SaveOrUpdateCPIAction_locationCd");
		appValuesInCombo(results, destinationCombo);

	});

}

function getUnitCd(obj) {

	var regionCd = obj.value;
	url = 'GetListAction.action?param=getUnitCd' + '&locationCd=' + regionCd;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document
				.getElementById("SaveOrUpdateCPIAction_unitCd");
		appValuesInCombo(results, destinationCombo);

	});

}

var updateId;
var formName;
var element_Id;
var displayDiv;

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

function toggleStatus() {
	$('#tab2 :input').attr('disabled', true);
	$('#tab3 :input').attr('disabled', true);
}

$(function() {
	$('.date-pick').datePicker({
		autoFocusNextInput : true
	});
	$('.date-pick').datePicker({
		startDate : '01/01/1996'
	});
});

function setConstants() {
	updateId = 0;
	formName = "CpiForm";
	element_Id = "ajaxDisplayDiv";
	displayDiv = document.getElementById("displayDiv");
}

function getLocationCd(obj) {

	var regionCd = obj.value;
	url = 'GetListAction.action?param=getLocationCd' + '&regionCd=' + regionCd;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_locationCd");
		appValuesInCombo(results, destinationCombo);

	});

}

function getUnitCd(obj) {

	var locationCd = obj.value;
	url = 'GetListAction.action?param=getUnitCd' + '&locationCd=' + locationCd;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_unitCd");
		appValuesInCombo(results, destinationCombo);

	});

}

function getClientCd(obj) {

	var unitCd = obj.value;
	url = 'GetListAction.action?param=getClientCd' + '&unitCd=' + unitCd;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_clientCd");
		appValuesInCombo(results, destinationCombo);

	});

}

function getCpiType(obj) {

	var priority = obj.value;
	url = 'GetListAction.action?param=getCpiType' + '&priority=' + priority;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_cpiNature");
		appValuesInCombo(results, destinationCombo);
	});
}
function getMaintanenceType(obj) {

	var cpiType = obj.value;

	url = 'GetListAction.action?param=getMaintanenceType' + '&cpiType='
			+ cpiType;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document
				.getElementById("formValidate_maintanenceType");
		appValuesInCombo(results, destinationCombo);

	});

}

function getAssetCd1(obj) {
	var assetType1 = obj.value;
	url = 'GetListAction.action?param=getAssetCd1' + '&assetType1='
			+ assetType1;

	

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_assetName1");
		appValuesInCombo(results, destinationCombo);
	});

}

function getAssetCd2(obj) {

	var assetType1 = obj.value;
	url = 'GetListAction.action?param=getAssetCd1' + '&assetType1='
			+ assetType1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_assetName2");
		appValuesInCombo(results, destinationCombo);
	});

}

function getAssetCd3(obj) {

	var assetType1 = obj.value;
	url = 'GetListAction.action?param=getAssetCd1' + '&assetType1='
			+ assetType1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_assetName3");
		appValuesInCombo(results, destinationCombo);
	});

}

function getAssetCd4(obj) {

	var assetType1 = obj.value;
	url = 'GetListAction.action?param=getAssetCd1' + '&assetType1='
			+ assetType1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_assetName4");
		appValuesInCombo(results, destinationCombo);
	});

}

function getAssetCd5(obj) {

	var assetType1 = obj.value;
	url = 'GetListAction.action?param=getAssetCd1' + '&assetType1='
			+ assetType1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_assetName5");
		appValuesInCombo(results, destinationCombo);
	});

}

function getAssetCd6(obj) {

	var assetType1 = obj.value;
	url = 'GetListAction.action?param=getAssetCd1' + '&assetType1='
			+ assetType1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_assetName6");
		appValuesInCombo(results, destinationCombo);
	});

}

function getAssetSrNo1(obj) {   
	var assetSrNo1 = obj.value;	
	url = 'GetListAction.action?param=getAssetSrNo1' + '&assetSrNo1='
			+ assetSrNo1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_assetSrNo1");
		appValuesInCombo(results, destinationCombo);
	});

}

function getAssetSrNo2(obj) {

	var assetSrNo1 = obj.value;
	url = 'GetListAction.action?param=getAssetSrNo1' + '&assetSrNo1='
			+ assetSrNo1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_assetSrNo2");
		appValuesInCombo(results, destinationCombo);
	});

}

function getAssetSrNo3(obj) {

	var assetSrNo1 = obj.value;
	url = 'GetListAction.action?param=getAssetSrNo1' + '&assetSrNo1='
			+ assetSrNo1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_assetSrNo3");
		appValuesInCombo(results, destinationCombo);
	});

}

function getAssetSrNo4(obj) {

	var assetSrNo1 = obj.value;
	url = 'GetListAction.action?param=getAssetSrNo1' + '&assetSrNo1='
			+ assetSrNo1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_assetSrNo4");
		appValuesInCombo(results, destinationCombo);
	});

}

function getAssetSrNo5(obj) {

	var assetSrNo1 = obj.value;
	url = 'GetListAction.action?param=getAssetSrNo1' + '&assetSrNo1='
			+ assetSrNo1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_assetSrNo5");
		appValuesInCombo(results, destinationCombo);
	});

}

function getAssetSrNo6(obj) {

	var assetSrNo1 = obj.value;
	url = 'GetListAction.action?param=getAssetSrNo1' + '&assetSrNo1='
			+ assetSrNo1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_assetSrNo6");
		appValuesInCombo(results, destinationCombo);
	});

}

function getSectionName1(obj) {

	var assetSrNo1 = obj.value;

	url = 'GetListAction.action?param=getSectionName1' + '&assetSrNo1='
			+ assetSrNo1;

	$.post(url,
			function(results) {
				$('.result').html(results);

				destinationCombo = document
						.getElementById("formValidate_sectionName1");
				appValuesInCombo(results, destinationCombo);
			});

}

function getSectionName2(obj) {

	var assetSrNo1 = obj.value;

	url = 'GetListAction.action?param=getSectionName1' + '&assetSrNo1='
			+ assetSrNo1;

	$.post(url,
			function(results) {
				$('.result').html(results);

				destinationCombo = document
						.getElementById("formValidate_sectionName2");
				appValuesInCombo(results, destinationCombo);
			});

}

function getSectionName3(obj) {

	var assetSrNo1 = obj.value;

	url = 'GetListAction.action?param=getSectionName1' + '&assetSrNo1='
			+ assetSrNo1;

	$.post(url,
			function(results) {
				$('.result').html(results);

				destinationCombo = document
						.getElementById("formValidate_sectionName3");
				appValuesInCombo(results, destinationCombo);
			});

}

function getSectionName4(obj) {

	var assetSrNo1 = obj.value;

	url = 'GetListAction.action?param=getSectionName1' + '&assetSrNo1='
			+ assetSrNo1;

	$.post(url,
			function(results) {
				$('.result').html(results);

				destinationCombo = document
						.getElementById("formValidate_sectionName4");
				appValuesInCombo(results, destinationCombo);
			});

}

function getSectionName5(obj) {

	var assetSrNo1 = obj.value;

	url = 'GetListAction.action?param=getSectionName1' + '&assetSrNo1='
			+ assetSrNo1;

	$.post(url,
			function(results) {
				$('.result').html(results);

				destinationCombo = document
						.getElementById("formValidate_sectionName5");
				appValuesInCombo(results, destinationCombo);
			});

}

function getSectionName6(obj) {

	var assetSrNo1 = obj.value;

	url = 'GetListAction.action?param=getSectionName1' + '&assetSrNo1='
			+ assetSrNo1;

	$.post(url,
			function(results) {
				$('.result').html(results);

				destinationCombo = document
						.getElementById("formValidate_sectionName6");
				appValuesInCombo(results, destinationCombo);
			});

}

function getSectionSerialNo1(obj) {

	var sectionName1 = obj.value;

	url = 'GetListAction.action?param=getSectionSerialNo1' + '&sectionName1='
			+ sectionName1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document
				.getElementById("formValidate_sectionSerialNo1");
		appValuesInCombo(results, destinationCombo);
	});

}

function getSectionSerialNo2(obj) {

	var sectionName1 = obj.value;

	url = 'GetListAction.action?param=getSectionSerialNo1' + '&sectionName1='
			+ sectionName1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document
				.getElementById("formValidate_sectionSerialNo2");
		appValuesInCombo(results, destinationCombo);
	});

}

function getSectionSerialNo3(obj) {

	var sectionName1 = obj.value;

	url = 'GetListAction.action?param=getSectionSerialNo1' + '&sectionName1='
			+ sectionName1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document
				.getElementById("formValidate_sectionSerialNo3");
		appValuesInCombo(results, destinationCombo);
	});

}

function getSectionSerialNo4(obj) {

	var sectionName1 = obj.value;

	url = 'GetListAction.action?param=getSectionSerialNo1' + '&sectionName1='
			+ sectionName1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document
				.getElementById("formValidate_sectionSerialNo4");
		appValuesInCombo(results, destinationCombo);
	});

}

function getSectionSerialNo5(obj) {

	var sectionName1 = obj.value;

	url = 'GetListAction.action?param=getSectionSerialNo1' + '&sectionName1='
			+ sectionName1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document
				.getElementById("formValidate_sectionSerialNo5");
		appValuesInCombo(results, destinationCombo);
	});

}

function getSectionSerialNo6(obj) {

	var sectionName1 = obj.value;

	url = 'GetListAction.action?param=getSectionSerialNo1' + '&sectionName1='
			+ sectionName1;

	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document
				.getElementById("formValidate_sectionSerialNo6");
		appValuesInCombo(results, destinationCombo);
	});

}

function getCpicpiProcess() {
	url = 'GetListAction.action?param=getCpicpiProcess';
	$.post(url, function(results) {
		$('.result').html(results);
		destinationCombo = document.getElementById("formValidate_cpiProcess");
		appValuesInCombo(results, destinationCombo);
	});
}


