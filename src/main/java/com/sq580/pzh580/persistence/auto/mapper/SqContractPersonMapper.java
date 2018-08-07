package com.sq580.pzh580.persistence.auto.mapper;

import com.sq580.pzh580.persistence.auto.model.SqContractPerson;
import com.sq580.pzh580.util.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * create in 20180803
 * @author chensh
 */
public interface SqContractPersonMapper extends CommonMapper<SqContractPerson> {
    /**
     * 查询全部idCard
     * @param updateTime 更新时间
     * @return idCards
     */
    List<String> selectIdCard(@Param("updateTime") String updateTime);
    /*List<SqContractPerson> sqContractPersonQuery();*/

}