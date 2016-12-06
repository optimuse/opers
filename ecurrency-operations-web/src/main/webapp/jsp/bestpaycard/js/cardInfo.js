function queryCardInfo() {
    var sAjax = new SimpleAjax({
        url: _path + "/bestpaycard/queryCardInfo.do",
        data: $("#queryCardInfoForm").serialize(),
        successCallback: function (data) {
            var obj = data.bestpayCardInfoDTO;
            var sForm = new SimpleForm('showCardInfoForm',{
                cardNo:obj.cardNo,
                cardState:obj.cardState,
                cardValue:obj.cardValue,
                expDate:obj.expDate,
                totalBal:obj.totalBal,
                validBal:obj.validBal,
                frozenBal:obj.frozenBal
            });
            sForm.show();
        }
    });
    sAjax.post();
}