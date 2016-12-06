<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <jsp:include page="../common/imports.jsp"/>
    <title>${platformName} - 日志管理</title>
    <link href="${path}/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${path}/js/adminlte/plugins/daterangepicker/daterangepicker-bs3.css">
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
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>调度日志
                <small>任务调度中心</small>
            </h1>
        </section>

        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-3">
                    <div class="input-group">
                        <span class="input-group-addon">执行器</span>
                        <select class="form-control" id="jobGroup" paramVal="${jobGroup}">
                            <option value="0" selected>请选择</option>
                            <c:forEach var="group" items="${JobGroupList}">
                                <option value="${group.id}">${group.title}</option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="input-group">
                        <span class="input-group-addon">描述</span>
                        <select class="form-control" id="jobName" paramVal="${jobName}">
                            <option value="">请选择</option>
                        </select>
                    </div>
                </div>
                <div class="col-xs-4">
                    <div class="input-group">
                		<span class="input-group-addon">
	                  		调度时间
	                	</span>
                        <input type="text" class="form-control" id="filterTime" readonly
                               value2="<c:if test="${not empty triggerTimeStart && (not empty triggerTimeEnd)}" >
                   <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${triggerTimeStart}" />-<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${triggerTimeEnd}" />
                   </c:if>"/>
                    </div>
                </div>


                <div class="col-xs-2">
                    <button class="btn btn-block btn-info" id="searchBtn">搜索</button>
                </div>
            </div>

            <div class="row">
                <div class="col-xs-12">
                    <div class="box">
                        <div class="box-header hide"><h3 class="box-title">调度日志</h3></div>
                        <div class="box-body">
                            <table id="joblog_list" class="table table-bordered table-striped display" width="100%">
                                <thead>
                                <tr>
                                    <th name="id">id</th>
                                    <th name="jobGroup">任务组</th>
                                    <th name="jobName">任务名</th>
                                    <th name="executorAddress">执行器地址</th>
                                    <th name="executorHandler">JobHandler</th>
                                    <th name="executorParam">任务参数</th>
                                    <th name="triggerTime">调度时间</th>
                                    <th name="triggerStatus">调度结果</th>
                                    <th name="triggerMsg">调度备注</th>
                                    <th name="handleTime">执行时间</th>
                                    <th name="handleStatus">执行结果</th>
                                    <th name="handleMsg">执行备注</th>
                                    <th name="handleMsg">操作</th>
                                </tr>
                                </thead>
                                <tbody></tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<!-- DataTables -->
<script src="${path}/js/adminlte/plugins/datatables/jquery.dataTables.min.js"></script>
<script src="${path}/js/adminlte/plugins/datatables/dataTables.bootstrap.min.js"></script>
<!-- daterangepicker -->
<script src="${path}/js/adminlte/plugins/daterangepicker/moment.min.js"></script>
<script src="${path}/js/adminlte/plugins/daterangepicker/daterangepicker.js"></script>
<script>var base_url = '${path}';</script>
<script src="${path}/jsp/schedule/js/xxl.alert.1.js"></script>
<script src="${path}/jsp/schedule/js/joblog.index.1.js"></script>
</body>
</html>

