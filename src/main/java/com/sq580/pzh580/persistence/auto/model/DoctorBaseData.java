package com.sq580.pzh580.persistence.auto.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_doctor_base_data")
public class DoctorBaseData implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    @Column(name = "gw_doctor_id")
    private String gwDoctorId;

    @Column(name = "gw_doctor_name")
    private String gwDoctorName;

    @Column(name = "gw_team_id")
    private String gwTeamId;

    @Column(name = "gw_team_name")
    private String gwTeamName;

    @Column(name = "sq_org_code")
    private String sqOrgCode;

    @Column(name = "sq_org_name")
    private String sqOrgName;

    @Column(name = "sq_doctor_name")
    private String sqDoctorName;

    @Column(name = "sq_doctor_id")
    private String sqDoctorId;

    @Column(name = "sq_team_name")
    private String sqTeamName;

    @Column(name = "sq_team_id")
    private String sqTeamId;

    @Column(name = "gw_org_id")
    private String gwOrgId;

    @Column(name = "gw_org_no")
    private String gwOrgNo;

    @Column(name = "gw_org_name")
    private String gwOrgName;

    @Column(name = "gw_dept_name")
    private String gwDeptName;

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
     * @return gw_doctor_id
     */
    public String getGwDoctorId() {
        return gwDoctorId;
    }

    /**
     * @param gwDoctorId
     */
    public void setGwDoctorId(String gwDoctorId) {
        this.gwDoctorId = gwDoctorId == null ? null : gwDoctorId.trim();
    }

    /**
     * @return gw_doctor_name
     */
    public String getGwDoctorName() {
        return gwDoctorName;
    }

    /**
     * @param gwDoctorName
     */
    public void setGwDoctorName(String gwDoctorName) {
        this.gwDoctorName = gwDoctorName == null ? null : gwDoctorName.trim();
    }

    /**
     * @return gw_team_id
     */
    public String getGwTeamId() {
        return gwTeamId;
    }

    /**
     * @param gwTeamId
     */
    public void setGwTeamId(String gwTeamId) {
        this.gwTeamId = gwTeamId == null ? null : gwTeamId.trim();
    }

    /**
     * @return gw_team_name
     */
    public String getGwTeamName() {
        return gwTeamName;
    }

    /**
     * @param gwTeamName
     */
    public void setGwTeamName(String gwTeamName) {
        this.gwTeamName = gwTeamName == null ? null : gwTeamName.trim();
    }

    /**
     * @return sq_org_code
     */
    public String getSqOrgCode() {
        return sqOrgCode;
    }

    /**
     * @param sqOrgCode
     */
    public void setSqOrgCode(String sqOrgCode) {
        this.sqOrgCode = sqOrgCode == null ? null : sqOrgCode.trim();
    }

    /**
     * @return sq_org_name
     */
    public String getSqOrgName() {
        return sqOrgName;
    }

    /**
     * @param sqOrgName
     */
    public void setSqOrgName(String sqOrgName) {
        this.sqOrgName = sqOrgName == null ? null : sqOrgName.trim();
    }

    /**
     * @return sq_doctor_name
     */
    public String getSqDoctorName() {
        return sqDoctorName;
    }

    /**
     * @param sqDoctorName
     */
    public void setSqDoctorName(String sqDoctorName) {
        this.sqDoctorName = sqDoctorName == null ? null : sqDoctorName.trim();
    }

    /**
     * @return sq_doctor_id
     */
    public String getSqDoctorId() {
        return sqDoctorId;
    }

    /**
     * @param sqDoctorId
     */
    public void setSqDoctorId(String sqDoctorId) {
        this.sqDoctorId = sqDoctorId == null ? null : sqDoctorId.trim();
    }

    /**
     * @return sq_team_name
     */
    public String getSqTeamName() {
        return sqTeamName;
    }

    /**
     * @param sqTeamName
     */
    public void setSqTeamName(String sqTeamName) {
        this.sqTeamName = sqTeamName == null ? null : sqTeamName.trim();
    }

    /**
     * @return sq_team_id
     */
    public String getSqTeamId() {
        return sqTeamId;
    }

    /**
     * @param sqTeamId
     */
    public void setSqTeamId(String sqTeamId) {
        this.sqTeamId = sqTeamId == null ? null : sqTeamId.trim();
    }

    /**
     * @return gw_org_id
     */
    public String getGwOrgId() {
        return gwOrgId;
    }

    /**
     * @param gwOrgId
     */
    public void setGwOrgId(String gwOrgId) {
        this.gwOrgId = gwOrgId == null ? null : gwOrgId.trim();
    }

    /**
     * @return gw_org_no
     */
    public String getGwOrgNo() {
        return gwOrgNo;
    }

    /**
     * @param gwOrgNo
     */
    public void setGwOrgNo(String gwOrgNo) {
        this.gwOrgNo = gwOrgNo == null ? null : gwOrgNo.trim();
    }

    /**
     * @return gw_org_name
     */
    public String getGwOrgName() {
        return gwOrgName;
    }

    /**
     * @param gwOrgName
     */
    public void setGwOrgName(String gwOrgName) {
        this.gwOrgName = gwOrgName == null ? null : gwOrgName.trim();
    }

    /**
     * @return gw_dept_name
     */
    public String getGwDeptName() {
        return gwDeptName;
    }

    /**
     * @param gwDeptName
     */
    public void setGwDeptName(String gwDeptName) {
        this.gwDeptName = gwDeptName == null ? null : gwDeptName.trim();
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