package com.bestpay.ecurrency.operations.common.util;

import lombok.extern.slf4j.Slf4j;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;


/**
 * 类描述
 * <p>
 * 方法描述列表
 * </p>
 * User: Jwxa Date: 2016/11/17 ProjectName: ecurrency-operations Version: 1.0
 */
@Slf4j
public class ReflectionUtils {


    /**
     * <b>DESCRIPION:</b>根据属性名，获得对应的值<br/>
     *
     * @param bean
     *            bean对象
     * @param propertyName
     *            属性名称
     * @return 对应值
     */
    public static Object getBeanValue(Object bean, String propertyName) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                if (!"class".equals(propertyName) && propertyName.equals(descriptor.getName())) {
                    Method readMethod = descriptor.getReadMethod();
                    return readMethod.invoke(bean, new Object[0]);
                }
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return null;
    }

    /**
     * <b>DESCRIPION:</b>根据属性名，获得对应的值<br/>
     *
     * @param bean
     *            bean对象
     * @param propertyName
     *            属性名称
     * @param value
     *            对应值
     * @return 对应值
     */
    public static Object setBeanValue(Object bean, String propertyName, Object value) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                if (!"class".equals(propertyName) && propertyName.equals(descriptor.getName())) {
                    Method writeMethod = descriptor.getWriteMethod();
                    return writeMethod.invoke(bean, value);
                }
            }
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return null;
    }

    /**
     * <B>Description:</B>利用反射获取指定对象的指定属性 <br>
     * <B>Create on:</B> 2013年12月9日 下午10:50:23<br>
     *
     * @param obj
     *            目标对象
     * @param fieldName
     *            目标属性
     * @return 目标属性的值
     */
    public static Object getFieldValue(Object obj, String fieldName) {
        Object result = null;
        Field field = getField(obj, fieldName);
        if (field != null) {
            field.setAccessible(true);
            try {
                result = field.get(obj);
            } catch (IllegalArgumentException e) {
                log.error("", e);
            } catch (IllegalAccessException e) {
                log.error("", e);
            }
        }
        return result;
    }

    /**
     * <B>Description:</B> 利用反射获取指定对象里面的指定属性<br>
     * <B>Create on:</B> 2013年12月9日 下午10:50:48<br>
     *
     * @param obj
     *            目标对象
     * @param fieldName
     *            目标属性
     * @return 目标字段
     */
    private static Field getField(Object obj, String fieldName) {
        Field field = null;
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz
                .getSuperclass()) {
            try {
                field = clazz.getDeclaredField(fieldName);
                break;
            } catch (NoSuchFieldException ignore) {
                // 这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
            }
        }
        return field;
    }

    /**
     * <B>Description:</B> 利用反射设置指定对象的指定属性为指定的值<br>
     * <B>Create on:</B> 2013年12月9日 下午10:51:11<br>
     *
     * @param obj
     *            目标对象
     * @param fieldName
     *            目标属性
     * @param fieldValue
     *            目标值
     */
    public static void setFieldValue(Object obj, String fieldName,
                                     Object fieldValue) {
        Field field = getField(obj, fieldName);
        if (field != null) {
            try {
                field.setAccessible(true);
                field.set(obj, fieldValue);
            } catch (IllegalArgumentException e) {
                log.error("", e);
            } catch (IllegalAccessException e) {
                log.error("", e);
            }
        }
    }

    /**
     * <B>Description:反射方式调用SETTER方法,并进行自动转型</B> <br>
     * <B>Create on:</B> 2014-1-22 下午3:41:58<br>
     *
     * @param m
     *            方法
     * @param entity
     *            实体信息
     * @param params
     *            参数信息
     * @throws IllegalArgumentException
     *             非法参数异常
     * @throws IllegalAccessException
     *             非法访问权限异常
     * @throws InvocationTargetException
     *             目标调用异常
     */
    public static void invokeSetter(Method m, Object entity, Object params)
            throws IllegalArgumentException, IllegalAccessException,
            InvocationTargetException {
        if (m.getParameterTypes()[0] == Integer.class
                || m.getParameterTypes()[0] == Integer.class) {
            m.invoke(entity, Integer.valueOf(params.toString()));
        } else if (m.getParameterTypes()[0] == Date.class) {
            // 日期类型
            m.invoke(entity, Date.valueOf(params.toString()));
        } else if (m.getParameterTypes()[0] == Timestamp.class) {
            // 日期类型
            m.invoke(entity, Timestamp.valueOf(params.toString()));
        } else if (m.getParameterTypes()[0] == Integer.class
                || m.getParameterTypes()[0] == int.class) {
            // 数字类型
            m.invoke(entity, Integer.valueOf(params.toString()));
        } else if (m.getParameterTypes()[0] == double.class
                || m.getParameterTypes()[0] == Double.class) {
            // 小数类型
            m.invoke(entity, Double.valueOf(params.toString()));
        } else if (m.getParameterTypes()[0] == BigDecimal.class) {
            // BigDecimal类型
            m.invoke(entity, new BigDecimal(params.toString()));
        } else if (m.getParameterTypes()[0] == Time.class) {
            // Time类型
            m.invoke(entity, Time.valueOf(params.toString()));
        } else {
            // String类型
            m.invoke(entity, params);
        }
    }

    /**
     * <B>Description:</B> <br>
     * <B>Create on:</B> 2014-1-22 下午3:43:49<br>
     *
     * @param map
     * @param bean
     * @param columnNames
     * @param propNames
     */
    public static <T> void map2bean(Map<String, Object> map, T bean,
                                    String[] columnNames, String[] propNames) {
        try {
            for (int i = 0; i < columnNames.length; i++) {
                Object value = map.get(columnNames[i]);
                if (value != null && hasField(bean, propNames[i])) {
                    setFieldValue(bean, propNames[i], value);
                }
            }
        } catch (Exception e) {
            log.error(
                    "error in map2bean, args are :" + map + "," + bean + ","
                            + Arrays.toString(columnNames) + ","
                            + Arrays.toString(propNames), e);
        }
    }

    public static <T> void map2bean(Map<String, Object> map, T bean) {
        Set<String> keys = map.keySet();
        String[] columnNames = new String[keys.size()];
        map.keySet().toArray(columnNames);
        map2bean(map, bean, columnNames, columnNames);
    }

    private static boolean hasField(Object obj, String fieldName) {
        for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz
                .getSuperclass()) {
            try {
                if (clazz.getDeclaredField(fieldName) != null)
                    return true;
            } catch (NoSuchFieldException ignore) {
                // 这里不用做处理，子类没有该字段可能对应的父类有，都没有就返回null。
            }
        }
        return false;
    }
}
