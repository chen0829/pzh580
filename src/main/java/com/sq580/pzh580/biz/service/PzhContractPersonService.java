package com.sq580.pzh580.biz.service;


import java.util.List;

/**
 * @author chensh
 * @date 2018.08.03
 */
public interface PzhContractPersonService {
    /**
     * 查询身份证
     * @param idCards ids
     * @return list
     */
    List<String> selectIdCard(List<String> idCards);

}
