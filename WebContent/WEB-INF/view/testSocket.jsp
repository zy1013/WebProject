<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/my.css">
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
       welcome<br />  
       <input id="text" type="text"/>  
       <button onclick="sendMsg()">sendMsg</button>  
       <hr/>  
       <button onclick="closeWebSocket()">close WebSocketconnection</button>  
       <hr/>  
       <div id="message"></div>  

</body>
 <script type="text/javascript">  
       var websocket = null;  
       //判断浏览器是否支持websocket  
       if('WebSocket' in window) {  
           websocket = new WebSocket("ws://localhost:8080/finalDesign/socket");  
       }else{  
           $("#message").html("该浏览器不支持实时通信功能");  
       }  
        
       websocket.onopen= function() {  
           console.log("websocket连接成功");  
       }  
        
       websocket.onclose= function() {  
           console.log("websocket连接关闭");  
       }  
        
       websocket.onmessage= function(event) {  
           console.log("接收消息");  
           console.log(event);  
           printMsg(event.data);  
       }  
        
       //打印消息  
       function printMsg(msg) {  
           $("#message").append(msg+ "<br/>");  
       }  
        
       function sendMsg() {  
           var msg = $("#text").val();  
           websocket.send(msg);  
       }  
        
       function closeWebSocket(){  
           websocket.close();  
       }  
    </script>  

</html>