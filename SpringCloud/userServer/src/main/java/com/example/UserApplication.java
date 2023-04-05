package com.example;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author gyx
 * @EnableEurekaClient 开启eureka客户端发现功能
 * @MapperScan("com.kkb.mapper") 开启扫描数据库操作接口的注解，
 * 注意：使用@MapperScan该注解要导入tk-mybais的依赖包，如下：
 * 		 import tk.mybatis.spring.annotation.MapperScan;
 *
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.example.mapper")
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}

