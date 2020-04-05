<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
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

				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">

					</ul>
				</div>
			</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<li><a href="home" class="active"><i class="lnr lnr-home"></i> <span>主页</span></a></li>
						<li>
							<a href="#subPages3" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>标签</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages3" class="collapse ">
								<ul class="nav">
									<li><a href="selecttag" class="">发现标签</a></li>
									<li><a href="tagsetting" class="">标签管理</a></li>
								</ul>
							</div>
						</li>
						<li>
							<a href="#subPages1" data-toggle="collapse" class="collapsed"><i class="lnr lnr-user"></i> <span>好友</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages1" class="collapse ">
								<ul class="nav">
									<li><a href="friends" class="">好友管理</a></li>
									<li><a href="addfriend" class="">添加好友</a></li>
								</ul>
							</div>
						</li>
						<li><a href="notification" class=""><i class="lnr lnr-alarm"></i> <span>通知</span></a></li>
						<li><a href="setting" class=""><i class="lnr lnr-cog"></i> <span>设置</span></a></li>
						
						<li id="manage">
							<a href="#subPages2" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>管理</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
							<div id="subPages2" class="collapse ">
								<ul class="nav">
									<li><a href="manageuser" class="">用户管理</a></li>
									<li><a href="managemovie" class="">电影管理</a></li>
									<li><a href="managechannel" class="">频道管理</a></li>
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
				<div id = "recommendmovie" class="container-fluid">
					<!-- OVERVIEW -->
					
					<!-- END OVERVIEW -->
					
					<!--整个推荐的条子-->
					<div class="panel" onclick="openmoviepage('3');">
								<div class="panel-heading">
									<h3 class="panel-title" onclick="jump(this);">电影名</h3>
									<div class="right">
										<button type="button" onclick="like(this);" class="btn"><i class="fa fa-check-circle"></i></button>
										<button type="button" onclick="remove(this);" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								<div class="panel-footer">
									<h5>推荐原因</h5>
								</div>
							</div>
					<!--结束条子-->
				</div>
				<div id = "recommenduser" class="container-fluid">
					<!-- OVERVIEW -->
					
					<!-- END OVERVIEW -->
					
					<!--整个推荐的条子-->
					<div class="panel">
								<div class="panel-heading">
									<h3 class="panel-title" onclick="jump(this);">电影名</h3>
									<div class="right">
										<button type="button" onclick="like(this);" class="btn"><i class="fa fa-check-circle"></i></button>
										<button type="button" onclick="remove(this);" class="btn-remove"><i class="lnr lnr-cross"></i></button>
									</div>
								</div>
								<div class="panel-footer">
									<h5>推荐原因</h5>
								</div>
							</div>
					<!--结束条子-->
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
		
				$(document).ready(function (){
			refresh();
		});
		
		function refresh(){
 		$.ajax(
   	    {
   	    		
   	        url:"getrecommendmovie",
   	        type:"post",
   	        
   	        success:function(data)
   	        {
   	        	if(data.length>0)
   	        		$("#recommendmovie").empty();
   	        		change(data);
   	        }
 		});
 		
 				$.ajax(
   	    {
   	    		
   	        url:"getrecommenduser",
   	        type:"post",
   	        
   	        success:function(data)
   	        {
   	        	if(data.length>0)
   	        		$("#recommenduser").empty();
   	        		change1(data);
   	        }
 		});
 		
 		
 		};
 		
 		
 		function change(data){
		var list = jQuery.parseJSON(data);
		console.log(data);
		for(var i = 0;i<list.length;i++)
			{
				var title = list[i].title;
				var reason = list[i].reason;
				var mid = list[i].mid;
		$("#recommendmovie").append(
		"					<div class=\"panel\">"+
"								<div class=\"panel-heading\">"+
"									<h3 class=\"panel-title\" onclick=\"openmoviepage("+mid+");\">"+title+"</h3>"+
"									<div class=\"right\">"+
"										<button type=\"button\" onclick=\"like(this);\" class=\"btn\"><i class=\"fa fa-check-circle\"></i></button>"+
"										<button type=\"button\" onclick=\"remove(this);\" class=\"btn-remove\"><i class=\"lnr lnr-cross\"></i></button>"+
"									</div>"+
"								</div>"+
"								<div class=\"panel-footer\">"+
"									<h5>根据类似"+reason+"标签匹配</h5>"+
"								</div>"+
"							</div>");
	};
	
};


 		function change1(data){
		var list = jQuery.parseJSON(data);
		console.log(data);
		for(var i = 0;i<list.length;i++)
			{
				var name = list[i].name;
				var intro = list[i].intro;
			var uid = list[i].uid.trim();
		$("#recommendmovie").append(
		"					<div class=\"panel\">"+
"								<div class=\"panel-heading\">"+
"									<h3 class=\"panel-title\" onclick=\"openuserpage(\""+uid+"\")\">"+name+"</h3>"+
"									<div class=\"right\">"+
"										<button type=\"button\" onclick=\"like(this);\" class=\"btn\"><i class=\"fa fa-check-circle\"></i></button>"+
"										<button type=\"button\" onclick=\"remove(this);\" class=\"btn-remove\"><i class=\"lnr lnr-cross\"></i></button>"+
"									</div>"+
"								</div>"+
"								<div class=\"panel-footer\">"+
"									<h5>个人简介："+intro+"</h5>"+
"								</div>"+
"							</div>");
	};
	
};


function openuserpage(data)
{
	var str = "user/"+data;
	window.open(str);
};



function openmoviepage(data)
{
	var str = "movie/"+data;
	window.open(str);
};
	</script>
</body>

</html>
