package com.sq580.pzh580.biz.task;

import com.sq580.pzh580.biz.model.UploadContract;
import com.sq580.pzh580.persistence.auto.mapper.MatchContractMapper;
import com.sq580.pzh580.persistence.auto.model.MatchContract;
import com.sq580.pzh580.util.WebServiceUtil;
import com.sq580.pzh580.util.XmlConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class UploadContractTask2 {

    @Autowired
    private MatchContractMapper matchContractMapper;

    public void sendContract() throws JAXBException {
        Date date=new Date();
        String method="upConfirmSignedInfo";
        String nameSpace="http://ws.hzehr.bsoft.com";
        String endPoint="http://172.16.90.254:8097/appws/ws/signService?wsdl";
        /*String endPoint="http://172.16.90.254:8097/appws/ws/signService";*/
        log.info("开始上传咯");
        Example example=new Example(MatchContract.class);
        Criteria criteria=example.createCriteria();
        criteria.andEqualTo("uploadState","0");
        List<MatchContract> matchContractList=matchContractMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(matchContractList)) {
            MatchContract matchContract=matchContractList.get(0);
            log.info(matchContract.toString());
            UploadContract uploadContract=new UploadContract();
            uploadContract.setSIGNTEAM(matchContract.getSignTeam());
            uploadContract.setSIGNTEAMNAME(matchContract.getSignTeamName());
            uploadContract.setSIGNPERIOD(matchContract.getSignPeriod());
            uploadContract.setSIGNPERIODFROM(matchContract.getSignPeriodFrom());
            uploadContract.setIDNUMBER(matchContract.getIdNumber());
            uploadContract.setCODE(matchContract.getCode());
            uploadContract.setAGREEMENTNAME(matchContract.getAgreementName());
            uploadContract.setORGCODE(matchContract.getOrgCode());
            uploadContract.setUSERID(matchContract.getUserId());
            uploadContract.setHOSTELPHONE(matchContract.getHosTelPhone());
            uploadContract.setPACKAGEID(matchContract.getPackageId());
            String xmlParam=webserviceParam(uploadContract);
            Map<String, Object> paramsMap = new HashMap<>(16);
            DataHandler dh1 = null;
            try {
                dh1 = new DataHandler(new FileDataSource(
                        new File("/usr/local/580/shishi.jpg").getAbsoluteFile().getCanonicalPath()));
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            paramsMap.put("dh",dh1);
            paramsMap.put("xmlData",xmlParam);
            log.info("响应信息: {}, url {}",paramsMap.toString(),endPoint);
            String encodeResult=WebServiceUtil.sendWebServiceReq(endPoint,nameSpace,method,paramsMap);
            log.info("响应信息encodeResult:{} ",encodeResult);
            String jsonResult =  XML.toJSONObject(encodeResult).toString();
            log.info("响应信息jsonResult:{} ",jsonResult);
            matchContract.setUploadState(Byte.valueOf("1"));
            matchContract.setUpdateTime(date);
            matchContractMapper.updateByPrimaryKey(matchContract);
        }

    }

    private String webserviceParam(UploadContract Contract) throws JAXBException {
        StringBuffer sb = new StringBuffer("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        String personInfoReqXml = XmlConvertUtil.beanToXml(Contract, UploadContract.class);
        sb.append(personInfoReqXml);
        String paramStr=sb.toString();
        paramStr=paramStr.replaceAll("uploadContract","QUERY_FORM");
        return paramStr;
    }




}