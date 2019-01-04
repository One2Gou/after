package com.go.after;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Dong
 */
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
@EnableTransactionManagement
@Slf4j
@MapperScan("com.go.after.**.mapper")
@EnableApolloConfig
public class AfterApplication {

    public static void main(String[] args) {
        SpringApplication.run(AfterApplication.class, args);
        log.info("SpringBoot启动成功!");
    }

}

