package com.sq580.pzh580.util;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.rmi.RemoteException;
import java.util.List;
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
            JSONObject jsonObject=new JSONObject(obj);
            String jsonStr = jsonObject.toString();
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

    /**
     * 上传邳州
     * @param endpoint url
     * @param method 方法名
     * @param obj  参数
     * @return 结果
     */
    public static  String sendToPzhByWebService(String endpoint, String method, Object[] obj)
            throws ServiceException, RemoteException {

        // 创建一个服务（service）调用（call）
        Service service = new Service();
        Call call = (Call) service.createCall();
        // 设置service所在的url
        call.setTargetEndpointAddress(endpoint);

        // 方法名
        call.setOperation(method);

        LOGGER.info("开始调用邳州东软接口方法");
        // 方法调用
        String result = (String) call.invoke(obj);
        return result;

    }

    /**
     * 上传邳州
     * @param endpoint url
     * @param method 方法名
     * @param obj  参数
     * @return 结果
     */
    public static  String sendToKaiFuByWebService(String endpoint, String method,
                                                  List<String> paramList, Object[] obj)
            throws ServiceException, RemoteException {

        // 创建一个服务（service）调用（call）
        Service service = new Service();
        Call call = (Call) service.createCall();
        // 设置service所在的url
        call.setTargetEndpointAddress(endpoint);

        call.setOperationName(new QName("http://tempuri.org/",method));
        //Add 是net 那边的方法 "http://tempuri.org/" 这个也要注意Namespace 的地址,不带也会报错
        for (String param: paramList) {
            call.addParameter(new QName("http://tempuri.org/",param),
                    org.apache.axis.encoding.XMLType.XSD_STRING, javax.xml.rpc.ParameterMode.IN);
        }
        call.setUseSOAPAction(true);
        //返回参数的类型
        call.setReturnType(org.apache.axis.encoding.XMLType.SOAP_STRING);
        //这个也要注意 就是要加上要调用的方法Add,不然也会报错
        call.setSOAPActionURI("http://tempuri.org/"+method);
        LOGGER.info("开始调用上传接口方法");
        // 方法调用
        String result = (String) call.invoke(obj);
        return result;

    }
}
