package com.sq580.pzh580;

import com.sq580.pzh580.persistence.auto.mapper.LogUploadLogMapper;
import com.sq580.pzh580.persistence.auto.model.LogUploadLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Pzh580ApplicationTests {

    @Autowired
    private LogUploadLogMapper mapper;

    @Test
    public void contextLoads() {
    }


    // 分页查询用户
    @Test
    public void selectByPage() {
        LogUploadLog dbUserList =mapper.selectByPrimaryKey("402880d164f88d740164f8b034490000");
        System.out.println(dbUserList.toString());

    }

}
