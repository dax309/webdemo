<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<div style="float: left;" class="col-md-12">
    <a href="javascript:history.back(-1)">
        <button type="button" class="btn btn-default" aria-label="Left Align">
            <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
        </button>
    </a>
</div>
<br>
<div class="col-md-4"></div>
<div class="col-md-5">
<c:forEach items="${pageInfo.list}" var="classinfo" varStatus="s" >
    <span style="float: left">${classinfo.name}</span>
    <a href="/playclass?code=${classinfo.code}">
    <span style="float: right">播放</span>
    </a>
    <br>
    <hr>
</c:forEach>

    <nav aria-label="Page navigation" style="text-align: center">
        <ul class="pagination">
            <li>
                <a href="${pageContext.request.contextPath}/classinfo?pageNumber=${pageInfo.pageNumber-1}&code=${code}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="1" end="${pageInfo.total}" var="i">
                <c:if test="${pageInfo.pageNumber== i}">
                    <li class="active"><a href="${pageContext.request.contextPath}/classinfo?pageNumber=${i}&code=${code}">${i}</a></li>
                </c:if>
                <c:if test="${pageInfo.pageNumber!= i}">
                    <li><a href="${pageContext.request.contextPath}/classinfo?pageNumber=${i}&code=${code}">${i}</a></li>
                </c:if>
            </c:forEach>
            <li>
                <c:if test="${pageInfo.pageNumber<pageInfo.total}">
                     <a href="${pageContext.request.contextPath}/classinfo?pageNumber=${pageInfo.pageNumber+1}&code=${code}" aria-label="Next">
                </c:if>
                 <c:if test="${pageInfo.pageNumber>=pageInfo.total}">
                    <a href="${pageContext.request.contextPath}/classinfo?pageNumber=${pageInfo.total}&code=${code}" aria-label="Next">
                    </c:if>
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>

<div class="col-md-3"></div>

</body>
</html>
