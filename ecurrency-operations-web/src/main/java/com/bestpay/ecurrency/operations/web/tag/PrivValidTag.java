package com.bestpay.ecurrency.operations.web.tag;


import com.bestpay.ecurrency.operations.common.util.SpringContextHelper;
import com.bestpay.ecurrency.operations.manager.interfaces.IRoleprivManager;
import com.bestpay.ecurrency.operations.manager.model.LoginBO;
import com.bestpay.ecurrency.operations.manager.model.PrivBO;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.util.List;

import static com.bestpay.ecurrency.operations.common.constant.CommonConstant.LOGIN_SESSION_KEY;

@Data
@Slf4j
public class PrivValidTag extends BodyTagSupport {
	
	private static final long serialVersionUID = 6135630775848652419L;
	
	// 权限URL
	private String privUrl;
	
	@Override
	public int doStartTag() throws JspException {
		int returnFlag = SKIP_BODY;
		HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
		HttpSession session = request.getSession();
		LoginBO loginBO = (LoginBO) session.getAttribute(LOGIN_SESSION_KEY);
		//1.从session中获取权限列表
		List<PrivBO> privBOList = loginBO.getPrivBOList();
		try {
			// 有权限则输出页面内容
			IRoleprivManager roleprivManager = SpringContextHelper.getBean("roleprivManagerImpl");
			if (roleprivManager.validateRolePriv(privBOList,privUrl)) {
				returnFlag = EVAL_BODY_INCLUDE;
			}
		} catch (Exception e) {
			log.info("权限验证时发生错误，默认进行拦截");
			log.error(e.getMessage(),e);
		}
		return returnFlag;
	}

}
