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


function getAssetCd(obj) {	
	var assetType1 = obj.value;
	url = 'GetListAction.action?param=getAssetCd1' + '&assetType1='
			+ assetType1;
	$.post(url, function(results) {
		$('.result').html(results);

		destinationCombo = document.getElementById("formValidate_assetCd");
		appValuesInCombo(results, destinationCombo);
	});

}

