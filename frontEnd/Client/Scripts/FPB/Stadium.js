var districtId = getUrlVars()["districtId"];
var url = urlws["urlStadium"];
console.log("districtId = " + url);
var jsonObj = new Array();
var temp = new Array();
var numPerPage = 10;
var numPagerPerPage = 10;
var page = 1;
var numPage = 0;
var numPagerFrom = 1;
var numPagerTo = 0;

function load() {
    $.getJSON(url, function (result) {
        temp = result; // lưu json trả về vào 1 biến tạm
		console.log(temp);
        if (districtId == null) { // kiểm tra xem có truyền tham số QUận vào k?
            jsonObj = result;
            numPage = Math.floor(jsonObj.length / numPerPage) + 1;
            if (numPagerPerPage <= numPage) {
                numPagerTo = numPagerPerPage;
            } else {
                numPagerTo = numPage;
            }
            showData();

        } else
            for (var i = 0; i < temp.length; ++i) {
                if (temp[i].CDistrictId.CId == districtId) {
                    jsonObj.push(temp[i]);
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

        console.log("jsonObj[i].CDistrictId.CId = " + jsonObj[i].CDistrictId.CId);
        var index = i + 1
        $('#dssb')
            .html('Danh Sách Sân Bóng Hà Nội');
        $('#js')
            .append('<tr><td><img src="' + images[i] + '" /></td>' +
                '<td>' + jsonObj[i].CName +
                '</td><td>' + jsonObj[i].CAddress +
                '</td><td>' + jsonObj[i].CDistrictId.CDistrict +
                '</td><td>' + jsonObj[i].CPhone +
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