package com.huaru.baselibrary.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * com.rocketarmyevaluating.Utils
 * Created by Mr.Hao on 2017/6/8 11:28.
 */

public class MD5Utils {
    public static String encode(String text){
        try {
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte [] result=digest.digest(text.getBytes());
            StringBuilder sb=new StringBuilder();
            for(byte b:result){
                int number=b&0xff;
                String hex= Integer.toHexString(number);
                if(hex.length()==1){
                    sb.append("0"+hex);
                }else {
                    sb.append(hex);
                }
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
