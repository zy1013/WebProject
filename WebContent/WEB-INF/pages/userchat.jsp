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
	<link rel="stylesheet" href="../assets/vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" href="../assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="../assets/vendor/linearicons/style.css">
	<link rel="stylesheet" href="../assets/vendor/chartist/css/chartist-custom.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="../assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="../assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="../assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="../assets/img/favicon.png">
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<!-- NAVBAR -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="brand">
				<a href="index.html"><img src="../assets/img/icon.jpg" alt="Klorofil Logo" class="img-responsive logo"></a>
			</div>
			<div class="container-fluid">
				<div class="navbar-btn">
					<button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
				</div>
				

				<div id="navbar-menu">
					<ul class="nav navbar-nav navbar-right">
				

						<!-- <li>
							<a class="update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
						</li> -->
					
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
									<li><a href="page-profile.html" class="">好友管理</a></li>
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
				<div id="content" class="container-fluid">
					<!-- OVERVIEW -->
					
					<!-- END OVERVIEW -->
					<p id="destination">${target}</p>
					<div  id="messagebox" class="form-control" style="height:50%; resize: none;" placeholder="聊天内容" rows="4">
						
					</div>
					
					<div class="input-group">
										<input id="inputbox" class="form-control" type="text">
										<span class="input-group-btn"><button class="btn btn-primary" onclick="send();" type="button">发送</button></span>
									</div>
					
					
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
	<script src="../assets/vendor/jquery/jquery.min.js"></script>
	<script src="../assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="../assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="../assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script src="../assets/vendor/chartist/js/chartist.min.js"></script>
	<script src="../assets/scripts/klorofil-common.js"></script>
	<script>
	function send(){
		
		var value = $("#inputbox").val();
		var target = "${target}";
		console.log(value);
		$.ajax(
   	    {
   	    		
   	        url:"sendmessage",
   	        type:"post",
   	        dataType:"text",
   	        data:{"target":target,
   	        "content":value}
   	        
 		});
	};


window.setInterval(refresh(),1000);
		
		function refresh(){
			console.log("start!refresh!");
			var target = "${target}";
 		$.ajax(
   	    {
   	    		
   	        url:"pullchat",
   	        type:"post",
   	        dataType:"text",
   	        data:{"target":target
   	       },
   	        success:function(data)
   	        {
   	        	if(data.length>0)
   	        	{
   	        		console.log(data);
   	        		change(data);
   	        	}
   	        	
   	        		
   	        }
 		});
 		};
 		
 		
 		function change(data){
		var list = jQuery.parseJSON(data);
		console.log(data);
		for(var i = 0;i<list.length;i++)
			{
			var message = list[i].message;
			var dest = list[i].source;
			var time = list[i].date;
			var num = list[i].num;
			$("#messagebox").append("<p>来自："+dest+"<p>");
			$("#messagebox").append(time);
			$("#messagebox").append("<p>"+message+"<p>");

	};
	};

	</script>
</body>

</html>
