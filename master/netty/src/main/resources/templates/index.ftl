<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>无标题文档</title>
</head>
</head>
<script type="text/javascript">
  var socket;


  if(!window.WebSocket){

    window.WebSocket = window.MozWebSocket;
  }

  if(window.WebSocket){
    socket = new WebSocket("ws://localhost:7397/websocket");

    socket.onmessage = function(event){

      var ta = document.getElementById('responseText');
      ta.value += event.data+"\r\n";
    };

    socket.onopen = function(event){

      var ta = document.getElementById('responseText');
      ta.value = "打开WebSoket 服务正常，浏览器支持WebSoket!"+"\r\n";

    };

    socket.onclose = function(event){

      var ta = document.getElementById('responseText');
      ta.value = "";
      ta.value = "WebSocket 关闭"+"\r\n";
    };
  }else{
    alert("您的浏览器不支持WebSocket协议！");
  }

  function send(message){
    if(!window.WebSocket){return;}
    if(socket.readyState == WebSocket.OPEN){
      socket.send(message);
    }else{
      alert("WebSocket 连接没有建立成功！");
    }

  }

</script>
<body>
<form onSubmit="return false;">
  <input type = "text" name="message" value="Netty The Sinper"/>
  <br/><br/>
  <input type="button" value="发送 WebSocket 请求消息" onClick="send(this.form.message.value)"/>
  <hr color="blue"/>
  <h3>服务端返回的应答消息</h3>
  <textarea id="responseText" style="width: 1024px;height: 300px;"></textarea>
</form>
</body>
</html>
