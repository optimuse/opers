/**
 * 简单的ajax再次封装，必须与后台一起使用
 * @param url 请求地址
 * @param data 请求对象
 * @param successCallback 成功回调方法
 * @constructor
 */
function SimpleAjax(obj){
    if ( typeof obj === "object" ) {
        this.options=obj;
    }else{
        console.error("simpleAjax参数传入有误");
    }
}

SimpleAjax.prototype={
    constructor:SimpleAjax,
    post:function(){
        var url = this.options.url;
        var data = this.options.data;
        var successCallback = this.options.successCallback;
        var successMsg = this.options.successMsg;
        var loadingLayer = layer.load(2, {shade: 0.3});
        $.ajax({
            type: "POST",
            url: url,
            data: data,
            dataType: "json",
            success: function(data){
                var flag = data.flag;
                if(typeof(flag)=="undefined"||flag){
                    if(typeof(successMsg)!="undefined"){
                        layer.alert(successMsg,{
                            icon:1,
                            title:'提示'
                        });
                    }else if(typeof(data.successMsg)!="undefined"){
                        layer.alert(data.successMsg,{
                            icon:1,
                            title:'提示'
                        });
                    }
                    successCallback(data);
                }else{
                    layer.alert(data.errMsg,{
                        icon:0,
                        title:'提示'
                    });
                }
                layer.close(loadingLayer);
            },
            error:function (e) {
                console.log(e);
                layer.alert('系统错误，请联系管理员',{
                    icon:0,
                    title:'提示'
                });
                layer.close(loadingLayer);
            }
        });
    }
}




function SimpleForm(formId,obj){
    this.formId = formId;
    if ( typeof obj === "object" ) {
        this.options=obj;
    }else{
        console.error("SimpleForm参数传入有误");
    }
}

SimpleForm.prototype={
    constructor:SimpleForm,
    show:function () {
        var formId = this.formId;
        var options = this.options;
        for(var key in options){
            var _input = "#"+formId+" input[name='"+ key +"']";
           if($(_input).length==0){
               continue;
           }
           $(_input).val(options[key]);
       }
    }

}



function isEmail(str){
    var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
    return reg.test(str);
}

function isPhone(str){
    var reg=/^(\(\d{3,4}\)|\d{3,4}-)?\d{7,8}$/;
    return reg.test(str);
}

function matchPwd(str) {
    var reg=/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$/;
    return reg.test(str);
}

