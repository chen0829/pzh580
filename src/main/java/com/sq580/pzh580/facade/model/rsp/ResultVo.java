package com.sq580.pzh580.facade.model.rsp;

import com.sq580.pzh580.biz.enums.BizErrorCode;
import lombok.Data;

import java.io.Serializable;

/**
 * ClassName: ResultVo<br/>
 * Function: 返回结果<br/>
 * Date: 2017-11-13 11:39<br/>
 *
 * @author xiawei
 */
@Data
public class ResultVo<T> implements Serializable {

    /**
     * 错误号:0:成功；非0:错误
     */
    private String err="0";
    private boolean encrypted = false;
    private String errmsg;
    private T data;

    public static final ResultVo SUCESS = new ResultVo(BizErrorCode.SUCCESS);

    public ResultVo() {
    }


    public ResultVo(BizErrorCode errorCode) {
        this.errmsg = errorCode.getDesc();
    }

    public ResultVo(BizErrorCode errorCode, boolean encrypted, T data) {
        this.err = errorCode.getCode();
        this.errmsg = errorCode.getDesc();
        this.encrypted = encrypted;
        this.data = data;
    }

    /**
     * Description: 成功.<br/>
     * Date: 2017-11-13 11:45:30.<br/>
     */
    public static <T> ResultVo<T> success(T data) {
        return new ResultVo(BizErrorCode.SUCCESS, false, data);
    }

    /**
     * Description: 失败.<br/>
     * Date: 2017-11-13 11:45:30.<br/>
     */
    public static <T> ResultVo<T> fail(BizErrorCode errorCode) {
        return new ResultVo(errorCode, false, (Object) null);
    }

    /**
     * Description: 失败.<br/>
     * Date: 2017-11-13 11:45:30.<br/>
     */
    public static <T> ResultVo<T> fail() {
        return new ResultVo(BizErrorCode.ERR, false, (Object) null);
    }

}
