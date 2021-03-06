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
            </div>
            <div class="row">
                <div class="col-xs-4">
                    <div class="input-group">
                        <span class="input-group-addon">执行器</span>

                        <select class="form-control" id="jobGroup">
                            <c:forEach var="group" items="${JobGroupList}">
                                <option value="${group.id}">${group.title}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="input-group">
                        <span class="input-group-addon">JobHandler</span>
                        <input type="text" class="form-control" id="executorHandler" value="${jobName}"
                               autocomplete="on">
                    </div>
                </div>
                <div class="col-xs-2">
                    <button class="btn btn-block btn-info" id="searchBtn">搜索</button>
                </div>
                <div class="col-xs-2">
                    <button class="btn btn-block btn-success add" type="button">+新增任务</button>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">调度列表</h3>
                        </div>
                        <div class="box-body">
                            <table id="job_list" class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th name="id">id</th>
                                    <th name="jobGroup">jobGroup</th>
                                    <th name="jobName">jobName</th>
                                    <th name="childJobKey">任务Key</th>
                                    <th name="jobDesc">描述</th>
                                    <th name="jobCron">Cron</th>
                                    <th name="executorHandler">JobJandler</th>
                                    <th name="executorParam">任务参数</th>
                                    <th name="addTime">新增时间</th>
                                    <th name="updateTime">更新时间</th>
                                    <th name="author">负责人</th>
                                    <th name="alarmEmail">报警邮件</th>
                                    <th name="glueSwitch">GLUE模式</th>
                                    <th name="jobStatus">状态</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody></tbody>
                                <tfoot></tfoot>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>


<!-- job新增.模态框 -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">新增任务</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal form" role="form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">执行器<font color="red">*</font></label>

                        <div class="col-sm-4">
                            <select class="form-control" name="jobGroup">
                                <c:forEach var="group" items="${JobGroupList}">
                                    <option value="${group.id}">${group.title}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <label class="col-sm-2 control-label">任务描述<font color="red">*</font></label>

                        <div class="col-sm-4"><input type="text" class="form-control" name="jobDesc"
                                                     placeholder="请输入“描述”" maxlength="50"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">JobHandler<font
                                color="red">*</font></label>

                        <div class="col-sm-4">
                            <div class="input-group">
                                <input type="text" class="form-control" name="executorHandler"
                                       placeholder="请输入“JobHandler”" maxlength="100">
                                <span class="input-group-addon"><b>GLUE</b>&nbsp;<input type="checkbox" class="ifGLUE"></span>
                                <input type="hidden" name="glueSwitch" value="0">
                            </div>
                        </div>
                        <label class="col-sm-2 control-label">执行参数<font color="black">*</font></label>

                        <div class="col-sm-4"><input type="text" class="form-control" name="executorParam"
                                                     placeholder="请输入“执行参数”" maxlength="100"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Cron<font color="red">*</font></label>

                        <div class="col-sm-4"><input type="text" class="form-control" name="jobCron"
                                                     placeholder="请输入“Cron”" maxlength="20"></div>
                        <label class="col-sm-2 control-label">子任务Key<font color="black">*</font></label>

                        <div class="col-sm-4"><input type="text" class="form-control" name="childJobKey"
                                                     placeholder="请输入子任务的任务Key,如存在多个逗号分隔" maxlength="100"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">报警邮件<font color="red">*</font></label>

                        <div class="col-sm-4"><input type="text" class="form-control" name="alarmEmail"
                                                     placeholder="请输入“报警邮件”，多个邮件地址逗号分隔" maxlength="100"></div>
                        <label class="col-sm-2 control-label">负责人<font color="red">*</font></label>

                        <div class="col-sm-4"><input type="text" class="form-control" name="author"
                                                     placeholder="请输入“负责人”" maxlength="50"></div>
                    </div>
                    <hr>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-6">
                            <button type="submit" class="btn btn-primary">保存</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        </div>
                    </div>
                    <input type="hidden" name="glueRemark" value="GLUE代码初始化">
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 更新.模态框 -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">更新任务</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal form" role="form">
                    <div class="form-group">
                        <label class="col-sm-2 control-label">执行器<font color="red">*</font></label>

                        <div class="col-sm-4">
                            <input type="text" class="form-control jobGroupTitle" maxlength="50" readonly>
                        </div>
                        <label class="col-sm-2 control-label">任务描述<font color="red">*</font></label>

                        <div class="col-sm-4"><input type="text" class="form-control" name="jobDesc"
                                                     placeholder="请输入“描述”" maxlength="50"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">JobHandler<font
                                color="red">*</font></label>

                        <div class="col-sm-4">
                            <div class="input-group">
                                <input type="text" class="form-control" name="executorHandler"
                                       placeholder="请输入“JobHandler”" maxlength="100">
                                <span class="input-group-addon"><b>GLUE</b>&nbsp;<input type="checkbox" class="ifGLUE"></span>
                                <input type="hidden" name="glueSwitch" value="0">
                            </div>
                        </div>
                        <label class="col-sm-2 control-label">执行参数<font color="black">*</font></label>

                        <div class="col-sm-4"><input type="text" class="form-control" name="executorParam"
                                                     placeholder="请输入“执行参数”" maxlength="100"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">Cron<font color="red">*</font></label>

                        <div class="col-sm-4"><input type="text" class="form-control" name="jobCron"
                                                     placeholder="请输入“Cron”" maxlength="20"></div>
                        <label class="col-sm-2 control-label">子任务Key<font color="black">*</font></label>

                        <div class="col-sm-4"><input type="text" class="form-control" name="childJobKey"
                                                     placeholder="请输入子任务的任务Key,如存在多个逗号分隔" maxlength="100"></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">报警邮件<font color="red">*</font></label>

                        <div class="col-sm-4"><input type="text" class="form-control" name="alarmEmail"
                                                     placeholder="请输入“报警邮件”，多个邮件地址逗号分隔" maxlength="100"></div>
                        <label class="col-sm-2 control-label">负责人<font color="red">*</font></label>

                        <div class="col-sm-4"><input type="text" class="form-control" name="author"
                                                     placeholder="请输入“负责人”" maxlength="50"></div>
                    </div>
                    <hr>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-6">
                            <button type="submit" class="btn btn-primary">保存</button>
                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                            <input type="hidden" name="jobGroup">
                            <input type="hidden" name="jobName">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- DataTables -->
<script src="${path}/js/adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${path}/js/adminlte/plugins/datatables/dataTables.bootstrap.min.js"></script>
<script src="${path}/js/adminlte/plugins/jQuery/jquery.validate.min.js"></script>
<!-- daterangepicker -->
<script src="${path}/js/adminlte/plugins/daterangepicker/moment.min.js"></script>
<script src="${path}/js/adminlte/plugins/daterangepicker/daterangepicker.js"></script>
<script>var base_url = '${path}';</script>
<script src="${path}/jsp/schedule/js/jobinfo.index.1.js"></script>
<script src="${path}/jsp/schedule/js/xxl.alert.1.js"></script>
</body>
</html>
