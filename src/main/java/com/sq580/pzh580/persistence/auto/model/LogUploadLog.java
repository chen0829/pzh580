package com.sq580.pzh580.persistence.auto.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class LogUploadLog implements Serializable {
    private String ulid;

    private String fromip;

    private String toip;

    private Date crtime;

    private Date uploadtime;

    private Integer uploadstatus;

    private Integer source;

    private String errmsg;

    private String social;

    private String checkupid;

    private String fromparam;

    private String toparam;

    private String toresponse;

    private static final long serialVersionUID = 1L;

    public String getUlid() {
        return ulid;
    }

    public void setUlid(String ulid) {
        this.ulid = ulid == null ? null : ulid.trim();
    }

    public String getFromip() {
        return fromip;
    }

    public void setFromip(String fromip) {
        this.fromip = fromip == null ? null : fromip.trim();
    }

    public String getToip() {
        return toip;
    }

    public void setToip(String toip) {
        this.toip = toip == null ? null : toip.trim();
    }

    public Date getCrtime() {
        return crtime;
    }

    public void setCrtime(Date crtime) {
        this.crtime = crtime;
    }

    public Date getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Date uploadtime) {
        this.uploadtime = uploadtime;
    }

    public Integer getUploadstatus() {
        return uploadstatus;
    }

    public void setUploadstatus(Integer uploadstatus) {
        this.uploadstatus = uploadstatus;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg == null ? null : errmsg.trim();
    }

    public String getSocial() {
        return social;
    }

    public void setSocial(String social) {
        this.social = social == null ? null : social.trim();
    }

    public String getCheckupid() {
        return checkupid;
    }

    public void setCheckupid(String checkupid) {
        this.checkupid = checkupid == null ? null : checkupid.trim();
    }

    public String getFromparam() {
        return fromparam;
    }

    public void setFromparam(String fromparam) {
        this.fromparam = fromparam == null ? null : fromparam.trim();
    }

    public String getToparam() {
        return toparam;
    }

    public void setToparam(String toparam) {
        this.toparam = toparam == null ? null : toparam.trim();
    }

    public String getToresponse() {
        return toresponse;
    }

    public void setToresponse(String toresponse) {
        this.toresponse = toresponse == null ? null : toresponse.trim();
    }
}