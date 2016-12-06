package com.bestpay.ecurrency.operations.common.util;

import com.google.common.collect.Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Map辅助类<br>
 * User: Jwxa<br>
 * Date: 2016/5/11.
 */
public class MapUtils {

    /**
     * 通过属性名称分类Map 遇到重复KEY会覆盖
     *
     * @param list      数据list
     * @param paramNames 属性名
     * @param <AnyType> 泛型
     * @return
     */
    public static  <AnyType> Map<String, AnyType> trans2MapByParamName(List<AnyType> list, String... paramNames) {
        Map<String, AnyType> map = Maps.newHashMap();
        for (AnyType anyType : list) {
            StringBuffer keyValue = new StringBuffer();
            String keyFlag = null;
            for (String key : paramNames) {
                keyValue.append(ReflectionUtils.getBeanValue(anyType, key));
                keyValue.append("|");
            }
            if (keyValue.length() > 0) {
                keyFlag = keyValue.substring(0, keyValue.length() - 1);
            }
            map.put(keyFlag, anyType);
        }
        return map;
    }


    /**
     * 通过属性名称分类统计Map 放入value中
     * @param originInfoList 原始信息List
     * @param paramNames 泛型中的属性组成的数组
     * @return
     */
    public static <S> Map<String, Integer> trans2countMapByParamName(List<S> originInfoList, String... paramNames) {
        Map<String, Integer> timesMap = Maps.newTreeMap();
        for (S bean : originInfoList) {
            int times = 0;
            StringBuffer keyValue = new StringBuffer();
            String keyFlag = null;
            for (String key : paramNames) {
                keyValue.append(ReflectionUtils.getBeanValue(bean, key));
                keyValue.append("|");
            }
            if (keyValue.length() > 0) {
                keyFlag = keyValue.substring(0, keyValue.length() - 1);
            }

            if (timesMap.containsKey(keyFlag)) {
                times = timesMap.get(keyFlag);
            }
            times++;
            timesMap.put(keyFlag, times);
        }
        return timesMap;
    }

    public static <AntType> Map<String,List<AntType>> trans2HashMapList(List<AntType> list, String paramName) {
        Map<String,List<AntType>> hashMapList = new HashMap<>();
        for(AntType bean:list){
            String key = (String) ReflectionUtils.getBeanValue(bean, paramName);
            List<AntType> beanList  = null;
            if(hashMapList.containsKey(key)){
                beanList =  hashMapList.get(key);
            }else{
                beanList = new ArrayList<>();
            }
            beanList.add(bean);
            hashMapList.put(key,beanList);
        }
        return hashMapList;
    }
}
