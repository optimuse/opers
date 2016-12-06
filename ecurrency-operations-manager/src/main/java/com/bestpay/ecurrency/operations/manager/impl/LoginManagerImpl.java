package com.bestpay.ecurrency.operations.manager.impl;

import com.bestpay.ecurrency.operations.common.exception.OperationSystemErrorCode;
import com.bestpay.ecurrency.operations.common.exception.OperationsSystemException;
import com.bestpay.ecurrency.operations.common.util.BeanMapperUtil;
import com.bestpay.ecurrency.operations.common.util.TreeBuilder;
import com.bestpay.ecurrency.operations.dal.mapper.*;
import com.bestpay.ecurrency.operations.dal.model.*;
import com.bestpay.ecurrency.operations.manager.interfaces.ILoginManager;
import com.bestpay.ecurrency.operations.manager.model.LoginBO;
import com.bestpay.ecurrency.operations.manager.model.PrivBO;
import lombok.extern.slf4j.Slf4j;
import org.patchca.background.BackgroundFactory;
import org.patchca.color.ColorFactory;
import org.patchca.color.RandomColorFactory;
import org.patchca.filter.ConfigurableFilterFactory;
import org.patchca.filter.library.AbstractImageOp;
import org.patchca.filter.library.WobbleImageOp;
import org.patchca.font.RandomFontFactory;
import org.patchca.service.Captcha;
import org.patchca.service.ConfigurableCaptchaService;
import org.patchca.text.renderer.BestFitTextRenderer;
import org.patchca.text.renderer.TextRenderer;
import org.patchca.word.RandomWordFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static com.bestpay.ecurrency.operations.common.constant.CommonConstant.IMG_VALIDATION_CODE;
import static com.bestpay.ecurrency.operations.common.util.MD5Util.MD5;

/*
 * Created by Jwxa on 2016/11/9.
 */
@Service
@Slf4j
public class LoginManagerImpl implements ILoginManager {

    private ConfigurableCaptchaService configurableCaptchaService = null;
    private ColorFactory colorFactory = null;
    private RandomFontFactory fontFactory = null;
    private RandomWordFactory wordFactory = null;
    private TextRenderer textRenderer = null;

    @Autowired
    private EoSymStaffMapper eoSymStaffMapper;

    @Autowired
    private EoSymStaffRoleMapper eoSymStaffRoleMapper;

    @Autowired
    private EoSymRoleMapper eoSymRoleMapper;

    @Autowired
    private EoSymPrivMapper eoSymPrivMapper;

    @Autowired
    private EoSymRolePrivMapper eoSymRolePrivMapper;

    @PostConstruct
    public void init() throws ServletException {
        configurableCaptchaService = new ConfigurableCaptchaService();

        // 颜色创建工厂,使用一定范围内的随机色
        colorFactory = new RandomColorFactory();
        configurableCaptchaService.setColorFactory(colorFactory);

        // 随机字体生成器
        fontFactory = new RandomFontFactory();
        fontFactory.setMaxSize(24);
        fontFactory.setMinSize(20);
        fontFactory.setRandomStyle(true);
        configurableCaptchaService.setFontFactory(fontFactory);

        // 随机字符生成器,去除掉容易混淆的字母和数字,如o和0等
        wordFactory = new RandomWordFactory();
        wordFactory.setCharacters("abcdefghkmnpqstwxyz23456789");
        wordFactory.setMaxLength(5);
        wordFactory.setMinLength(4);
        configurableCaptchaService.setWordFactory(wordFactory);

        // 自定义验证码图片背景
        MyCustomBackgroundFactory backgroundFactory = new MyCustomBackgroundFactory();
        configurableCaptchaService.setBackgroundFactory(backgroundFactory);

        // 图片滤镜设置
        ConfigurableFilterFactory filterFactory = new ConfigurableFilterFactory();

        List<BufferedImageOp> filters = new ArrayList<BufferedImageOp>();
        WobbleImageOp wobbleImageOp = new WobbleImageOp();
        wobbleImageOp.setEdgeMode(AbstractImageOp.EDGE_MIRROR);
        wobbleImageOp.setxAmplitude(2.0);
        wobbleImageOp.setyAmplitude(1.0);
        filters.add(wobbleImageOp);
        filterFactory.setFilters(filters);

        configurableCaptchaService.setFilterFactory(filterFactory);

        // 文字渲染器设置
        textRenderer = new BestFitTextRenderer();
        textRenderer.setBottomMargin(3);
        textRenderer.setTopMargin(3);
        configurableCaptchaService.setTextRenderer(textRenderer);

        // 验证码图片的大小
        configurableCaptchaService.setWidth(72);
        configurableCaptchaService.setHeight(20);
    }

    /**
     * 自定义验证码图片背景,主要画一些噪点和干扰线
     */
    private class MyCustomBackgroundFactory implements BackgroundFactory {
        private Random random = new Random();

        public void fillBackground(BufferedImage image) {
            Graphics graphics = image.getGraphics();

            // 验证码图片的宽高
            int imgWidth = image.getWidth();
            int imgHeight = image.getHeight();

            // 填充为白色背景
            graphics.setColor(Color.WHITE);
            graphics.fillRect(0, 0, imgWidth, imgHeight);

            // 画100个噪点(颜色及位置随机)
            for (int i = 0; i < 40; i++) {
                // 随机颜色
                int rInt = random.nextInt(255);
                int gInt = random.nextInt(255);
                int bInt = random.nextInt(255);
                graphics.setColor(new Color(rInt, gInt, bInt));

                // 随机位置
                int xInt = random.nextInt(imgWidth - 3);
                int yInt = random.nextInt(imgHeight - 2);

                // 随机旋转角度
                int sAngleInt = random.nextInt(360);
                int eAngleInt = random.nextInt(360);

                // 随机大小
                int wInt = random.nextInt(6);
                int hInt = random.nextInt(6);
                graphics.fillArc(xInt, yInt, wInt, hInt, sAngleInt, eAngleInt);

                // 画5条干扰线
                if (i % 20 == 0) {
                    int xInt2 = random.nextInt(imgWidth);
                    int yInt2 = random.nextInt(imgHeight);
                    graphics.drawLine(xInt, yInt, xInt2, yInt2);
                }
            }
        }
    }


    public BufferedImage createJcaptcha(HttpSession session) {
        // 得到验证码对象,有验证码图片和验证码字符串
        Captcha captcha = configurableCaptchaService.getCaptcha();
        // 取得验证码字符串
        String validationCode = captcha.getChallenge();
        // 取得验证码字符串放入Session
        session.setAttribute(IMG_VALIDATION_CODE, validationCode);
        // 取得验证码图片并输出
        BufferedImage bufferedImage = captcha.getImage();
        return bufferedImage;
    }

    @Override
    public LoginBO validateLogin(LoginBO loginBO) {
        EoSymStaffDO eoSymStaffDO = validateAccountAndPwd(loginBO);
        log.info("查询到一条记录,进行角色以及权限信息的获取,{}", eoSymStaffDO);
        List<EoSymRoleDO> eoSymRoleDOList = queryRoleInfoList(eoSymStaffDO);
        List<EoSymPrivDO> eoSymPrivDOList = queryPrivInfoList(eoSymRoleDOList);
        if(eoSymPrivDOList==null||eoSymPrivDOList.isEmpty()){
            throw new OperationsSystemException(OperationSystemErrorCode.USER_NEED_PRIVILEGE);
        }
        List<PrivBO> privBOList = new ArrayList<>();
        for(EoSymPrivDO eoSymPrivDO:eoSymPrivDOList){
            privBOList.add(BeanMapperUtil.objConvertOld(eoSymPrivDO,PrivBO.class));
        }
        String privType = EoSymPrivDO.PrivType.MENU.name();
        List<PrivBO> menuList = filterPrivInfo(privBOList,privType);
        TreeBuilder treeBuilder = new TreeBuilder();
        List<PrivBO> privTreeList = treeBuilder.buildListToTree(privBOList);
        List<PrivBO> menuTreeList = treeBuilder.buildListToTree(menuList);
        loginBO.setPrivBOList(privTreeList);
        loginBO.setMenuList(menuTreeList);
        return loginBO;
    }

    /**
     * 通过privType划分过滤权限list
     * @param privBOList 所有的权限list
     * @param privType 权限类型
     * @return
     */
    private List<PrivBO> filterPrivInfo(List<PrivBO> privBOList, String privType) {
        if(privType==null||privBOList==null){
            return null;
        }
        List<PrivBO> copyList =  BeanMapperUtil.mapList(privBOList,PrivBO.class);
        List<PrivBO> resultList = new ArrayList<>();
        for(PrivBO privBO:copyList){
            if(privType.equals(privBO.getPrivType())){
                resultList.add(privBO);
            }
        }
        return resultList;
    }

    @Override
    public String queryMobileByUsername(String userName) {
        //查询用户信息
        EoSymStaffDOExample eoSymStaffDOExample = new EoSymStaffDOExample();
        eoSymStaffDOExample.createCriteria().andStaffIdEqualTo(userName);
        List<EoSymStaffDO> list = eoSymStaffMapper.selectByExample(eoSymStaffDOExample);
        if(list==null||list.size()==0||list.size()>2){
           throw new OperationsSystemException(OperationSystemErrorCode.USERNAME_OR_PWD_NOT_PASS);
        }else{
            return list.get(0).getMobile();
        }
    }

    /**
     * 验证用户名密码
     *
     * @param loginBO
     * @return
     */
    private EoSymStaffDO validateAccountAndPwd(LoginBO loginBO) {
        //查询用户信息
        EoSymStaffDOExample eoSymStaffDOExample = new EoSymStaffDOExample();
        eoSymStaffDOExample.createCriteria().andStaffIdEqualTo(loginBO.getUsername())
                .andPasswordEqualTo(MD5(loginBO.getPassword()));
        List<EoSymStaffDO> list = eoSymStaffMapper.selectByExample(eoSymStaffDOExample);
        if (list == null || list.isEmpty() || list.size() > 1) {
            throw new OperationsSystemException(OperationSystemErrorCode.USERNAME_OR_PWD_NOT_PASS);
        } else {
            EoSymStaffDO eoSymStaffDO = list.get(0);
            if (!EoSymStaffDOExample.Stat.S0A.name().equals(eoSymStaffDO.getStat())) {
                throw new OperationsSystemException(OperationSystemErrorCode.ACCOUNT_STAT_NOT_S0A);
            }
            return eoSymStaffDO;
        }
    }

    /**
     * 通过用户信息获取权限信息
     *
     * @param eoSymStaffDO
     * @return
     */
    private List<EoSymRoleDO> queryRoleInfoList(EoSymStaffDO eoSymStaffDO) {
        if (eoSymStaffDO == null) {
            return null;
        }
        EoSymStaffRoleDOExample staffRoleDOExample = new EoSymStaffRoleDOExample();
        staffRoleDOExample.createCriteria().andStaffIdEqualTo(eoSymStaffDO.getStaffId());
        List<EoSymStaffRoleDOKey> eoSymStaffRoleDOKeyList = eoSymStaffRoleMapper.selectByExample(staffRoleDOExample);
        log.debug("通过用户id获取角色信息,{}", eoSymStaffDO);
        EoSymRoleDOExample eoSymRoleDOExample = new EoSymRoleDOExample();
        List<Integer> roleKeys = eoSymStaffRoleDOKeyList.stream().map(EoSymStaffRoleDOKey::getRoleId).collect(Collectors.toList());
        if(roleKeys==null||roleKeys.isEmpty()){
            throw  new OperationsSystemException(OperationSystemErrorCode.USER_NEED_PRIVILEGE);
        }
        eoSymRoleDOExample.createCriteria().andRoleIdIn(roleKeys).andStatEqualTo(EoSymRoleDOExample.Stat.S0A.name());
        log.debug("通过角色id（可能为多个）获取权限信息,{}", roleKeys);
        List<EoSymRoleDO> eoSymRoleDOList = eoSymRoleMapper.selectByExample(eoSymRoleDOExample);
        return eoSymRoleDOList;
    }


    /**
     * 通过角色信息获取权限信息
     *
     * @param eoSymRoleDOList
     * @return
     */
    private List<EoSymPrivDO> queryPrivInfoList(List<EoSymRoleDO> eoSymRoleDOList) {
        if (eoSymRoleDOList != null && !eoSymRoleDOList.isEmpty()) {
            List<Integer> roleIdKeys = eoSymRoleDOList.stream().map(EoSymRoleDO::getRoleId).collect(Collectors.toList());
            EoSymRolePrivDOExample rolePrivDOExample = new EoSymRolePrivDOExample();
            rolePrivDOExample.createCriteria().andRoleIdIn(roleIdKeys);
            log.debug("通过角色信息获取权限信息,{}", roleIdKeys);
            List<EoSymRolePrivDOKey> rolePrivDOKeyList = eoSymRolePrivMapper.selectByExample(rolePrivDOExample);
            if (rolePrivDOKeyList == null || rolePrivDOKeyList.isEmpty()) {
                return null;
            } else {
                List<Integer> privIdKeys = rolePrivDOKeyList.stream().map(EoSymRolePrivDOKey::getPrivId).collect(Collectors.toList());
                log.debug("通过权限id获取所有权限信息,{}", privIdKeys);
                EoSymPrivDOExample privDOExample = new EoSymPrivDOExample();
                privDOExample.setOrderByClause("parent_priv,show_seq ");
                privDOExample.createCriteria().andPrivIdIn(privIdKeys).andStatEqualTo(EoSymPrivDOExample.Stat.S0A.name());
                List<EoSymPrivDO> eoSymPrivDOList = eoSymPrivMapper.selectByExample(privDOExample);
                return eoSymPrivDOList;
            }
        } else {
            return null;
        }
    }

}
