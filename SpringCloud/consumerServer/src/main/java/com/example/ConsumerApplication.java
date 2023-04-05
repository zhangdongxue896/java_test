package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Author gyx
 *
 * @SpringBootApplication
 * @EnableEurekaClient 开启eureka客户端
 * @EnableCircuitBreaker 开启服务熔断机制
 * 上面三个注解可以直接由 @SpringCloudApplication 代替
 * @EnableFeignClients 开启feign代理功能,自带负载均衡处理，可以不编写RestTemplate
 */
@SpringCloudApplication
@EnableFeignClients //更改点
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}


    /**
     * 提供restful风格请求的服务
     * @LoadBalanced 拉取服务时开启负载均衡
     * @return
     */
//    @Bean
//    @LoadBalanced //更改点
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }
//}


