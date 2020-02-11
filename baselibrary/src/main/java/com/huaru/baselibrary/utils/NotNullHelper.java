package com.huaru.baselibrary.utils;

import java.util.List;

/**
 * Created by Mr.Hao on 2018/1/9.
 */

public class NotNullHelper {
    /**
     * List集合判空
     * @param list
     * @return
     */
    public static boolean notEmpty(List<?> list) {
        return list != null && list.size() > 0;
    }
    /**
     * List集合判空
     * @param objects
     * @return
     */
//    public static boolean notEmpty(Object... objects) {
//        return objects!=null&&objects.length>0;
//    }
    public static boolean notEmpty(Object[] objects){
        return objects!=null&&objects.length>0;
    }
    /**
     * String判空
     * @param string
     * @return
     */
    public static boolean notEmpty(String string) {
        return string != null && !"".equals(string);
    }
    /**
     * Object判空
     * @param object
     * @return
     */
    public static boolean notEmpty(Object object){
        if (object!=null) {
            return true;
        }
        return false;
    }
}
