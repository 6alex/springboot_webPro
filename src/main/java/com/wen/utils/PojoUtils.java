package com.wen.utils;

import com.alibaba.dubbo.common.utils.ReflectUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.commons.collections4.CollectionUtils;

/**
 * POJO工具类
 *
 * @author bo.mo
 * @date: 2016年9月20日 下午4:12:06
 * @version 1.0
 * @since JDK 1.8
 */
public class PojoUtils {

    private static final ConcurrentMap<String, Method> NAME_METHODS_CACHE = new ConcurrentHashMap<>();

    /**
     * 
     * 将list 转成前台ztree所需要的json
     * 
     * @author haoyuan.yang
     * @date: 2016年7月23日 下午5:12:31
     * @version 1.0
     *
     * @param pos
     * @return
     */
    public static <T> String getZtreeStr4Po(List<T> pos) {
        StringBuilder zTreeStr = new StringBuilder();
        String menuTree = "";
        if (CollectionUtils.isNotEmpty(pos)) {
            for (T po : pos) {
                try {
                    Method getId = getGetterMethod(po.getClass(), "id");
                    Method getParentid = getGetterMethod(po.getClass(), "parentid");
                    Method getName = getGetterMethod(po.getClass(), "name");
                    zTreeStr.append("{ id:").append(getId.invoke(po)).append(", pId:").append(getParentid.invoke(po))
                            .append(", open:false").append(", name:\"").append(getName.invoke(po)).append("\"},");
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            if (zTreeStr.length() > 0) {
                menuTree = zTreeStr.toString().substring(0, zTreeStr.toString().length() - 1);
            }
        }
        return menuTree;
    }

    /**
     * baojie.ren
     * 
     * @param pos
     * @param <T>
     * @return
     */
    public static <T> String getZtreeStrPrForLabel(List<T> pos) {
        StringBuilder zTreeStr = new StringBuilder();
        String menuTree = "";
        if (CollectionUtils.isNotEmpty(pos)) {
            for (T po : pos) {
                try {
                    Method getId = getGetterMethod(po.getClass(), "id");
                    Method getParentid = getGetterMethod(po.getClass(), "parentId");
                    Method getName = getGetterMethod(po.getClass(), "labelName");
                    zTreeStr.append("{ id:").append(getId.invoke(po)).append(", pId:").append(getParentid.invoke(po))
                            .append(", open:false").append(", name:\"").append(getName.invoke(po)).append("\"},");
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            if (zTreeStr.length() > 0) {
                menuTree = zTreeStr.toString().substring(0, zTreeStr.toString().length() - 1);
            }
        }
        return menuTree;
    }

    /**
     * 
     * 以及
     * 
     * @author lingyu.bao
     * @date: 2017年7月31日 上午10:44:41
     * @version 1.0
     * 
     *          注释: lingyu.bao
     *
     * @param pos
     * @return
     */
    public static <T> String getZtreeStr1Po(List<T> pos) {
        StringBuilder zTreeStr = new StringBuilder();
        String menuTree = "";
        if (CollectionUtils.isNotEmpty(pos)) {
            for (T po : pos) {
                try {
                    Method getId = getGetterMethod(po.getClass(), "id");
                    Method getName = getGetterMethod(po.getClass(), "name");
                    zTreeStr.append("{ id:").append(getId.invoke(po)).append(", open:false").append(", name:\"")
                            .append(getName.invoke(po)).append("\"},");
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            if (zTreeStr.length() > 0) {
                menuTree = zTreeStr.toString().substring(0, zTreeStr.toString().length() - 1);
            }
        }
        return menuTree;
    }

    /**
     * Description:转成前台ztree所需要的json (对比两个集合，确定节点是否需要选中)
     *
     * @author haoyuan.yang
     * @date: 2016/9/5 10:59
     * @version 1.0
     */
    public static <T> String getZtreeStr4Po(List<T> source, List<T> target) {
        StringBuilder zTreeStr = new StringBuilder();
        String menuTree = "";
        if (CollectionUtils.isNotEmpty(source)) {
            for (T po : source) {
                try {
                    Method getId = getGetterMethod(po.getClass(), "id");
                    Method getParentid = getGetterMethod(po.getClass(), "parentid");
                    Method getName = getGetterMethod(po.getClass(), "name");
                    zTreeStr.append("{ id:").append(getId.invoke(po)).append(", pId:").append(getParentid.invoke(po))
                            .append(", open:true");
                    if (CollectionUtils.isNotEmpty(target)) {
                        for (T poTemp : target) {
                            if (getId.invoke(po).equals(getId.invoke(poTemp))) {
                                zTreeStr.append(", checked:true");
                                break;
                            }
                        }
                    }
                    zTreeStr.append(", name:\"").append(getName.invoke(po)).append("\"},");
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            if (zTreeStr.length() > 0) {
                menuTree = zTreeStr.toString().substring(0, zTreeStr.toString().length() - 1);
            }
        }
        return menuTree;
    }

    /**
     * 
     * ztree 不显示层级关系
     * 
     * @author lingyu.bao
     * @date: 2016年10月24日 上午11:50:03
     * @version 1.0
     *
     * @param source
     * @param target
     * @return
     */
    public static <T> String getZtreeStr4PoExitPid(List<T> source, List<T> target) {
        StringBuilder zTreeStr = new StringBuilder();
        String menuTree = "";
        if (CollectionUtils.isNotEmpty(source)) {
            for (T po : source) {
                try {
                    Method getId = getGetterMethod(po.getClass(), "id");
                    // Method getParentid = getGetterMethod(po.getClass(),
                    // "parentid");
                    Method getName = getGetterMethod(po.getClass(), "name");
                    zTreeStr.append("{ id:").append(getId.invoke(po)).append(", open:true");
                    if (CollectionUtils.isNotEmpty(target)) {
                        for (T poTemp : target) {
                            if (getId.invoke(po).equals(getId.invoke(poTemp))) {
                                zTreeStr.append(", checked:true");
                                break;
                            }
                        }
                    }
                    zTreeStr.append(", name:\"").append(getName.invoke(po)).append("\"},");
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
            if (zTreeStr.length() > 0) {
                menuTree = zTreeStr.toString().substring(0, zTreeStr.toString().length() - 1);
            }
        }
        return menuTree;
    }

    /**
     * Description:获取字段的get方法
     *
     * @author haoyuan.yang
     * @date: 2016年7月23日 下午5:12:31
     * @version 1.0
     */
    private static Method getGetterMethod(Class<?> cls, String property) {
        String name = "get" + property.substring(0, 1).toUpperCase() + property.substring(1);
        Method method = NAME_METHODS_CACHE.get(cls.getName() + "." + name + "()");
        if (method == null) {
            try {
                method = cls.getMethod(name);
            } catch (NoSuchMethodException e) {
                for (Method m : cls.getMethods()) {
                    if (ReflectUtils.isBeanPropertyReadMethod(m) && m.getName().equals(name)) {
                        method = m;
                    }
                }
            }
            if (method != null) {
                NAME_METHODS_CACHE.put(cls.getName() + "." + name + "()", method);
            }
        }
        return method;
    }

}
