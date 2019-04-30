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
    <link rel="stylesheet" href="css/paging.css">
    <script src="js/paging.js"></script>
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>

    <script type="text/javascript">
                function sdemo(th) {
                    var pcode = $(th).attr('id');
                    $.post("/classinfos", {pcode: pcode}, function (data) {
                            $("#child").html('');
                            var html = "";
                            $.each(data.list,function (index,classinfo) {
                                html+="<span style='float: left'>"+classinfo.name+"</span>";
                                html+="<span style='float: right'>"+classinfo.createtime+"</span><br>";
                                html+="<hr><br>";

                            });
                            $("#child").html(html);
                            pageInfo(data.total);
                    }, "json");
                }
                function pageInfo(totalPages){
                    $('#box').paging({
                        initPageNo: 1, // 初始页码
                        totalPages: totalPages, //总页数
                        /*totalCount: '合计' + setTotalCount + '条数据',*/ // 条目总数
                        slideSpeed: 600, // 缓动速度。单位毫秒
                        jump: true, //是否支持跳转
                        callback: function(page) { // 回调函数
                            console.log(page);
                        }
                    })
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
<div>
<div class="col-md-3">

</div>
<div style="width: 50%;height: 100%;" class="col-md-6">
    <div id="child" style="text-align: center;">
        <strong><p style="text-indent:2em">No Contents</p></strong>
    </div>
    <div class="box" id="box">

    </div>
</div>

<div class="col-md-3">

</div>
</div>
</body>
</html>
