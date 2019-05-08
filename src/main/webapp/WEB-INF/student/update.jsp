<%@ page import="cn.daxalfred.demo.Entity.Student" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/4/24
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>个人信息</title>
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function() {

            $(function () {
                $("#username").click(function () {
                    alert("用户名不能修改")
                });

                $("#myform").validate({
                    rules: {
                        email: {
                            required: true,
                            email: true
                        },
                        realname: {
                            required: true
                        },
                        birthday: {
                            required: true
                        },
                    },
                    messages: {
                        email: {
                            required: "邮箱不能为空",
                            email: "邮箱格式不正确"
                        },
                        realname: {
                            required: "姓名不能为空"
                        },
                        birthday: {
                            required: "生日不能为空"
                        },
                    },
                    errorElement: "labelErr"
                });
            });

            $(function () {
                $("#submit").click(function () {
                    var realname = $("#realname").val();
                    var username = $("#username").val();
                    var email = $("#inputEmail3").val();
                    var gender = $('input[name="gender"]:checked').val();
                    var birthday = $("#date").val();
                    $.post("/updateStudent",{username:username,email:email,realname:realname,gender:gender,birthday:birthday},function (date) {
                        if(date.info){
                            alert("修改成功，点击返回主界面");
                            window.location.href="/studentinfo";
                        }else {
                            alert("修改失败，请稍后重试");
                        }
                    },"json");
                });
            })


        });



    </script>

</head>
<body>
    <div class="col-md-12"><jsp:include page="/header.jsp"></jsp:include></div>
    <div style="float: left;border: 1px solid red">
        <br>
        <br>
        <br>
        <a href="/studentupdate">
            <button type="button" class="btn btn-default btn-lg btn-block">修改个人信息</button>
        </a>
        <br>
        <a href="/updatepassword">
            <button type="button" class="btn btn-default btn-lg btn-block">修&nbsp;&nbsp;改&nbsp;&nbsp;密&nbsp;&nbsp;码</button>
        </a>
        <br>
        <button type="button" class="btn btn-default btn-lg btn-block">个人学习记录</button>
        <br>
        <button type="button" class="btn btn-default btn-lg btn-block">考试成绩查看</button>
        <br>
        <button type="button" class="btn btn-default btn-lg btn-block">我&nbsp;&nbsp;的&nbsp;&nbsp;提&nbsp;&nbsp;问</button>
    </div>
<div style="float: left">
    <div  style="margin-left: 150px;border: 1px solid red;width: 500px">
        <form id="myform" class="form-horizontal" style="margin-top: 5px;"
              method="post" autocomplete="off">


            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">用户名</label>
                <span
                        class="col-sm-6"> <input type="text" class="form-control"
                                                 id="username" name="username" value="${sessionScope.student.getUsername()}" readonly>
                        </span>
            </div>

            <div class="form-group">
                <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
                <span class="col-sm-6"> <input type="email"
                                               class="form-control" id="inputEmail3" name="email"
                                               value="${sessionScope.student.getEmail()}">
                </span>
            </div>
            <div class="form-group">
                <label for="realname" class="col-sm-2 control-label">真实姓名</label>
                <span class="col-sm-6"> <input type="text"
                                               class="form-control" id="realname" name="realname"
                                               value="${sessionScope.student.getRealname()}">
                        </span>
            </div>
            <script>

            </script>
            <div class="form-group opt">
                <label for="Radio1" class="col-sm-2 control-label">性别</label>
                <c:if test="${sessionScope.student.getGender()== 0}" >
                <span class="col-sm-6">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="Radio1" value="0" checked>男
                            </label>
                            <label class="radio-inline">
                                <input type="radio"name="gender" id="Radio" value="1">女
                            </label>
                        </span>
                </c:if>
                <c:if test="${sessionScope.student.getGender()==1}" >
                <span class="col-sm-6">
                            <label class="radio-inline">
                                <input type="radio" name="gender" id="inlineRadio1" value="0" >男
                            </label>
                            <label class="radio-inline">
                                <input type="radio"name="gender" id="inlineRadio" value="1" checked>女
                            </label>
                        </span>
                </c:if>
            </div>

<%
    Student student = (Student) session.getAttribute("student");
    Date birthday = student.getBirthday();
    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String birth = formatter.format(birthday);
%>

            <div class="form-group">
                <label for="date" class="col-sm-2 control-label">出生日期</label>
                <span
                        class="col-sm-6"> <input id="date" type="date" class="form-control"
                                                 name="birthday" value="<%=birth%>">
                        </span>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <input id="submit" type="button" width="100" value="修&nbsp;&nbsp;改" name="submit"
                           style="height: 35px; width: 100px; color: #ff2325;">
                </div>
            </div>
        </form>
    </div>
</div>


</body>
</html>
