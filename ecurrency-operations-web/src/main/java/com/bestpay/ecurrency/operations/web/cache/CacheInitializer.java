package com.bestpay.ecurrency.operations.web.cache;

import com.bestpay.ecurrency.operations.common.util.MapUtils;
import com.bestpay.ecurrency.operations.dal.model.EoSymDictDO;
import com.bestpay.ecurrency.operations.manager.interfaces.ISymDictManager;
import com.bestpay.ecurrency.operations.manager.interfaces.ISymErrorManager;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import lombok.extern.slf4j.Slf4j;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.ServletException;
import java.util.List;
import java.util.Map;

import static com.bestpay.ecurrency.operations.common.constant.CommonConstant.*;


/**
 * 初始化各种配置信息 加载至缓存
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/15 ProjectName: ecurrency-operations Version: 1.0
 */

@Slf4j
@Component
public class CacheInitializer {

    @Autowired
    private ISymDictManager sysDictManager;
    @Autowired
    private ISymErrorManager symErrorManager;
    @Autowired
    private EhCacheCacheManager cacheManager;

    @PostConstruct
    public void init()throws ServletException {
        //1.初始化加载所有异常的描述 通过表t_eo_sym_error定义
        initEoSymErrorCache();
        //2.初始化加载所有字典数据 通过表t_eo_sym_dict定义
        initEoSymDictCache();
    }

    private void initEoSymErrorCache() {
        try {
            Cache errorCache = cacheManager.getCacheManager().getCache(INIT_CACHE_KEY);
            Map<String,String> errDescMap = symErrorManager.queryErrorInfoMap();
            errorCache.put(new Element(EO_SYM_ERROR_CACHE_KEY,errDescMap));
        } catch (Exception e) {
            log.info("将表t_eo_sym_error数据加载缓存失败");
            log.error(e.getMessage(),e);
        }
    }


    private void initEoSymDictCache(){
        try {
            Cache sysDictCache = cacheManager.getCacheManager().getCache(INIT_CACHE_KEY);
            List<EoSymDictDO> dictDOList= sysDictManager.queryAllDictList();
            Table<String,String,EoSymDictDO> table = HashBasedTable.create();
            for(EoSymDictDO eoSymDictDO:dictDOList){
                table.put(eoSymDictDO.getDictTypeid(),eoSymDictDO.getDictId(),eoSymDictDO);
            }
            sysDictCache.put(new Element(EO_SYM_DICT_CACHE_KEY,table));
        } catch (Exception e) {
            log.info("将表t_eo_sym_dict数据加载缓存失败");
            log.error(e.getMessage(),e);
        }
    }

}
