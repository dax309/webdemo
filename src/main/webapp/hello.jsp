<%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/4/7
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>主页</title>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css" type="text/css" />
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript"></script>
</head>
<body>
<div class="row col-md-12">
    <!-- 引入header.jsp -->
    <jsp:include page="/header.jsp"></jsp:include>
</div>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>阿酷TONY</title>
</head>
<body>
<div style="text-align:center">
    <button onclick="playPause()">播放/暂停</button>
    <button onclick="makeBig()">放大</button>
    <button onclick="makeSmall()">缩小</button>
    <button onclick="makeNormal()">普通</button>
    <button onclick="getPlaySpeed()" type="button">播放速度是多少？</button>
    <button onclick="setPlaySpeed()" type="button">将视频设置为以快速播放</button>
    <br>
    <video id="video" width="420" autoplay controls>
        <source src="video/001.mp4" type="video/mp4">
        TONY提示：您浏览器不支持 HTML5 video 标签。 </video>
</div>
<script>
    var myVideo=document.getElementById("video");
    function getPlaySpeed() {
        alert(myVideo.playbackRate);//获取播放速度
    }
    function setPlaySpeed()  {
        myVideo.playbackRate=2;//设定新的播放速度2倍速度
    }
    function playPause(){
        if (myVideo.paused)
            myVideo.play(); //播放
        else
            myVideo.pause(); //暂停播放
    }
    function makeBig(){
        myVideo.width=660;
    }
    function makeSmall(){
        myVideo.width=230;
    }
    function makeNormal(){
        myVideo.width=400;
    }
</script>
</body>
</html>

</body>
</html>