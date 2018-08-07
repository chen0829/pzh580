package com.sq580.pzh580.facade.model.req;

import lombok.Data;

@Data
public class OpenApiSignedReq extends CommonReq {
    private String begin_date;
    private String end_date;

}
