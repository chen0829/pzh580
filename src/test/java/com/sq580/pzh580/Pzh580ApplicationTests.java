package com.sq580.pzh580;

import com.github.pagehelper.PageHelper;
import com.sq580.pzh580.persistence.auto.mapper.LogUploadLogMapper;
import com.sq580.pzh580.persistence.auto.model.LogUploadLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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
        PageHelper.offsetPage(2, 5);
        LogUploadLog dbUserList =mapper.selectByPrimaryKey("20");

    }

}
