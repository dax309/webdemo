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
    <link rel='dns-prefetch' href='//s.w.org' />
    <link rel='stylesheet' id='wpProQuiz_front_style-css'  href='https://c.runoob.com/wp-content/plugins/Wp-Pro-Quiz/css/wpProQuiz_front.min.css?ver=0.37' type='text/css' media='all' />
    <script type='text/javascript' src='https://c.runoob.com/wp-includes/js/jquery/jquery.js?ver=1.12.4'></script>
    <script type='text/javascript' src='https://c.runoob.com/wp-includes/js/jquery/jquery-migrate.min.js?ver=1.4.1'></script>
    <link rel="canonical" href="https://c.runoob.com/compile/9" />
    <meta name="keywords" content="Python3 在线工具">
    <meta name="description" content="该工具基于 Python3.x，可以实现在线编译 Python 代码……..">

    <script src="//cdn.staticfile.org/codemirror/5.25.0/codemirror.min.js"></script>
    <link rel="stylesheet" href="//cdn.staticfile.org/codemirror/5.25.0/codemirror.min.css">
    <script src="//cdn.staticfile.org/codemirror/5.25.0/mode/python/python.js"></script>
    <link href="https://cdn.staticfile.org/normalize/7.0.0/normalize.min.css" rel="stylesheet">
    <!-- Bootstrap Core CSS -->
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="/wp-content/themes/toolrunoob/startbootstrap/css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="/wp-content/themes/toolrunoob/assets/font-awesome-4.4.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!--[if lt IE 9]>
    <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
    <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- PHP 代码 -->
    <link rel="stylesheet" href="/wp-content/themes/toolrunoob/style.css?version=1.03">



    <!-- jQuery -->
    <!--[if gte IE 9]><!-->
    <script src="//cdn.staticfile.org/jquery/2.0.3/jquery.min.js"></script>
    <!--<![endif]-->
    <!--[if lt IE 9]>
    <script src="//cdn.staticfile.org/jquery/1.9.1/jquery.min.js"></script>
    <![endif]-->
    <script src="https://cdn.staticfile.org/clipboard.js/2.0.4/clipboard.min.js"></script>
</head>

<body>
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
                        <button type="button" class="btn btn-success" id="submitBTN" disabled="disabled"><i class="fa fa-send-o"></i> 点击运行</button>
                        <button type="button" class="btn btn-default" id="clearCode" ><i class="fa fa-eraser" aria-hidden="true"></i> 清空</button>
                        <input type="text" class="form-control" name="stdin" id="stdin" placeholder="标准输入(stdin)">				<select class="form-control" id="sel1">
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
        var editor = CodeMirror.fromTextArea(document.getElementById("code"), {
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
            stdin = '';
            if ($('#stdin').length > 0) {
                stdin = $("#stdin").val();
            }
            runcode = 15;
            $.post("https://m.runoob.com/api/compile.php",{code:code,stdin:stdin,language:runcode, fileext:"py3"},function(data){
                if(runcode==18) {
                    data.output = data.output.replace("Free Pascal Compiler version 2.6.2-8 [2014/01/22] for x86_64\nCopyright (c) 1993-2012 by Florian Klaempfl and others\n", "");
                    data.errors = data.errors.replace("/usr/bin/ld.bfd: warning: /usercode/link.res contains output sections; did you forget -T?\n", "");
                }
                if(runcode==8) {
                    data.errors = data.errors.replace("/usercode/script.sh: line 69: bc: command not found", "");
                }
                $("#compiler-textarea-result").val(data.output + data.errors);
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
            // bind change event to select
            $('#sel1').on('change', function () {
                var url = $(this).val(); // get selected value
                if (url) { // require a URL
                    window.location = url; // redirect
                }
                return false;
            });
        });

    </script>

    <hr>
</div>

<script src="bootstrap/js/bootstrap.min.js"></script>

</body>

</html>