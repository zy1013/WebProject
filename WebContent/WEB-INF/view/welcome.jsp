<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>welcome</title>
</head>
<body>${requestScope.message}
<form class="form-horizontal">
    <fieldset>
      <div id="legend" class="">
        <legend class="">登录</legend>
      </div>
    <div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">用户名</label>
          <div class="controls">
            <input type="text" placeholder="" class="input-xlarge">
            <p class="help-block"></p>
          </div>
        </div>

    <div class="control-group">

          <!-- Text input-->
          <label class="control-label" for="input01">密码</label>
          <div class="controls">
            <input type="text" placeholder="" class="input-xlarge">
            <p class="help-block"></p>
          </div>
        </div>

    <div class="control-group">
          <label class="control-label">Button</label>

          <!-- Button -->
          <div class="controls">
            <button class="btn btn-success">Button</button>
          </div>
        </div>

    </fieldset>
  </form>
</body>
</html>