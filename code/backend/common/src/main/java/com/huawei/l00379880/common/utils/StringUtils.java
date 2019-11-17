package com.huawei.l00379880.common.utils;

/**
 * 字符串工具类
 *
 * @author Louis
 * @date Sep 1, 2018
 */
public class StringUtils {

    /**
     * 判空操作
     *
     * @param value 要判断的字符串
     * @return true或false
     */
    public static boolean isBlank(String value) {
        return value == null || "".equals(value) || "null".equals(value) || "undefined".equals(value);
    }

}
