package com.sq580.pzh580.facade.model.req;

import lombok.Data;

@Data
public class CommonReq {
    private int page;
    private int rows;
    private String token;
    private String seq;
    private String appkey;
    private String signature;
}
