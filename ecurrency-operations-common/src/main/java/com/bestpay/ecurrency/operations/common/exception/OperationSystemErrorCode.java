package com.bestpay.ecurrency.operations.common.exception;

import com.bestpay.ecurrency.operations.common.util.SpringContextHelper;
import com.bestpay.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.cache.ehcache.EhCacheCacheManager;

import java.util.Map;

import static com.bestpay.ecurrency.operations.common.constant.CommonConstant.EO_SYM_ERROR_CACHE_KEY;
import static com.bestpay.ecurrency.operations.common.constant.CommonConstant.INIT_CACHE_KEY;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/14 ProjectName: ecurrency-operations Version: 1.0
 */
@Slf4j
public enum OperationSystemErrorCode implements ErrorCode {
    USERNAME_OR_PWD_NOT_PASS("2001","用户名或密码错误"),
    ACCOUNT_STAT_NOT_S0A("2002","当前账号已锁定"),
    PARAMETER_VALID_NOT_PASS("2003", "参数校验失败"),
    IMG_VERIFICATION_CODE_NOT_PASS("2004","图片验证码错误"),
    SMS_VERIFICATION_CODE_NOT_PASS("2005","短信验证码错误"),
    USERNAME_NOT_EXIST("2006","用户不存在"),
    USER_NEED_PRIVILEGE("2007","当前用户没有任何权限，请联系管理员赋权"),
    USERNAME_ALREADY_BEEN_REGISTERED("2008","该用户名已被注册"),
    BESTPAYCARD_NOT_FOUND("2009","没有查询到该翼支付卡的卡信息"),
    CARDNO_CANNOT_EMPTY("2010","卡号不能为空"),
    ADMIN_CAN_NOT_BE_LOCKED("2011","管理员账号不能被锁定"),
    DATABASE_SELECT_FAILED("3001", "数据查询失败"),
    DATABASE_INSERT_FAILED("3002", "数据插入失败"),
    DATABASE_UPDATE_FAILED("3003", "数据更新失败"),
    DATABASE_DELETE_FAILED("3004", "数据删除失败"),
    DATABASE_NOT_RESULT("3005","没有查询到结果"),
    ERROR_DESC_NOT_FOUND("9998","请求失败，未能获取错误描述"),
    SYSTEM_ERROR("9999","系统错误"),;

    /**
     * 异常码
     */
    private String code;

    /**
     * 异常描述
     */
    private String desc;


    OperationSystemErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        EhCacheCacheManager cacheManager = SpringContextHelper.getBean("cacheManager");
        String descStr = null;
        try {
            Map<String,String> errDescMap = null;
            errDescMap = (Map<String, String>) cacheManager.getCacheManager().getCache(INIT_CACHE_KEY).get(EO_SYM_ERROR_CACHE_KEY).getObjectValue();
            descStr = errDescMap.get(code);
            if(StringUtils.isBlank(descStr)){
                log.info("错误描述为空");
                descStr = ERROR_DESC_NOT_FOUND.desc;
            }
        } catch (Exception e) {
            log.info("从缓存中获取错误描述失败，使用默认描述");
            log.error(e.getMessage(),e);
            descStr = desc;
        }
        return descStr;
    }




}
