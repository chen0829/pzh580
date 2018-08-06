package com.sq580.pzh580.persistence.auto.mapper;

import com.sq580.pzh580.persistence.auto.model.MatchContract;
import com.sq580.pzh580.util.CommonMapper;
import org.apache.ibatis.annotations.Param;

public interface MatchContractMapper extends CommonMapper<MatchContract> {

    /**
     * 增加签约数据
     * @return inst
     */
    int insertMatch();
}