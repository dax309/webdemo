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
<html lang="zh-CN">
<head>
    <title>课程列表</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>

    <script type="text/javascript">

                function sdemo(th) {
                    var pcode = $(th).attr('id');
                    $.post("/classinfos", {pcode: pcode}, function (data) {
                            $("#child").html('');
                            var html = "";
                            $.each(data.list,function (index,classinfo) {
                                html+="<a href='/classinfo?code="+classinfo.code+"'> <span style='float: left'>"+classinfo.name+"</span>";
                                html+="<span style='float: right'>"+classinfo.createtime+"</span></a><br>";
                                html+="<hr>";
                            });
                            html+="<br>";
                            html+="<nav aria-label='Page navigation' style='text-align: center'>\n" +
                                "  <ul class='pagination'>\n" +
                                "    <li>\n" +
                                "      <a onclick='javascript:flowertwo(this,"+pcode+");' id= aria-label='Previous'>\n" +
                                "        <span aria-hidden='true'>&laquo;</span>\n" +
                                "      </a>\n" +
                                "    </li>";
                            for(var i = 1;i<=data.total;i++){
                                if (i ==data.pageNumber ){
                                    html+=" <li class='active'><span  onclick='javascript:flowertwo(this,"+pcode+");' id=" + i +">"+i+"</span></li>";
                                } else {
                                    html+=" <li><span  onclick='javascript:flowertwo(this,"+pcode+");' id="  + i + ">"+ i + "</span></li>";
                                }
                            }
                            html+="<li>\n" +
                                "      <a onclick='javascript:flowertwo(this,"+pcode+");'  aria-label='Next'>\n" +
                                "        <span aria-hidden='true'>&raquo;</span>\n" +
                                "      </a>\n" +
                                "    </li>\n" +
                                "  </ul>\n" +
                                "</nav>";
                            $("#child").html(html);
                    }, "json");
                }

                function flowertwo(th,pcode) {
                    var pageNumber = $(th).attr('id');
                    var code = $(pcode).attr("id");
                    console.log(code);
                    $.post("/classinfos", {pcode:code ,pageNumber:pageNumber}, function (data) {
                        $("#child").html('');
                        var html = "";
                        $.each(data.list,function (index,classinfo) {
                            html+="<a href='/classinfo?code="+classinfo.code+"'><span style='float: left'>"+classinfo.name+"</span>";
                            html+="<span style='float: right'>"+classinfo.createtime+"</span></a><br>";
                            html+="<hr>";
                        });
                        html+="<br>";
                        html+="<nav aria-label='Page navigation' style='text-align: center'>\n" +
                            "  <ul class='pagination'>\n" +
                            "    <li>\n" +
                            "      <a onclick='javascript:flowertwo(this);' id=" + (pageNumber-1)+ " aria-label='Previous'>\n" +
                            "        <span aria-hidden='true'>&laquo;</span>\n" +
                            "      </a>\n" +
                            "    </li>";
                        for(var i = 1;i<=data.total;i++){
                            if (i == pageNumber) {
                                html+=" <li class='active'><span  onclick='javascript:flowertwo(this);' id= "+ i +">"+i+"</span></li>";
                            }else {
                                html+=" <li><span  onclick='javascript:flowertwo(this);' id= "+i+">"+i+"</span></li>";
                            }
                        }
                        html+="<li>\n" ;
                        if(pageNumber == data.total){
                            html+="      <a onclick='javascript:flowertwo(this);' id=" + pageNumber+ " aria-label=\"Next\">\n";
                        }else {
                            html+="      <a onclick='javascript:flowertwo(this);' id=" + (++pageNumber)+ " aria-label=\"Next\">\n";
                        }
                        html+=

                            "        <span aria-hidden=\"true\">&raquo;</span>\n" +
                            "      </a>\n" +
                            "    </li>\n" +
                            "  </ul>\n" +
                            "</nav>";
                        $("#child").html(html);
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
        <span>课程：${pcode}</span>
    </div>
    <hr style="border: solid red" />
    <div style="text-align: center;float: left;margin: 20px">
            <button type="button" id="all" class="btn btn-primary btn-lg active" onclick='javascript:sdemo(this);'>全部</button>
    </div>
    <c:forEach var="classinfo" items="${list}" varStatus="s">
        <div style="text-align: center;float: left;margin: 20px">
                <button type="button" id="${classinfo.code}" onclick='javascript:sdemo(this);' class="btn btn-primary btn-lg active" >${classinfo.name}</button>
        </div>
    </c:forEach>
</div>
<div>
    <div class="col-md-3"></div>
    <div id="child" style="margin: auto;border: 1px solid red;width: 50%;" class="col-md-6">
    </div>
    <div class="col-md-3"></div>
</div>
</body>
</html>