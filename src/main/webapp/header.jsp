<%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/4/21
  Time: 11:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
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
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/index">主&nbsp;页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/index">Link1 <span class="sr-only">(current)</span></a></li>
                <li><a href="/classdir">课程目录</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">下拉菜单 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">课程目录</a></li>
                        <li><a href="#">下拉2</a></li>
                        <li><a href="#">下拉3</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">One more separated link</a></li>
                    </ul>
                </li>
            </ul>
            <%--<form class="navbar-form navbar-left">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="课程查找">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>--%>

            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">Link</a></li>
                <c:if test="${!empty sessionScope.student }">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.student.getRealname()} <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/studentinfo">个人中心</a></li>
                        <li><a href="#">退出登录</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>

                        <li><a href="javascript:void(0)"  onclick="loginOut()" ><span style="text-align: center;">退出</span></a></li>
                    </ul>
                </li>
                </c:if>
                <c:if test="${empty sessionScope.student }">
                    <li><a href="login.jsp">登陆</a> </li>
                    <li><a href="register.jsp">注册</a> </li>
                </c:if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="bootstrap/js/bootstrap.min.js"></script>
</body>
</html>
