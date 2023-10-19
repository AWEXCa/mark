package com.example.mark;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.example.mark.mapper")
@EnableTransactionManagement
public class MarkApplication {

    public static void main(String[] args) {
        SpringApplication.run(MarkApplication.class, args);
    }

}
