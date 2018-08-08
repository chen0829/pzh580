package com.sq580.pzh580.persistence.auto.mapper;

import com.sq580.pzh580.biz.model.UploadContract;
import com.sq580.pzh580.persistence.auto.model.MatchContract;
import com.sq580.pzh580.util.CommonMapper;

import java.util.List;

public interface MatchContractMapper extends CommonMapper<MatchContract> {

    /**
     * 增加签约数据
     * @return inst
     */
    int insertMatch();

    /**
     * 查询签约数据
     * @return list
     */
    List<UploadContract > selectUpContract();
}