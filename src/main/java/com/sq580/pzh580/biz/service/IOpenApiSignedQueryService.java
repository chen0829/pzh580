package com.sq580.pzh580.biz.service;

import com.sq580.pzh580.facade.model.req.OpenApiSignedReq;

public interface IOpenApiSignedQueryService {

    public String openApiTokenQuery();

    public String openApiSignedQuery(OpenApiSignedReq req);

}
