package com.sq580.pzh580;

import com.sq580.pzh580.biz.service.DoctorBaseDataService;
import com.sq580.pzh580.biz.service.PzhContractPersonService;
import com.sq580.pzh580.biz.service.SqContractPersonService;
import com.sq580.pzh580.persistence.auto.mapper.SqContractPersonMapper;
import com.sq580.pzh580.persistence.auto.model.PzhContractPerson;
import com.sq580.pzh580.persistence.auto.model.SqContractPerson;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class Pzh580ApplicationTests {

    @Autowired
    private DoctorBaseDataService doctorBaseDataService;
    @Autowired
    private PzhContractPersonService pzhContractPersonService;
    @Autowired
    private SqContractPersonService sqContractPersonService;

    @Autowired
    private SqContractPersonMapper sqContractPersonMapper;
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
}
