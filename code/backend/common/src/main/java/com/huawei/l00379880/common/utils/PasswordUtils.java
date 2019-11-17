/***********************************************************
 * @Description : 密码操作工具类
 * @author      : 梁山广(Liang Shan Guang)
 * @date        : 2019/11/17 19:34
 * @email       : liangshanguang2@gmail.com
 ***********************************************************/
package com.huawei.l00379880.common.utils;

import java.util.UUID;

public class PasswordUtils {
    /**
     * 匹配密码
     *
     * @param salt    盐
     * @param rawPass 明文
     * @param encPass 密文
     * @return 密码是否匹配
     */
    public static boolean matches(String salt, String rawPass, String encPass) {
        return new PasswordEncoder(salt).matches(encPass, rawPass);
    }

    /**
     * 明文密码加密
     *
     * @param rawPass 明文
     * @param salt    里用盐加密
     * @return 加密后的字符串
     */
    public static String encode(String rawPass, String salt) {
        return new PasswordEncoder(salt).encode(rawPass);
    }

    /**
     * 获取加密盐
     *
     * @return 加密盐
     */
    public static String getSalt() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 20);
    }
}
