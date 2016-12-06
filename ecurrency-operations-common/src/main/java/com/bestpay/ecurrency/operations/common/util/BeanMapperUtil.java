package com.bestpay.ecurrency.operations.common.util;

import com.google.common.collect.Lists;
import org.dozer.DozerBeanMapper;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * <ul>
 * <li>简单封装Dozer, 实现深度转换Bean<->Bean的Mapper.实现:</li>
 * <li>1、持有Mapper的单例.</li>
 * <li>2、泛型返回值转换.</li>
 * <li>3、批量转换Collection中的所有对象.</li>
 * <li>4、区分创建新的B对象与将对象A值复制到已存在的B对象两种函数.</li>
 * <li>User:ShuZhen Date: 2014-09-07</li>
 * </ul>
 */
public class BeanMapperUtil {

    /**
     * 持有Dozer单例, 避免重复创建DozerMapper消耗资源.**
     */
    private static DozerBeanMapper dozer = new DozerBeanMapper();

    /**
     * 基于Dozer转换对象的类型
     *
     * @param obj   需要转换的对象
     * @param toObj 转换后的类型
     * @param <T>   返回对象类型泛型
     * @return 返回对象
     */
    public static <T> T objConvert(Object obj, Class<T> toObj) {
        if(obj == null) return null;
        T toObjIns;
        try{
            toObjIns = (T)toObj.newInstance(); //创建目标对象实例
            Class sourCls = obj.getClass();
            //遍历源属性
            do{
                Field[] sourFlds = sourCls.getDeclaredFields(); //源属性集
                for(int i = 0 ; i < sourFlds.length; i++){ //遍历源所有属性
                    Field sf = sourFlds[i];
                    sf.setAccessible(true);
                    // System.out.println(sf.getName());
                    //遍历目标所有属性
                    Class toCls = toObj;
                    do{
                        Field[] toFlds = toCls.getDeclaredFields(); //源属性集
                        for(int j = 0 ; j < toFlds.length; j++){ //遍历源所有属性
                            Field tof = toFlds[j];
                            boolean isStatic = Modifier.isStatic(tof.getModifiers());//避免对静态字段进行设置值
                            if(isStatic) continue;
                            tof.setAccessible(true);
                            if(sf.getName().equals(tof.getName())){ //属性名字相同
                                String type = tof.getType().toString();//得到此属性的类型
                                if (type.endsWith("String")) {
                                    tof.set(toObjIns,(String)sf.get(obj));
                                }else if(type.endsWith("int") || type.endsWith("Integer")){
                                    tof.set(toObjIns,(Integer)sf.get(obj));
                                }else if(type.endsWith("Date")){
                                    tof.set(toObjIns,(Date)sf.get(obj));
                                }else if(type.endsWith("long") || type.endsWith("Long")){
                                    tof.set(toObjIns,(Long)sf.get(obj));
                                }else if(type.endsWith("short") || type.endsWith("Short")){
                                    tof.set(toObjIns,(Short)sf.get(obj));
                                } else if(type.endsWith("double") || type.endsWith("Double")) {
                                    tof.set(toObjIns, (Double) sf.get(obj));
                                } else if(type.endsWith("List")) {
                                    // 判断list不为空
                                    if(sf.get(obj) == null || ((List)sf.get(obj)).size() == 0) continue;
                                    //得到list
                                    List<Object> list = (List)sf.get(obj);
                                    //获得泛型
                                    Type fc = tof.getGenericType();
                                    if(fc == null) continue;
                                    List<Object> convertList = null;
                                    if(fc instanceof ParameterizedType)
                                    {
                                        //获得泛型参数类型
                                        ParameterizedType pt = (ParameterizedType) fc;
                                        //获得泛型的class
                                        Class genericClazz = (Class)pt.getActualTypeArguments()[0];

                                        convertList = new ArrayList<Object>();
                                        //转换
                                        for(Object temp : list) {
                                            Object convertObj = objConvert(temp,genericClazz);
                                            convertList.add(convertObj);
                                        }
                                    }
                                    tof.set(toObjIns, convertList);

                                }
                                else {
                                    System.out.println("类型转换失败！");
                                    throw new Exception("类型转换失败！");
                                }
                            }
                        }
                        toCls = toCls.getSuperclass();

                    }while(toCls != Object.class);
                }
                sourCls = sourCls.getSuperclass();
            }while(sourCls != Object.class);
        }catch (Exception e){
            toObjIns = null;
            e.printStackTrace();
        }
        return toObjIns;
    }


    /**
     * 基于Dozer转换对象的类型
     *
     * @param obj   需要转换的对象
     * @param toObj 转换后的类型
     * @param <T>   返回对象类型泛型
     * @return 返回对象
     */
    public static <T> T objConvertOld(Object obj, Class<T> toObj) {
        if (null == obj) {
            return null;
        }
        return dozer.map(obj, toObj);
    }


    /**
     * 基于Dozer转换Collection中对象的类型
     *
     * @param sourceList 需要转换的集合
     * @param toObj      转换后对象类型
     * @param <T>        返回对象类型泛型
     * @return 返回对象
     */
    public static <T> List<T> mapList(Collection sourceList, Class<T> toObj) {
        if (null == sourceList) {
            return null;
        }
        List<T> destinationList = Lists.newArrayList();
        for (Object sourceObject : sourceList) {
            T destinationObject = dozer.map(sourceObject, toObj);
            destinationList.add(destinationObject);
        }
        return destinationList;
    }

    /**
     * 基于Dozer将对象A的值拷贝到对象B中
     *
     * @param source 需要转换的对象
     * @param toObj  转换后对象类型
     */
    public static void copy(Object source, Object toObj) {
        if (null != source) {
            dozer.map(source, toObj);
        }
    }

}