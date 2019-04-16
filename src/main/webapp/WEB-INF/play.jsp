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
<div>
    <a href="/index">
    <button type="button" class="btn btn-default" aria-label="Left Align">
        <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
    </button>
    </a>
</div>
<div class="row">
    <div class="col-md-3"  style="border: 1px solid red;float: left;">
        <div class='course-sidebar-layout' id='courseSidebar'>
            <dl>
                <button type="button" class="btn btn-lg btn-danger"
                        data-toggle="popover" title="Popover title"
                        data-content="And here's some amazing content. It's very engaging. Right?">
                    点我弹出/隐藏弹出框
                </button>
            </dl>
        </div>
    </div>
    <div class="col-md-6" style="border: 1px solid red;float: left;background-color: #1c1b17;">
        <video id="div" width="100%" height="100%" controls>
            <source src="video/z.mp4" type="video/mp4">
            Your browser does not support the video tag.
        </video>
    </div>
    <div class="col-md-3" style="border: 1px solid red;float: right;">
            ceshi
    </div>
</div>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<!-- 引入footer.jsp -->
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
