package com.example.qpsshardingjdbcdemp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@MapperScan("com.example.qpsshardingjdbcdemp.mapper")
@SpringBootApplication
public class QpsShardingJdbcDempApplication {

    public static void main(String[] args) {
        SpringApplication.run(QpsShardingJdbcDempApplication.class, args);
    }

}
