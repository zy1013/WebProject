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
	<div id="mainpage">
		<div id="message">
			<p>${message}</p>
		</div>
  <body>
 	</body>
 	<script>

  var i=5;
  var timer = setInterval(function(){
      i--;
      if(i ==1){
          window.location.href="home";
      }
  },1000);
 	</script>
</html>