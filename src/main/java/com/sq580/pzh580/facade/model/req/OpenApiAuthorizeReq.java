package com.sq580.pzh580.facade.model.req;

import lombok.Data;

@Data
public class OpenApiAuthorizeReq extends CommonReq {
    private String passwd;
    private String account;
}
