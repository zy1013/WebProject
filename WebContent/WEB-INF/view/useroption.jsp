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
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" href="css/my.css">
	<script src="/js/jquery-3.3.1.min.js"></script>
	<script src="/js/bootstrap.min.js"></script>
    </head>
    <body>

<div id="header">
<h1>City Gallery</h1>
</div>

<div id="nav" class ="show">

	<h4>你好!<h3 >${cookie.uname.value}<h3></h4>
	<h5 id="uid">${cookie.uid.value}</h5>
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
	<div id="number">${fn:length(list)}</div>
	<table id = "friends" class="table table-hover">
	<tr>	
		<th> uid</th>
		<th> uname</th>
		<th> 时间</th>
		<th> 操作</th>
	</tr>

	</table>


</div>

<div id="footer">
Copyright W3School.com.cn
</div>
<form id="temp" method="post" action="" style="visibility:hidden">
	<input id="formuid" name="uid"></input>
	
	</form>

 	</body>
 	<script>
// 		
$(document).ready(function(){
	
	<c:forEach items="${list}" var="data">   
    var uid = "${data.uid2}";  
	var type = "${data.type}"; 
	var uname = "${data.uname}"; 
	var builddate = "${data.date}"; 
	if(type=="friend")
	$("tbody").append("<tr class=\"success\">");
	else	
	$("tbody").append("<tr class=\"warning\">");
    $("tbody").append("<td>"+uid+"</td>");
    $("tbody").append("<td>"+uname+"</td>");
    $("tbody").append("<td>"+ builddate+"</td>");
	$("tbody").append("<td>" + "<button class='chatuser' "+"name='"+uid+"'"+">聊天</button></td>");
	$("tbody").append( "<td><button class='deleteuser' "+"name='"+uid+"'"+">删除</button>" + "</td>");
    $("tbody").append("</tr>");
    </c:forEach>   
    
    
    var source =$("#uid").val();
    		$(".chatuser").bind("click",function(){
    		var target = this.name.toString();
    		target="friend/"+target;
    		alert(target);
    		var form = document.getElementById('temp');
    		$("#formuid").val(source);
    		form.action=target.toString();
    		
    		form.submit();
 	});
 	    $(".deleteuser").bind("click",function(){
    	var target = this.name;
  		$.ajax(
   	    {
   	        url:"deleteuser/"+target,
   	        data:{"source":source},
   	        type:"post",
   	        dataType:"text",
   	        success:function(data)
   	        {
   	        if(data!=="")
   	        alert(data);
   	        }
 	});
 	});

});



 	</script>
</html>