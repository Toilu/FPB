function load(){
	var id = getUrlVars()["id"];
	var url = "http://localhost:8080/FPBws/webresources/entities.tbuser/" + id;
	$('#js').html('');
    $.getJSON(url,function(result){
		$('#js').append('<tr><td>' + result['CId'] + 
		'</td><td>' + result['CUserName'] + 
		'</td><td>' + result['CFullName'] + 
		'</td><td>' + result['CPhoneNumber'] + 
		'</td><td>' + result['CEmail'] + 
		'</td><td>' + result['CAddress'] + 
		'</td><td>' + result['CIsActive'] + 
		'</td><td>' + result['CRankId']['CRankName'] + 
		'</td><td>' + result['CRoleId']['CDisplayName'] + 
		'</td><td><a href="delete?id=' + result['CId'] +
		'" class="btn btn-link">View</a></td></tr>');
		
		document.getElementById("CAddress").value = result['CAddress'];
		document.getElementById("CEmail").value = result['CEmail'];
		document.getElementById("CFullName").value = result['CFullName'];
		document.getElementById("CIsActive").value = result['CIsActive'];
		document.getElementById("CJoinDate").value = result['CJoinDate'];
		document.getElementById("CPassword").value = result['CPassword'];
		document.getElementById("CPhoneNumber").value = result['CPhoneNumber'];
		document.getElementById("CPoint").value = result['CPoint'];
		document.getElementById("CRankId").value = result['CRankId']['CId'];
		document.getElementById("CRoleId").value = result['CRoleId']['CId'];
		document.getElementById("CUserName").value = result['CUserName'];
  });
  };