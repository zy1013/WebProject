<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../css/bootstrap.min.css">
        <link rel="stylesheet" href="../css/my.css">
	<script src="../js/jquery-3.3.1.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
    </head>
    <body>

<div id="header">
<h1>City Gallery</h1>
</div>

<div id="nav">

	<h4>你好!${cookie.uname.value}</h4>
	<h5>uid:${cookie.uid.value}</h5>
	<h5>上次登录:${cookie.lastlogin.value}</h5>
	<div class="module" >
		<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">主页</a>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li ><a href="home">频道</a></li>
            <li class="active"><a href="#">好友</a></li>
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    设置
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">个人属性设置</a></li>
                    <li><a href="#">推荐属性设置</a></li>
                    <li><a href="#">好友属性设置</a></li>
                    <!--<li class="divider"></li>
                    <li><a href="#">分离的链接</a></li>
                    <li class="divider"></li>
                    <li><a href="#">另一个分离的链接</a></li>-->
                </ul>
            </li>
            	<li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    管理
                    <b class="caret"></b>
                </a>
                <ul class="dropdown-menu">
                    <li><a href="#">频道管理</a></li>
                    <li><a href="#">个人信息管理</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
</nav>
		
	</div>
</div>

<div id="section">
<p id="target">${target}</p>
<div id="chatbox">
	<div id="messagebox">
		
	</div>
	<div id="inputbox" style="width:100%; position:fixed;  bottom:10%;">
		<!-- Textarea -->
          <label class="control-label">回复</label>
          <div class="controls">
            <div class="textarea">
                  <textarea id="textarea" class="" style="width: 80%;height: 20%;resize:none;"> </textarea>
                  <button onclick="sendMessage();">发送</button>
            </div>
          </div>
	</div>
</div>

<div id="footer">
Copyright W3School.com.cn
</div>
 	</body>
 	<script>
 		
 		window.setInterval(function(){
 		var data =$("#target").val().toString();
 		$.ajax(
   	    {
   	    		
   	        url:"pullMessage",
   	        type:"post",
   	        dataType:"text",
   	        data:{"target":data}，
   	        success:function(data)
   	        {
   	        	if(data.length>0)
   	        		notify(data);
   	        }
 		});
 		},1000);
	function notify(data){
		var list = jQuery.parseJSON(data);
		console.log(data);
		for(var i = 0;i<list.length;i++)
			{
			var message = list[i].message;
			var dest = list[i].source;
			var time = list[i].date;
			var num = list[i].num;
			already(num);
		$("#messagebox").append("<p>"+dest+"<p>");
		$("#messagebox").append("<p>"+time+"<p>");
		$("#messagebox").append("<p>"+message+"<p>");
			
			}

	};
 		function already(data)
 		{
 		var target=$("#target").val().toString();
 		var content=$("#target").val().toString();
 			$.ajax(
   	    {
   	        url:"readMessage",
   	        type:"post",
   	        dataType:"text",
   	        data:{"target":target,
   	        "content":content}
 		});
 		}
 		
 		
 		
 		function sendMessage(){
 			$.ajax(
   	    {
   	    		
   	        url:"sendmessage",
   	        type:"post",
   	        dataType:"text",
   	        data:{"target":data}，
   	        success:function(data)
   	        {
   	        	if(data.length>0)
   	        		notify(data);
   	        }
 		});
 		};
 	</script>
 	<style type="text/css">
 		#chatbox{
 			width: auto;
 			height: 50%;
 			border-color: #000000;
			border-style: solid;
			border-width: 2px;
 		}
 	</style>
</html>