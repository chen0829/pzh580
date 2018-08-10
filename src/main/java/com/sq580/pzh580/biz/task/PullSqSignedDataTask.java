package com.sq580.pzh580.biz.task;

import com.sq580.pzh580.facade.model.req.OpenApiSignedReq;
import com.sq580.pzh580.facade.openapi.OpenApiSignedQueryController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class PullSqSignedDataTask {

    @Autowired
    private OpenApiSignedQueryController signedQueryController;
    private static SimpleDateFormat sday = new SimpleDateFormat("yyyy-MM-dd");

    @Scheduled(cron = "${openapi.taskCorn}")
    public void openApiSignedQuery(){
        log.info("========openApiSignedQuery 开始=========");
        OpenApiSignedReq req = new OpenApiSignedReq();
        /*req.setEnd_date("2018-08-09 23:59:59");
        req.setBegin_date("2018-06-01 00:00:00");*/
        signedQueryController.openApiSignedQuery(req);
        log.info("========openApiSignedQuery 结束=========");
    }

    /**
     * 避免发布的时候有遗漏数据，每天23点执行一次
     */
    @Scheduled(cron = "0 0 23 * * ?")
    public void openApiSignedQueryRunOnce(){
        log.info("========openApiSignedQueryRunOnce 开始=========");
        OpenApiSignedReq req = new OpenApiSignedReq();
        req.setEnd_date(sday.format(new Date())+" 23:59:59");
        req.setBegin_date("2018-08-01 00:00:00");
        signedQueryController.openApiSignedQuery(req);
        log.info("========openApiSignedQueryRunOnce 结束=========");
    }

}
