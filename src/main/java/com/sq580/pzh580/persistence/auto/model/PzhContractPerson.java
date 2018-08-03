package com.sq580.pzh580.persistence.auto.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
@Data
@Table(name = "t_pzh_contract_person")
public class PzhContractPerson implements Serializable {
    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    @Column(name = "doc_no")
    private String docNo;

    @Column(name = "id_card_no")
    private String idCardNo;

    private String name;

    private String tel;

    private String gender;

    private String state;

    private String birthday;

    private String address;

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
     * @return doc_no
     */
    public String getDocNo() {
        return docNo;
    }

    /**
     * @param docNo
     */
    public void setDocNo(String docNo) {
        this.docNo = docNo == null ? null : docNo.trim();
    }

    /**
     * @return id_card_no
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * @param idCardNo
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo == null ? null : idCardNo.trim();
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * @return state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state
     */
    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    /**
     * @return birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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