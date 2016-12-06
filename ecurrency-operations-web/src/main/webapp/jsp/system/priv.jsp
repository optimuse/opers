<%--
  Created by IntelliJ IDEA.
  User: Jwxa
  Date: 2016/11/18
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="/WEB-INF/tag-tlds/priv.tld" prefix="priv"%>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <jsp:include page="../common/imports.jsp"/>
    <title>${platformName} - 权限管理</title>
    <link href="${path}/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${path}/css/plugins/jsTree/style.min.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-md-4">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>菜单列表</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-plus" id="addPrivBtn" onclick="showAddPrivForm()"></i>
                        </a>
                        <a class="collapse-link">
                            <i class="fa fa-refresh" id="refreshBtn"></i>
                        </a>
                        <a class="collapse-link">
                            <i class="fa fa-save"></i>
                        </a>
                    </div>
                </div>

                <div class="ibox-content">
                    <div id="privTree"></div>
                </div>
            </div>
        </div>
        <div class="col-md-8">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>菜单详情</h5>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-sm-12">
                            <form role="form" class="form-horizontal" id="privInfoForm">
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">id：</label>

                                    <div class="col-sm-8">
                                        <input id="privId" name="privId" placeholder="权限id" class="form-control" type="text" readonly="readonly"
                                               >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">名称：</label>

                                    <div class="col-sm-8">
                                        <input id="privName" name="privName" placeholder="权限名称" class="form-control" type="text"
                                               required="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">类型：</label>

                                    <div class="col-sm-8">
                                        <%--<input id="privType" placeholder="权限类型" class="form-control" type="text" required="">--%>
                                        <div class="radio">
                                            <div class="col-sm-2">
                                                <label>
                                                    <input checked="" value="MENU" id="optionsRadios1"
                                                           name="optionsRadios" type="radio">菜单
                                                </label>
                                            </div>
                                            <div class="col-sm-2">
                                                <label>
                                                    <input  value="FUNC" id="optionsRadios2"
                                                           name="optionsRadios" type="radio">按键
                                                </label>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">链接：</label>

                                    <div class="col-sm-8">
                                        <input id="privUrl" name="privUrl" placeholder="权限链接" class="form-control" type="text"
                                               required="">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label">图标样式：</label>

                                    <div class="col-sm-8">
                                        <input id="privImg" name="privImg" placeholder="图标样式" class="form-control" type="text">
                                    </div>
                                </div>
                                <%--有权限则显示 注意检查防止js报错--%>
                                <priv:valid privUrl="com.bestpay.ecurrency.operations.web.controller.system.PrivController.modifyPrivInfo">
                                <div class="form-group">
                                    <div class="col-sm-4 col-sm-offset-3">
                                        <div class="col-sm-2">
                                            <button class="btn btn-primary" type="button" onclick="javascript:modifyPriv();">修改</button>
                                        </div>
                                        <div class="col-sm-2  col-sm-offset-2">
                                            <button class="btn btn-primary" type="button">重置</button>
                                        </div>
                                    </div>
                                </div>
                                </priv:valid>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jsTree plugin javascript -->
<script src="${path}/js/plugins/jsTree/jstree.min.js"></script>

<style>
    .jstree-open > .jstree-anchor > .fa-folder:before {
        content: "\f07c";
    }

    .jstree-default .jstree-icon.none {
        width: 0;
    }
</style>

<script>
    var _path = "${path}";
    $(function () {
        var privList = new PrivList("privTree", "refreshBtn");
    });
</script>
<script src="${path}/jsp/system/js/priv.js?v=1.0.0"></script>
<!-- 自定义js -->
<script src="${path}/js/content.js?v=1.0.0"></script>
</body>

</html>

