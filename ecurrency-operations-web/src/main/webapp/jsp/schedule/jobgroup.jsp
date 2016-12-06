<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../common/imports.jsp"/>
    <title>${platformName} - 调度管理</title>
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
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <div class="content-wrapper">
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">执行器列表</h3>&nbsp;&nbsp;
                            <button class="btn btn-info btn-xs pull-left2 add">+新增执行器</button>
                            &nbsp;&nbsp;&nbsp;&nbsp;
                            调度中心OnLine:
                            <c:if test="${not empty adminAddressList}">
                                <c:forEach var="item" items="${adminAddressList}">
                                    <span class="badge bg-green">${item}</span>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div class="box-body">
                            <table id="joblog_list" class="table table-bordered table-striped display" width="100%">
                                <thead>
                                <tr>
                                    <th name="id">ID</th>
                                    <th name="appName">AppName</th>
                                    <th name="title">名称</th>
                                    <th name="order">排序</th>
                                   <%-- <th name="registryList">OnLine 机器</th>--%>
                                    <th name="operate">操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty list}">
                                    <c:forEach var="group" items="${list}">
                                        <tr>
                                            <td>${group.id}</td>
                                            <td>${group.appName}</td>
                                            <td>${group.title}</td>
                                            <td>${group.order}</td>
                                           <%-- <td>
                                                <c:if test="${not empty group.registryList}">
                                                    <c:forEach var="item" items="${group.registryList}">
                                                        <span class="badge bg-green">${item}</span><br>
                                                    </c:forEach>
                                                </c:if>
                                            </td>--%>
                                            <td>
                                                <button class="btn btn-warning btn-xs update" id="${group.id}"
                                                        appName="${group.appName}" title="${group.title}"
                                                        order="${group.order}">编辑
                                                </button>
                                                <button class="btn btn-danger btn-xs remove" id="${group.id}">删除
                                                </button>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>

    <!-- 新增.模态框 -->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">新增执行器</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal form" role="form">
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">AppName<font
                                    color="red">*</font></label>

                            <div class="col-sm-10"><input type="text" class="form-control" name="appName"
                                                          placeholder="请输入“AppName”" maxlength="64"></div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">名称<font color="red">*</font></label>

                            <div class="col-sm-10"><input type="text" class="form-control" name="title"
                                                          placeholder="请输入“名称”" maxlength="12"></div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">排序<font color="red">*</font></label>

                            <div class="col-sm-10"><input type="text" class="form-control" name="order"
                                                          placeholder="请输入“排序”" maxlength="50"></div>
                        </div>
                        <hr>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-6">
                                <button type="submit" class="btn btn-primary">保存</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- 更新.模态框 -->
    <div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog ">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title">编辑执行器</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal form" role="form">
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">AppName<font
                                    color="red">*</font></label>

                            <div class="col-sm-10"><input type="text" class="form-control" name="appName"
                                                          placeholder="请输入“AppName”" maxlength="64"></div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">名称<font color="red">*</font></label>

                            <div class="col-sm-10"><input type="text" class="form-control" name="title"
                                                          placeholder="请输入“名称”" maxlength="12"></div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-2 control-label">排序<font color="red">*</font></label>

                            <div class="col-sm-10"><input type="text" class="form-control" name="order"
                                                          placeholder="请输入“排序”" maxlength="50"></div>
                        </div>
                        <hr>
                        <div class="form-group">
                            <div class="col-sm-offset-3 col-sm-6">
                                <button type="submit" class="btn btn-primary">保存</button>
                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                <input type="hidden" name="id">
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- DataTables -->
<script src="${path}/js/adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${path}/js/adminlte/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${path}/js/adminlte/plugins/jQuery/jquery.validate.min.js"></script>
<script>var base_url = '${path}';</script>
<script src="${path}/jsp/schedule/js/xxl.alert.1.js"></script>

<script type="text/javascript">
    $(function(){
        $('.remove').on('click', function(){
            var id = $(this).attr('id');

            ComConfirm.show("确认删除分组?", function(){
                $.ajax({
                    type : 'POST',
                    url : base_url + '/jobgroup/remove',
                    data : {"id":id},
                    dataType : "json",
                    success : function(data){
                        if (data.code == 200) {
                            ComAlert.show(1, '删除成功');
                            window.location.reload();
                        } else {
                            if (data.msg) {
                                ComAlert.show(2, data.msg);
                            } else {
                                ComAlert.show(2, '删除失败');
                            }
                        }
                    },
                });
            });
        });

        // jquery.validate 自定义校验 “英文字母开头，只含有英文字母、数字和下划线”
        jQuery.validator.addMethod("myValid01", function(value, element) {
            var length = value.length;
            var valid = /^[a-z][a-zA-Z0-9-]*$/;
            return this.optional(element) || valid.test(value);
        }, "限制以小写字母开头，由小写字母、数字和下划线组成");

        $('.add').on('click', function(){
            $('#addModal').modal({backdrop: false, keyboard: false}).modal('show');
        });
        var addModalValidate = $("#addModal .form").validate({
            errorElement : 'span',
            errorClass : 'help-block',
            focusInvalid : true,
            rules : {
                appName : {
                    required : true,
                    rangelength:[4,64],
                    myValid01 : true
                },
                title : {
                    required : true,
                    rangelength:[4, 12]
                },
                order : {
                    required : true,
                    digits:true,
                    range:[1,1000]
                }
            },
            messages : {
                appName : {
                    required :"请输入“AppName”",
                    rangelength:"AppName长度限制为4~64",
                    myValid01: "限制以小写字母开头，由小写字母、数字和中划线组成"
                },
                title : {
                    required :"请输入“执行器名称”",
                    rangelength:"长度限制为4~12"
                },
                order : {
                    required :"请输入“排序”",
                    digits: "请输入整数",
                    range: "取值范围为1~1000"
                }
            },
            highlight : function(element) {
                $(element).closest('.form-group').addClass('has-error');
            },
            success : function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },
            errorPlacement : function(error, element) {
                element.parent('div').append(error);
            },
            submitHandler : function(form) {
                $.post(base_url + "/jobgroup/save",  $("#addModal .form").serialize(), function(data, status) {
                    if (data.code == "200") {
                        $('#addModal').modal('hide');
                        setTimeout(function () {
                            ComAlert.show(1, "新增成功", function(){
                                window.location.reload();
                            });
                        }, 315);
                    } else {
                        if (data.msg) {
                            ComAlert.show(2, data.msg);
                        } else {
                            ComAlert.show(2, "新增失败");
                        }
                    }
                });
            }
        });
        $("#addModal").on('hide.bs.modal', function () {
            $("#addModal .form")[0].reset();
            addModalValidate.resetForm();
            $("#addModal .form .form-group").removeClass("has-error");
        });

        $('.update').on('click', function(){
            $("#updateModal .form input[name='id']").val($(this).attr("id"));
            $("#updateModal .form input[name='appName']").val($(this).attr("appName"));
            $("#updateModal .form input[name='title']").val($(this).attr("title"));
            $("#updateModal .form input[name='order']").val($(this).attr("order"));
            $('#updateModal').modal({backdrop: false, keyboard: false}).modal('show');
        });
        var updateModalValidate = $("#updateModal .form").validate({
            errorElement : 'span',
            errorClass : 'help-block',
            focusInvalid : true,
            rules : {
                appName : {
                    required : true,
                    rangelength:[4,64],
                    myValid01 : true
                },
                title : {
                    required : true,
                    rangelength:[4, 12]
                },
                order : {
                    required : true,
                    digits:true,
                    range:[1,1000]
                }
            },
            messages : {
                appName : {
                    required :"请输入“AppName”",
                    rangelength:"AppName长度限制为4~64",
                    myValid01: "限制以小写字母开头，由小写字母、数字和中划线组成"
                },
                title : {
                    required :"请输入“执行器名称”",
                    rangelength:"长度限制为4~12"
                },
                order : {
                    required :"请输入“排序”",
                    digits: "请输入整数",
                    range: "取值范围为1~1000"
                }
            },
            highlight : function(element) {
                $(element).closest('.form-group').addClass('has-error');
            },
            success : function(label) {
                label.closest('.form-group').removeClass('has-error');
                label.remove();
            },
            errorPlacement : function(error, element) {
                element.parent('div').append(error);
            },
            submitHandler : function(form) {
                $.post(base_url + "/jobgroup/update",  $("#updateModal .form").serialize(), function(data, status) {
                    if (data.code == "200") {
                        $('#addModal').modal('hide');
                        setTimeout(function () {
                            ComAlert.show(1, "更新成功", function(){
                                window.location.reload();
                            });
                        }, 315);
                    } else {
                        if (data.msg) {
                            ComAlert.show(2, data.msg);
                        } else {
                            ComAlert.show(2, "更新失败");
                        }
                    }
                });
            }
        });
        $("#updateModal").on('hide.bs.modal', function () {
            $("#updateModal .form")[0].reset();
            addModalValidate.resetForm();
            $("#updateModal .form .form-group").removeClass("has-error");
        });
    });
</script>
<%--<script src="${path}/jsp/schedule/js/jobgroup.index.1.js">--%>

</body>
</html>
