package com.sq580.pzh580.biz.service.test.impl;

import com.sq580.pzh580.biz.service.test.UploadLogService;
import com.sq580.pzh580.persistence.auto.mapper.LogUploadLogMapper;
import com.sq580.pzh580.persistence.auto.model.LogUploadLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chensh
 */
@Service(value = "uploadLogService")
public class UploadLogServiceImpl implements UploadLogService {

    @Autowired
    private LogUploadLogMapper uploadLogMapper;

    /**
     * @return LogUploadLog
     */
    @Override
    public LogUploadLog selectAllLog() {
        return uploadLogMapper.selectByPrimaryKey("20");
    }
}
