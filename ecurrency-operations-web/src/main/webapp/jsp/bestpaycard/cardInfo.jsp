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
    <title>${platformName} - 翼支付卡信息查询</title>
</head>

<body class="gray-bg">
<div class="wrapper wrapper-content animated fadeInRight">
    <div class="row">
        <div class="col-md-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title" data-toggle="collapse" data-target="#collapseDiv">
                    <h5>查询条件</h5>
                </div>
                <div class="ibox-content collapse in" id="collapseDiv" >
                    <div class="row">
                        <div class="col-sm-12">
                            <form role="form" class="form-horizontal" id="queryCardInfoForm">
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label class="col-sm-1 control-label red-star">卡号：</label>
                                        <div class="col-sm-2">
                                            <input id="cardNo" name="cardNo" placeholder="卡号" class="form-control"
                                                   type="text"
                                                   required="">
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-4 col-sm-offset-1">
                                        <div class="col-sm-2">
                                            <button class="btn btn-primary" type="button"
                                                    onclick="javascript:queryCardInfo();">查询
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

        <div class="col-md-12">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>查询结果</h5>
                </div>
                <div class="ibox-content">
                    <div class="row">
                        <div class="col-sm-12">
                            <form role="form" class="form-horizontal" id="showCardInfoForm">
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label class="col-sm-1 control-label">卡号：</label>
                                        <div class="col-sm-2">
                                            <input name="cardNo" placeholder="卡号" class="form-control"
                                                   type="text" readonly="readonly"
                                                   >
                                        </div>
                                        <label class="col-sm-1 control-label">卡状态：</label>
                                        <div class="col-sm-2">
                                            <input name="cardState" placeholder="卡状态" class="form-control"
                                                   type="text" readonly="readonly"
                                                   >
                                        </div>
                                        <label class="col-sm-1 control-label">卡面值(元)：</label>
                                        <div class="col-sm-2">
                                            <input name="cardValue" placeholder="卡面值(元)" class="form-control"
                                                   type="text" readonly="readonly"
                                                  >
                                        </div>
                                        <label class="col-sm-1 control-label">有效期：</label>
                                        <div class="col-sm-2">
                                            <input name="expDate" placeholder="有效期" class="form-control"
                                                   type="text" readonly="readonly"
                                                  >
                                        </div>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-sm-12">
                                        <label class="col-sm-1 control-label">余额(元)：</label>
                                        <div class="col-sm-2">
                                            <input name="totalBal" placeholder="余额(元)" class="form-control"
                                                   type="text" readonly="readonly"
                                                  >
                                        </div>
                                        <label class="col-sm-1 control-label">可用金额(元)：</label>
                                        <div class="col-sm-2">
                                            <input name="validBal" placeholder="可用金额(元)" class="form-control"
                                                   type="text" readonly="readonly"
                                                   >
                                        </div>
                                        <label class="col-sm-1 control-label">冻结金额(元)：</label>
                                        <div class="col-sm-2">
                                            <input name="frozenBal" placeholder="冻结金额(元)" class="form-control"
                                                   type="text" readonly="readonly"
                                                   >
                                        </div>
                                        <div class="col-sm-3">
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
</div>



<script src="${path}/js/common.js?v=1.0.0"></script>

<script>
    var _path = "${path}";
</script>
<script src="${path}/jsp/bestpaycard/js/cardInfo.js?v=1.0.0"></script>
<!-- 自定义js -->
<script src="${path}/js/content.js?v=1.0.0"></script>
</body>

</html>

