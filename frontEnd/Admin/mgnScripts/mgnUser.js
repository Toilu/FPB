var url = "http://localhost:8080/FPBws/webresources/entities.tbuser";
var jsonObj = new Array();
var numPerPage = 6;
var numPagerPerPage = 5;
var page = 1;
var numPage=0;
var numPagerFrom=1;
var numPagerTo=0;

function load(){
    $.getJSON(url,function(result){
		jsonObj = result;
		numPage = Math.floor(jsonObj.length/numPerPage) + 1;
		if(numPagerPerPage <= numPage){
			numPagerTo = numPagerPerPage;
		}else{
			numPagerTo = numPage;
		}
		showData();
  });
  };
 function showData(){
		showItems();
		showPagers();
 }
 function showItems(){
	$('#js').html('');
	var to = page*numPerPage;
	var from = to - numPerPage;
	if(to > jsonObj.length){
		to = jsonObj.length;
	}
	
	// window.alert(jsonObj[from].CMainOwner.CFullName);
	for(var i = from; i < to; ++i) {
		var index = i + 1
		$('#js').append('<tr><td>' + index + 
		'</td><td>' + jsonObj[i].CUserName + 
		'</td><td>' + jsonObj[i].CFullName + 
		'</td><td>' + jsonObj[i].CAddress + 
		'</td><td>' + jsonObj[i].CPhoneNumber + 
		'</td><td>' + jsonObj[i].CEmail + 
		'</td><td>' + jsonObj[i].CRoleId.CDisplayName + 
		'</td><td><a href="Userdetail.html?id=' + jsonObj[i].CId +
		'" class="btn btn-link">View</a></td></tr>');
	}
	
 }
 
 function showPagers(){
	//window.alert(page);
	$('#pager').html('');
	
	for(var i = numPagerFrom; i <= numPagerTo; ++i) {
		if (i == numPagerFrom) {
			
			$('#pager').append('<li><a href="#" class="item" onclick="previous()">Previous</a></li>');
		}
		if(i == page){
			$('#pager').append('<li><a href="#" class="current" onclick="clickPage(' + i + ')">' + i + '</a></li>');
		}else{
			$('#pager').append('<li><a href="#" class="item" onclick="clickPage(' + i + ')">' + i + '</a></li>');
		}
			if (i==numPagerTo) {
				$('#pager').append('<li><a href="#" class="item" onclick="next()">Next</a></li>');
			}
		
	}
 }
 
 function previous(){
		
		if(page > 1){
			page--;
			if(page == numPagerFrom){
				if(numPagerFrom > 1){
					numPagerTo--;
					numPagerFrom--;
				}
			}
			showData();
		}
		
 }
 
 function next(){
	if(page < numPagerTo){
			page++;
			
			if(page == numPagerTo){
				if(numPagerTo < numPage){
					numPagerTo++;
					numPagerFrom++;
				}
			}
			
			showData();
		}
 }
 
 function clickPage(i){
	page = i;
	showData();
 }
 