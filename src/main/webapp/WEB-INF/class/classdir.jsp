<%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/4/26
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <title>课程列表</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>

    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script type="text/javascript">
                function sdemo(th) {
                    var pcode = $(th).attr('id');
                    $.post("/classinfos", {pcode: pcode}, function (data) {
                        var result = "<br>" +
                            "<br>" +
                            "<br>";
                        if(pcode == "all"){
                            for (var i = 0; i < data.length; i++) {
                                    result += "<span id="+data[i].code+" onclick='javascript:sdemo(this);'>";
                                    result += data[i].name;
                                    result += "</span> ";
                                    if ((i+1)%5 ==0){
                                        result+="<br>";
                                    }
                            }
                        }else {
                            for (var i = 0; i < data.length; i++) {
                                result += "<span id="+data[i].code+" onclick='javascript:sdemo(this);'>";
                                result += data[i].name;
                                result += "</span><br>";

                            }
                        }
                        $("#child").html(result);
                    }, "json");

                }

        $(function () {

        })
    </script>
</head>
<body>
<div>
    <jsp:include page="/header.jsp"></jsp:include>
</div>
<div class="col-md-12" style="float: left;">
    <div>
        <span>课程：</span>
    </div>
    <hr style="border: solid red" />
    <div style="text-align: center;float: left;margin: 20px">
            <button type="button" id="all" class="btn btn-primary btn-lg active" onclick='javascript:sdemo(this);'>全部</button>
    </div>
    <c:forEach var="classinfo" items="${list}" varStatus="s">
        <div style="text-align: center;float: left;margin: 20px">
            <a href="#">
                <button type="button" id="${classinfo.code}" onclick='javascript:sdemo(this);' class="btn btn-primary btn-lg active" >${classinfo.name}</button>
            </a>
        </div>
    </c:forEach>
</div>
<div style="width: 100%;margin-top: 170px;height: 100%;background-color: #e5eee8">
    <div id="child" style="text-align: center;">

    </div>
</div>

</body>
</html>
