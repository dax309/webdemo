<%@ page import="java.util.Date" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/4/15
  Time: 9:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="zh-CN">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>播放页</title>
    <!--左侧导航样式-->
    <link rel="stylesheet" type="text/css" href="css/LeftNav.css">
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <link href="http://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
    <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css"/>
    <link rel="stylesheet" href="css/custom.css">
    <script type="text/javascript">
        function click() {
            $(this).siblings().slideToggle(1500);
        }

        $(function () {
            var videoPlayer = document.getElementById("video");
            videoPlayer.ontimeupdate = function () { timeUpdate(); };
            function timeUpdate() {
                // console.log(video.currentTime);
                /*document.getElementById('time').innerHTML = video.currentTime;*/
            }
        })
    </script>

    <script type="text/javascript">
        function btnReplyClick() {
            var UID = $("#UID").val();
            var contentwords = $("#contentwords").val();
            var classID = $("#classID").val();
            var wordstype = $("#wordstype").val();
            $.post("/saveWords", {UID:UID,classID:classID,wordstype:wordstype,contentwords:contentwords},function (data) {
                if (data.flag)
                    alert("留言成功")
                else
                    alert("留言失败，请稍后重试！")
            }
            ,"json");
        };
    </script>

    <script type="text/javascript">
        function btnclic() {
            var rUID = $("#rUID").val();
            var rcontentwords = $("#rcontentwords").val();
            var rclassID = $("#rclassID").val();
            var rwordstype = $("#rwordstype").val();
            var replyID = $("#replyID").val();
            $.post("/atreplyWords", {rUID:rUID,rclassID:rclassID,rwordstype:rwordstype,rcontentwords:rcontentwords,replyID:replyID},function (data) {
                    if (data.flag)
                        alert("回复成功")
                    else
                        alert("回复失败，请稍后重试！")
                }
                ,"json");
        };
    </script>

    <script type="text/javascript">
        function btnclic(th) {
            if (th == 1) {
            var rUID = $("#asrUID").val();
            var rcontentwords = $("#asrcontentwords").val();
            var rclassID = $("#asrclassID").val();
            var rwordstype = $("#asrwordstype").val();
            var replyID = $("#asreplyID").val();
            }else {
                console.log(th);
                var rUID = $("#rUID").val();
                var rcontentwords = $("#rcontentwords").val();
                var rclassID = $("#rclassID").val();
                var rwordstype = $("#rwordstype").val();
                var replyID = $("#replyID").val();
            }
            $.post("<%=basePath%>/replyat", {rUID:rUID,rclassID:rclassID,rwordstype:rwordstype,rcontentwords:rcontentwords,replyID:replyID},function (data) {
                    if (data.flag)
                        alert("回复成功")
                    else
                        alert("回复失败，请稍后重试！")
                }
                ,"json");
        };
    </script>

</head>
<body>
<div class="row col-md-12">
    <!-- 引入header.jsp -->
    <jsp:include page="/header.jsp"></jsp:include>
</div>
<br>
<br>
<div style="margin:20px;border-radius: 15px">
    <div class="row" style="border-radius: 15px">
        <div style="float: left;">
            <a href="javascript:history.back(-1)">
                <button type="button" class="btn btn-default" aria-label="Left Align" style="cursor: pointer">
                    <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
                </button>
            </a>
        </div>
        <div class="col-md-2" style="float: left;font-size: 23px">
            <a href="">
                <span style="text-align: center;font-weight: bold">${classinfo2.name}</span>
            </a>
            <span style="text-align: center">:${classinfo.name}</span>
        </div>
    </div>
    <div class="row" style="border-radius: 15px">
        <div class="col-md-12" style="height: 20px;"></div>
    </div>

    <div class="row" style="background-color: #1c1b17;border-radius: 15px">
        <div class="col-md-1" style="float: left;border-radius: 15px">
            <div style="border-radius: 15px;height: 450px">
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <a href="/Compiler">
                    <button type="button" class="btn btn-primary btn-lg active">练&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;习</button>
                    <br>
                </a>
                <br>
                <a href="/begin?classId=${classinfo.ID}">
                    <button type="button" class="btn btn-primary btn-lg active">考&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;试</button>
                    <br>
                </a>
                <br>
                <button type="button" class="btn btn-primary btn-lg active">课件下载</button><br>
            </div>
        </div>
        <div class="col-md-7" style="height: 450px;float: left;background-color: black;
                                     border-radius: 15px;margin:15px auto auto auto" id="vedio">
            <p align="center" style="margin:10px auto auto auto;border-radius: 10px">
                <video id="video" width="80%" height="90%" autoplay controls>
                    <source src="video/${classinfo.videoaddress}.mp4" type="video/mp4">
                    你的播放器不支持本视频播放，建议使用谷歌浏览器电脑版

                </video>
                <br>

                <button onclick="playPause()">播放/暂停</button>
                <button onclick="setPlaySpeed(0.75)" type="button">0.75倍速</button>
                <button onclick="setPlaySpeed(1)" type="button">普通</button>
                <button onclick="setPlaySpeed(1.5)" type="button">1.5倍</button>
                <button onclick="setPlaySpeed(2)" type="button">2倍</button>
                <script>
                    var myVideo = document.getElementById("video");

                    function setPlaySpeed(spend) {
                        myVideo.playbackRate = spend;//设定新的播放速度2倍速度
                    }

                    function playPause() {
                        if (myVideo.paused)
                            myVideo.play(); //播放
                        else
                            myVideo.pause(); //暂停播放
                    }
                </script>
            </p>
        </div>
        <div class="col-md-4" style="float: right;height: 500px;border-radius: 15px;border: 1px solid red">
            <span class="list"></span>
            <ul id="side_nav">
                <c:forEach var="classinfo" items="${list1}" varStatus="s">
                    <li>
                        <span id="${classinfo.code}" onclick='javascript:click(this);'>
                                ${classinfo.name}
                        </span>
                        <ul>
                            <c:forEach var="classinf" items="${list2}" varStatus="s">
                                <c:if test="${classinf.pcode eq classinfo.code}">
                                    <li><a href="#">菜单1-0</a></li>
                                    <li><span onclick="javascript:classinfos(this);">${classinf.name}</span></li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
            </ul>

        </div>
    </div>
</div>
<hr style="width:80%;margin:0 auto;border: 0;height: 0;border-top: 1px solid rgba(0, 0, 0, 0.1);border-bottom: 1px solid rgba(255, 255, 255, 0.3);">
<div>
    <div class="col-md-1"></div>
    <div class="col-md-11">
        <!-- 留言的表单 -->
        <form class="layui-form" style="width:80%;">
            <c:if test="${not empty sessionScope.teacher}">
                <input name="UID" id="UID" value="${sessionScope.teacher.ID}" hidden="hidden"/>
                <input name="wordstype" id="wordstype" value="1" hidden="hidden"/>
            </c:if>
            <c:if test="${not empty sessionScope.student}">
                <input name="UID" id="UID" value="${sessionScope.student.ID}" hidden="hidden"/>
                <input name="wordstype" id="wordstype" value="0" hidden="hidden"/>
            </c:if>

            <input name="classID" id="classID" value="${classinfo.ID}" hidden="hidden"/>
            <div class="layui-input-block" style="margin-left: 0;">
                <textarea id="contentwords" name="contentwords" placeholder="请输入你的留言" class="layui-textarea"
                          style="height: 150px;width: 600px"></textarea>
            </div>
            <br/>
            <div class="layui-input-block" style="text-align: left;margin-left: 0;">
                <button type="button"  class="layui-btn" id="wordsbtn" onclick='javascript:btnReplyClick();' >留言</button>
            </div>
        </form>
        <br/>
        <!-- 留言信息列表展示 -->
        <div>
            <ul>
                <!-- 先遍历留言信息（一条留言信息，下面的全是回复信息） -->
                <c:forEach items="${words}" var="words">
                    <!-- 如果留言信息是在本文章下的才显示 -->
                        <li style="border-top: 1px dotted #01AAED">
                            <br/>
                            <div style="text-align: left;color:#444">
                                <div>
                                    <c:if test="${words.wordsType == 1}">
                                        <span style="color:#ed0613">${words.uname}老师</span>
                                    </c:if>
                                    <c:if test="${words.wordsType == 0}">
                                        <span style="color:#01AAED">${words.uname}</span>
                                    </c:if>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <span><fmt:formatDate value="${words.date}" pattern="yyyy年MM月dd日 HH时mm分ss秒" /></span>
                                </div>
                                <div>${words.content}</div>
                            </div>
                            <div>

                                <!-- 回复表单默认隐藏 -->
                                <div class="replycontainer" style="margin-left: 61px;">
                                    <form>
                                        <input name="rclassID" id="rclassID" value="${classinfo.ID}" hidden="hidden"/>
                                        <input name="replyID" id="replyID" value="${words.ID}" hidden="hidden"/>
                                        <c:if test="${not empty sessionScope.student}">
                                            <input name="rUID" id="rUID" value="${sessionScope.student.ID}" hidden="hidden"/>
                                            <input name="rwordstype" id="rwordstype" value="0" hidden="hidden"/>
                                        </c:if>
                                        <c:if test="${not empty sessionScope.teacher}">
                                            <input name="rUID" id="rUID" value="${sessionScope.student.ID}" hidden="hidden"/>
                                            <input name="rwordstype" id="rwordstype" value="1" hidden="hidden"/>
                                        </c:if>
                                        <div><textarea name="rcontentwords" id="rcontentwords"
                                                                               placeholder="请输入回复内容"
                                                                               style="min-height:80px;min-width: 400px"></textarea>
                                        </div>
                                        <div>
                                            <button onclick='javascript:btnclic(0);'>回复</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <!-- 以下是回复信息 -->
                            <c:forEach items="${replywords}" var="reply">
                                <!-- 每次遍历出来的留言下存在回复信息才展示（本条回复信息是本条留言下的就显示在当前留言下） -->
                                <c:if test="${reply.replyID ==words.ID}">
                                    <div style="text-align: left;margin-left:61px;color: #444">
                                        <c:if test="${not empty sessionScope.student}">
                                            <div><span style="color:#5FB878">${reply.sname}&nbsp;&nbsp;</span></div>
                                        </c:if>
                                        <c:if test="${not empty sessionScope.teacher}">
                                            <div><span style="color:#b81510">${reply.sname}老师&nbsp;&nbsp;</span></div>
                                        </c:if><span><fmt:formatDate value="${reply.date}" pattern="yyyy年MM月dd日 HH时mm分ss秒" /></span>
                                        <div>${reply.content}</div>
                                    </div>
                                    <div>
                                        <!-- 回复表单默认隐藏 -->
                                        <div class="replycontainer layui-hide" style="margin-left: 61px;">
                                            <form>
                                                <input name="asrclassID" id="asrclassID" value="${classinfo.ID}" hidden="hidden"/>
                                                <input name="asreplyID" id="asreplyID" value="${words.ID}" hidden="hidden"/>
                                                <c:if test="${not empty sessionScope.student}">
                                                    <input name="asrUID" id="asrUID" value="${sessionScope.student.ID}" hidden="hidden"/>
                                                    <input name="asrwordstype" id="asrwordstype" value="0" hidden="hidden"/>
                                                </c:if>
                                                <c:if test="${not empty sessionScope.teacher}">
                                                    <input name="asrUID" id="asrUID" value="${sessionScope.student.ID}" hidden="hidden"/>
                                                    <input name="asrwordstype" id="asrwordstype" value="1" hidden="hidden"/>
                                                </c:if>
                                                <div><textarea name="asrcontentwords" id="asrcontentwords"
                                                               placeholder="请输入回复内容"
                                                               style="min-height:80px;min-width: 400px"></textarea>
                                                </div>
                                                <div>
                                                    <button onclick='javascript:asbtnclic(1);'>回复</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach>
                        </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <script type="text/javascript">
        //设置目录
        (function () {
            var navWrap = document.getElementById("side_nav");
            var nav1s = navWrap.getElementsByTagName("span");
            var nav2s = navWrap.getElementsByTagName("ul");
            for (var i = 0, len = nav1s.length; i < len; i++) {
                nav1s[i].onclick = (function (i) {
                    return function () {
                        for (var j = 0; j < len; j++) {
                            nav2s[j].style.display = "none";
                        }
                        nav2s[i].style.display = "block";
                    }
                })(i)
            }
        })()

    </script>
    <!-- 引入footer.jsp -->
    <jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
