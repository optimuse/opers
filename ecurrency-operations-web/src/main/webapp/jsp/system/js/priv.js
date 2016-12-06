function PrivList(jsTreeId, reloadBtnId) {
    this.jsTreeId = jsTreeId;
    this.reloadBtnId = reloadBtnId;
    var that = this;
    var _bind = function () {
        $("#" + that.jsTreeId).on('changed.jstree', function (obj, e) {
            // 处理代码
            // 获取当前节点
            var currentNode = e.node;
            // console.log("当前选择的节点privID为" + currentNode.original.attr.id);
            var privDetail = new PrivDetail();
            privDetail.showPrivInfo(currentNode.original.attr.id);
        });
    };
    $("#" + reloadBtnId).bind('click', function () {
        that.load(_bind);
    });
    this.load(_bind);
}
PrivList.prototype = {
    constructor: PrivList,
    load: function (callback) {
        var jsTreeId = this.jsTreeId;
        var _interval = this.onload();
        var _loaded = this.loaded;
        $("#" + jsTreeId).data('jstree', false).empty();
        $.ajax({
            type: "GET",
            url: _path + "/sym/queryPrivInfo.do",
            data: {},
            dataType: "json",
            success: function (data) {
                var jsTreeConf = {
                    'plugins': ['dnd', "wholerow"],
                    'types': {
                        'default': {
                            'icon': 'fa fa-folder'
                        },
                    }
                };
                var configObj = $.extend(data.jsTreeObj, jsTreeConf);
                $("#" + jsTreeId).jstree(
                    configObj
                );
                _loaded(_interval);
                callback();
            }
        });
    },
    onload: function () {
        var degree = 0;
        var reloadBtnObj = $("#" + this.reloadBtnId);
        return setInterval(function () {
            reloadBtnObj.removeClass("fa-rotate-" + degree);
            degree += 90;
            reloadBtnObj.addClass("fa-rotate-" + degree);
            if (degree == 360) {
                degree = 0;
            }
        }, 125);
    },
    loaded: function (_interval) {
        var reloadBtnObj = $("#" + this.reloadBtnId);
        window.clearInterval(_interval);
    },
}

function PrivDetail() {
}
PrivDetail.prototype = {
    constructor: PrivDetail,
    showPrivInfo: function (privId) {
        var sAjax = new SimpleAjax({
            url: _path + "/sym/queryPrivInfoDetail.do",
            data: {
                privId: privId
            },
            successCallback: function (data) {
                var obj = data.privResp;
                var sForm = new SimpleForm('privInfoForm',{
                    privId: obj.privId,
                    privName: obj.privName,
                    privType: obj.privType,
                    privUrl: obj.privUrl,
                    privImg: obj.privImg
                });
                sForm.show();
            }
        });
        sAjax.post();
    }
}


function modifyPriv() {
    //询问框
    layer.confirm('确认修改?', {
        btn: ['确认', '取消'] //按钮
    }, function () {
        var sAjax = new SimpleAjax({
            url: _path + "/sym/modifyPrivInfo.do",
            data: $("#privInfoForm").serialize(),
            successCallback: function (data) {
                new PrivList("privTree", "refreshBtn").load();
            },
            successMsg: '修改成功'
        });
        sAjax.post();
    }, function () {

    });


}


function showAddPrivForm(){

}