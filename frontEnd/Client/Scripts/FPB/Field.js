var stadiumId = getUrlVars()["stadiumId"];
var date = getUrlVars()["date"];
var slotId = getUrlVars()["slotId"];

var url = urlws["urlField"];
var urlReservation = urlws["urlReservation"];
console.log(stadiumId);
console.log(date);
console.log(slotId);
var jsonObj = new Array(); // json
var temp = new Array();

var reservationList = new Array(); //json đặt sân
var reservationTemp = new Array();

var avaiableList = new Array(); //danh sách sân còn trống theo date - slot
var avaiableTemp = new Array();

var numPerPage = 10;
var numPagerPerPage = 10;
var page = 1;
var numPage = 0;
var numPagerFrom = 1;
var numPagerTo = 0;

function load() {
	$.getJSON(urlReservation, function (result) { // lấy danh sách sân đã đặt Date - Slot
		reservationTemp = result;
		for (var i = 0; i < reservationTemp.length; ++i) {
			if (reservationTemp[i].CDate == date && reservationTemp[i].CSlotId.CId == slotId) {
				reservationList.push(reservationTemp[i]);
			}
		}
		console.log(reservationList);

		$.getJSON(url, function (result) {
			temp = result; // lưu json trả về vào 1 biến tạm
			if (stadiumId == null) { // kiểm tra xem có truyền tham số QUận vào k?
				jsonObj = result;

			} else
				for (var i = 0; i < temp.length; ++i) {
					if (temp[i].CStadiumId.CId == stadiumId) {
						jsonObj.push(temp[i]);
					}
				}
			for (var i = 0; i < jsonObj.length; ++i) { // tìm phần tử trùng nhau giữa 2 mảng để xử lý
				for (var j = 0; j < reservationList.length; ++j) {
					if (jsonObj[i].CId == reservationList[j].CFieldId.CId) {
						console.log('trùng nè: ' + jsonObj[i].CId);
						var ind = jsonObj.indexOf(jsonObj[i]); // lấy thứ tự pt trong mảng
						jsonObj.splice(i, 1); // xóa
					}
				}
			}

			numPage = Math.floor(jsonObj.length / numPerPage) + 1;
			if (numPagerPerPage <= numPage) {
				numPagerTo = numPagerPerPage;
			} else {
				numPagerTo = numPage;
			}
			showData();

		});

	});

};

function showData() {
	showItems();
	showPagers();
}

function showItems() {

	$('#js')
	.html('');
	var to = page * numPerPage;
	var from = to - numPerPage;
	if (to > jsonObj.length) {
		to = jsonObj.length;
	}

	// window.alert(jsonObj[from].CMainOwner.CFullName);
	for (var i = from; i < to; ++i) {

		var index = i + 1
			$('#dssb')
			.html('Danh Sách Sân Bóng Hà Nội');
		$('#js')
		.append('<tr><td><img src="' + images[i] + '" /></td>' +
			'<td>' + jsonObj[i].CStadiumId.CName +
			'</td><td>Sân số ' + jsonObj[i].CNumber +
			'</td><td>Sân ' + jsonObj[i].CFieldTypeId.CFieldType + ' Người' +
			'</td><td>' + jsonObj[i].CStadiumId.CPhone +
			'</td><td><a href="Field.htm?stadiumId=' + jsonObj[i].CId + '" class="btn btn-link">Đặt Sân</a></td></tr>');

	}

}

function showPagers() {
	//window.alert(page);
	$('#pager')
	.html('');

	for (var i = numPagerFrom; i <= numPagerTo; ++i) {
		if (i == numPagerFrom) {

			$('#pager')
			.append('<li><a href="#" class="item" onclick="previous()">Previous</a></li>');
		}
		if (i == page) {
			$('#pager')
			.append('<li><a href="#" class="current" onclick="clickPage(' + i + ')">' + i + '</a></li>');
		} else {
			$('#pager')
			.append('<li><a href="#" class="item" onclick="clickPage(' + i + ')">' + i + '</a></li>');
		}
		if (i == numPagerTo) {
			$('#pager')
			.append('<li><a href="#" class="item" onclick="next()">Next</a></li>');
		}

	}
}

function previous() {

	if (page > 1) {
		page--;
		if (page == numPagerFrom) {
			if (numPagerFrom > 1) {
				numPagerTo--;
				numPagerFrom--;
			}
		}
		showData();
	}

}

function next() {
	if (page < numPagerTo) {
		page++;

		if (page == numPagerTo) {
			if (numPagerTo < numPage) {
				numPagerTo++;
				numPagerFrom++;
			}
		}

		showData();
	}
}

function clickPage(i) {
	page = i;
	showData();
}
