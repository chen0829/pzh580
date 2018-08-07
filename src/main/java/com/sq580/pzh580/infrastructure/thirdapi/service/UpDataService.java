package com.sq580.pzh580.infrastructure.thirdapi.service;

import com.sq580.pzh580.infrastructure.thirdapi.model.ThreadParam;

import javax.xml.bind.JAXBException;
import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;

/**
 * 与东软对接的功能类
 * @author chensh 20180806
 */
public interface UpDataService {

    /**
     * 提交确认签约信息
     * @param threadParam 参数
     * @return 调用结果
     * @throws JAXBException ja
     * @throws ServiceException se
     * @throws RemoteException re
     */
    String upConfirmSignedInfo(ThreadParam threadParam)
            throws JAXBException, ServiceException, RemoteException;
}
