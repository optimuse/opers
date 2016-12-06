<%--
  Created by IntelliJ IDEA.
  User: Jwxa
  Date: 2016/11/18
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../common/imports.jsp"/>
    <title>${platformName} - TEST</title>
    <link href="${path}/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${path}/css/plugins/jsTree/style.min.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-md-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>TITLE</h5>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-sm-12">
                            <form role="form" class="form-horizontal">
                                <input id="sInput" value="11111"/>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="${path}/js/common.js?v=1.0.0"></script>

<script>
    var _path = "${path}";
    $(function () {
        //demo1 simpleAjax
        /*
        var sAjax = new SimpleAjax({
            url:_path+"/testAjaxSuccess.do",
            data:{},
            successCallback:function (data) {
               alert("this is successCallback");
            },
            successMsg:'hello msg'
        });
        sAjax.post();
        */
        //demo2 simpleFOrm
        /*
        var sForm = new SimpleForm({
         sInput:'222222'
         });
         sForm.show();
         */
         var loadingLayer = layer.load(2, {shade: 0.3});
         setTimeout(function () {
             layer.close(loadingLayer);
         },5000);
    });
</script>
<!-- 自定义js -->
<script src="${path}/js/content.js?v=1.0.0"></script>
</body>

</html>

