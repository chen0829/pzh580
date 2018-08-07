package com.sq580.pzh580.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Slf4j
public class MD5Util {
    private static char[] hexs = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'a', 'b', 'c', 'd', 'e', 'f' };
    public static String md5(String source){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(source.getBytes("utf-8"));
            byte[] digest = md.digest();

            String result = "";
            for (byte b : digest) {
                int high = (b >> 4) & 0x0f;
                result += hexs[high];
                int low = b & 0x0f;
                result += hexs[low];
            }
            return result;
        } catch (NoSuchAlgorithmException e) {
            log.error(e.getMessage(), e);
        } catch (UnsupportedEncodingException e) {
            log.error(e.getMessage(), e);
        }
        return null;
    }

    public static boolean md5Validate(String md5, String pwd, String ts){
        String value = md5(pwd+ts);
        if(value.equals(md5)){
            return true;
        }else
            return false;
    }


    public static String getVerifycode(String pwd, String ts){
        return md5(pwd+ts);
    }
    public static void main(String[] args) {
        //c138d518
        String value = md5("3f7e2o4d"+"1503370060675");
        System.out.println(System.currentTimeMillis());
        System.out.println(value);
    }
}
