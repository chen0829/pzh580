package com.sq580.pzh580.persistence.auto.mapper;

import com.sq580.pzh580.persistence.auto.model.PzhContractPerson;
import com.sq580.pzh580.util.CommonMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author chensh
 */
public interface PzhContractPersonMapper extends CommonMapper<PzhContractPerson> {
    /**
     * 查询身份证
     * @param idCards ids
     * @return list
     */
    List<String> selectIdCard(@Param("id_carts") List<String> idCards);
}