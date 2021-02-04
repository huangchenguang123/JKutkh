package com.sharepower.JKutkh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sharepower.JKutkh.dal")
public class JKutkhApplication {

    public static void main(String[] args) {
        SpringApplication.run(JKutkhApplication.class, args);
    }

}
