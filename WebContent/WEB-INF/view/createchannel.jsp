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
    		  <form class="form-horizontal" action="createChannel">
      <fieldset>
      <div id="legend" class="">
        <legend class="">表单名</legend>
      </div>
    <div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">频道id</label>
          <div class="controls">
            <input type="text" name="cid" placeholder="输入频道url" class="input-xlarge">
            <p class="help-block">不超过20个字符</p>
          </div>
        </div><div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">频道名称</label>
          <div class="controls">
            <input type="text" name="cname" placeholder="在此输入频道名称" class="input-xlarge">
            <p class="help-block">不超过20个字符</p>
          </div>
        </div>

    <div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">简介</label>
          <div class="controls">
            <input type="text" name="cintro" placeholder="在此输入简介" class="input-xlarge">
            <p class="help-block">不超过100个字符</p>
          </div>
        </div>

    <div class="control-group">
          <label class="control-label">是否公开</label>
          <div class="controls">
      <!-- Multiple Radios -->
      <label class="radio">
        <input type="radio" value="1" name="public" checked="checked">
        是
      </label>
      <label class="radio">
        <input type="radio" value="0" name="public">
        否
      </label>
  </div>

        </div>

    <div class="control-group">
          <label class="control-label"></label>

          <!-- Button -->
          <div class="controls">
            <button class="btn btn-default">检查</button>
          </div>
        </div><div class="control-group">
          <label class="control-label"></label>

          <!-- Button -->
          <div class="controls">
            <button class="btn btn-success" type="submit">创建</button>
          </div>
        </div>

    

    </fieldset>
  </form>

   </div>
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