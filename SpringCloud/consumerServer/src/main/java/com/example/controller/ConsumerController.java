package com.example.controller;

import com.example.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import jdk.nashorn.internal.runtime.Context;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Gyx
 * @Date: 2021/4/19 15:24
 */
@RestController
@ResponseBody
@RequestMapping("/consumer")
@Log4j2
@DefaultProperties(defaultFallback = "defaultFallBack")
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 使用负载均衡前获取地址的方法
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        //使用eureka注册中心后获取地址的方法
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
        ServiceInstance serviceInstance = instances.get(0);
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/user/" + id;
        System.out.println("success");
        return restTemplate.getForObject(url, User.class);
    }
    /**
     * 使用负载均衡后获取地址的方法
     * @param id
     * @return
     */
    @GetMapping("/ribbon/{id}")
    public User findByIdForRibbon(@PathVariable("id") Long id){
        String url = "http://user-service/user/" +id;
        return restTemplate.getForObject(url,User.class);
    }

    /**
     * 使用负载均衡后获取地址的方法，并开启局部服务熔断
     * @param id
     * @return
     * @HystrixCommand(fallbackMethod = "fallBack")
     * 开启局部服务降级注解，并指定一个局部服务降级方法，
     */
    @GetMapping("/hystrix1/{id}")
    @HystrixCommand(fallbackMethod = "fallBack")
    public String findByIdForHystrix1(@PathVariable("id") Long id){
        if(id==1){
            throw new RuntimeException("太忙了");
        }
        String url = "http://user-service/user/" +id;
        return restTemplate.getForObject(url,String.class);
    }

    /**
     * 局部服务降级方法
     * @param id
     * @return
     */
    public String fallBack(Long id){
        log.error("查询用户失败，id：{}",id);
        return "对不起，网络太拥挤了";
    }
    /**
     * 使用负载均衡后获取地址的方法，并开启全局服务熔断
     * @param id
     * @return
     * @HystrixCommand 开启全局服务降级注解后无需指定局部服务降级方法
     */
    @GetMapping("/hystrix2/{id}")
    @HystrixCommand
    public String findByIdForHystrix2(@PathVariable("id") Long id){
        if(id==1){
            throw new RuntimeException("太忙了");
        }
        String url = "http://user-service/user/" +id;
        return restTemplate.getForObject(url,String.class);
    }

    /**
     * 全局服务降级方法
     * @return
     */
    public String defaultFallBack(){
        return "全局提示：对不起，网络太拥挤了";
    }

}

