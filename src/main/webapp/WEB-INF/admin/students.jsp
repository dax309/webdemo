<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>学生信息管理</title>
	<%
    	String path = request.getContextPath();
	    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    %>
	<c:set var="path" value="<%=basePath %>"></c:set>
 	<link href="${path }/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
 	<link rel="stylesheet" type="text/css" href="${path }/js/zeroModal/zeroModal.css" />
</head>
<body>

	<div style="text-align: center;">
		<table class="table table-striped table-hover table-condensed">
			<thead>
				<tr>
					<th>学生编号</th>
					<th>学生姓名</th>
					<th>学生账户</th>
					<th>性别</th>
					<th>邮箱</th>
					<th>生日</th>
					<%--<th>就读班级</th>--%>
					<c:if test="${sessionScope.adminPower == 1 }">
						<th>操作</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty students }">
						<c:forEach items="${students }" var="student">
							<tr>
								<td>${student.ID }</td>
								<td>${student.realname }</td>
								<td>${student.username }</td>
                                <td>
                                    <c:if test="${student.gender == 0 }">
                                        男
                                    </c:if>
                                    <c:if test="${student.gender == 1 }">
                                        女
                                    </c:if>
                                </td>
                                <td>${student.email}</td>
                                <td><fmt:formatDate value="${student.birthday }" pattern="yyyy-MM-dd"/></td>
								<%--<td>${student.classInfo.className }</td>--%>

								<td>
									<div class="btn-group">
										<button type="button" class="btn btn-danger btn-sm" onclick="del('student/${student.ID }')">删除</button>
									</div>
								</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</tbody>
		</table>
		<form action="student" method="post">
			<input type="hidden" value="DELETE" name="_method" />
		</form>
		<c:if test="${pageTotal > 1 }">
			<div>
				<ul class="pagination">
					<li><a href="students?startPage=1">首页</a></li>
					<c:if test="${pageNow-1 > 0 }">
						<li><a href="students?startPage=${pageNow-1 }">上一页</a></li>
					</c:if>
					<c:forEach begin="${pageNow }" end="${pageNow+4 }" var="subPage">
						<c:if test="${subPage-5 > 0 }">
							<li><a href="students?startPage=${subPage-5 }">${subPage-5 }</a></li>
						</c:if>
					</c:forEach>
					<c:forEach begin="${pageNow }" end="${pageNow+5 }" step="1" var="pageNo">
						<c:if test="${pageNo <= pageTotal }">
							<c:if test="${pageNow == pageNo }">
								<li class="active"><a href="students?startPage=${pageNo }">${pageNo }</a></li>
							</c:if>
							<c:if test="${pageNow != pageNo }">
								<li><a href="students?startPage=${pageNo }" class="pageLink">${pageNo }</a></li>
							</c:if>
						</c:if>
					</c:forEach>
					<c:if test="${pageNow+1 <= pageTotal }">
						<li><a href="students?startPage=${pageNow+1 }">下一页</a></li>
					</c:if>
					<li><a href="students?startPage=${pageTotal }">尾页</a></li>
					<li>
						<a>${pageNow }/${pageTotal }</a>
					</li>
					<li>
						<div style="width:-1%; height:100%;float:right;">
							<form action="students" id="scannerPageForm">
								<input id="scannerPage" type="text" name="startPage" style="width: 40px; height: 30px; border: 1px solid gray; border-radius: 4px;" />
								<input class="btn btn-default goPage" type="submit" value="Go" style="margin-left: -4px; height: 30px;" />
							</form>
						</div>
					</li>
				</ul>
			</div>
		</c:if>
	</div>


	<!-- js引入 -->
    <script src="${path }/js/jquery1.10.js"></script>
    <script src="${path }/js/handle.js"></script>
    <script src="${path }/js/zeroModal/zeroModal.min.js"></script>
    <script src="${path }/js/add-update.js"></script>
   	<script src="${path }/js/handle.js"></script>
   	<script type="text/javascript">
   		$(function() {
   			$(".viewPwd").click(function() {
   				var pwd0 = $(this).siblings("#hidePwd").text();
   				if (pwd0.indexOf("*") != -1) {
   					var pwd = $(this).siblings("#showPwd").text();
   					$(this).siblings("#hidePwd").text(pwd);
   					return;
   				} else {
   					$(this).siblings("#hidePwd").text("******");
   				}
   			});
   		});
   	</script>
</body>
</html>