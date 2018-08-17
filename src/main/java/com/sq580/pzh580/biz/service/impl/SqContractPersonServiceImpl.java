package com.sq580.pzh580.biz.service.impl;

import com.sq580.pzh580.biz.service.SqContractPersonService;
import com.sq580.pzh580.persistence.auto.mapper.SqContractPersonMapper;
import com.sq580.pzh580.persistence.auto.model.SqContractPerson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

import java.util.List;

/**
 * @author chensh
 * @date 2018.08.03
 */
@Slf4j
@Service
public class SqContractPersonServiceImpl implements SqContractPersonService {
    @Autowired
    private SqContractPersonMapper sqContractPersonMapper;

    /**
     * 查询身份证
     *
     * @param updateTime upt
     * @return list
     */
    @Override
    public List<String> selectIdCard(String updateTime) {
        if (!StringUtils.isEmpty(updateTime)) {
            log.info("in this");
            return sqContractPersonMapper.selectIdCard(updateTime);
        }
        return null;

    }

    /**
     * 通过身份证查询签约用户信息
     *
     * @param idCards ids
     * @return user
     */
    @Override
    public List<SqContractPerson> selectByIdCard(List<String> idCards) {
        if (!CollectionUtils.isEmpty(idCards)) {
            Example example=new Example(SqContractPerson.class);
            Criteria criteria=example.createCriteria();
            criteria.andIn("idCardNo",idCards);
            return sqContractPersonMapper.selectByExample(example);

        }

        return null;
    }

    /**
     * 批量插入社区580签约用户
     * @param personList
     * @return
     */
    @Override
    public int insertContractData(List<SqContractPerson> personList) {
        int count = sqContractPersonMapper.insertList(personList);
        return count;
    }

    @Override
    public int insertContractData(SqContractPerson person) {
        int count = sqContractPersonMapper.insert(person);
        return count;
    }

    @Override
    public int updateContractData(SqContractPerson person) {
        int count = sqContractPersonMapper.updateByPrimaryKeySelective(person);
        return count;
    }
}
