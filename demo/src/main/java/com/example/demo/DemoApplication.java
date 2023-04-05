package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication(scanBasePackages = "com.example.demo")
//@EnableJpaRepositories(basePackages = "com.example.demo")
//@EntityScan(basePackages = "com.example.demo.entity")
@SpringBootApplication
//@ComponentScan(basePackages = "com.example.demo")
//指定JpaRepositry扫描包的位置
//@EnableJpaRepositories(basePackages = {"com.example.demo"})
//
////扫描的包可以定义多个 , basePackages 是一个 String 数组 (一定要保证你的Reposity在扫描路径中)
////如果项目中没有定义 @EnableJpaRepositories , 可以在Application启动类上添加此注解 (或者自己定义一个 JpaConfig Bean 也可以)
////指定Entity的扫描位置 (如果不指定 Entity Bean 也无法使用)
//@EntityScan(basePackages = { "com.example.demo" })

public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
