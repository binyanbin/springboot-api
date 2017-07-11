package com.yanbin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by yanbin on 2017/6/30.
 */
@SpringBootApplication(scanBasePackages = "com.yanbin")
@MapperScan(basePackages = "com.yanbin.dao" )
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class);
    }
}


