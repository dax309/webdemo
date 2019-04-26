<%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/4/24
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>个人信息</title>
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
</head>
<body>
<div class="col-md-12">
    <div style="width: 100%"><jsp:include page="/header.jsp"></jsp:include></div>
    <div style="float: left;border: 1px solid red">
        <br><br>
        <br>
        <a href="/studentupdate">
            <button type="button" class="btn btn-default btn-lg btn-block">修改个人信息</button>
        </a>
            <br>
            <button type="button" class="btn btn-default btn-lg btn-block">个人学习记录</button>
            <br>
            <button type="button" class="btn btn-default btn-lg btn-block">考试成绩查看</button>
            <br>
            <button type="button" class="btn btn-default btn-lg btn-block">我&nbsp;&nbsp;的&nbsp;&nbsp;提&nbsp;&nbsp;问</button>
        </div>
        <div style="float: left">
            <img src="images/1.jpg">
        </div>

</div>
</body>
    <footer>
        <div>
            <br>
            <jsp:include page="/footer.jsp"></jsp:include>
        </div>
    </footer>



</html>
