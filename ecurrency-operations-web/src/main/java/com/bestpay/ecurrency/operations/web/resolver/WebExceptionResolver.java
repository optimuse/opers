package com.bestpay.ecurrency.operations.web.resolver;

import com.bestpay.ecurrency.operations.common.exception.NoPrivilegeException;
import com.bestpay.ecurrency.operations.common.exception.OperationsSystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 公共异常处理
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/14 ProjectName: ecurrency-operations Version: 1.0
 */
@Slf4j
public class WebExceptionResolver implements HandlerExceptionResolver {

    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object handler, Exception ex) {
        log.error("system catch exception:{}", ex);
        ModelAndView mv = new ModelAndView();
        HandlerMethod method = (HandlerMethod) handler;
        ResponseBody responseBody = method.getMethodAnnotation(ResponseBody.class);
        if (responseBody != null) {
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            Map<String,Object> attributes = new HashMap<>();
//            response.setContentType("application/json;charset=UTF-8");
            if (ex instanceof OperationsSystemException) {
                //由于是已知的异常，所以自己组装返回报文，交给前端ajax处理
                OperationsSystemException e = (OperationsSystemException) ex;
                attributes.put("flag", false);
                attributes.put("errMsg", e.getErrMsg());
            }else if (ex instanceof NoPrivilegeException) {
                //403错误 没有权限
                attributes.put("flag", false);
                attributes.put("errMsg", "当前用户没有权限发起该请求");
            } else {
                //继续向上抛,由ajax捕获
                throw new RuntimeException(ex);
            }
            view.setAttributesMap(attributes);
            mv.setView(view);
        } else {
            if (ex instanceof NoPrivilegeException) {
                //没有权限
                mv.setViewName("errorpage/403");
            }else{
                //展示错误页面
                mv.setViewName("errorpage/500");
            }
        }
        return mv;
    }

}