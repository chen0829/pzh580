package com.sq580.pzh580.facade.openapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 *   社区580签约数据
 */
@RestController
@RequestMapping(value = "/sq")
@Slf4j
public class SqSignedQuery {

    @GetMapping("/print")
    public String printLog(){
        for (int i = 0; i < 10; i++) {
            log.info("=======我说info: {}", i);
        }
        for (int i = 0; i < 10; i++) {
            log.error("==%%%===我说debug: {}", i);
        }
        for (int i = 0; i < 10; i++) {
            log.warn("===我说warn:  {}", i);
        }
        for (int i = 0; i < 10; i++) {
            log.error("===**===我说error:  {}", i);
        }
        return "打印了";
    }

    //全量查询openApi
    public static void main(String[] args) {
        /*List<String> list = new ArrayList<>();
        list.add("passwd");
        list.add("seq");
        list.add("appkey");
        list.add("account");
        list.add("secret_key");*/
        /*list.add("page");
        list.add("rows");
        list.add("hos_code");
        list.add("seq");
        list.add("secret_key");*/
        Map<String,String> map = new TreeMap<>();
        map.put("passwd","MGJmOTI4ZDZmYzM0MTM0YjE0ZDcxNjJjYTY5Y2Q5MThiYjE0MmQwZWVhNmRhNzVjODQxODUxZDZjY2I4ZDM4Ng==");
        map.put("seq","1533275177");
        map.put("appkey","sq580J4Z79Z474IES");
        map.put("account","pizhoushiyunheshequweishengfuwuzhongxin");
        map.put("secret_key","9AFB3UH2II6D0Q16");
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String,String> str : map.entrySet()) {
            sb.append(str.getKey()).append("=").append(str.getValue()).append("&");
        }
        System.out.println(sb.toString());
        /*Collections.sort(list);
        StringBuffer sb = new StringBuffer();
        for (String str : list){
            sb.append(str).append("= &");
        }
        System.out.println(sb.toString());*/

        // account=pizhoushiyunheshequweishengfuwuzhongxin&appkey=sq580J4Z79Z474IES&passwd=MGJmOTI4ZDZmYzM0MTM0YjE0ZDcxNjJjYTY5Y2Q5MThiYjE0MmQwZWVhNmRhNzVjODQxODUxZDZjY2I4ZDM4Ng==&secret_key=9AFB3UH2II6D0Q16=1533264470&seq=1533267466
        // hos_code=320382H001&page=1&rows=100&secret_key=9AFB3UH2II6D0Q16=1533264470
    }

}
