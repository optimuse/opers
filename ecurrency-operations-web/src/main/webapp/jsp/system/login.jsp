<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>


    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../common/imports.jsp"/>
    <title>${platformName} - 登录</title>
    <script src="${path}/jsp/system/js/login.js?v=1.0.0"></script>
    <script>


        if (window.top !== window.self) {
            window.top.location = window.location;
        }
        var _path = "${path}";
        $(document).ready(function () {
            refreshCode();
        });

    </script>
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen  animated fadeInDown">
    <div>
        <%--<h3 class="logo-name"></h3>--%>
        <h3 class="logo-name">${platformName}</h3>
        <form class="m-t" role="form" method="post" action="${path}/toLogin.do">
            <div class="form-group">
                <input name="username" id="username" type="text" class="form-control" placeholder="用户名" required=""
                       value="${loginDTO.username}">
            </div>
            <div class="form-group">
                <input name="password" id="password" type="password" class="form-control" placeholder="密码" required="">
            </div>
            <div class="form-group">
                <div class="input-group">
                    <input id="imgVerificationCode" name="imgVerificationCode" class="form-control" placeholder="验证码"
                           required="">
                    <span class="input-group-addon"><img title="点击换一张" id="validationCode" style="cursor: pointer;"
                                                         onclick="refreshCode()" alt="点击换一张"
                    > </span>
                </div>
            </div>
            <div class="form-group">
                <div class="input-group">
                    <input id="smsVerificationCode" name="smsVerificationCode" class="form-control" placeholder="短信验证码"
                           required="">
                    <span class="input-group-btn">
                        <button id="sendSmsVerificationCodeBtn"
                                class="btn btn-primary"
                                onclick="sendSmsVerificationCode(this)" type="button">获取动态码
                        </button>
                    </span>
                </div>
            </div>
            <c:if test="${!empty errMsg}">
            <script>
                layer.alert('${errMsg}',{
                    icon:0,
                    title:'提示'
                });
            </script>
            </c:if>
            <div class="form-group">
                <button type="submit" class="btn btn-primary block full-width m-b">登 录</button>
            </div>

            <p class="text-muted text-center"><a href="login.html#">
                <small>忘记密码了？</small>
            </a>
                <%--| <a href="register.html">注册一个新账号</a>--%>
            </p>

        </form>
    </div>
</div>


</body>

</html>
