package com.csp.yiyan;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.csp.yiyan.mapper")
@EnableScheduling
public class YiyanApplication {

    public static void main(String[] args) {
        SpringApplication.run(YiyanApplication.class, args);
    }

}
