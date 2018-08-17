package com.sq580.pzh580.util;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

@Slf4j
public class RestfulUtil {
    public static Map<String, Object> postJson(Map<String, String> headerParam, Map<String, Object> queryParam, Map<String, Object> bodyParam, String url) {
        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse resp = null;
        if (queryParam != null) {
            url = url + "?" + OpenSignedUtil.getUrlParamsByMap(queryParam, "UTF-8");
        }
        if (url == null || bodyParam==null) {
            return null;
        }

        log.info("请求：url:" + url + ", param："  + JSONObject.toJSON(bodyParam).toString());
        HttpPost post = new HttpPost(url);
        post.setHeader("Content-Type", "application/json");
        if (headerParam != null) {
            log.info("head :{}",JSONObject.toJSON(headerParam).toString());
            Set<Map.Entry<String, String>> set = headerParam.entrySet();
            for (Iterator<Map.Entry<String, String>> iter = set.iterator(); iter.hasNext(); ) {
                Map.Entry<String, String> entry = iter.next();
                post.setHeader(entry.getKey(), entry.getValue());
            }
        }

        StringEntity reqentity = null;
        reqentity = new StringEntity(JSONObject.toJSON(bodyParam).toString(), "utf-8");
        post.setEntity(reqentity);
        log.info(System.currentTimeMillis() + "开始请求");
        try {
            resp = client.execute(post);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        log.info(System.currentTimeMillis() + "结束请求");
        StatusLine statusLine = resp.getStatusLine();
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", statusLine.getStatusCode());
        try {
            String str = EntityUtils.toString(resp.getEntity(), "utf-8");
            result.put("resp", str);
            log.info("响应：" + str);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }

    public static Map<String, Object> get(Map<String, String> headerParam, Map<String, Object> queryParam, String url) {
        if (queryParam != null) {
            url = url + "?" + OpenSignedUtil.getUrlParamsByMap(queryParam, "UTF-8");
        }
        log.info("请求：url:" + url + "，headerParam：" + JSONObject.toJSON(headerParam).toString());
        CloseableHttpResponse resp = null;
        HttpGet request = new HttpGet(url);
        if (headerParam != null) {
            Set<Map.Entry<String, String>> set = headerParam.entrySet();
            for (Iterator<Map.Entry<String, String>> iter = set.iterator(); iter.hasNext(); ) {
                Map.Entry<String, String> entry = iter.next();
                request.addHeader(entry.getKey(), entry.getValue());
            }
        }

        CloseableHttpClient httpClient = HttpClients.createDefault();
        log.info(System.currentTimeMillis() + "开始请求");
        try {
            resp = httpClient.execute(request);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        log.info(System.currentTimeMillis() + "结束请求");
        StatusLine statusLine = resp.getStatusLine();
        HashMap<String, Object> result = new HashMap<>();
        result.put("status", statusLine.getStatusCode());
        try {
            String str = EntityUtils.toString(resp.getEntity(), "utf-8");
            result.put("resp", str);
            log.info("响应：" + str);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return result;
    }
}
