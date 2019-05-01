<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/5/1
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
</head>
<body>
<div>
    <jsp:include page="/header.jsp"></jsp:include>
</div>

<div style="float: left;">
    <a href="javascript:history.back(-1)">
        <button type="button" class="btn btn-default" aria-label="Left Align">
            <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
        </button>
    </a>


</div>
<div>
<c:forEach items="${pageInfo.list}" var="classinfo" varStatus="s" >
    <span style="float: left">${classinfo.name}</span>
    <span style="float: right">播放</span>
    <br>
</c:forEach>
</div>

</body>
</html>
