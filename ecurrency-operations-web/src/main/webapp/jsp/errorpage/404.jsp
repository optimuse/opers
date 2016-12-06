<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" autoFlush="true" %>
<jsp:include page="../common/imports.jsp"/>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>${platformName} - 404 页面</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico">
    <link href="${path}/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${path}/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${path}/css/animate.css" rel="stylesheet">
    <link href="${path}/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">


    <div class="middle-box text-center animated fadeInDown">
        <h1>404</h1>
        <h3 class="font-bold">页面未找到！</h3>

        <div class="error-desc">
            抱歉，页面好像去火星了~
            <form class="form-inline m-t" role="form">
                <div class="form-group">
                    <input type="email" class="form-control" placeholder="请输入您需要查找的内容 …">
                </div>
                <button type="submit" class="btn btn-primary">搜索</button>
            </form>
        </div>
    </div>

    <!-- 全局js -->
    <script src="${path}/js/jquery.min.js?v=2.1.4"></script>
    <script src="${path}/js/bootstrap.min.js?v=3.3.6"></script>

    
    

</body>

</html>
