<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!doctype html>
<html lang="en">

<head>
	<title>Home</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="./assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="./assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="./assets/vendor/linearicons/style.css">
	<link rel="stylesheet" href="./assets/vendor/chartist/css/chartist-custom.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="./assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="./assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="./assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="./assets/img/favicon.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="index.html"><img src="assets/img/icon.jpg" alt="Klorofil Logo" class="img-responsive logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
				</div>
				<form class="navbar-form navbar-left">
					<div class="input-group">
						<input type="text" value="" class="form-control" placeholder="Search dashboard...">
						<span class="input-group-btn"><button type="button" class="btn btn-primary">Go</button></span>
					</div>
				</form>

			</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<li><a href="#" class=""><i class="lnr lnr-home"></i> <span>主页</span></a></li>
						<li>
							<a href="#subPages3" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>频道</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages3" class="collapse ">
								<ul class="nav">
									<li><a href="page-profile.html" class="">创建频道</a></li>
									<li><a href="page-login.html" class="">频道管理</a></li>
									<li><a href="page-lockscreen.html" class="">发现频道</a></li>
								</ul>
							</div>
						</li>
						<li>
							<a href="#subPages1" data-toggle="collapse" class="collapsed"><i class="lnr lnr-user"></i> <span>好友</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages1" class="collapse ">
								<ul class="nav">
									<li><a href="page-profile.html" class="active">好友管理</a></li>
									<li><a href="page-login.html" class="">添加好友</a></li>
								</ul>
							</div>
						</li>
						<li><a href="notifications.html" class=""><i class="lnr lnr-alarm"></i> <span>通知</span></a></li>
						<li><a href="panels.html" class=""><i class="lnr lnr-cog"></i> <span>设置</span></a></li>
						
						<li>
							<a href="#subPages2" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>管理</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages2" class="collapse ">
								<ul class="nav">
									<li><a href="page-profile.html" class="">用户管理</a></li>
									<li><a href="page-login.html" class="">电影管理</a></li>
									<li><a href="page-lockscreen.html" class="">频道管理</a></li>
								</ul>
							</div>
						</li>
						
					</ul>
				</nav>
			</div>
		</div>
		<!-- END LEFT SIDEBAR -->
		<!-- MAIN -->
		<div class="main">
			<!-- MAIN CONTENT -->
			<div class="main-content">
				<div class="container-fluid">
					<!-- OVERVIEW -->
						<div id="number"></div>
	<table id = "friends" class="table table-hover">
	<tr>	
		<th> uid</th>
		<th> uname</th>
		<th> date</th>
	</tr>

	</table>
					
					
				</div>
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->
		<div class="clearfix"></div>
		<footer>
			<div class="container-fluid">
				
				
			</div>
		</footer>
	</div>
	<!-- END WRAPPER -->
	<!-- Javascript -->
	<script src="./assets/vendor/jquery/jquery.min.js"></script>
	<script src="./assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="./assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="./assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script src="./assets/vendor/chartist/js/chartist.min.js"></script>
	<script src="./assets/scripts/klorofil-common.js"></script>
	<script>
$(document).ready(function(){

	
	<c:forEach items="${list}" var="data">   
    var uid = "${data.uid}";  
	var date = "${data.createDate}"; 
	var uname = "${data.name}"; 
    $("tbody").append("<tr>");
    $("tbody").append("<td id=\"uid\" onclick=\"openuserpage(this)\">"+uid+"</td>");
    $("tbody").append("<td>"+uname+"</td>");
    $("tbody").append("<td>"+ date+"</td>");
    $("tbody").append("</tr>");
    </c:forEach>   
    
    
    
 	    
 	});



function openuserpage(data)
{
	var uid = data.innerText.trim();
	var str = "user/"+uid;
	window.open(str);
};
	</script>
</body>

</html>
