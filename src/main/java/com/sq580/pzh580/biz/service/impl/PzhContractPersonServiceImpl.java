package com.sq580.pzh580.biz.service.impl;

import com.sq580.pzh580.biz.service.PzhContractPersonService;
import com.sq580.pzh580.persistence.auto.mapper.PzhContractPersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author chensh
 * @date 2018.08.03
 */
@Service
public class PzhContractPersonServiceImpl implements PzhContractPersonService {

    @Autowired
    private PzhContractPersonMapper mapper;
    /**
     * 查询身份证
     *
     * @param idCards ids
     * @return list
     */
    @Override
    public List<String> selectIdCard(List<String> idCards) {
        if (!CollectionUtils.isEmpty(idCards)) {
            return mapper.selectIdCard(idCards);
        }
        return null;
    }
}
