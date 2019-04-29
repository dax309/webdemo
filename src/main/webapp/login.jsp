<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>会员登录</title>
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="js/jquery.validate.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function() {
            //刷新验证码
            $("#checkCode").click(function(){
                    $("#checkCode").prop(
                        "src", "/checkCode?page=1&time=" + new Date().toString());
                });

            $("#loginForm").validate({
                rules:{
                    username:{
                        required : true
                    },
                    password:{
                        required : true
                    },
                    checkCode:{
                        required : true
                    }
                },
                messages:{
                    username:{
                        required : "请输入用户名"
                    },
                    password:{
                        required : "请输入密码"
                    },
                    checkCode:{
                        required : "验证码不能为空"
                    }
                },
                errorElement:"labelErr"
            });


        });
    </script>

    <style>
        body {
            margin-top: 20px;
            margin: 0 auto;
        }

        .carousel-inner .item img {
            width: 100%;
            height: 300px;
        }

        .container .row div {
            /* position:relative;
                         float:left; */

        }

        #span1 {
            color: #666;
            font-size: 22px;
            font-weight: normal;
            padding-right: 17px;
        }

        labelErr {
            color: red;
        }
    </style>
</head>
<%
    //判断是否存在用户名cookie,存在就输出,不存在跳转到登录页面
    String uname = "";
    String pword = "";
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (Cookie c : cookies) {
           if(c.getName().equals("uname")){
               uname = c.getValue();
           }else if(c.getName().equals("pword")){
               pword = c.getValue();
           }
        }
    }

%>
<body>
    <!-- 引入header.jsp -->
    <jsp:include page="/header.jsp"></jsp:include>

<div class="container"
     style="width: 100%; height: 460px; background: #FF2C4C url('images/loginbg.jpg') no-repeat;">
    <div class="row">
        <div class="col-md-7">
        </div>

        <div class="col-md-5">
            <div
                    style="width: 440px; border: 1px solid #E7E7E7; padding: 20px 0 20px 30px; border-radius: 5px; margin-top: 60px; background: #fff;">
                <span id="span1">学员登录</span>USER LOGIN
                <div style="float: right"><span>没有账号？</span><a href="register.jsp">请注册</a></div>
                <form class="form-horizontal" autocomplete="off"
                      action="${pageContext.request.contextPath }/userlogin"
                      method="post"
                      id="loginForm">
                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label">用户名</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" name="username" id="username"
                                   value="<%=uname%>">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">密码</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control" name="password" id="password"
                                   value="<%=pword%>">
                        </div>
                    </div>
                    <div class="form-group" >
                        <label for="inputCheckCode" class="col-sm-2 control-label">验证码</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="inputCheckCode"
                                   name="checkCode" placeholder="请输入验证码">

                            <div class="col-sm-3" style="float: left">
                                <img id="checkCode" style="width : 120px"
                                     src="/checkCode?page=1" />
                            </div>
                        </div><br/>
                        <span id="checkCodeEror" style="color: red">${requestScope.checkCodeEror}</span>
                        <span id="loginError" style="color: red">${requestScope.loginError }</span>
                        <br>
                        <br>
                        <a href="#">忘记密码？</a>
                    </div>
                    <div class="form-group">
                        <label for="username" class="col-sm-2 control-label"></label>
                        <div class="col-sm-6">
                            <input type="checkbox" id="ckeckb" name="rember" checked>七天免登陆
                            <input type="submit" width="100" value="登录" name="submit" class="btn btn-success"
                                   style=" height: 35px; width: 185px; color: #fefafa;">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<br>
<br>
<br>
<!-- 引入footer.jsp -->
<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>