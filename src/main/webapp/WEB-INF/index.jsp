<%@ page import="cn.daxalfred.demo.Entity.Student" %><%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/4/8
  Time: 21:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <script src="js/jquery-1.11.3.min.js" type="text/javascript"></script>
    <title>主页</title>
</head>
<body>
<div class="row col-md-12">
    <!-- 引入header.jsp -->
    <jsp:include page="/header.jsp"></jsp:include>
</div>
<div class="col-md-12">
    <h1 style="text-align: center">主页测试</h1>
</div>

<div class="col-md-12">
    <div class="col-md-2" style="float: left;">

    </div>
    <div class="jumbotron col-md-8" style="margin: 20px;float: left;border-radius: 10px">
        <h1 style="text-align: center">Hello, Python!</h1>
        <br>
        <br>
        <br>
        <br>
        <p style="text-align: center">
            <a class="btn btn-primary btn-lg" href="/play" role="button">播&nbsp;&nbsp;&nbsp;放</a>
        </p>
    </div>
    <div class="col-md-2" style="float: left;"></div>
</div>
            <%--引入footer.jsp--%>
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
