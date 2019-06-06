<%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/5/8
  Time: 9:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改密码</title>


    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $.validator.addMethod("isExist", function(value, element, params) {
            flag = false;
            $.ajax({
                "url" : "/passwordCentre?method=isExist",
                "async" : false,
                "type" : "POST",
                "data" : {
                    "oldpassword" : value
                },
                "success" : function(data) {
                    flag = data.flag;
                },
                "dataType" : "json"
            });
            return flag;
        });

        $(function() {

            $("#myform").validate({
                rules : {
                    oldpassword : {
                        isExist : true,
                    },
                    password : {
                        required : true,
                        minlength : 6
                    },
                    repassword : {
                        required : true,
                        equalTo : "#password"
                    }
                },
                messages : {
                    oldpassword : {
                        isExist:"密码错误！",
                    },
                    password : {
                        required : "密码不能为空",
                        minlength : "密码最少为6个字段"
                    },
                    repassword : {
                        required : "请确认密码",
                        equalTo : "两次输入不一致"
                    }
                },
                errorElement:"labelErr"
            });




            $(function () {
                $("#submit").click(function () {
                    var password = $("#password").val();
                    $.post("/updatepwd",{password:password},function (date) {
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

    <!-- 引入自定义css文件 registerstyle.css -->
    <link rel="stylesheet" href="css/registerstyle.css" type="text/css" />

    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }

        font {
            color: #3164af;
            font-size: 18px;
            font-weight: normal;
            padding: 0 10px;
        }

        labelErr {
            color: red;
        }
    </style>
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
    <a href="/learnhistory?studentid=${sessionScope.student.ID}">
    <button type="button" class="btn btn-default btn-lg btn-block">个人学习记录</button>
    </a>
    <br>

</div>
<div style="float: left">
    <div  style="margin-left: 150px;border: 1px solid red;width: 500px">

        <form id="myform" class="form-horizontal" style="margin-top: 5px;"
              action="/updatepwd" method="post" autocomplete="off">

            <div class="form-group">
                <label for="oldpassword" class="col-sm-2 control-label">旧密码</label>
                <span class="col-sm-6"> <input type="password"
                                               class="form-control" id="oldpassword" name="oldpassword"
                                               placeholder="请输入旧密码">
                    </span>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">新密码</label>
                <span class="col-sm-6"> <input type="password"
                                               class="form-control" id="password" name="password"
                                               placeholder="请输入新密码">
                    </span>
            </div>
            <div class="form-group">
                <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
                <span class="col-sm-6"> <input type="password"
                                               class="form-control" id="confirmpwd" name="repassword"
                                               placeholder="请确认新密码">
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
