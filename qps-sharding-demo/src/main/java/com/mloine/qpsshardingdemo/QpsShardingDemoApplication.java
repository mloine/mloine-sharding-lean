package com.mloine.qpsshardingdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@MapperScan("com.mloine.qpsshardingdemo.mapper")
@SpringBootApplication
public class QpsShardingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QpsShardingDemoApplication.class, args);
    }

}
