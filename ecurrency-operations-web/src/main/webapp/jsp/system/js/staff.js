$("#showAddBtn").click(function (event) {
    event.stopPropagation();
    $("#addStaffDiv").modal({
        keyboard: true,
        backdrop: false
    });
});
/**
 * 添加用户信息
 */
function addStaff() {
    var email = $("#addStaffForm input[name='email']").val();
    if (!isEmail(email)) {
        layer.alert('Email格式不符', {
            icon: 0,
            title: '提示'
        });
        return false;
    }
    var mobile = $("#addStaffForm input[name='mobile']").val();
    if (typeof (mobile) == 'undefined' || mobile == '' || mobile.length != 11) {
        layer.alert('移动电话格式不符', {
            icon: 0,
            title: '提示'
        });
        return false;
    }
    var phone = $("#addStaffForm input[name='phone']").val();
    ;
    if (typeof (phone) != 'undefined' && phone != '' && !isPhone(phone)) {
        layer.alert('固定电话格式不符', {
            icon: 0,
            title: '提示'
        });
        return false;
    }
    var zip = $("#addStaffForm input[name='zip']").val();
    if (typeof (zip) != 'undefined' && zip != '' && zip.length != 6) {
        layer.alert('邮政编码格式不符', {
            icon: 0,
            title: '提示'
        });
        return false;
    }

    var password = $("#addStaffForm input[name='password']").val();
    var passwordConfirm = $("#addStaffForm input[name='passwordConfirm']").val();
    if (!matchPwd(password) || !matchPwd(passwordConfirm)) {
        layer.alert('密码格式不符', {
            icon: 0,
            title: '提示'
        });
        return false;
    }
    if (password != passwordConfirm) {
        layer.alert('两次输入的密码不一致', {
            icon: 0,
            title: '提示'
        });
        return false;
    }
    console.log($("#addStaffForm").serialize());
    var sAjax = new SimpleAjax({
        url: _path + "/sym/addStaff.do",
        data: $("#addStaffForm").serialize(),
        successCallback: function (data) {
            //添加成功后页面默认搜索该用户名并关闭模态框
            $("#queryStaffForm")[0].reset();
            $("#staffId").val($("#addStaffForm input[name=staffId]").val());
            queryStaff();
            $("#addStaffDiv").modal('hide');
        }
    });
    sAjax.post();
    return false;
}

function queryParams(params) {
    return {
        limit: params.limit,
        offset: params.offset,
        order: params.order,
        search: params.search,
        sort: params.sort,
        staffId: $("#staffId").val(),
        staffName: $("#staffName").val(),
        sex:$("#sex").val()
    };
}

function operateFormatter(value, row, index) {
    var showStr = '<a class="showAllocateRoleDiv" href="javascript:void(0)">';
    showStr +='<i class="glyphicon glyphicon-user">分配角色</i>';
    showStr +='</a>  ';
    if(row.stat=='有效'){
        showStr +='<a class="lock" href="javascript:void(0)">';
        showStr +='<i class="glyphicon glyphicon-lock">锁定用户</i>';
        showStr +='</a>  ';
    }else{
        showStr +='<a class="unlock" href="javascript:void(0)">';
        showStr +='<i class="glyphicon glyphicon-lock">解锁用户</i>';
        showStr +='</a>  ';
    }
    return showStr;
}

window.operateEvents = {
    'click .showAllocateRoleDiv': function (e, value, row, index) {
        var staffId = row.staffId;
        var sAjax = new SimpleAjax({
            url: _path + "/sym/queryRoleList.do",
            data: {
                staffId: staffId
            },
            successCallback: function (data) {
                $("#allocateStaffId").val(staffId);
                var roleList = data.roleList;
                if(roleList){
                    for(var i=0;i<roleList.length;i++){
                        var allObj = $("#roleTree").jstree()._model.data;
                        for(var key in allObj){
                            var roleId = allObj[key].original;
                            if(roleId){
                                roleId=roleId.attr.id;
                            }else{
                                $("#roleTree").jstree().uncheck_node(allObj[key]);
                            }
                            console.log(roleId);
                            console.log(roleList[i].roleId);
                            if(roleId==roleList[i].roleId){
                                console.log(roleId);
                                $("#roleTree").jstree().check_node(allObj[key]);
                            }
                        }
                        // $("#roleTree").jstree("get_checked");
                    }
                }else{
                    //如果为空 代表没有权限信息
                    var allObj = $("#roleTree").jstree()._model.data;
                    for(var key in allObj){
                        $("#roleTree").jstree().uncheck_node(allObj[key]);
                    }
                }
                //模态框显示
                $("#allocateRoleDiv").modal({
                    keyboard: true,
                    backdrop: false
                });

            }
        });
        sAjax.post();

        //loadRoleTree("roleTree",row.staffName)
    },
    'click .lock': function (e, value, row, index) {
        lockStaff(row.staffId);
    },
    'click .unlock': function (e, value, row, index) {
        unlockStaff(row.staffId);
    }
};
/**
 * 查询用户列表
 */
function queryStaff() {
    $('#staffTable').bootstrapTable('destroy');
    $('#staffTable').bootstrapTable(
        {
            url: _path + "/sym/queryStaffList.do",
            undefinedText: '-',
            pagination: true, // 分页
            striped: true, // 是否显示行间隔色
            method: 'post',
            queryParams: queryParams,//查询条件
            cache: false, // 是否使用缓存
            pageList: [5, 10, 20],
            toolbar: "#toolbar",// 指定工具栏
            showColumns: true, // 显示隐藏列
            showRefresh: true, // 显示刷新按钮
            uniqueId: "staffId", // 每一行的唯一标识
            sidePagination: "server", // 服务端处理分页server,本地client
            showToggle: false,//是否显示详细视图和列表视图的切换按钮
            sortable: false, //是否启用排序
            sortOrder: "asc", //排序方式
           /* onSort: function (name,order) {
               alert(JSON.stringify(name));
                alert(JSON.stringify(order));
            },*/
            columns: [/*{
             field: 'state',
             checkbox: true,
             align: 'center',
             valign: 'middle'
             }, */{
                title: '用户名',
                field: 'staffId', // 字段
                align: 'center', // 对齐方式（左 中 右）
                valign: 'middle', //
                sortable: true
            }, {
                title: '真实姓名',
                field: 'staffName',
                align: 'center',
                valign: 'middle',
                sortable: true
            }, {
                title: '用户性别',
                field: 'sex',
                align: 'center',
                valign: 'middle',
                sortable: true
            }, {
                title: '用户状态',
                field: 'stat',
                align: 'center',
                valign: 'middle',
                sortable: true
            }, {
                field: 'operate',
                title: '操作',
                align: 'center',
                events: operateEvents,
                formatter: operateFormatter
            }

            ],
            responseHandler: function (res) {
                return {
                    total: res.table.total,
                    rows: res.table.records
                };
            }
        }
    );

}
/**
 * 锁定用户
 */
function lockStaff(staffId){
    var sAjax = new SimpleAjax({
        url: _path + "/sym/lockStaff.do",
        data: {
            staffId:staffId
        },
        successCallback: function (data) {
            $('#staffTable').bootstrapTable('refresh');
        }
    });
    layer.confirm('确认要锁定该用户？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        sAjax.post();
    }, function(){
        return;
    });
}


/**
 * 解锁用户
 */
function unlockStaff(staffId){
    var sAjax = new SimpleAjax({
        url: _path + "/sym/unlockStaff.do",
        data: {
            staffId:staffId
        },
        successCallback: function (data) {
            $('#staffTable').bootstrapTable('refresh');
        }
    });
    layer.confirm('确认要解锁该用户？', {
        btn: ['确定','取消'] //按钮
    }, function(){
        sAjax.post();
    }, function(){
        return;
    });
}


/**
 * 分配角色
 */
function allocateRole(){
    var nodeArray = getNode("roleTree");
    console.log(nodeArray);
    if(nodeArray){
        //有选择了的节点 需要进行比较删除去掉的权限，新增选中的权限
        var sAjax = new SimpleAjax({
            url: _path + "/sym/allocateRole.do",
            data: {
                nodeArray:nodeArray,
                staffId:$("#allocateStaffId").val()
            },
            successCallback: function (data) {
                $("#allocateRoleDiv").modal('hide');
            }
        });
        sAjax.post();
    }else{
        //没有选择任何节点，删除该用户的所有权限
        layer.confirm('确认要删除所有角色?用户将无法正常使用', {
            btn: ['确定','取消'] //按钮
        }, function(){
            var sAjax = new SimpleAjax({
                url: _path + "/sym/delRole.do",
                data: {
                    staffId:$("#allocateStaffId").val()
                },
                successCallback: function (data) {
                    $("#allocateRoleDiv").modal('hide');
                }
            });
            sAjax.post();
        }, function(){
            return;
        });
    }

    return false;
}

function loadRoleTree(){
    $("#roleTree").data('jstree', false).empty();
    $.ajax({
        type: "POST",
        url: _path + "/sym/queryRoleList.do",
        data: {},
        dataType: "json",
        success: function (data) {
            var jsTreeConf = {
                'plugins': ['checkbox']
            };
            var configObj = $.extend(data.jsTreeObj, jsTreeConf);
            $("#roleTree").jstree(
                configObj
            );
        }
    });

    ;
    // $("#" + jsTreeId).jstree("hide_checkboxes");//隐藏多选框
}

function getNode(jsTreeId){
    //获得选中节点的id数组，可能为空
    var id = $("#" + jsTreeId).jstree("get_checked");
    //获取选中的节点
    if(id.length==0){
        console.log("没有选中的节点");
        return false;
    }else{
        var node =  new Array();
        for(var i=0;i<id.length;i++){
            node[i] = $("#" + jsTreeId).jstree("get_node", id[i]).original.attr.id;
        }
        return node;
    }
}