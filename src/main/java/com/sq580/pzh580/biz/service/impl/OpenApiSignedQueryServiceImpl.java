package com.sq580.pzh580.biz.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sq580.pzh580.biz.service.IOpenApiSignedQueryService;
import com.sq580.pzh580.biz.service.SqContractPersonService;
import com.sq580.pzh580.facade.model.req.OpenApiSignedReq;
import com.sq580.pzh580.persistence.auto.model.SqContractPerson;
import com.sq580.pzh580.util.OpenSignedUtil;
import com.sq580.pzh580.util.RestfulUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Slf4j
public class OpenApiSignedQueryServiceImpl implements IOpenApiSignedQueryService {
    private static SimpleDateFormat sday = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private SqContractPersonService sqContractPersonServiceImpl;

    @Value("${openapi.passwd}")
    private String passwd;
    @Value("${openapi.appkey}")
    private String appkey;
    @Value("${openapi.account}")
    private String account;
    @Value("${openapi.url}")
    private String url;
    @Value("${openapi.secretkey}")
    private String secretkey;

    @Override
    public String openApiTokenQuery() {
        long seq = OpenSignedUtil.getSeq();
        Map<String, Object> authMap = new HashMap<>();
        authMap.put("passwd", passwd);
        authMap.put("appkey", appkey);
        authMap.put("account", account);
        authMap.put("seq", String.valueOf(seq));
        String signature = OpenSignedUtil.getSign(authMap, secretkey, "UTF-8").toUpperCase();
        authMap.put("signature", signature);
        String authUrl = url + "/v1_0/authorize";
        Map<String, Object> resultMap = RestfulUtil.postJson(null, null, authMap, authUrl);
        log.info("openApiTokenQuery resultMap :{}", resultMap.get("resp"));
        String token = null;
        if (resultMap != null) {
            JSONObject resultObj = JSON.parseObject(resultMap.get("resp").toString());
            int err = resultObj.getIntValue("err");
            if (err == 0) {
                JSONObject dataObj = resultObj.getJSONObject("data");
                token = dataObj.getString("token");
            }
        }
        return token;
    }

    @Override
    public String openApiSignedQuery(OpenApiSignedReq req) {
        long seq = OpenSignedUtil.getSeq();
        Map<String, Object> signParamMap = new HashMap<>();
        if (req.getBegin_date() == null && req.getEnd_date() == null) {
            signParamMap.put("begin_date",sday.format(new Date())+" 00:00:00");
            signParamMap.put("end_date",sday.format(new Date())+" 23:59:59");
        } else {
            signParamMap.put("begin_date",req.getBegin_date());
            signParamMap.put("end_date",req.getEnd_date());
        }
        if(req.getRows() < 1){
            req.setRows(100);
            signParamMap.put("rows",100);
        }
        if (req.getPage() < 1) {
            signParamMap.put("page",1);
        }
        signParamMap.put("seq",String.valueOf(seq));
        signParamMap.put("appkey", appkey);
        signParamMap.put("hos_code", "430105021010001");
        String signature = OpenSignedUtil.getSign(signParamMap, secretkey, "UTF-8").toUpperCase();
        signParamMap.put("signature", signature);

        Map<String, String> signHeadMap = new HashMap<>();
        signHeadMap.put("Token",req.getToken());

        String signedQueryUrl = url + "/v1_0/residents/signed";
        Map<String, Object> resultMap = RestfulUtil.postJson(signHeadMap, null, signParamMap, signedQueryUrl);
        //log.info("openApiSignedQuery resultMap :{}", resultMap.get("resp"));
        //resultMap.put("tokentoken","11111");

        //解析数据
        int total = insertSqSingData(resultMap);
        int maxRows = 100; // 固定每页最大记录数
        int loopCount = total / maxRows; // 循环请求openApi签约数据的次数
        if (loopCount > 0 && loopCount % maxRows != 0) {
            loopCount += 1;
        } else {
            loopCount = 0;
        }
        // 循环分页
        for (int i = 2; i <= loopCount; i++) {
            signParamMap.put("page",i);
            signParamMap.put("seq",String.valueOf(OpenSignedUtil.getSeq()));
            signature = OpenSignedUtil.getSign(signParamMap, secretkey, "UTF-8").toUpperCase();
            signParamMap.put("signature", signature);
            resultMap = RestfulUtil.postJson(signHeadMap, null, signParamMap, signedQueryUrl);
            // 继续解析数据
            insertSqSingData(resultMap);
        }
        return null;
    }


    /**
     *  在openapi中查询到的签约数据录入到库中
     * @return
     */
    public int insertSqSingData(Map<String, Object> resultMap) {
        int total = 0;
        if (resultMap != null) {
            JSONObject resultObj = JSON.parseObject(resultMap.get("resp").toString());
            //JSONObject resultObj = JSON.parseObject("{\"encrypted\":false,\"total\":2,\"page\":1,\"rows\":100,\"err\":0,\"errmsg\":\"成功\",\"data\":[{\"contract_id\":\"0fa36c25cf67448a8cf26305c91f24e3\",\"introducer\":\"黄健忠\",\"start_from\":\"2017-05-21\",\"valid_year\":4,\"end_on\":\"2018-05-21\",\"status\":2,\"termination_reason\":null,\"remark\":null,\"create_time\":\"2017-05-22 12:24:00\",\"update_time\":\"2018-06-05 10:52:50\",\"hos_name\":\"广州市白云区新市街社区卫生院112112\",\"hos_code\":\"44008\",\"team_code\":\"05\",\"team_name\":\"45\",\"team_phone\":\"13416355575\",\"doc_id\":\"19\",\"doc_department\":\"全科11\",\"duser_name\":\"刘彦11\",\"duser_mobile\":\"13724026398\",\"duser_sex\":2,\"luser_name\":\"李栋生\",\"luser_mobile\":\"18800188006\",\"luser_sex\":1,\"resident_name\":\"apple\",\"resident_guardian\":\"oppo \",\"resident_relationship\":0,\"resident_gender\":1,\"resident_birthday\":\"1990-01-01\",\"resident_id_num\":\"110101199901027357\",\"resident_id_type\":1,\"resident_phone\":\"\",\"resident_mobile\":\"15555555555\",\"resident_address\":\"5555555555555555\",\"resident_blood_abo\":0,\"resident_blood_rh\":0,\"resident_disease_tag\":\"[1,5]\",\"resident_disease_history\":\"\",\"resident_allergic_history\":\"\"},{\"contract_id\":\"8acd34b94f9c46a08c7e1cfa359d766e\",\"introducer\":\"黄健忠11\",\"start_from\":\"2017-05-21\",\"valid_year\":4,\"end_on\":\"2018-05-21\",\"status\":2,\"termination_reason\":null,\"remark\":null,\"create_time\":\"2017-05-22 12:24:00\",\"update_time\":\"2017-06-05 10:52:50\",\"hos_name\":\"广州市白云区新市街社区卫生院\",\"hos_code\":\"44008\",\"team_code\":\"05\",\"team_name\":\"45\",\"team_phone\":\"13416355575\",\"doc_id\":\"19\",\"doc_department\":\"全科\",\"duser_name\":\"刘彦\",\"duser_mobile\":\"13724026398\",\"duser_sex\":2,\"luser_name\":\"李栋生\",\"luser_mobile\":\"18800188006\",\"luser_sex\":1,\"resident_name\":\"ooppo \",\"resident_guardian\":\"idididid \",\"resident_relationship\":0,\"resident_gender\":1,\"resident_birthday\":\"1999-09-01\",\"resident_id_num\":\"110101199901025351\",\"resident_id_type\":1,\"resident_phone\":\"\",\"resident_mobile\":\"13333333333\",\"resident_address\":\"广东广州市天河\",\"resident_blood_abo\":0,\"resident_blood_rh\":0,\"resident_disease_tag\":\"[1,3]\",\"resident_disease_history\":\"\",\"resident_allergic_history\":\"\"}]}");
            total = resultObj.getIntValue("total");
            int err = resultObj.getIntValue("err");
            if (err == 0) {
                // 获取社区580在前置机的签约居民信息
                List<String> sqIdCardList = sqContractPersonServiceImpl.selectIdCard(sday.format(new Date()));

                JSONArray dataArray = resultObj.getJSONArray("data");
                // 解析数据
                if (dataArray != null && dataArray.size() > 0) {
                    //List<SqContractPerson> personList = new ArrayList<>();
                    for (int i = 0; i < dataArray.size(); i++) {
                        SqContractPerson person = new SqContractPerson();
                        JSONObject persionObj = dataArray.getJSONObject(i);
                        // 签约状态 1:签约未生效,2:签约生效中,3:签约已失效,4:已解约
                        /*int status = persionObj.getIntValue("status");
                        if (status == 3 || status == 4) {
                            continue;
                        }*/
                        // 如果是存在的居民则更新数据，否则新增
                        String idCard = persionObj.getString("resident_id_num");
                        String contract_id = persionObj.getString("contract_id");
                        //person.setId(contract_id == null ? UUID.randomUUID().toString() : contract_id);
                        person.setIdCardNo(idCard);
                        person.setName(persionObj.getString("resident_name"));
                        person.setMobilePhone(persionObj.getString("resident_mobile"));
                        person.setGender(persionObj.getString("resident_gender"));
                        person.setState(persionObj.getString("status"));//默认签约
                        person.setBirthday(persionObj.getString("resident_birthday"));
                        person.setHospitalCode(persionObj.getString("hos_code"));
                        person.setTeamCode(persionObj.getString("team_code"));
                        person.setDoctorCode(persionObj.getString("doc_id"));
                        person.setExpiryStartDate(persionObj.getString("start_from"));
                        person.setExpiryEndDate(persionObj.getString("end_on"));
                        person.setExpiryMonth(persionObj.getString("valid_year"));
                        person.setAddress(persionObj.getString("resident_address"));
                        person.setCreateTime(new Date());
                        person.setUpdateTime(new Date());
                        // 合约有效时长 1:1个月,2:3个月,3:6个月,4:1年,5:2年,6:长期(open真实数据没有按接口文档返回，默认是12个月)
                        String validyear = persionObj.getString("valid_year");
                        switch (validyear){
                            case "1":
                                person.setExpiryMonth("12");
                                break;
                            /*case "2":
                                person.setExpiryMonth("3");
                                break;
                            case "3":
                                person.setExpiryMonth("6");
                                break;
                            case "4":
                                person.setExpiryMonth("12");
                                break;
                            case "5":
                                person.setExpiryMonth("24");
                                break;
                            case "6":
                                person.setExpiryMonth("120");
                                break;*/
                        }
                        if (sqIdCardList.contains(idCard)) {
                            List<String> updateIdCard = new ArrayList<>();
                            updateIdCard.add(idCard);
                            SqContractPerson contractPerson = sqContractPersonServiceImpl.selectByIdCard(updateIdCard).get(0);
                            person.setId(contractPerson.getId());
                            int updateCount = sqContractPersonServiceImpl.updateContractData(person);
                            log.info("=======updateSqSingData 成功数：updateCount {}, 总记录数:total: ", updateCount, total);
                        } else {
                            int insertCount = sqContractPersonServiceImpl.insertContractData(person);
                            log.info("=======insertSqSingData 成功数：insertCount {}, 总记录数:total: ", insertCount, total);
                        }
                        //personList.add(person);
                    }
                    //int count = sqContractPersonServiceImpl.insertContractData(personList);
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        OpenApiSignedQueryServiceImpl impl = new OpenApiSignedQueryServiceImpl();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("tokentoken","11111");
        impl.insertSqSingData(resultMap);
    }
}
