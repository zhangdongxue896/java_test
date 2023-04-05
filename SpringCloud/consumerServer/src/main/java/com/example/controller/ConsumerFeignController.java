package com.example.controller;

import com.example.feign.UserFeign;
import com.example.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/consumer")
public class ConsumerFeignController {

    @Resource
    private UserFeign userFeign;

    @GetMapping("/feign/{id}")
    public User findById(@PathVariable("id") Long id){
        return userFeign.findById(id);
    }
}


