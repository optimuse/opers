package com.bestpay.ecurrency.operations.web.controller.system;

import com.bestpay.ecurrency.operations.manager.interfaces.IIndexManager;
import com.bestpay.ecurrency.operations.manager.model.LoginBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.bestpay.ecurrency.operations.common.constant.CommonConstant.LOGIN_SESSION_KEY;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/17 ProjectName: ecurrency-operations Version: 1.0
 */
@Controller
public class IndexController {

    @Autowired
    private IIndexManager indexManager;

    /**
     * 进入首页面
     *
     * @return
     */
    @RequestMapping(value = "/index.do", method = RequestMethod.GET)
    public String index(HttpServletRequest request, HttpSession session) {
        LoginBO loginBO = (LoginBO) session.getAttribute(LOGIN_SESSION_KEY);
        String menu = indexManager.createMenuHtml(request.getContextPath(),loginBO);
        request.setAttribute("menu",menu);
        return "system/index";
    }
}
