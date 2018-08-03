package com.sq580.pzh580.biz.service.impl;

import com.sq580.pzh580.biz.service.DoctorBaseDataService;
import com.sq580.pzh580.biz.service.MatchContractService;
import com.sq580.pzh580.biz.service.PzhContractPersonService;
import com.sq580.pzh580.biz.service.SqContractPersonService;
import com.sq580.pzh580.facade.model.rsp.ResultVo;
import com.sq580.pzh580.persistence.auto.mapper.MatchContractMapper;
import com.sq580.pzh580.persistence.auto.model.MatchContract;
import com.sq580.pzh580.persistence.auto.model.SqContractPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 匹配签约用户
 * @author chensh
 * @date 2018.08.03
 */
@Service
public class MatchContractServiceImpl implements MatchContractService {
    @Autowired
    private DoctorBaseDataService doctorBaseDataService;
    @Autowired
    private PzhContractPersonService pzhContractPersonService;
    @Autowired
    private SqContractPersonService sqContractPersonService;
    @Autowired
    private MatchContractMapper matchContractMapper;


    /**
     * 查找匹配用户
     *
     * @return re
     */
    @Override
    public ResultVo findMatchContract() {
        String dateStr=null;
        List<String> sqContracts=sqContractPersonService.selectIdCard(dateStr);
        List<String> matchContracts=pzhContractPersonService.selectIdCard(sqContracts);
        //查询匹配的签约数据
        List<SqContractPerson> sqContractPersonList=sqContractPersonService.selectByIdCard(matchContracts);
        List<MatchContract> matchContractList=new ArrayList<>();
        for (SqContractPerson person : sqContractPersonList) {

        }
        return null;
    }
}
