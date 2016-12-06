package com.bestpay.ecurrency.operations.web.interceptor;

import com.bestpay.ecurrency.operations.common.exception.NoPrivilegeException;
import com.bestpay.ecurrency.operations.manager.interfaces.IRoleprivManager;
import com.bestpay.ecurrency.operations.manager.model.LoginBO;
import com.bestpay.ecurrency.operations.manager.model.PrivBO;
import com.bestpay.ecurrency.operations.web.interceptor.annotation.PrivilegeValidate;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.List;

import static com.bestpay.ecurrency.operations.common.constant.CommonConstant.LOGIN_SESSION_KEY;

/**
 * 切面类
 * 通过AOP将访问Controller页面的方法中获取ip信息的代码提取至此
 * Created by Jwxa on 2015/7/5.
 */
@Aspect
@Component
@Slf4j
public class PrivilegeValidateAspect implements Ordered {

    @Autowired
    private IRoleprivManager roleprivManager;

    /**
     * Controller层切点
     */
    @Pointcut("@annotation(com.bestpay.ecurrency.operations.web.interceptor.annotation.PrivilegeValidate)")
    public void privilegeValidateAspect() {
    }

    @Before("privilegeValidateAspect()")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session = request.getSession();
        LoginBO loginBO = (LoginBO) session.getAttribute(LOGIN_SESSION_KEY);
        List<PrivBO> privBOList = loginBO.getPrivBOList();
        String privKey = getAnnotationPrivKey(joinPoint);
        boolean flag = roleprivManager.validateRolePriv(privBOList, privKey);
        if (!flag){
            throw new NoPrivilegeException();
        }
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getAnnotationPrivKey(JoinPoint joinPoint)
            throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String privKey = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    privKey = method.getAnnotation(PrivilegeValidate. class).privKey();
                    break;
                }
            }
        }
        return privKey;
    }


    @Override
    public int getOrder() {
        return 2;
    }
}
