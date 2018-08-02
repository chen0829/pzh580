package com.sq580.pzh580;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author chensh
 */
@Slf4j
@EnableScheduling
@EnableTransactionManagement
@MapperScan({"com.sq580.pzh580.persistence.auto.mapper"})
@SpringBootApplication
public class Pzh580Application {

    public static void main(String[] args) {
        SpringApplication.run(Pzh580Application.class, args);
    }
}
