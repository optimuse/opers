<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" autoFlush="true" %>
<jsp:include page="../common/imports.jsp"/>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../common/imports.jsp"/>
    <title>${platformName} - 没有权限</title>

</head>

<body class="gray-bg">


    <div class="middle-box text-center animated fadeInDown">
        <h1>403</h1>
        <h3 class="font-bold">你好像没有权限</h3>

        <div class="error-desc">
            你好像没有权限访问这个页面
        </div>
    </div>

</body>

</html>
