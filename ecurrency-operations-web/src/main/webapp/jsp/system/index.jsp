<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" autoFlush="true" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="renderer" content="webkit">
    <jsp:include page="../common/imports.jsp"/>
    <title> ${platformName} - 主页</title>
    <link rel="stylesheet" href="${path}/css/bootstrap-addtabs.css" type="text/css" media="screen"/>
    <script src="${path}/js/bootstrap-addtabs.js"></script>
    <script>
        if (window.top !== window.self) {
            window.top.location = window.location;
        }
        var _path = "${path}";
        $(function () {
            $('#tabs').addtabs({monitor: '.menu-group'});
            $('#save').click(function () {
                Addtabs.add({
                    id: $(this).attr('addtabs'),
                    title: $(this).attr('title') ? $(this).attr('title') : $(this).html(),
                    content: Addtabs.options.content ? Addtabs.options.content : $(this).attr('content'),
                    url: $(this).attr('url'),
                    ajax: $(this).attr('ajax') ? true : false
                })
            });
        })

    </script>
</head>

<body class="fixed-sidebar full-height-layout gray-bg" style="overflow:hidden">
<div id="wrapper">
    <!--左侧导航开始-->
    <nav class="navbar-default navbar-static-side" role="navigation">
        <div class="nav-close"><i class="fa fa-times-circle"></i>
        </div>
        <div class="sidebar-collapse menu-group">
            <ul class="nav" id="side-menu">
                <li class="nav-header">
                    <div class="dropdown profile-element">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                                    <span class="block m-t-xs" style="font-size:20px;">
                                        <i class="fa fa-area-chart"></i>
                                        <strong class="font-bold">电子货币</strong>
                                    </span>
                                </span>
                        </a>
                    </div>
                    <div class="logo-element">hAdmin
                    </div>
                </li>
                ${menu}

            </ul>
        </div>
    </nav>
    <!--左侧导航结束-->
    <!--右侧部分开始-->
    <div id="page-wrapper" class="gray-bg dashbard-1">
        <div class="row border-bottom">
            <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
                <div class="navbar-header">
                    <%--<a class="navbar-minimalize minimalize-styl-2 btn btn-info " href="#"><i class="fa fa-bars"></i> </a>--%>

                </div>

                <div class="main">
                    <div id="tabs">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                        </ul>
                        <!-- Tab panes -->
                        <div class="tab-content">

                        </div>
                    </div>
                </div>


            </nav>
        </div>
    </div>
    <!--右侧部分结束-->
</div>

<!-- 全局js -->


<script src="${path}/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="${path}/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="${path}/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="${path}/js/hAdmin.js?v=4.1.0"></script>

</body>

</html>
