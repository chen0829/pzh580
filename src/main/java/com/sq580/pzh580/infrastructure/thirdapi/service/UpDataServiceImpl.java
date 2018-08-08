package com.sq580.pzh580.infrastructure.thirdapi.service;

import com.sq580.pzh580.biz.model.UploadContract;
import com.sq580.pzh580.infrastructure.thirdapi.model.ThreadParam;
import com.sq580.pzh580.infrastructure.util.DataHandlerUtil;
import com.sq580.pzh580.persistence.auto.model.MatchContract;
import com.sq580.pzh580.util.WebServiceUtil;
import com.sq580.pzh580.util.XmlConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.activation.DataHandler;
import javax.xml.bind.JAXBException;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
/**
 * 与东软对接的功能类
 * @author chensh 20180806
 */
@Slf4j
@Service
public class UpDataServiceImpl implements UpDataService {


    /**
     * 提交确认签约信息
     * @param threadParam 参数
     * @return 返回调用结果
     */
    @Override
    public String upConfirmSignedInfo(ThreadParam threadParam)
            throws JAXBException, ServiceException, RemoteException {

        MatchContract matchContract=threadParam.getMatchContract();
        UploadContract uploadContract = new UploadContract();
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
        StringBuilder sb = new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        String personInfoReqXml = XmlConvertUtil.beanToXml(uploadContract, UploadContract.class);
        sb.append(personInfoReqXml);
        String paramStr=sb.toString();
        paramStr=paramStr.replaceAll("uploadContract","QUERY_FORM");
        log.info("发送的内容{}",paramStr);
        DataHandler handler=DataHandlerUtil.getDataHandler();
        Object[] obj={handler,paramStr};
        return WebServiceUtil.sendToPzhByWebService(
                threadParam.getEndpoint(),threadParam.getMethod(),obj);
    }

}
