package com.sq580.pzh580.facade.openapi;

import com.sq580.pzh580.biz.service.IOpenApiSignedQueryService;
import com.sq580.pzh580.facade.model.req.OpenApiAuthorizeReq;
import com.sq580.pzh580.facade.model.req.OpenApiSignedReq;
import com.sq580.pzh580.util.RestfulUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * 调openApi的签约数据
 */
@RestController
@RequestMapping(value = "/openApi")
@Slf4j
public class OpenApiSignedQueryController {

    @Autowired
    private IOpenApiSignedQueryService openApiSignedQuery;


    /**
     * 获取openApi的token
     * @return
     */
    @GetMapping("/getToken")
    public String openApiTokenQuery(){
        return openApiSignedQuery.openApiTokenQuery();
    }

    /**
     * 带上token获取签约数据
     * @return
     */
    @PostMapping("/querySigned")
    public String openApiSignedQuery(@RequestBody OpenApiSignedReq req){
        String token = openApiTokenQuery();
        if(token!=null){
            req.setToken(token);
            openApiSignedQuery.openApiSignedQuery(req);
        }
        return null;
    }

}
