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

				</div>
			</div>
		</nav>
		<!-- END NAVBAR -->
		<!-- LEFT SIDEBAR -->
		<div id="sidebar-nav" class="sidebar">
			<div class="sidebar-scroll">
				<nav>
					<ul class="nav">
						<li><a href="#" class="active"><i class="lnr lnr-home"></i> <span>主页</span></a></li>
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
							<div class="container-fluid">

			<form id="registerform" class="" action="updateuser">
								<div class="form-group">
									<label for="signin-email" class="control-label sr-only">uid</label>uid
									<input disabled="true" type="text" id="uid" name="uid" class="form-control" id="signin-email" value="${uid}" placeholder="text">
								</div>
								<div class="form-group">
									<label for="signin-email" class="control-label sr-only"></label>昵称
									<input type="text" id="name" name="uname" class="form-control" id="signin-email" value="${name}" placeholder="text">
								</div>
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only"></label>密码
									<input type="password" id="password" name="password" class="form-control" id="signin-password" value="${password}" placeholder="${password}">
								</div>
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only"></label>简介
									<input type="textarea" id="intro" name="intro" class="form-control" id="signin-password" value="${intro}" placeholder="Password">
								</div>
								<div class="form-group">
									邮箱
									<input type="email" id="email" name="email" class="form-control" id="signin-email" value="${email}" placeholder="Email">
									<label class="fancy-checkbox">
									<input name="allowrecommend" type="checkbox">
										<span>是否被推荐</span>
									</label>
									<label class="fancy-checkbox">
									<input name="allowwatch" type="checkbox">
										<span>是否允许查看</span>
									</label>
									<label class="fancy-checkbox">
									<input name="allowadd" type="checkbox">
										<span>是否被添加好友</span>
									</label>
								<button id="registerbutton" type="submit" class="btn btn-primary btn-lg btn-block" >更新</button>
								
							</form>
			
			</div>
			</div>
			<!-- END MAIN CONTENT -->
		</div>
		<!-- END MAIN -->
		<div class="clearfix"></div>


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
		function test(data){
		console.log(data.checked)	;
		};
	</script>
</body>

</html>
