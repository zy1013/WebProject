<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/my.css">
	<script src="js/jquery-3.3.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
    </head>
    <body>
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
            <li class="active"><a href="#">频道</a></li>
            <li><a href="friend">好友</a></li>
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
                    <li><a href="#">jmeter</a></li>
                    <li><a href="#">EJB</a></li>
                    <li><a href="#">Jasper Report</a></li>
                    <li class="divider"></li>
                    <li><a href="#">分离的链接</a></li>
                    <li class="divider"></li>
                    <li><a href="#">另一个分离的链接</a></li>
                </ul>
            </li>
        </ul>
    </div>
    </div>
</nav>
		
	</div>
</div>

<div id="section">
<h1>London</h1>
<p>
London is the capital city of England. It is the most populous city in the United Kingdom,
with a metropolitan area of over 13 million inhabitants.
</p>
<p>
Standing on the River Thames, London has been a major settlement for two millennia,
its history going back to its founding by the Romans, who named it Londinium.
</p>
</div>

<div id="footer">
Copyright W3School.com.cn
</div>

</body>
 	</body>
 	<script>

 		
 	</script>
</html>