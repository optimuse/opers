//验证码
function refreshCode() {
    var imgObj = document.getElementById("validationCode");
    var url = _path+"/jcaptcha.do?";
    imgObj.src = url + Math.random();
}


function sendSmsVerificationCode(btnObj){
    $.ajax({
            type: "POST",
            url: _path + "/sendSmsValidate.do",
            data: {
                username:$("#username").val()
            },
            dataType: "json",
            success: function(data){
                var flag = data.flag;
                if(typeof(flag)=="undefined"||flag){
                    var successMsg = data.successMsg;
                    layer.alert(successMsg,{
                        icon:1,
                        title:'提示'
                    });
                    var timer = new Timer(60,btnObj,1000);
                    timer.start();
                }else{
                    layer.alert(data.errMsg,{
                        icon:0,
                        title:'提示'
                    });
                }
            },
            error:function (e) {
                console.log(e);
                layer.alert('系统错误，请联系管理员',{
                    icon:0,
                    title:'提示'
                });
            }
        });

}


/**
 * 计时器
 * @param lastNum 最大数开始-1
 * @param bindBtn 绑定显示字符的btn
 * @param interval 间隔时间 毫秒
 */
function Timer(lastNum,bindBtnObj,interval){
    this.lastNum=lastNum;
    this.bindBtnObj=bindBtnObj;
    this.interval=interval;
}

Timer.prototype={
    constructor: Timer,
    start:function () {
        var lastNum = this.lastNum;
        var bindBtnObj = this.bindBtnObj;
        var interval = this.interval;
        $(bindBtnObj).attr("disabled","disabled");
        var _interval = setInterval(function () {
            if(lastNum == 0){
                window.clearInterval(_interval);
                $(bindBtnObj).attr("disabled",false);
                $(bindBtnObj).text("获取动态码");
            }else{
                $(bindBtnObj).text("等待("+lastNum--+"秒)");
            }
        },interval);
    }
}

