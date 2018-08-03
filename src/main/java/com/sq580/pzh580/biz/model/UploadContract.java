package com.sq580.pzh580.biz.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Data
public class UploadContract {

    private String SIGNTEAM;
    private String SIGNTEAMNAME;
    private String SIGNPERIOD;
    private String SIGNPERIODFROM;
    private String IDNUMBER;
    private String CODE;
    private String AGREEMENTNAME;
    private String ORGCODE;
    private String USERID;
    private String HOSTELPHONE;
    private String PACKAGEID;
}
