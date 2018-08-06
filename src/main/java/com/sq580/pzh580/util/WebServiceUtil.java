package com.sq580.pzh580.util;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import com.alibaba.fastjson.JSONObject;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;


public class WebServiceUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(WebServiceUtil.class);

    public static String sendWebServiceRequest(String endpoint, String method, Object obj) {
        String result = "";
        try {
            Service service = new Service();
            Call call = (Call)service.createCall();
            call.setTargetEndpointAddress(endpoint);
            // WSDL里面描述的接口名称
            call.setOperationName(new QName("http://ws.hzehr.bsoft.com", method));
            String jsonStr = JSONObject.toJSONString(obj);
            // 接口的参数
            call.addParameter("json",
                    org.apache.axis.encoding.XMLType.XSD_STRING,
                    javax.xml.rpc.ParameterMode.IN);
            // 设置返回类型
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);
            // 给方法传递参数，并且调用方法
            result = (String) call.invoke(new Object[] { jsonStr });
        } catch (Exception e) {
            LOGGER.error("发送请求失败", e);
        }
        return result;
    }

    /**
     *
     * @param endpoint webservice接口地址
     * @param nameSpace targetNamespace
     * @param method 接口名称
     * @param paramsMap key:接口方法参数名,value:接口方法参数值
     * @return
     */
    public static String sendWebServiceReq(String endpoint, String nameSpace,
                                           String method, Map<String, Object> paramsMap) {
        String result = "";
        try {
            Service service = new Service();
            Call call = (Call) service.createCall();
            call.setTargetEndpointAddress(endpoint);
            LOGGER.info("请求同步远方地址： {}",endpoint);
            // WSDL里面描述的接口名称
            call.setOperationName(new QName(nameSpace, method));
            // 单位是毫秒
            call.setTimeout(20000);
            Object[] paramsMapValue = null;
            if (!paramsMap.isEmpty()) {
                int index = 0;
                for (Map.Entry<String, Object> entry : paramsMap.entrySet()) {
                    // 接口的参数
                    call.addParameter(entry.getKey(), XMLType.XSD_STRING, ParameterMode.IN);
                    paramsMapValue = new String[paramsMap.size()];
                    paramsMapValue[index] = entry.getValue();
                    index++;
                }
            }
            // 设置返回类型
            call.setReturnType(XMLType.XSD_STRING);
            LOGGER.info("WebServiceUtil sendWebServiceReq() requestParams: {} ", paramsMapValue);
            // 给方法传递参数，并且调用方法
            result = (String) call.invoke( paramsMapValue );
            LOGGER.info("WebServiceUtil sendWebServiceReq() responseResult: {} ", result);
        } catch (Exception e) {
            LOGGER.error("WebServiceUtil sendWebServiceReq() 发送请求失败", e);
        }
        return result;
    }
}