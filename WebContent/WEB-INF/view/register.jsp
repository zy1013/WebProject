<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        	<!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
	<script src="js/jquery-3.3.1.min.js"></script>
	<!-- 包括所有已编译的插件 -->
	<script src="js/bootstrap.min.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/my.css" rel="stylesheet">
	</head>

    <body>
    	<div id = "mainpage">
    <form class="form-horizontal" action="validuid">
    <fieldset>
      <div id="legend" class="">
        <legend class="activity_box">注册表单</legend>
      </div>
    <div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">用户名</label><p id="resultMessage">1</p>
          <div class="controls">
            <input id="uid" name="uid" type="text" placeholder="" class="input-xlarge">
            <p class="help-block">不超过20个字符</p>
            
          </div>
        </div>

    <div class="control-group">

          
        </div><div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">昵称</label>
          <div class="controls">
            <input id="name" name="uname" type="text" placeholder="" class="input-xlarge">
            <p class="help-block">不超过20个字符</p>
            <br>
          </div>
        </div>

    <div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">密码</label>
          <div class="controls">
            <input id="password" name="password" type="password" placeholder="" class="input-xlarge">
            <p class="help-block">不超过20个字符</p>
          </div>
        </div>

    <div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">简介</label>
          <div class="controls">
            <input id="intro" name="intro" type="text" placeholder="" class="input-xlarge">
            <p class="help-block"></p>
          </div>
        </div>

    <div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">邮箱</label>
          <div class="controls">
            <input id="email" name="email" type="text" placeholder="" class="input-xlarge">
            <p class="help-block">请输入你的邮箱</p>
          </div>
        </div>

    <div class="control-group">
          <label class="control-label"></label>

          <!-- Button -->
          <div class="controls">
            <button class="btn btn-success" id="registerbutton" type="submit">注册</button>
            <button class="btn btn-danger" type="reset">重置</button>
            <button type="button" onclick="sendAjax()">检查</button>
          </div>
        </div>

    </fieldset>
 
    </div>
  </form>

 	</body>
  	<script>
 	function sendAjax()
 	{
 		if($("#uid").val()==""||$("#uname").val()==""||$("#password").val()==""||$("#email").val()==""||$("#intro").val()=="")
 		{
 		alert("不可为空!");
 		return;
 		}
 		
 		if($("#uid").val().length>20)
 		{alert("uid不可超过20个字符");
 		return;
 		}
 		if($("#uname").val().length>20)
 		{alert("昵称不可超过20个字符");
 		 		return;
 		}
 		if($("#password").val().length>20)
 		{alert("密码不可超过20个字符");
 		 		return;
 		}
 		if($("#intro").val().length>50)
 		{alert("简介不可超过50个字符");
 		 		return;
 		}
   	    var username = $("#uid").val();
   	    var email = $("#email").val();
   	    $.ajax(
   	    {
   	        url:"checkUsername",
   	        data:{"uid":username},
   	        type:"get",
   	        dataType:"text",
   	        success:function(data)
   	        {
   	        alert(data);
   	        }
			

 	});
 	   	$.ajax(
   	    {
   	        url:"checkemail",
   	        data:{"email":email},
   	        type:"get",
   	        dataType:"text",
   	        success:function(data)
   	        {
   	        if(data!=="")
   	        alert(data);
   	        }
 	});
   	    }
 	</script> 
</html>