package com.zys.springbootshiro.util;

import java.util.Random;

/**
 * @author zhongyushi
 * @date 2020/10/10 0010
 * @dec 随机盐工具类
 */
public class SaltUtil {

    //生成指定位数的随机盐，用于密码加密
    public static String createSalt(Integer length){
        String result="";
        String str="qwertyuiopasdfghjklzxcvbnm123456789QWERTYUIOPLKJHGFDSAZXCVBNM!@#$%^&*()_+,./?-";
        Random random=new Random();
        for (int i = 0; i < length; i++) {
            result+=str.charAt(random.nextInt(str.length()));
        }
        return result;

    }

}
