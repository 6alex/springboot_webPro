package com.wen.demo;

import static org.junit.Assert.*;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

/**
 * @author wencun
 * @date 2018年8月16日 上午11:49:32
 * @version 1.0
 * @since JDK 1.8
 */
public class MD5 {
    /**
     * MD5方法
     * 
     * @param text
     *            明文
     * @param key
     *            密钥
     * @return 密文
     * @throws Exception
     */
    public static String md5(String text, String key) throws Exception {
        // 加密后的字符串
        String encodeStr = DigestUtils.md5Hex(text + key);
        System.out.println("MD5加密后的字符串为:encodeStr=" + encodeStr);
        return encodeStr;
    }

    /**
     * MD5验证方法
     * 
     * @param text
     *            明文
     * @param key
     *            密钥
     * @param md5
     *            密文
     * @return true/false
     * @throws Exception
     */
    public static boolean verify(String text, String key, String md5) throws Exception {
        // 根据传入的密钥进行验证
        String md5Text = md5(text, key);
        if (md5Text.equalsIgnoreCase(md5)) {
            System.out.println("MD5验证通过");
            return true;
        }
        System.out.println("MD5验证失败");
        return false;
    }

    @Test
    public void MD5() throws Exception {
        String content = "123456";
        String key = "";
        String md5 = md5(content, key);
        boolean verify = verify(content, "", md5);
    }
}
