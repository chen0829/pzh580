package com.sq580.pzh580.biz.task;


import com.alibaba.fastjson.JSON;
import com.sq580.pzh580.infrastructure.thirdapi.model.ThreadParam;
import com.sq580.pzh580.infrastructure.thirdapi.service.UpDataService;
import com.sq580.pzh580.persistence.auto.mapper.MatchContractMapper;
import com.sq580.pzh580.persistence.auto.model.MatchContract;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;
import javax.xml.bind.JAXBException;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;
import javax.xml.rpc.ServiceException;


@Slf4j
@Component
public class UploadContractTask {

    @Autowired
    private MatchContractMapper matchContractMapper;

    @Autowired
    UpDataService upDataService;

    @Scheduled(cron = "0 0/1 * * * ?")
    public void sendContract() {

        log.info("开始上传咯");
        try {
            matchContractMapper.insertMatch();
        } catch (Exception e) {
            log.warn(e.getMessage());
        }
        String endPoint="http://100.100.200.15:8097/appws/ws/signService?wsdl";
        String method="upConfirmSignedInfo";
        String signSucc="1";
        Date date=new Date();
        Example example = new Example(MatchContract.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("uploadState", "0");
        List<MatchContract> matchContractList = matchContractMapper.selectByExample(example);
        if (!CollectionUtils.isEmpty(matchContractList)) {
            for (MatchContract matchContract :matchContractList) {

                ThreadParam threadParam=new ThreadParam();
                threadParam.setEndpoint(endPoint);
                threadParam.setMatchContract(matchContract);
                threadParam.setMethod(method);
                try {
                    String result = upDataService.upConfirmSignedInfo(threadParam);
                    log.info("結果result: {}", result);
                    //转为json串
                    JSONObject xmlJSONObj = XML.toJSONObject(result);
                    String jsonResult = xmlJSONObj.toString();
                    log.info(jsonResult);
                    //更新记录
                    com.alibaba.fastjson.JSONObject jsonObject=JSON.parseObject(jsonResult);
                    String resultFlag=jsonObject.getJSONObject("MSGFORM")
                            .getJSONObject("XMLDATA").getString("RESULTFLAG");
                    String resultState=jsonObject.getJSONObject("MSGFORM")
                            .getJSONObject("XMLDATA").getString("STATUS");
                    log.info(resultFlag);
                    if (StringUtils.equals(resultFlag,signSucc)) {
                        //签约成功
                        matchContract.setUploadState(Byte.valueOf("1"));
                    }
                    else {
                        //签约失败
                        matchContract.setUploadState(Byte.valueOf("2"));
                    }
                    matchContract.setUpdateTime(date);
                    matchContract.setRemark(resultState);
                    matchContractMapper.updateByPrimaryKey(matchContract);
                } catch (Exception e) {
                    e.printStackTrace();
                    log.error(e.getMessage());
                }

            }



        }

    }



}
