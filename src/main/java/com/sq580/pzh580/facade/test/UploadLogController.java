package com.sq580.pzh580.facade.test;

import com.sq580.pzh580.biz.service.test.UploadLogService;
import com.sq580.pzh580.persistence.auto.model.LogUploadLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chensh
 */
@RestController
@RequestMapping(value = "/upload")
public class UploadLogController {
    @Autowired
    private UploadLogService uploadLogService;

    @RequestMapping(value = "/findAll")
    public LogUploadLog findAll() {
        return uploadLogService.selectAllLog();
    }

}
