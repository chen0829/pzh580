package com.sq580.pzh580.persistence.auto.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_match_contract")
public class MatchContract implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    @Column(name = "sign_team")
    private String signTeam;

    @Column(name = "sign_team_name")
    private String signTeamName;

    @Column(name = "sign_period")
    private String signPeriod;

    @Column(name = "sign_period_from")
    private String signPeriodFrom;

    @Column(name = "id_number")
    private String idNumber;

    private String code;

    @Column(name = "agreement_name")
    private String agreementName;

    @Column(name = "org_code")
    private String orgCode;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "hos_tel_phone")
    private String hosTelPhone;

    @Column(name = "package_id")
    private String packageId;

    @Column(name = "upload_state")
    private Byte uploadState;

    @Column(name = "create_name")
    private String createName;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_name")
    private String updateName;

    @Column(name = "update_time")
    private Date updateTime;

    private String remark;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * @return sign_team
     */
    public String getSignTeam() {
        return signTeam;
    }

    /**
     * @param signTeam
     */
    public void setSignTeam(String signTeam) {
        this.signTeam = signTeam == null ? null : signTeam.trim();
    }

    /**
     * @return sign_team_name
     */
    public String getSignTeamName() {
        return signTeamName;
    }

    /**
     * @param signTeamName
     */
    public void setSignTeamName(String signTeamName) {
        this.signTeamName = signTeamName == null ? null : signTeamName.trim();
    }

    /**
     * @return sign_period
     */
    public String getSignPeriod() {
        return signPeriod;
    }

    /**
     * @param signPeriod
     */
    public void setSignPeriod(String signPeriod) {
        this.signPeriod = signPeriod == null ? null : signPeriod.trim();
    }

    /**
     * @return sign_period_from
     */
    public String getSignPeriodFrom() {
        return signPeriodFrom;
    }

    /**
     * @param signPeriodFrom
     */
    public void setSignPeriodFrom(String signPeriodFrom) {
        this.signPeriodFrom = signPeriodFrom == null ? null : signPeriodFrom.trim();
    }

    /**
     * @return id_number
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber == null ? null : idNumber.trim();
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return agreement_name
     */
    public String getAgreementName() {
        return agreementName;
    }

    /**
     * @param agreementName
     */
    public void setAgreementName(String agreementName) {
        this.agreementName = agreementName == null ? null : agreementName.trim();
    }

    /**
     * @return org_code
     */
    public String getOrgCode() {
        return orgCode;
    }

    /**
     * @param orgCode
     */
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    /**
     * @return user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * @return hos_tel_phone
     */
    public String getHosTelPhone() {
        return hosTelPhone;
    }

    /**
     * @param hosTelPhone
     */
    public void setHosTelPhone(String hosTelPhone) {
        this.hosTelPhone = hosTelPhone == null ? null : hosTelPhone.trim();
    }

    /**
     * @return package_id
     */
    public String getPackageId() {
        return packageId;
    }

    /**
     * @param packageId
     */
    public void setPackageId(String packageId) {
        this.packageId = packageId == null ? null : packageId.trim();
    }

    /**
     * @return upload_state
     */
    public Byte getUploadState() {
        return uploadState;
    }

    /**
     * @param uploadState
     */
    public void setUploadState(Byte uploadState) {
        this.uploadState = uploadState;
    }

    /**
     * @return create_name
     */
    public String getCreateName() {
        return createName;
    }

    /**
     * @param createName
     */
    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return update_name
     */
    public String getUpdateName() {
        return updateName;
    }

    /**
     * @param updateName
     */
    public void setUpdateName(String updateName) {
        this.updateName = updateName == null ? null : updateName.trim();
    }

    /**
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}