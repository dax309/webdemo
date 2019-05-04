<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/4/25
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = new Date();
    String nowDate = sdf.format(date);
%>

<script type="text/javascript">
    function btnReplyClick(elem) {
        var $ = layui.jquery;
        $(elem).parent('p').parent('.comment-parent').siblings('.replycontainer').toggleClass('layui-hide');
        if ($(elem).text() == '回复') {
            $(elem).text('收起')
        } else {
            $(elem).text('回复')
        }
    }

    $("#replyBtn").click(function(){
        var lr_for_article_id = $("#lr_for_article_id").val();
        var lr_name = $("#lr_name").val();
        var lr_date = $("#lr_date").val();
        var lr_for_name = $("#lr_for_name").val();
        var lr_content = $("#lr_content").val();
        var lr_for_words = $("#lr_for_words").val();
        $.ajax({
            url: '<%=basePath%>/article/saveReply.do',
            type: 'POST',
            data: [{
                lr_for_article_id: lr_for_article_id,
                lr_name: lr_name,
                lr_date: lr_date,
                lr_for_name: lr_for_name,
                lr_content: lr_content,
                lr_for_words: lr_for_words
            }],
            success: function(data){
                layer.open({
                    title: '提示信息',
                    content: '留言成功',
                    btn: ['确定'],
                    btn1: function(index){
                        $("body").html(data);
                    }
                });
            },
            error: function(){
                layer.open({
                    title: '提示信息',
                    content: '出现未知错误'
                });
            }
        });
    });
</script>

<body>


</body>
</html>