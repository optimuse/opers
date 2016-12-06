<%--
  Created by IntelliJ IDEA.
  User: Jwxa
  Date: 2016/11/10
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="../common/imports.jsp"/>
<html>
<head>
    <title>${platformName} - 登录</title>
</head>
<body>
    <%
        /**
         * 直接将控制转给springmvc
         */
        response.sendRedirect(request.getContextPath() + "/login.do");
    %>

</body>
</html>
