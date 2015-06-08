var jsonObj = new Array();
var numPerPage = 6;
var numPagerPerPage = 5;
var page = 1;
var numPage=0;
var numPagerFrom=1;
var numPagerTo=0;

function load(){
    $.getJSON("data.json",function(result){
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
	$('listTem').html('');
	var to = page*numPerPage;
	var from = to - numPerPage;
	if(to > jsonObj.length){
		to = jsonObj.length;
	}
	
	//window.alert(from + '-' + to);
	for(var i = from; i < to; ++i) {
		if (i == from) {
			$('listTem').append('<ul class="thumbnails">');
		}
		$('listTem').append('<li class="span4">' + '<div class="thumbnail">' + '<img alt="300x200" src="' + 
			jsonObj[i].imgUrl + '">' + '<div class="caption">' + '<h3>' + 
			jsonObj[i].tit + '</h3>' + '<p>' + 
			jsonObj[i].des + '</p>' + '<p><a class="btn btn-primary" href="../index.html?id=	' + 
			jsonObj[i].id + '">View3D</a></p>' + '</div>' + '</div>' + '</li>');
			if (i==to-1) {
				$('listTem').append('</ul>');
			}
		
	}
	
 }
 
 function showPagers(){
	//window.alert(page);
	$('.pager').html('');
	
	for(var i = numPagerFrom; i <= numPagerTo; ++i) {
		if (i == numPagerFrom) {
			
			$('.pager').append('<li><a href="#" class="item" onclick="previous()">Previous</a></li>');
		}
		if(i == page){
			$('.pager').append('<li><a href="#" class="current" onclick="clickPage(' + i + ')">' + i + '</a></li>');
		}else{
			$('.pager').append('<li><a href="#" class="item" onclick="clickPage(' + i + ')">' + i + '</a></li>');
		}
			if (i==numPagerTo) {
				$('.pager').append('<li><a href="#" class="item" onclick="next()">Next</a></li>');
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