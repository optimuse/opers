package com.bestpay.ecurrency.operations.web.controller.system;

import com.bestpay.ecurrency.operations.common.exception.OperationSystemErrorCode;
import com.bestpay.ecurrency.operations.common.exception.OperationsSystemException;
import com.bestpay.ecurrency.operations.common.util.BeanMapperUtil;
import com.bestpay.ecurrency.operations.dal.model.EoSymDictDO;
import com.bestpay.ecurrency.operations.manager.interfaces.ILoginManager;
import com.bestpay.ecurrency.operations.manager.interfaces.ISmsManager;
import com.bestpay.ecurrency.operations.manager.model.LoginBO;
import com.bestpay.ecurrency.operations.web.model.LoginDTO;
import com.bestpay.utils.MessageHelper;
import com.google.common.collect.Table;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.bestpay.ecurrency.operations.common.constant.CommonConstant.*;


/**
 * 登陆相关Controller
 * <p>
 * 1.访问登陆页面
 * 2.验证登陆
 * 3.进入首页面
 * 4.获取图片验证码
 * </p>
 * User: Jwxa Date: 2016/11/10 ProjectName: ecurreccy-operations Version: 1.0
 */
@Controller
@Slf4j
public class LoginController {


    @Autowired
    private ISmsManager smsManager;

    @Autowired
    private ILoginManager loginManager;

    @Autowired
    private EhCacheCacheManager cacheManager;

    /**
     * 访问登陆页面
     *
     * @return 登陆页面
     */
    @RequestMapping(value = "/login.do", method = RequestMethod.GET)
    public String showLoginPage(HttpSession session) {
        if (session.getAttribute(LOGIN_SESSION_KEY) != null) {
            return "redirect:/index.do";
        }
        return "system/login";
    }


    /**
     * 验证登陆
     *
     * @return 首页面或者回显原页面
     */
    @RequestMapping(value = "/toLogin.do", method = RequestMethod.POST)
    public String toLogin(@Valid LoginDTO loginDTO, HttpServletRequest request, HttpSession session, BindingResult result) {
        try {
            if (result.hasErrors()) {
                throw new OperationsSystemException(OperationSystemErrorCode.PARAMETER_VALID_NOT_PASS);
            }
            LoginBO loginBO = BeanMapperUtil.objConvert(loginDTO, LoginBO.class);
            String imgValidationCode = (String) session.getAttribute(IMG_VALIDATION_CODE);
            log.debug("验证图片验证码:{}", imgValidationCode);
            if (!loginBO.getImgVerificationCode().equals(imgValidationCode)) {
                throw new OperationsSystemException(OperationSystemErrorCode.IMG_VERIFICATION_CODE_NOT_PASS);
            }
            String smsValidationCode = (String) session.getAttribute(SMS_VALIDATION_CODE);
            log.debug("验证短信验证码:{}", smsValidationCode);
            if (!loginBO.getSmsVerificationCode().equals(smsValidationCode)) {
                throw new OperationsSystemException(OperationSystemErrorCode.SMS_VERIFICATION_CODE_NOT_PASS);
            }
            log.debug("验证账号密码:{}", loginDTO);
            loginBO = loginManager.validateLogin(loginBO);
            session.removeAttribute(SMS_VALIDATION_CODE);
            session.removeAttribute(IMG_VALIDATION_CODE);
            session.setAttribute(LOGIN_SESSION_KEY, loginBO);
            return "redirect:/index.do";
        } catch (OperationsSystemException e) {
            session.removeAttribute(SMS_VALIDATION_CODE);
            session.removeAttribute(IMG_VALIDATION_CODE);
            request.setAttribute("loginDTO", loginDTO);
            request.setAttribute("errMsg", e.getErrMsg());
            return "system/login";
        }
    }


    /**
     * 图片验证码
     */
    @RequestMapping(value = "/jcaptcha.do", method = RequestMethod.GET)
    public void jcaptcha(HttpServletResponse response, HttpSession session) {
        response.setContentType("image/png");
        response.setHeader("cache", "no-cache");
        OutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            BufferedImage bufferedImage = loginManager.createJcaptcha(session);
            ImageIO.write(bufferedImage, "png", outputStream);
            outputStream.flush();
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                }
            }
        }

    }

    /**
     * 生成6位验证码
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/sendSmsValidate.do")
    public Map<String, Object> sendSmsValidate(LoginDTO loginDTO, HttpSession session){
        Map<String, Object> resultMap = new HashMap<>();
        if (loginDTO != null && StringUtils.isNotBlank(loginDTO.getUsername())) {
            String mobile = loginManager.queryMobileByUsername(loginDTO.getUsername());
            if (StringUtils.isNotBlank(mobile)) {
                String ranD = (Math.random() + "").substring(2, 8);
                session.removeAttribute(SMS_VALIDATION_CODE);
                session.setAttribute(SMS_VALIDATION_CODE, ranD);
                log.info("用户名:{},验证码:{},手机号:{}", loginDTO.getUsername(), ranD, mobile);
                //插入数据库等待定时任务发送
                //TODO 如果缓存中获取不到的异常处理
                Table<String,String,EoSymDictDO>  dictTable = (Table<String, String, EoSymDictDO>) cacheManager.getCacheManager().getCache(INIT_CACHE_KEY).get(EO_SYM_DICT_CACHE_KEY).getObjectValue();
                String cacheSmsTemplate = dictTable.get("SMS_TEMPLATE","SMS_LOGIN").getDictName();
                String msgBody = MessageHelper.formatMsg(cacheSmsTemplate, ranD);
                smsManager.insertSms(msgBody, mobile);
                //TODO 由字典表中获取
                resultMap.put("successMsg","短信已发送，请注意查收");
            }
        } else {
            throw new OperationsSystemException(OperationSystemErrorCode.PARAMETER_VALID_NOT_PASS);
        }
        return resultMap;
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session) {
        session.removeAttribute(LOGIN_SESSION_KEY);
        return "redirect:/login.do";
    }

}
