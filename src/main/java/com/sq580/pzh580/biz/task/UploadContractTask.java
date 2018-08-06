package com.sq580.pzh580.biz.task;

import com.sq580.pzh580.biz.model.UploadContract;
import com.sq580.pzh580.persistence.auto.mapper.MatchContractMapper;
import com.sq580.pzh580.persistence.auto.model.MatchContract;
import com.sq580.pzh580.util.XmlConvertUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.xml.bind.JAXBException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import javax.activation.DataSource;
import javax.xml.rpc.ServiceException;


@Slf4j
@Component
public class UploadContractTask {

    @Autowired
    private MatchContractMapper matchContractMapper;
    @Scheduled(cron = "0 0/1 * * * ?")
    public void sendContract() throws ServiceException, MalformedURLException, JAXBException, RemoteException {

        String endPoint="http://100.100.200.15:8097/appws/ws/signService?wsdl";
        // 创建一个服务（service）调用（call）
        Service service = new Service();
        Call call = (Call) service.createCall();
        // 设置service所在的url
        call.setTargetEndpointAddress(new URL(endPoint));
        callUpConfirmSignedInfoService(call);

    }

    // 4.3提交签约信息
    public void callUpConfirmSignedInfoService(Call call) throws JAXBException, RemoteException {

        log.info("开始上传咯");
        try {
            matchContractMapper.insertMatch();
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        Date date=new Date();
        Example example = new Example(MatchContract.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uploadState", "0");
        List<MatchContract> matchContractList = matchContractMapper.selectByExample(example);
        String inputXml5;
        if (!CollectionUtils.isEmpty(matchContractList)) {
            MatchContract matchContract = matchContractList.get(0);
            log.info(matchContract.toString());
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
            inputXml5 = webserviceParam(uploadContract);
            log.info("inputXml5: {}", inputXml5);

            // 方法名
            call.setOperation("upConfirmSignedInfo");
            DataHandler dh1 = null;
            log.info("我进来了dh1: {}");
            try {
                dh1 = new DataHandler(new FileDataSource(
                        new File("/usr/local/580/shishi.jpg").getAbsoluteFile().getCanonicalPath()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            log.info("我开始调用方法了: ");
            // 方法调用
            String result = (String) call.invoke(new Object[]{dh1, inputXml5});
            log.info("結果ret: {}", result);

            matchContract.setUpdateTime(date);
            matchContract.setUploadState(Byte.valueOf("1"));
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
