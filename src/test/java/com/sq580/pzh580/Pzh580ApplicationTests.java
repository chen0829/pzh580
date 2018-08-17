package com.sq580.pzh580;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sq580.pzh580.biz.service.DoctorBaseDataService;
import com.sq580.pzh580.biz.service.PzhContractPersonService;
import com.sq580.pzh580.biz.service.SqContractPersonService;
import com.sq580.pzh580.persistence.auto.mapper.SqContractPersonMapper;
import com.sq580.pzh580.persistence.auto.model.PzhContractPerson;
import com.sq580.pzh580.persistence.auto.model.SqContractPerson;
import com.sq580.pzh580.util.WebServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.XML;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Pzh580ApplicationTests {

    /*@Autowired
    private DoctorBaseDataService doctorBaseDataService;
    @Autowired
    private PzhContractPersonService pzhContractPersonService;
    @Autowired
    private SqContractPersonService sqContractPersonService;

    @Autowired
    private SqContractPersonMapper sqContractPersonMapper;*/
    @Test
    public void contextLoads() {
    }

   /* @Test
    public void exampleUse() {
        Date date=new Date();
        *//*SqContractPerson person=new SqContractPerson();
        person.setUpdateTime(date);
        person.setId("1747480");*//*
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateStr=formatter.format(date);
        log.info(dateStr);
        *//*List<String> idCards=sqContractPersonMapper.selectIdCard(dateStr);
        log.info(idCards.toString());
        Example example=new Example(SqContractPerson.class);
        Criteria criteria=example.createCriteria();
        *//*
        *//*criteria.andIn("idCardNo",idCards);*//*
        *//*
        criteria.andEqualTo("idCardNo",idCards.get(0));
        sqContractPersonMapper.updateByPrimaryKeySelective(person);*//*
        SqContractPerson person=sqContractPersonMapper.selectByPrimaryKey("1747480");
        log.info(person.toString());
        person.setUpdateTime(date);
        sqContractPersonMapper.updateByPrimaryKey(person);
    }

    @Test
    public void findMatch() {
        String dateStr="345";
        List<String> sqContracts=sqContractPersonService.selectIdCard(dateStr);
        log.info(sqContracts.toString());
        List<String> matchContracts=pzhContractPersonService.selectIdCard(sqContracts);
        log.info(matchContracts.toString());
        //查询匹配的签约数据
        List<SqContractPerson> sqContractPersonList=sqContractPersonService.selectByIdCard(matchContracts);
        log.info(sqContractPersonList.toString());
    }*/

    /*@Test
    public  void testJson() {
        String jsonStr="{\"MSGFORM\":{\"XMLDATA\":" +
                "{\"STATUS\":\"签约团队不是该居民的管档团队，不可签约！\",\"RESULTFLAG\":0}}}";
        JSONObject jsonObject=JSON.parseObject(jsonStr);
        String resultFlag=jsonObject.getJSONObject("MSGFORM")
                .getJSONObject("XMLDATA").getString("RESULTFLAG");
        log.info(resultFlag);
    }

    @Test
    public void testWebYun() {
        StringBuilder infoBuilder=new StringBuilder("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

        String businessInfo="<NETHIS><TJJG><JKDAID>430111197111174019</JKDAID>" +
                "<NJRQ>2015-4-15</NJRQ><ZRYS>佘雨晴</ZRYS><ZRYSDM>382452496</ZRYSDM>" +
                "<SSY>105</SSY><SZY>74</SZY><SG>135</SG><TZ>30</TZ><BMI>16.7</BMI>" +
                "<KFXT></KFXT><STWD>36.3</STWD><NCGNDB></NCGNDB><NCGNT></NCGNT>" +
                "<NCGNTT></NCGNTT><NCGNQX></NCGNQX><NCGQT></NCGQT><FCXDT></FCXDT>" +
                "<XGRY>佘雨晴</XGRY><XGRYBM>382452496</XGRYBM>" +
                "<XGJGDM>430105004010001</XGJGDM></TJJG></NETHIS>";
        infoBuilder.append(businessInfo);
        log.info(infoBuilder.toString());
        Object[] obj={"HNKF","HNKF@01","GW31",businessInfo};
        String endpoint="http://113.247.228.77:8081/NetHisWebService/NetHisWebService.asmx";
        String nameSpace="nethis_common_business";
        String[] params={"userId","userPassword","businessCode","businessInfo"};
        List<String> paramList=Arrays.asList(params);
        try {
            String result=WebServiceUtil.sendToKaiFuByWebService(endpoint,nameSpace,paramList,obj);
            log.info("響應:{}",result);
        } catch (ServiceException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }*/

}
