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

    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->



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
            <a href="/index">
                <button type="button" class="btn btn-default" aria-label="Left Align">
                    <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
                </button>
            </a>
        </div>
        <div class="col-md-2" style="float: left;font-size: 23px">
            <span style="text-align: center">第一节：课程简介</span>
        </div>
    </div>
    <div class="row" style="border-radius: 15px">
        <div class="col-md-12" style="height: 20px;"></div>
    </div>

    <div class="row" style="background-color: #1c1b17;border-radius: 15px">
        <div class="col-md-2"  style="float: left;border-radius: 15px">
            <div style="border-radius: 15px;height: 450px">
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <button type="button" class="btn btn-primary btn-lg active">章节</button><br>
                <br>
                <button type="button" class="btn btn-primary btn-lg active">练习</button><br>
                <br>
                <button type="button" class="btn btn-primary btn-lg active">讨论</button><br>

            </div>
        </div>
        <div class="col-md-7" style="height: 450px;float: left;background-color: black;
                                     border-radius: 15px;margin:15px auto auto auto" id="vedio">
            <p align="center" style="margin:10px auto auto auto;border-radius: 10px">
                <video  id="div" width="80%" height="90%" controls="controls">
                    <source src="video/001.mp4" type="video/mp4">
                    你的播放器不支持本视频播放，建议使用谷歌浏览器电脑版
                </video>
            </p>
        </div>
        <div class="col-md-3" style="float: right;height: 500px;border-radius: 15px;border: 1px solid red">
               <h1 style="text-align: center"><span style="color: #fefefb">测试</span></h1>
            <span style="color: white;font-size: 25px">此处添加简介、教师等信息</span>
        </div>
    </div>
</div>
<!-- 引入footer.jsp -->
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
