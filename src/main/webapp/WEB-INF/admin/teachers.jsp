<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>教师信息</title>
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
					<th>教师编号</th>
					<th>教师姓名</th>
					<th>后台账户</th>
					<th>后台权限</th>

                    <c:if test="${sessionScope.adminPower == 1}">
						<th>操作
							&emsp;
							<button type="button" class="btn btn-xs btn-info" onclick="_iframe(0, '/adminteacheredit', 'teachers')">添加</button>
						</th>
					</c:if>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${not empty teachers }">
						<c:forEach items="${teachers }" var="teacher">
							<tr>
								<td>${teacher.ID }</td>
								<td>${teacher.username }</td>
								<td>${teacher.realname }</td>

								<td>
									<c:if test="${teacher.adminPower == 0 }">
										普通教职工
									</c:if>
									<c:if test="${teacher.adminPower == 1 }">
										<span style="color: red;">管理员</span>
									</c:if>
								</td>

								<td>
										<div class="btn-group">
											<c:set value="0" var="flag"></c:set>
											<c:if test="${sessionScope.loginTeacher.teacherName == teacher.username or sessionScope.adminPower == 1 }">
												<c:set value="1" var="flag"></c:set>
												<button type="button" class="btn btn-info btn-sm" onclick="_iframe(1,'teacher/${teacher.ID }', 'teachers')">修改</button>
											</c:if>
											<c:if test="${sessionScope.adminPower == 1}">
												<button type="button" class="btn btn-danger btn-sm" onclick="del('teacher/${teacher.ID }')">删除</button>
											</c:if>
										</div>
								</td>
							</tr>
						</c:forEach>
					</c:when>
				</c:choose>
			</tbody>
		</table>
		<form action="class" method="post">
			<input type="hidden" value="DELETE" name="_method" />
		</form>
		<div>
			<ul class="pagination"> 
				<c:if test="${pageTotal > 1 }">
					<ul class="pagination">
				<li><a href="teachers?startPage=1">首页</a></li>
				<c:if test="${pageNow-1 > 0 }">
					<li><a href="teachers?startPage=${pageNow-1 }">上一页</a></li>
				</c:if>
				<c:forEach begin="${pageNow }" end="${pageNow+4 }" var="subPage">
					<c:if test="${subPage-5 > 0 }">
						<li><a href="teachers?startPage=${subPage-5 }">${subPage-5 }</a></li>
					</c:if>
				</c:forEach>
				<c:forEach begin="${pageNow }" end="${pageNow+5 }" step="1" var="pageNo">
					<c:if test="${pageNo <= pageTotal }">
						<c:if test="${pageNow == pageNo }">
							<li class="active"><a href="teachers?startPage=${pageNo }">${pageNo }</a></li>
						</c:if>
						<c:if test="${pageNow != pageNo }">
							<li><a href="teachers?startPage=${pageNo }" class="pageLink">${pageNo }</a></li>
						</c:if>
					</c:if>
				</c:forEach>
				<c:if test="${pageNow+1 <= pageTotal }">
					<li><a href="teachers?startPage=${pageNow+1 }">下一页</a></li>
				</c:if>
				<li><a href="teachers?startPage=${pageTotal }">尾页</a></li>
				<li>
					<a>${pageNow }/${pageTotal }</a>
				</li>
				<li>
					<div style="width:-1%; height:100%;float:right;">
						<form action="teachers" id="scannerPageForm">
							<input id="scannerPage" type="text" name="startPage" style="width: 40px; height: 30px; border: 1px solid gray; border-radius: 4px;" />
							<input class="btn btn-default goPage" type="submit" value="Go" style="margin-left: -4px; height: 30px;" />
						</form>
					</div>
				</li>
			</ul>
				</c:if>
			</ul>
		</div>
	</div>


	<!-- js引入 -->
    <script src="${path }/js/jquery1.10.js"></script>
    <script src="${path }/js/zeroModal/zeroModal.min.js"></script>
   	<script src="${path }/js/add-update.js"></script>
   	<script src="${path }/js/handle.js"></script>
   	<script type="text/javascript">
   		$(function() {
   			//管理员点击查看密码
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