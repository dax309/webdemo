<%--
  Created by IntelliJ IDEA.
  User: dax30
  Date: 2019/5/2
  Time: 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Python3 在线练习</title>
    <link rel='stylesheet' id='wpProQuiz_front_style-css'  href='css/wpProQuiz_front.min.css' type='text/css' media='all' />
    <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <script src="js/codemirror.min.js"></script>
    <link rel="stylesheet" href="css/codemirror.min.css">
    <script src="js/python.js"></script>
    <link href="css/normalize.min.css" rel="stylesheet">

    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">


    <script src="js/clipboard.min.js"></script>
</head>

<body>

<div class="col-md-12">
    <jsp:include page="/header.jsp"></jsp:include>
</div>

<div class="container">
    <style>
        .CodeMirror {
            height: 374px;
        }
    </style>
    <br>
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-default">
                <div id="compiler" class="panel-heading">
                    <form class="form-inline" role="form">
                        <a href="javascript:history.back(-1)">
                            <button type="button" class="btn btn-success" aria-label="Left Align" style="cursor: pointer">
                                <span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
                            </button>
                        </a>
                        <button type="button" class="btn btn-success" id="submitBTN" disabled="disabled"><i class="fa fa-send-o"></i> 点击运行</button>
                        <button type="button" class="btn btn-default" id="clearCode" ><i class="fa fa-eraser" aria-hidden="true"></i> 清空</button>
                        <select class="form-control" id="sel1">
                        <option selected="selected">Python3 在线工具</option>
                    </select>
                    </form>
                </div>
                <div class="panel-body">
                    <form role="form" id="compiler-form">
                        <div class="form-group">
                            <div class="row">
                                <div class="col-md-7">
                    <textarea class="form-control"  id="code" name="code" rows="18">#!/usr/bin/python
print("Hello, World!");</textarea>
                                </div>
                                <div class="col-md-5">
                                    <textarea placeholder="运行结果……" class="form-control" id="compiler-textarea-result" rows="18">Hello, World!</textarea>
                                </div>
                            </div>
                        </div>


                    </form>
                </div>
            </div>
        </div>
    </div>
    <script>
        var editor = CodeMirror.fromTextArea(document.getElementById("code"), {//定义CodeMirror代码编辑器
            lineNumbers: true,
            matchBrackets: true,
            mode: "text/x-python",
            indentUnit: 4,
            indentWithTabs: true,
        });

        btn = $("#submitBTN");
        editor.on("change",function(editor,change){
            btn.prop('disabled', false);
        });

        btn.click(function() {
            btn.prop('disabled', true);
            loadingdata = '程序正在运行中……';
            $("#compiler-textarea-result").val(loadingdata);

            code = editor.getValue();
            $.post("editorcode",{code:code},function(data){
                console.log(data);
                $("#compiler-textarea-result").val(data);
            });
            setTimeout(function(){
                btn.prop('disabled', false);
            }, 10*1000);
        });


        $("#clearCode").click(function() {
            var r=confirm("确认清空？");
            if (r==true){
                editor.setValue("");
                editor.clearHistory();
                $("#compiler-textarea-result").val("");
                btn.prop('disabled', true);
            }
        });

        $(function(){
        });
    </script>

    <hr>
</div>



</body>

</html>