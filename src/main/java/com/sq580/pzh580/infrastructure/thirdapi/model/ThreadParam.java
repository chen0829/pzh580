package com.sq580.pzh580.infrastructure.thirdapi.model;

import com.sq580.pzh580.persistence.auto.model.MatchContract;
import lombok.Data;

/**
 * 传给线程的参数
 * @author chensh
 */
@Data
public class ThreadParam {

    /**
     * 网址
     */
    private String endpoint;

    /**
     * 方法名
     */
    private String method;

    private MatchContract matchContract;


}
