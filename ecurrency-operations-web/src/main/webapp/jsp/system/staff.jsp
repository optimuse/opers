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
    <title>${platformName} - 用户管理</title>
    <link href="${path}/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link href="${path}/css/plugins/jsTree/style.min.css" rel="stylesheet">
    <script src="${path}/js/plugins/layer/layer.min.js?v=3.3.6"></script>
    <style>
        /**滚动条显示**/
        body {
            overflow-y: scroll !important;
        }
    </style>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-md-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title" data-toggle="collapse" data-target="#collapseDiv">
                    <h5>查询条件</h5>
                    <div class="ibox-tools">
                        <a class="btn btn-primary btn-xs" id="showAddBtn">创建新用户</a>
                    </div>
                </div>

                <div class="ibox-content collapse in" id="collapseDiv">
                    <div class="row">
                        <div class="col-sm-12">
                            <form role="form" class="form-horizontal" id="queryStaffForm">
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label class="col-sm-1 control-label">用户名：</label>

                                        <div class="col-sm-2">
                                            <input id="staffId" name="staffId" placeholder="用户名" class="form-control"
                                                   type="text"
                                                   required="">
                                        </div>
                                        <label class="col-sm-1 control-label">真实姓名：</label>

                                        <div class="col-sm-2">
                                            <input id="staffName" name="staffName" placeholder="真实姓名"
                                                   class="form-control" type="text"
                                                   required="">
                                        </div>
                                        <label class="col-sm-1 control-label">性别：</label>

                                        <div class="col-sm-2">
                                            <div class="col-sm-10">
                                                <select class="form-control" name="sex" id="sex">
                                                    <option value="">全部</option>
                                                    <option value="M">男</option>
                                                    <option value="F">女</option>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="col-sm-3"></div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-4 col-sm-offset-1">
                                        <div class="col-sm-2">
                                            <button class="btn btn-primary" type="button"
                                                    onclick="javascript:queryStaff();">查询
                                            </button>
                                        </div>
                                        <div class="col-sm-5  col-sm-offset-1">
                                            <button class="btn btn-primary" type="reset">重置</button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-12">

            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>查询结果</h5>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-sm-12">
                            <table id="staffTable">
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div>
    <div class="col-md-12">
        <div class="row">
            <div class="modal inmodal fade" id="addStaffDiv" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <form role="form" class="form-horizontal" id="addStaffForm" onsubmit="return addStaff();">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span
                                        aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title">创建新用户</h4>
                            </div>
                            <div class="modal-body">

                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <label class="col-sm-2 control-label red-star">用户名：</label>

                                            <div class="col-sm-4">
                                                <input name="staffId" placeholder="只能输入数字和英文,不超过20位"
                                                       class="form-control"
                                                       type="text" maxlength="20"
                                                       required="">
                                            </div>
                                            <label class="col-sm-2 control-label red-star">真实姓名：</label>

                                            <div class="col-sm-4">
                                                <input name="staffName" placeholder=""
                                                       class="form-control" type="text"
                                                       required="" maxlength="30">
                                            </div>

                                        </div>
                                    </div>

                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <label class="col-sm-2 control-label red-star">登录密码：</label>

                                            <div class="col-sm-4">
                                                <input name="password" placeholder="包含数字和英文,8-20位"
                                                       class="form-control red-star"
                                                       type="password" onkeyup="value=value.replace(/[\W]/g,'') "
                                                       onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
                                                       required="" maxlength="20">
                                            </div>
                                            <label class="col-sm-2 control-label red-star">登录密码确认：</label>

                                            <div class="col-sm-4">
                                                <input name="passwordConfirm" placeholder="包含数字和英文,8-20位"
                                                       class="form-control" type="password"
                                                       onkeyup="value=value.replace(/[\W]/g,'') "
                                                       onbeforepaste="clipboardData.setData('text',clipboardData.getData('text').replace(/[^\d]/g,''))"
                                                       required="" maxlength="20">
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <label class="col-sm-2 control-label">性别：</label>

                                            <div class="col-sm-4">
                                                <div class="radio">
                                                    <label>
                                                        <input checked="" value="M" name="sex" type="radio">男
                                                    </label>
                                                    &nbsp; &nbsp;
                                                    <label>
                                                        <input value="F" name="sex" type="radio">女
                                                    </label>
                                                </div>
                                            </div>
                                            <label class="col-sm-2 control-label">组别：</label>

                                            <div class="col-sm-4">
                                                <input name="orgId" placeholder="" value="1"
                                                       class="form-control" type="text"
                                                       required="" readonly="readonly">
                                            </div>

                                        </div>
                                    </div>

                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <label class="col-sm-2 control-label red-star">电子邮件：</label>

                                            <div class="col-sm-4">
                                                <input name="email" placeholder=""
                                                       class="form-control" type="text"
                                                       required="">
                                            </div>
                                            <label class="col-sm-2 control-label red-star">移动电话：</label>

                                            <div class="col-sm-4">
                                                <input name="mobile" placeholder="11位数字" class="form-control"
                                                       type="text"
                                                       required="" onkeyup="this.value=this.value.replace(/\D/g,'')"
                                                       onafterpaste="this.value=this.value.replace(/\D/g,'')"
                                                       minlength="11" maxlength="11">
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <label class="col-sm-2 control-label">固定电话：</label>

                                            <div class="col-sm-4">
                                                <input name="phone" placeholder="" class="form-control"
                                                       type="text" onkeyup="this.value=this.value.replace('^0\d{2,3}-\d{7,8}(-\d{1,6})?$','')"
                                                >
                                            </div>
                                            <label class="col-sm-2 control-label">邮政编码：</label>

                                            <div class="col-sm-4">
                                                <input name="zip" maxlength="6" minlength="6" placeholder="6位数字"
                                                       class="form-control" type="text"
                                                       onkeyup="this.value=this.value.replace(/\D/g,'')"
                                                       onafterpaste="this.value=this.value.replace(/\D/g,'')">
                                            </div>
                                        </div>
                                    </div>

                                </div>
                                <div class="form-group">
                                    <div class="row">
                                        <div class="col-sm-12">
                                            <label class="col-sm-2 control-label">联系地址：</label>

                                            <div class="col-sm-10">
                                                <input name="address" placeholder=""
                                                       class="form-control" type="text" maxlength="100">
                                            </div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary"
                                       >添加
                                </button>
                                <button type="reset" class="btn btn-white">重置</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<div>
    <div class="col-md-12">
        <div class="row">
            <div class="modal inmodal fade" id="allocateRoleDiv" tabindex="-1" role="dialog" aria-hidden="true">
                <div class="modal-dialog modal-lg">
                    <form role="form" class="form-horizontal" id="allocateRoleForm" onsubmit="return allocateRole();">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal"><span
                                        aria-hidden="true">×</span><span class="sr-only">Close</span></button>
                                <h4 class="modal-title">分配角色</h4>
                                <input type="hidden" id="allocateStaffId">
                            </div>
                            <div class="modal-body">
                                <div id="roleTree">
                                    节点树
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="submit" class="btn btn-primary"
                                >确认
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${path}/js/common.js?v=1.0.0"></script>
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
        queryStaff();
        loadRoleTree();
    });
</script>
<script src="${path}/jsp/system/js/staff.js?v=1.0.0"></script>
<!-- 自定义js -->
<script src="${path}/js/content.js?v=1.0.0"></script>
<!-- Bootstrap table -->
<script src="${path}/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
<script src="${path}/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
<script src="${path}/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>
</body>

</html>

