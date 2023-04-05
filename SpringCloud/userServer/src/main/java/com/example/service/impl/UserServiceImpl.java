package com.example.service.impl;

import com.example.mapper.UserMapper;
import com.example.pojo.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Gyx
 * @Date: 2021/4/19 15:02
 * @Service 表示给类的Service层的实现类
 * @Resource 自动注入的注解
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper mapper;

    /**
     * 按ID查询用户信息
     *
     * @param id
     * @return
     */
    @Override
    public User findById(Long id) {
        return mapper.selectByPrimaryKey(id);
    }
}


