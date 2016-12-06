package com.bestpay.ecurrency.operations.common.constant;

/**
 * 公共常量类
 *
 * User: wen Date:15-11-9 ProjectName: ecurreccy-operations Version: 1.0
 */
public final class CommonConstant {

    /**
     * 私有的构造函数
     */
    private CommonConstant() {
    }

    /**
     * 系统操作人
     */
    public static final String SYSTEM_OPERATOR = "SYSTEM";


    /**
     * sessionKey
     * 1.登陆账户信息
     * 2.图片验证码
     * 3.短信验证码
     */
    public static final String LOGIN_SESSION_KEY = "loginSession";
    public static final String IMG_VALIDATION_CODE = "imgValidationCode";
    public static final String SMS_VALIDATION_CODE = "smsValidationCode";

    /**
     * Ehcache缓存key
     * 1.t_eo_sym_dict
     * 2.t_eo_sym_error
     * 3.t_eo_sym_sysparam
     */
    public static final String INIT_CACHE_KEY = "initCache";
    public static final String EO_SYM_DICT_CACHE_KEY = "EoSymDictCache";
    public static final String EO_SYM_ERROR_CACHE_KEY = "EoSymErrorCache";
    public static final String EO_SYM_SYSPARAM_CACHE_KEY = "EoSymSysparamCache";


}
