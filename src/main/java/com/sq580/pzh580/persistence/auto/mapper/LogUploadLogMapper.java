package com.sq580.pzh580.persistence.auto.mapper;

import com.sq580.pzh580.persistence.auto.model.LogUploadLog;

public interface LogUploadLogMapper {
    int deleteByPrimaryKey(String ulid);

    int insert(LogUploadLog record);

    int insertSelective(LogUploadLog record);

    LogUploadLog selectByPrimaryKey(String ulid);

    int updateByPrimaryKeySelective(LogUploadLog record);

    int updateByPrimaryKeyWithBLOBs(LogUploadLog record);

    int updateByPrimaryKey(LogUploadLog record);
}