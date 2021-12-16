package com.example.sprigstudy;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
@Transactional
@MapperScan("com.example.sprigstudy.mapper")
public class SprigStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SprigStudyApplication.class, args);
    }

}
