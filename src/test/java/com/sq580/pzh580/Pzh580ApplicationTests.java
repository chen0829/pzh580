package com.sq580.pzh580;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan({"com.sq580.pzh580.persistence.auto.mapper"})
@RunWith(SpringRunner.class)
@SpringBootTest
public class Pzh580ApplicationTests {

    @Test
    public void contextLoads() {
    }
}
