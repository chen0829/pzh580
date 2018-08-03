package com.sq580.pzh580.biz.service;

import com.sq580.pzh580.facade.model.rsp.ResultVo;


/**
 * 匹配签约用户
 * @author chensh
 * @date 2018.08.03
 */
public interface MatchContractService {

    /**
     *查找匹配用户
     * @return re
     */
    ResultVo findMatchContract();
}
