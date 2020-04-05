<%@page contentType="text/html"%>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en" class="fullscreen-bg">

<head>
	<title>Login</title>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
	<!-- VENDOR CSS -->
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" href="assets/vendor/linearicons/style.css">
	<!-- MAIN CSS -->
	<link rel="stylesheet" href="assets/css/main.css">
	<!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
	<link rel="stylesheet" href="assets/css/demo.css">
	<!-- GOOGLE FONTS -->
	<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
	<!-- ICONS -->
	<link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
	    <!-- base需要放到head中 -->    
    <base href=" <%=basePath%>">   
</head>

<body>
	<!-- WRAPPER -->
	<div id="wrapper">
		<div class="vertical-align-wrap">
			<div class="vertical-align-middle">
				<div class="auth-box ">
					<div class="left">
						<div class="content">
							<div class="header">

								<p class="lead">请输入注册信息</p>
							</div>
							<form id="registerform" class="form-auth-small" action="confirmregister">
								<div class="form-group">
									<label for="signin-email" class="control-label sr-only">uid</label>uid
									<input type="text" id="uid" name="uid" class="form-control" id="signin-email" value="请输入你的uid" placeholder="text">
								</div>
								<div class="form-group">
									<label for="signin-email" class="control-label sr-only"></label>昵称
									<input type="text" id="name" name="uname" class="form-control" id="signin-email" value="请输入你的昵称" placeholder="text">
								</div>
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only"></label>密码
									<input type="password" id="password" name="password" class="form-control" id="signin-password" value="thisisthepassword" placeholder="Password">
								</div>
								<div class="form-group">
									<label for="signin-password" class="control-label sr-only"></label>简介
									<input type="textarea" id="intro" name="intro" class="form-control" id="signin-password" value="输入你的介绍" placeholder="Password">
								</div>
								<div class="form-group">
									邮箱
									<input type="email" id="email" name="email" class="form-control" id="signin-email" value="帮助您找回密码" placeholder="Email">

								<button id="registerbutton" type="submit" class="btn btn-primary btn-lg btn-block" disabled="disabled">注册</button>
								<div class="bottom">
									<span class="helper-text"><i class="fa fa-lock"></i> <a href="forgetpassword">忘记密码?</a></span>
								</div>
							</form>
						</div>
					</div>
					<div class="right">
						<div class="overlay"></div>
						<div class="content text">
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
	</div>
	<!-- END WRAPPER -->
</body>
	<script src="./assets/vendor/jquery/jquery.min.js"></script>
	<script src="./assets/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="./assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
	<script src="./assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
	<script src="./assets/vendor/chartist/js/chartist.min.js"></script>
	<script src="./assets/scripts/klorofil-common.js"></script>
<script>
	
	$('#registerform').change(function() {

			if(test()==0){
				$('#registerbutton').attr("disabled",false); 
			}
			else
			{
				$('#registerbutton').attr("disabled",true); 
			}
			
  			
});

	function test(){
		flag =0;
			if($('#uid').val().length>15)
			{
				alert("uid过长!请控制在15个字符以内");
				flag=1;
			}
			var pattern = new RegExp("[`~!@#$^&*()=|{}':;',\\[\\].<>/?~！@#￥……&*（）——|{}【】‘；：”“'。，、？]");

			var a=$('#uid').val();
				if(pattern.test(a))
				{
				     alert("uid不允许有特殊字符");
				     flag=1;
				}
			
			
  			if($('#name').val().length>20)
			{
				alert("昵称过长!请控制在20个字符以内");
				flag=1;
			}
			if($('#password').val().length>20)
			{
				alert("密码过长!请控制在20个字符以内");
				flag=1;
			}
			
			if($('#intro').val().length>20)
			{
				alert("简介过长!请控制在20个字符以内");
				flag=1;
			}
			
			
			var value = $('#uid').val();
			$.ajax(
   	    		{
   	    		
   	        url:"checkregister",
   	        type:"post",
   	        dataType:"text",
   	        data:{"uid":value},
   	        success:function(data)
   	        {
   	        	console.log(data);
   	        		if(data.length>0)
   	        		{
   	        			alert("此uid已存在");
   	        			flag=1;
   	        		}
   	        }
 		});
  		return flag;
	};
</script>
</html>
