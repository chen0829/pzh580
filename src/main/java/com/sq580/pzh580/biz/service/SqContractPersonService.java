package com.sq580.pzh580.biz.service;


import com.sq580.pzh580.persistence.auto.model.SqContractPerson;

import java.util.List;

/**
 * @author chensh
 */
public interface SqContractPersonService {

    /**
     *  查询身份证
      * @param updateTime upt
     * @return list
     */
    List<String> selectIdCard(String updateTime);

    /**
     * 通过身份证查询签约用户信息
     * @param idCards ids
     * @return user
     */
    List<SqContractPerson> selectByIdCard(List<String> idCards);

    int insertContractData(List<SqContractPerson> personList);

    int insertContractData(SqContractPerson person);

    int updateContractData(SqContractPerson person);

}
