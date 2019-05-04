<%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/5/3
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>

    <script type="text/javascript">

        function mulu(th) {
            var pcode = $(th).attr('id');
            $.post("/class", {pcode: pcode}, function (data) {
                $("#child").html('');
            });
        }
    </script>

</head>
<body>
<div class="row col-md-12">
    <!-- 引入header.jsp -->
    <jsp:include page="/header.jsp"></jsp:include>
</div>
<div class="col-md-12" >
    <div class="col-md-2"  style="float: left;border-radius: 15px">
        <div style="border-radius: 15px;height: 450px">
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <button type="button" class="btn btn-primary btn-lg active">上一节</button><br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <button type="button" class="btn btn-primary btn-lg active">下一节</button><br>
            <br>
        </div>
    </div>
    <div class="col-md-7" style="background-color: #e9e1de;height: 600px;border-radius: 15px">

    </div>
    <div class="col-md-2">

    </div>
</div>




</body>
</html>
