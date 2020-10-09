package com.electricaldiagram.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Zkl
 * @create: 2010-10-09
 * @Description 公共方法，用到注解校验必须要调用里面的方法
 * @Version 1.0
 */

public class CommonUtils {
    /**
     * 通过反射来获取javaBean上的注解信息，判断属性值信息，然后通过注解元数据
     * 来返回
     *
     * @param t
     */
    public static <T> Object getValue(T t, String fieldName) {
        Object value = null;
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(t.getClass());
            PropertyDescriptor[] props = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : props) {
                if (fieldName.equals(property.getName())) {
                    Method method = property.getReadMethod();
                    value = method.invoke(t, new Object[]{});
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static boolean notNull(Object value) {
        if (null == value) {
            return false;
        }
        if (value instanceof String && isEmpty((String) value)) {
            return false;
        }
        if (value instanceof List && isEmpty((List<?>) value)) {
            return false;
        }
        return null != value;
    }

    public static boolean isEmpty(String str) {
        return null == str || str.isEmpty();
    }

    public static boolean isEmpty(List<?> list) {
        return null == list || list.isEmpty();
    }

    /**
     * 判断两个集合的差，取出需要删除的数据和添加的数据
     *
     * @param oldId 旧的ID
     * @param newId 新的ID
     * @return 返回需要修改和删除的参数
     */
    public static Map<String, Object> different(List<String> oldId, List<String> newId) {
        List<String> add = new ArrayList<String>();
        List<String> del = new ArrayList<String>();
        List<String> common = new ArrayList<String>();
        Map<String, Object> map = new HashMap<>();
        /*
         * 集合add (新的数据有，旧的数据没有，即为要添加的数据)
         */
        //遍历新的数组元素
        for (String id : newId) {
            //旧的数组中不包含新的元素（即为要添加的元素）
            if (!oldId.contains(id)) {
                add.add(id);
            }
        }

        /*
         * 集合del (旧的数据中有，新的数据没有，即为要删除的数据)
         */
        //遍历旧的数组元素
        for (String id : oldId) {
            //新的数组中不包含旧的数组（即为要删除的元素）
            if (!newId.contains(id)) {
                del.add(id);
            }
        }

        /*
         * 集合common (旧的数据中有，新的数据有，即为共同的数据)
         */
        //遍历旧的数组元素
        for (String id : oldId) {
            //新的数组中包含旧的数组（即为共同的元素）
            if (newId.contains(id)) {
                common.add(id);
            }
        }
        map.put("add", add);
        map.put("del", del);
        map.put("common", common);
        return map;
    }

    /**
     * 判断当前操作系统
     *
     * @return
     */
    public static Boolean existWindows() {
        String osName = System.getProperty("os.name");
        System.out.println("当前操作系统：" + osName);
        return osName.toLowerCase().startsWith("win") ? true : false;
    }

    /**
     * 判断对象为空
     *
     * @param obj 对象名
     * @return 是否为空
     */
    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Object obj) {
        if (obj == null) {
            return true;
        }
        if ((obj instanceof List)) {
            return ((List) obj).size() == 0;
        }
        if ((obj instanceof String)) {
            return ((String) obj).trim().equals("");
        }
        return false;
    }

}
