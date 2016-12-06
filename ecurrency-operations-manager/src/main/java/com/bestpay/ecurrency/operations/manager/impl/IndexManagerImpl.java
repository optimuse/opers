package com.bestpay.ecurrency.operations.manager.impl;

import com.bestpay.ecurrency.operations.manager.interfaces.IIndexManager;
import com.bestpay.ecurrency.operations.manager.model.LoginBO;
import com.bestpay.ecurrency.operations.manager.model.PrivBO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/17 ProjectName: ecurrency-operations Version: 1.0
 */
@Service
@Slf4j
public class IndexManagerImpl implements IIndexManager {


    @Override
    public String createMenuHtml(String path,LoginBO loginBO) {
        StringBuffer sb = new StringBuffer();
        List<PrivBO> privDOList = loginBO.getMenuList();//根节点
        List<PrivBO> mainList = (List<PrivBO>) privDOList.get(0).getChildren();
        for (PrivBO privBO : mainList) {
            //首先遍历的必定为树根节点
            sb.append(menuItem(path,privBO));
        }
        return sb.toString();
    }


    /**
     * 递归拼接菜单HTML
     * @return
     */
    private String menuItem(String path, PrivBO privBO){
        String html;
        if(privBO.isLeaf()){
            StringBuffer sbHtml = new StringBuffer();
            sbHtml.append("<li><a class=\"J_menuItem\" data-addtab=\"")
                    .append(privBO.getPrivId())
                    .append("\" url=\"").append(path).append(privBO.getPrivUrl())
                    .append("\">");
            if(StringUtils.isNotBlank(privBO.getPrivImg())){
                sbHtml.append("<i class=\"")
                        .append(privBO.getPrivImg())
                        .append("\"></i>");
            }
            sbHtml.append("<span class=\"nav-label\">")
                    .append(privBO.getPrivName()).append("</span>")
                    .append("</a>\n</li>");
            html = sbHtml.toString();
        }else{
            List<PrivBO> childrenList = (List<PrivBO>) privBO.getChildren();
            StringBuffer sbHtml = new StringBuffer();
            sbHtml.append("<li><a url=\"#\">");
            if(StringUtils.isNotBlank(privBO.getPrivImg())){
                sbHtml.append("<i class=\"")
                        .append(privBO.getPrivImg())
                        .append("\"></i>");
            }

            sbHtml.append("<span class=\"nav-label\">")
                    .append(privBO.getPrivName())
                    .append("</span>")
                    .append("<span class=\"fa arrow\">")
                    .append("</span>")
                    .append("</a>");
            sbHtml.append("<ul class=\"nav ");
            int level = privBO.getLevel();
            log.debug("----------------------------------------:"+level);
            switch (level){
                case 1:
                    sbHtml.append("nav-second-level ");
                    break;
                case 2:
                    sbHtml.append("nav-third-level ");
                    break;
                default:
                    break;
            }
            sbHtml.append("\">");
            for(PrivBO children:childrenList){
                sbHtml.append(menuItem(path,children));
            }
            sbHtml.append("</ul>")
            .append("</li>");
            html = sbHtml.toString();
        }
        return html;
    }
}
