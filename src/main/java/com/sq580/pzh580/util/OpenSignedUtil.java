package com.sq580.pzh580.util;

import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

@Component
public class OpenSignedUtil {

    /**
     * 根据对应请求参数与对应serverCode获取secretKey进行签名并返回。
     * 对signature参数不做签名
     *
     * @param paramMaps
     * @param secretKey
     * @return
     */
    public static String getSign(Map<String, Object> paramMaps, String secretKey, String charset) {
        //按照自然排序
        SortedMap<String, Object> sortedMap = new TreeMap<String, Object>(paramMaps);
        sortedMap.put("secret_key",secretKey);
        //對signature不操作
        String checkStr= OpenSignedUtil.getUrlParamsByMap(sortedMap,charset);
        String encryptStr= MD5Util.md5(checkStr);
        return encryptStr;
    }


    /**
     * 将map转换成url
     * @param map
     * @return
     */
    public static String getUrlParamsByMap(Map<String, Object> map,String charset) {
        if (map == null || charset == null || charset.equals("")) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if("signature".equals(entry.getKey())){//对這个字段不做操作
                continue;
            }
            String val="";
            Object ov=entry.getValue();
            String[] value=new String[1];
            if(ov instanceof String[]){
                value=(String[])ov;
            }else{
                value[0] = ov==null?"":ov.toString();
            }

            for(int k=0;k<value.length;k++){
                val=val+value[k];
            }
            try {
                sb.append(entry.getKey() + "=" + new String(val.getBytes(charset), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            sb.append("&");
        }
        String s = sb.toString();
        if (s.endsWith("&")) {
            s = org.apache.commons.lang.StringUtils.substringBeforeLast(s, "&");
        }
        return s;
    }

    public static long getSeq(){
        long seq = System.currentTimeMillis();
        return seq;
    }

}
