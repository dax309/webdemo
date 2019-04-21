<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- 登录 注册 购物车... -->
<!-- 这里使用的是ajax技术完成导航栏，我们为每个导航栏加上地址 -->
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>头部</title>
    <link rel="shortcut icon" href="/images/favicon.ico" type="image/x-icon" />
    <!-- Bootstrap -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
    <style>
        #div1{
            float: right;
        }
        #div2{
            text-align:center;
            float: right;
            padding: 15px;
        }
        #div4{

            text-align: center;
            float: left;
            padding: 15px;
        }
    </style>
    <script type="text/javascript">
        function loginOut(){
            var flag = confirm("确认退出登录吗？");
            if(flag){
                location.href='${pageContext.request.contextPath }/logOut';
            }
        }
    </script>
</head>
<body>
<div class="col-md-12" style="background-color: white;width: 100%">
    <div class="col-md-2" style="float: left;">
        <a href="/index"><img src="images/logo2.png"></a>
    </div>
    <div class="col-md-5" style="text-align: center;
                                border: 1px solid red;
                                 float: left;
                                 padding: 15px;">
        <a href="#"><span style="text-align: center;font-size: 20px">占位符</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#"><span style="text-align: center;font-size: 20px">占位符</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#"><span style="text-align: center;font-size: 20px">占位符</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <a href="#"><span style="text-align: center;font-size: 20px">占位符</span></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <div class="col-md-5" id="div1" style="border: 1px solid red;float: right">
        <c:if test="${empty sessionScope.student }">
            <div class="col-md-3" id="div2">
                <a href="login.jsp"><span style="text-align: center;font-size: 20px">登录</span></a>&nbsp;&nbsp;/&nbsp;&nbsp;
                <a href="register.jsp"><span style="text-align: center;font-size: 20px">注册</span></a>
            </div>
        </c:if>
        <c:if test="${!empty sessionScope.student }">
            <div class="col-md-5" id="div2" style="border: 1px solid red">
                <a href="#"><span style="text-align: center;font-size: 20px">个人中心</span></a>&nbsp;&nbsp;/&nbsp;&nbsp;
                <a href="javascript:void(0)"  onclick="loginOut()" ><span style="text-align: center;font-size: 20px">退出</span></a>
            </div>
        </c:if>
    </div>
</div>

</body>
</html>




