package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;/**
 * @Author: Gyx
 * @Date: 2021/4/19 15:05
 * @RestController 标识该类是请求处理类的注解
 * @RequestMapping("/user") 请求的地址配置注解
 * @Resource 自动注入的注解
 * @GetMapping("/{id}") 请求的地址配置注解
 * 访问的地址为：http://127.0.0.1:8888/user/2
 * 127.0.0.1:8888 为userService的服务地址
 * /user/2 为@RequestMapping("/user")和@GetMapping("/{id}")的配置组合
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     *@PathVariable("id") 该注解作用是：获取{}占位符中的值
     */
    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id){
        System.out.println(id);
        return userService.findById(id);
    }
}

