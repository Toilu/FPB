 function loadNavibar(){
	 var strVar="";
strVar += "<ul class=\"templatemo-sidebar-menu\">";
strVar += "          <li>";
strVar += "            <form class=\"navbar-form\">";
strVar += "              <input type=\"text\" class=\"form-control\" id=\"templatemo_search_box\" placeholder=\"Search...\">";
strVar += "              <span class=\"btn btn-default\">Go<\/span>";
strVar += "            <\/form>";
strVar += "          <\/li>";
strVar += "          <li><a href=\"index.html\"><i class=\"fa fa-home\"><\/i>Dashboard<\/a><\/li>";
strVar += "          <li class=\"sub\">";
strVar += "            <a href=\"javascript:;\">";
strVar += "              <i class=\"fa fa-database\"><\/i> Nested Menu <div class=\"pull-right\"><span class=\"caret\"><\/span><\/div>";
strVar += "            <\/a>";
strVar += "            <ul class=\"templatemo-submenu\">";
strVar += "              <li><a href=\"#\">Aenean<\/a><\/li>";
strVar += "              <li><a href=\"#\">Pellentesque<\/a><\/li>";
strVar += "              <li><a href=\"#\">Congue<\/a><\/li>             ";
strVar += "              <li><a href=\"#\">Interdum<\/a><\/li>";
strVar += "              <li><a href=\"#\">Facilisi<\/a><\/li>";
strVar += "            <\/ul>";
strVar += "          <\/li>";
strVar += "          <li><a href=\"data-visualization.html\"><i class=\"fa fa-cubes\"><\/i><span class=\"badge pull-right\">9<\/span>Data Visualization<\/a><\/li>";
strVar += "          <li><a href=\"maps.html\"><i class=\"fa fa-map-marker\"><\/i><span class=\"badge pull-right\">42<\/span>Maps<\/a><\/li>";
strVar += "          <li class=\"active\"><a href=\"#\"><i class=\"fa fa-users\"><\/i><span class=\"badge pull-right\">NEW<\/span>Manage Users<\/a><\/li>";
strVar += "          <li><a href=\"preferences.html\"><i class=\"fa fa-cog\"><\/i>Preferences<\/a><\/li>";
strVar += "          <li><a href=\"javascript:;\" data-toggle=\"modal\" data-target=\"#confirmModal\"><i class=\"fa fa-sign-out\"><\/i>Sign Out<\/a><\/li>";
strVar += "        <\/ul>";

$('#navibar').html(strVar);
 }