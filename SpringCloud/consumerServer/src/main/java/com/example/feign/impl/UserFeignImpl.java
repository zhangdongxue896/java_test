package com.example.feign.impl;

import com.example.feign.UserFeign;
import com.example.pojo.User;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 服务降级类
 */
@Component
public class UserFeignImpl implements UserFeign {

    @Resource
    private User user;

    @Override
    public User findById(Long id) {
        user.setId(id);
        user.setName("用户异常");
        return user;
    }
}

