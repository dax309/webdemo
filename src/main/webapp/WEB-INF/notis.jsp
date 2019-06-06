<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/6/5
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>公告</title>
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
</head>
<body>
<jsp:include page="/header.jsp"></jsp:include>
<div class="col-md-12">
    <div class="col-md-3"></div>
<div class="col-md-6" style="text-align: center">
    <table style="text-align: center">
        <tr style="text-align: center">
            <td>标题</td>
            <td>内容</td>
            <td>时间</td>
        </tr>
        <c:if test="${not empty notis}">
            <c:forEach var="noti" items="${notis}" varStatus="s">
                <tr style="text-align: center">
                    <td style="padding-right: 15px;">${noti.title}</td>
                    <td style="padding-right: 15px;padding-left:15px">${noti.address}</td>

                    <td style="padding-right: 15px;padding-left:15px"> <fmt:formatDate value="${noti.createtime}" pattern="yyyy年MM月dd日 HH时mm分" /></td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</div>
    <div class="col-md-3"></div>

</div>
</body>
</html>
