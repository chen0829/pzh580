package com.sq580.pzh580.facade.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 返回结果
 * @author chensh
 * @param <T>
 */
@Data
public class ResultData<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    // 处理成功
    public static final String OK = "0000";
    public static final String OK_MSG = "操作成功";
    // 参数校验有误
    public static final String PARAM_VALID= "0001";
    public static final String PARAM_VALID_MSG = "参数校验失败";
    // 查询结果为空
    public static final String NOTFOUND= "0002";
    public static final String NOTFOUND_MSG = "查询结果为空";
    // 操作失败
    public static final String FAIL= "0004";
    public static final String FAIL_MSG = "操作失败";
    //超时
    public static final String TIME_OUT = "9998";
    public static final String TIME_OUT_MSG = "超时";
    // 系统异常
    public static final String ERR = "9999";
    public static final String ERR_MSG = "系统异常";

    public static final ResultData SUCESS = new ResultData(OK, OK_MSG);


    /**
     * 状态码
     */
    private String code = ERR;
    /**
     * 状态描述
     */
    private String msg = "";
    /**
     * 数据
     */
    private T data;

    /**
     * 查询结果为空
     *
     * @return
     */
    public static ResultData getNotFoundResult() {
        return new ResultData(NOTFOUND,NOTFOUND_MSG);
    }

    /**
     * 参数校验失败
     *
     * @return
     */
    public static ResultData getParamValidResult(String message) {
        return new ResultData(PARAM_VALID,message);
    }

    /**
     * 超时
     *
     * @return
     */
    public static ResultData getTimeOutResult() {
        return new ResultData(TIME_OUT,TIME_OUT_MSG);
    }

    /**
     * 失败
     *
     * @return
     */
    public static ResultData getFailResult() {
        return new ResultData(FAIL,FAIL_MSG);
    }

    /**
     * 失败
     *
     * @param message
     * @return
     */
    public static ResultData getFailResult(String message) {
        return new ResultData(FAIL,message);
    }

    /**
     * 成功
     *
     * @param message
     * @return
     */
    public static ResultData getSuccessResult(String message) {
        return new ResultData(OK,message);
    }

    /**
     * 成功
     *
     * @param data
     * @param <T>
     * @return
     */
    public static <T> ResultData getSuccessData(T data) {
        return new ResultData(OK,OK_MSG,data);
    }

    /**
     * 成功
     *
     * @param data
     * @param message
     * @return
     */
    public static <T> ResultData getSuccessResult(T data, String message) {
        return new ResultData(OK,message,data);
    }

    public ResultData() {}

    private ResultData(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    private ResultData(String code, String message, T result) {
        this.code = code;
        this.msg = message;
        this.data = result;
    }

    public ResultData(T result) {
        this(OK,OK_MSG,result);
    }

}
