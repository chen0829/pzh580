package com.sq580.pzh580.biz.enums;

import com.sq580.pzh580.facade.model.ResultData;
import lombok.Getter;

@Getter
public enum BizErrorCode {

    SUCCESS("0", "操作成功"),
    PARAM_VALID(ResultData.PARAM_VALID, ResultData.PARAM_VALID_MSG),
    NOTFOUND(ResultData.NOTFOUND, ResultData.NOTFOUND_MSG),
    FAIL(ResultData.FAIL, ResultData.FAIL_MSG),
    TIME_OUT(ResultData.TIME_OUT, ResultData.TIME_OUT_MSG),
    ERR(ResultData.ERR, ResultData.ERR_MSG),

    SYSTEM_ERROR("51001", "系统错误,请联系管理人员"),
    UNAUTHORIZED_APPKEY("52001", "未授权的appkey"),
    REPEAT_REQUEST("52002", "重复的请求"),
    SIGNATURE_VERIFI_ERR("52003", "签名校验失败"),
    INVALID_TOKEN("52004", "无效的token"),
    NO_ACCESS_ACCOUNT("52005", "账号权限不足"),
    PARAM_EMPTY("52006", "参数为空"),
    ILLEGAL_PARAM("52007", "非法参数"),
    PAGE_PARAM_ERR("52021", "分页查询参数错误"),
    INVALID_ORG_CODE("52022", "无效的机构编码"),
    INVALID_AREA_CODE("52023", "无效的区域编码"),
    HOSPITAL_EXISTS("52024", "医院已存在"),
    INVALID_HOSPITAL_CODE("52025", "无效的医院编码"),
    INVALID_TEAM_CODE("52026", "无效的团队编码"),
    TEAM_EXISTS("52027", "团队已存在"),
    INVALID_DOCTOR_CODE("52028", "无效的医生编码"),
    DOCTOR_EXISTS("52029", "医生已存在"),
    INVALID_PHONE("52030", "无效的手机号码"),
    INVALID_IDCARD("52031", "无效的身份证号码"),
    INVALID_DICT_CODE("52032", "无效的科室编码"),
    INVALID_MH_MAPPING("52033", "管理员已关联了该医院"),
    EXIST_DEPARTMENT("52034", "该科室已存在"),
    NOT_EXIST_DEPARTMENT("52035", "该科室不存在"),
    EXIST_SAME_NAME_SECOND_DEPARTMENT("52036", "该医院下已经存在名称相同的二级科室"),
    EXIST_DOCTORS_UNDER_DEPARTMENT("52037", "该科室下存在医生,请确认!"),
    EXIST_DOCTOR_UNDER_TEAM("52038", "该医生已经在其他团队下,且是队长!"),
    EXIST_CAPTAIN_UNDER_SAME_TEAM("52039", "该团队下已存在队长!"),
    NOT_EXIST_INSURANCE_DOCTOR("60001", "该商保医生不存在"),
    IDNUM_HAS_BINDED_INSURANCE_DOCTOR("60002", "该身份证已绑定其他医生"),
    NOT_EXIST_INSURANCE_ORG("70001", "该保险机构不存在"),
    CHANNEL_EXISTS("80001", "渠道已存在"),
    CHANNEL_NOT_EXISTS("80002", "渠道已不存在"),
    CHANNEL_IS_RELEASE("80003", "渠道已在医院上线"),;

    /**
     * 错误码
     */
    private final String code;
    /**
     * 描述
     */
    private final String desc;

    private BizErrorCode(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
