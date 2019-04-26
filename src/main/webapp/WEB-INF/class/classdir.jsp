<%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/4/26
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>课程列表</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function () {
            $('button').on('click','button',function() {
                function sdemo(id) {
                    var pcode = id;
                    $.post("/classinfos", {pcode: pcode}, function (date) {
                        var result = "";
                        for (var i = 0; i < date.length; i++) {
                            if (date[i].pcode == pcode) {
                                result += "<dl>";
                                result += "<dt>" + date[i].name + "</dt>";
                                for (var j = 0; j < date.length; j++) {
                                    if (date[j].pcode == date[i].code) {
                                        result += "<dd>" + date[j].name + "</dd>";
                                    }
                                }
                                result += "</dl>";
                            }
                        }
                        $("#child").html(result);
                    }, "json");
                }
            })
        });
    </script>
</head>
<body>
<div>
    <jsp:include page="/header.jsp"></jsp:include>
</div>
<div style="float: left;width: 200px">
    <c:forEach var="classinfo" items="${list}" varStatus="s">
    <br>
    <br>
        <div style="width: 100%;text-align: right;margin-right: 50px">
                <button type="button" id="${classinfo.code}" class="btn btn-primary btn-lg active" onclick='javascript:sdemo(this.id);'>${classinfo.name}</button>
        </div>
    </c:forEach>
</div>
<div id="child" style="float: left">

</div>


</body>
</html>
