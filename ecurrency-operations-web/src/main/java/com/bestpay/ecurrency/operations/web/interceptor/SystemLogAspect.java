package com.bestpay.ecurrency.operations.web.interceptor;

import com.bestpay.ecurrency.operations.manager.model.LoginBO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.bestpay.ecurrency.operations.common.constant.CommonConstant.LOGIN_SESSION_KEY;

/**
 * 切面类
 * 通过AOP将访问Controller页面的方法中获取ip信息的代码提取至此
 * Created by Jwxa on 2015/7/5.
 */
@Aspect
@Component
@Slf4j
public class SystemLogAspect implements Ordered {



    /**
     * Controller层切点
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public  void controllerAspect() {
    }

    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        //请求的IP
        String ip = request.getRemoteAddr();
        LoginBO loginBO = (LoginBO) session.getAttribute(LOGIN_SESSION_KEY);
        try {
            String userName = "";
            if(loginBO!=null&&StringUtils.isNotBlank(loginBO.getUsername())){
                userName = loginBO.getUsername();
            }
            //日志格式[用户账号][IP][请求地址][执行方法]
            log.info("用户名:[{}],IP:[{}],请求地址:[{}],请求方法:[{}]",userName,ip,request.getRequestURI(),(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
        } catch (Exception e) {
            log.error(e.getMessage(),e);
        }
    }


    @Override
    public int getOrder() {
        return 1;
    }
}
