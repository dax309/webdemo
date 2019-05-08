<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/4/15
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>播放页</title>

    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <%--<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
    <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css" />
    <link rel="stylesheet" href="css/custom.css">
    <script type="text/javascript">
       function click(){
            $(this).siblings().slideToggle(1500);



       }
    </script>


</head>
<body>
<div class="row col-md-12">
<!-- 引入header.jsp -->
<jsp:include page="/header.jsp"></jsp:include>
</div>
<br>
<br>
<div style="margin:20px;border-radius: 15px">
    <div class="row" style="border-radius: 15px">
        <div style="float: left;">
            <a href="javascript:history.back(-1)">
                <button type="button" class="btn btn-default" aria-label="Left Align" style="cursor: pointer">
                    <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
                </button>
            </a>
        </div>
        <div class="col-md-2" style="float: left;font-size: 23px">
            <a href="">
            <span style="text-align: center;font-weight: bold">${classinfo2.name}</span>
            </a>
            <span style="text-align: center">:${classinfo.name}</span>
        </div>
    </div>
    <div class="row" style="border-radius: 15px">
        <div class="col-md-12" style="height: 20px;"></div>
    </div>

    <div class="row" style="background-color: #1c1b17;border-radius: 15px">
        <div class="col-md-1"  style="float: left;border-radius: 15px">
            <div style="border-radius: 15px;height: 450px">
                <br>
                <br>
                <br>
                <br>
                <%--<button type="button" class="btn btn-primary btn-lg active">章节</button><br>
                <br>
                <a href="/testIndex">
                <button type="button" class="btn btn-primary btn-lg active">练习</button><br>
                </a>
                <br>
                <button type="button" class="btn btn-primary btn-lg active">讨论</button><br>--%>
            </div>
        </div>
        <div class="col-md-7" style="height: 450px;float: left;background-color: black;
                                     border-radius: 15px;margin:15px auto auto auto" id="vedio">
            <p align="center" style="margin:10px auto auto auto;border-radius: 10px">
                <video  id="video" width="80%" height="90%" autoplay controls>
                    <source src="video/${classinfo.videoaddress}.mp4" type="video/mp4">
                    你的播放器不支持本视频播放，建议使用谷歌浏览器电脑版
                </video>
                <br>

                    <button  onclick="playPause()">播放/暂停</button>
                    <button  onclick="setPlaySpeed(0.75)"  type="button">0.75倍速</button>
                    <button  onclick="setPlaySpeed(1)"  type="button">普通</button>
                    <button  onclick="setPlaySpeed(1.5)"  type="button">1.5倍</button>
                    <button  onclick="setPlaySpeed(2)"  type="button">2倍</button>
                <script>
                    var myVideo=document.getElementById("video");
                    function setPlaySpeed(spend)  {
                         myVideo.playbackRate=spend;//设定新的播放速度2倍速度
                    }
                    function playPause(){
                        if (myVideo.paused)
                            myVideo.play(); //播放
                        else
                            myVideo.pause(); //暂停播放
                    }
                </script>
            </p>
        </div>
        <div class="col-md-4" style="float: right;height: 500px;border-radius: 15px;border: 1px solid red">
            <c:forEach var="classinfo" items="${list1}" varStatus="s">
                <button type="button" id="${classinfo.code}" onclick='javascript:click(this);' class="btn btn-primary btn-lg active" >${classinfo.name}</button>
                <br>

            </c:forEach>
        </div>
    </div>
</div>
<hr style="width:80%;margin:0 auto;border: 0;height: 0;border-top: 1px solid rgba(0, 0, 0, 0.1);border-bottom: 1px solid rgba(255, 255, 255, 0.3);">
<!-- 引入footer.jsp -->
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
