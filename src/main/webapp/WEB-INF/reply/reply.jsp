<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/5/4
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String nowDate = sdf.format(date);
    %>
</head>
<body>

<!-- 留言的表单 -->
<form class="layui-form" action="<%=basePath%>/article/saveWords.do" method="post" style="width:80%;">
    <input name="lw_name" value="${sessionScope.name}" hidden="hidden"/>
    <input name="lw_date" value="<%=nowDate%>" hidden="hidden"/>
    <input name="lw_for_article_id" value="${article.r_id}" hidden="hidden"/>
    <div class="layui-input-block" style="margin-left: 0;">
        <textarea id="lw_content" name="lw_content" placeholder="请输入你的留言" class="layui-textarea" style="height: 150px;"></textarea>
    </div>
    <br/>
    <div class="layui-input-block" style="text-align: left;margin-left: 0;">
        <input type="submit" class="layui-btn" value="留言">
    </div>
</form>
<br/>
<!-- 留言信息列表展示 -->
<div>
    <ul>
        <!-- 先遍历留言信息（一条留言信息，下面的全是回复信息） -->
        <c:forEach items="${requestScope.lw_list}" var="words">
            <!-- 如果留言信息是在本文章下的才显示 -->
            <c:if test="${words.lw_for_article_id eq article.r_id}">
                <li style="border-top: 1px dotted #01AAED">
                    <br/>
                    <div style="text-align: left;color:#444">
                        <div>
                            <span style="color:#01AAED">${words.lw_name}</span>
                        </div>
                        <div>${words.lw_content}</div>
                    </div>
                    <div>
                        <div class="comment-parent" style="text-align:left;margin-top:7px;color:#444">
                            <span>${words.lw_date}</span>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            <p>
                                <a href="javascript:;" style="text-decoration: none;" onclick="btnReplyClick(this)">回复</a>
                            </p>
                            <hr style="margin-top: 7px;"/>
                        </div>
                        <!-- 回复表单默认隐藏 -->
                        <div class="replycontainer layui-hide" style="margin-left: 61px;">
                            <form action="<%=basePath%>/article/saveReply.do" method="post" class="layui-form">
                                <input name="lr_for_article_id" id="lr_for_article_id" value="${article.r_id}" hidden="hidden"/>
                                <input name="lr_name" id="lr_name" value="${sessionScope.name}" hidden="hidden"/>
                                <input name="lr_date" id="lr_date" value="<%=nowDate%>" hidden="hidden"/>
                                <input name="lr_for_name" id="lr_for_name" value="${words.lw_name}" hidden="hidden"/>
                                <input name="lr_for_words" id="lr_for_words" value="${words.lw_id}" hidden="hidden"/>
                                <input name="lr_for_reply" id="lr_for_reply" value="${reply.lr_id}" hidden="hidden"/>
                                <div class="layui-form-item">
                                    <textarea name="lr_content" id="lr_content" lay-verify="replyContent" placeholder="请输入回复内容" class="layui-textarea" style="min-height:80px;"></textarea>
                                </div>
                                <div class="layui-form-item">
                                    <button id="replyBtn" class="layui-btn layui-btn-mini" lay-submit="formReply" lay-filter="formReply">提交</button>
                                </div>
                            </form>
                        </div>
                    </div>

                    <!-- 以下是回复信息 -->
                    <c:forEach items="${requestScope.lr_list}" var="reply">
                        <!-- 每次遍历出来的留言下存在回复信息才展示（本条回复信息是本条留言下的就显示在当前留言下） -->
                        <c:if test="${reply.lr_for_article_id eq article.r_id && reply.lr_for_words eq words.lw_id}">
                            <div style="text-align: left;margin-left:61px;color: #444">
                                <div>
                                    <span style="color:#5FB878">${reply.lr_name}&nbsp;&nbsp;</span>
                                </div>
                                <div>${reply.lr_content}</div>
                            </div>
                            <div>
                                <div class="comment-parent" style="text-align:left;margin-top:7px;margin-left:61px;color:#444">
                                    <span>${reply.lr_date}</span>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    <p>
                                        <a href="javascript:;" style="text-decoration: none;" onclick="btnReplyClick(this)">回复</a>
                                    </p>
                                    <hr style="margin-top: 7px;"/>
                                </div>
                                <!-- 回复表单默认隐藏 -->
                                <div class="replycontainer layui-hide" style="margin-left: 61px;">
                                    <form action="<%=basePath%>/article/saveReply.do" method="post" class="layui-form">
                                        <input name="lr_for_article_id" id="lr_for_article_id" value="${article.r_id}" hidden="hidden"/>
                                        <input name="lr_name" id="lr_name" value="${sessionScope.name}" hidden="hidden"/>
                                        <input name="lr_date" id="lr_date" value="<%=nowDate%>" hidden="hidden"/>
                                        <input name="lr_for_name" id="lr_for_name" value="${words.lw_name}" hidden="hidden"/>
                                        <input name="lr_for_words" id="lr_for_words" value="${words.lw_id}" hidden="hidden"/>
                                        <input name="lr_for_reply" id="lr_for_reply" value="${reply.lr_id}" hidden="hidden"/>
                                        <div class="layui-form-item">
                                            <textarea name="lr_content" id="lr_content" lay-verify="replyContent" placeholder="请输入回复内容" class="layui-textarea" style="min-height:80px;"></textarea>
                                        </div>
                                        <div class="layui-form-item">
                                            <button id="replyBtn" class="layui-btn layui-btn-mini" lay-submit="formReply" lay-filter="formReply">提交</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </c:if>
                    </c:forEach>
                </li>
            </c:if>
        </c:forEach>
    </ul>
</div>


</body>
</html>
