<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/my.css" rel="stylesheet">
	</head>

  <body>
	    	<div id = "mainpage">
    <form class="form-horizontal" action="home" method="post">
    <fieldset>
      <div id="legend" class="">
        <legend class="activity_box">表单名</legend>
      </div>
    <div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">用户名</label>
          <div class="controls">
            <input id="uid" name="uid" type="text" placeholder="" class="input-xlarge">
            <p class="help-block">不超过20个字符</p>
            
          </div>
        </div>



    <div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">密码</label>
          ${message}
          <div class="controls">
            <input id="password" name="password" type="text" placeholder="" class="input-xlarge">
            <p class="help-block">不超过20个字符</p>
          </div>
        </div>


    <div class="control-group">
          <label class="control-label"></label>

          <!-- Button -->
          <div class="controls">
            <button class="btn btn-success" type="submit">登录</button>
            <button class="btn btn-danger" type="reset">重置</button>
            <button class="btn btn-danger" type="submit">已经登陆?</button>
          </div>
        </div>

    </fieldset>
    </div>
 	</body>
</html>