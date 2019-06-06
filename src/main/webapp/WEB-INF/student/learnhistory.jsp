<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <title>历史学习记录</title>
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>

<div class="col-md-12">
    <div class="col-md-3"></div>
    <div class="col-md-6" style="text-align: center">
<c:if test="${learnhistory ==0}">
   <span> 暂无学习记录</span>
</c:if>
        <c:if test="${not empty learnhistory }">
            <a href="/playclassbyid?id=${learnhistory}">点击继续学习</a>
        </c:if>

    </div>
    <div class="col-md-3"></div>
</div>
</body>
</html>